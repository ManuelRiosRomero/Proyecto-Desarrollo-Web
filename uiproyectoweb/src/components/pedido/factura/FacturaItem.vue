<template>
  <ul class="wrapper-list">
    <li class="facturaitem">
      <p>ID: {{ id }}</p>
      <p>Valor: {{ valor }}</p>
      <p>Fecha: {{ fecha }}</p>
      <p>Propina: {{ propina }}</p>
      <p>Compleatado: {{ completado }}</p>
    </li>
  </ul>
</template>

<script lang="js">
export default {
  //      <p>Platos: {{ platosFactura }}</p>
  name: "FacturaItem",
  props: {
    id: {
      type: String,
    },
    valor: {
      type: Number,
    },
    fecha: {
      type: String,
      default: ""
    },
    propina: {
      type: Number,
    },
    completado: {
      type: Boolean,
    },
    platosFactura: {
      type: String,
      default: ""
    }
  },
}
</script>

<style scoped>
.facturaitem {
  background-color: aliceblue;
}
.valor {
  font-weight: bold;
  color: #2c3e50;
}
.wrapper-list {
  list-style: none;
  padding: 2rem;
  background-color: #558c8d;
}
</style>
