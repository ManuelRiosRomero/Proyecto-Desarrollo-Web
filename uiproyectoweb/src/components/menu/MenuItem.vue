<template>
  <li class="menuitem">
    <img class="img" src="../../assets/item.png" />
    <p class="nombre">{{ nombre }}</p>
    <p class="descripcion">{{ descripcion }}</p>
  </li>
</template>

<script lang="js">

export default {
  name: "MenuItem",
  props: {
    nombre: {
      type: String,
      default: ""
    },
    descripcion: {
      type: String,
      default: ""
    },
    path: {
      type: String,
      default: ""
    },
    costo: {
      type: Number,
      required: true,
    }
  },
}
</script>

<style scoped>
.menuitem {
  background-color: aliceblue;
  padding: 10px;
}
.img {
  width: 100px;
}
.nombre {
  font-weight: bold;
  color: #2c3e50;
}
</style>
