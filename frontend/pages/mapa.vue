<head>
  <link rel="stylesheet" href="https://unpkg.com/leaflet@1.8.0/dist/leaflet.css"
   integrity="sha512-hoalWLoI8r4UszCkZ5kL8vayOGVae1oxXe/2A4AO6J9+580uKHDO3JdHb7NzwwzK5xr/Fs0W40kiNHxM9vyTtQ=="
   crossorigin=""/></head>

<template>
  <div class="home">
    <h1>Mapa de emergencias en la región del voluntario</h1>
    <div>{{point}} </div>
    <div>{{titulo}}</div>
    <div id="mapid"></div>

    <form @submit.prevent = "obtenerID">
      <form style = 'text-align: center; '>
        <p><kbd> <strong>INGRESE ID DEL VOLUNTARIO: </strong></kbd> </p>
        <input class = 'text_centrado' type = 'text' v-model = 'id_voluntario'>
      </form>
      <p>
        <button class = "centrado" type = 'submit'>BUSCAR </button>
      </p>
    </form>
  </div>
</template>
<script>


//Importaciones
import 'leaflet/dist/leaflet'; //librería leaflet
import 'leaflet/dist/leaflet.css'; //css leaflet
var icon = require('leaflet/dist/images/marker-icon-2x.png'); //ícono de marcadores
//Se crea objeto ícono con el marcador
var LeafIcon = L.Icon.extend({
          options: {iconSize:[25, 25], iconAnchor:[25, 25], popupAnchor: [1, -34],}
      });
var myIcon = new LeafIcon({iconUrl: icon});

//librería axios
import axios from 'axios';
export default {
  name: 'Home',
  data:function(){
    return{
      latitud:null, //Datos de nuevo punto
      longitud:null,
      name:'',
      points:[], //colección de puntos cargados de la BD
      message:'',
      mymap:null, //objeto de mapa(DIV)
      id_voluntario: 0
    }
  },
  computed:{

    point(){ // función computada para representar el punto seleccionado
      if(this.latitud && this.longitud){
        let lat = this.latitud.toFixed(5);
        let lon = this.longitud.toFixed(5);
        return `(${lat}, ${lon})`;
      }else{
        return '';
      }
    }
  },
  methods:{
    clearMarkers:function(){ //eliminar marcadores
      this.points.forEach(p=>{
        this.mymap.removeLayer(p);
      })
      this.points = [];
    },


    obtenerID()
    {
      var id_voluntario = this.id_voluntario;
      // limpiamos los marcadores
      this.clearMarkers();
      //Se agregan los puntos mediante llamada al servicio
      this.getPoints(this.mymap, id_voluntario);
      //seteamos el id que aparece en la casilla
      this.id_voluntario = 0;

    },

    async getPoints(map, valor){
      try {
        //se llama el servicio
        let response = await axios.get('http://localhost:8080/emergenciasRegionVoluntario/' + valor);

        console.log(response);
        let dataPoints = response.data;
        console.log(dataPoints);
        //Se itera por los puntos
        dataPoints.forEach(point => {
          //Se crea un marcador por cada punto
          let p =[point.latitud,point.longitud]
          let marker = L.marker(p, {icon:myIcon}) //se define el ícono del marcador
          .bindPopup(point.titulo); //Se agrega un popup con el nombre

          //Se agrega a la lista
          this.points.push(marker);
        });
        //Los puntos de la lista se agregan al mapa
        this.points.forEach(p => {
          p.addTo(map)
        })
      } catch (error) {
       console.log('error', error);
      }

    },


  },

  mounted:function(){
    let _this = this;
    //Se asigna el mapa al elemento con id="mapid"
     this.mymap = L.map('mapid').setView([-33.456, -70.648], 7);
    //Se definen los mapas de bits de OSM
    L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', {
      attribution: '&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors',
      maxZoom: 100
    }).addTo(this.mymap);
    //Evento click obtiene lat y long actual
    this.mymap.on('click', function(e) {
      _this.latitude = e.latlng.lat;
      _this.longitude =e.latlng.lng;
    });
    //Se agregan los puntos mediante llamada al servicio
    //this.getPoints(this.mymap, this.id_voluntario);
  }
}
</script>

<style>
.home{
  display:flex;
  flex-direction: column;
  align-items: center;
}
/* Estilos necesarios para definir el objeto de mapa */
#mapid {
  height: 500px;
  width:1000px;
}

.text_centrado{
  text-align: center;
}

button.centrado{
  width: 110px;
  margin-left: 50%;
  transform: translateX(-50%);
}
</style>
