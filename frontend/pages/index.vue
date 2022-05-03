<template>
  <div id="index">
    <h1 class="title">
      Listado de tareas
    </h1>

    <div v-for = "tarea of tareas" v-bind:key="tareas.id"
      {{tarea}}
    </div>
  </div>

</template>

<script>
import axios from "axios";

export default {
    name: "index",

    //Función que contiene los datos del componente
    data: function(){
        return {
            //Lista de ítems a mostrar
            tareas:[]
        }
    },

    methods:{
        //Función asíncrona para consultar los datos
        getData: async function(){
            try {
                let response = axios.get('/tareas/');
                this.tareas  = response.data;
                console.log(response)
            } catch (error) {
                console.log('error', error);
            }
        }
    },
    //Función que se ejecuta al cargar el componente
    created:function(){
        this.getData();
    }
}
</script>

<style>
body {
  background-color:#4FBDBA;
}

.title {
  font: bold 200% monospace;
  text-align: center;
  color: #072227
}

</style>
