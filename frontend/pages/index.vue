<template>
<div class="container">
  <h1 class='title'>
    Listado de tareas
  </h1>
  <ul class="item-list">
    <li v-for="tarea in items" v-bind:key="index">
      {{tarea.titulo}} - {{tarea.descripcion}} - {{tarea.id_estado}} - {{tarea.id_emergencia}} - {{tarea.cant_voluntarios}}
    </li>
  </ul>
  <div v-if="items.length==0" class="empty-list">
    <em>No se han cargado los datos</em>
  </div>
</div>
</template>

<script>

export default {
    //Función que contiene los datos del componente
    data: function(){
        return {
            //Lista de ítems a mostrar
            items:[]
        }
    },

    methods:{
        //Función asíncrona para consultar los datos
        getData: async function(){
            try {
                let response = await this.$axios.get('http://localhost:8080/tareas/');
                this.items  = response.data;
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
