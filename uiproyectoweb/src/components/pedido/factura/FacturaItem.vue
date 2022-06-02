<template>
  <ul class="wrapper-list">
    <li class="facturaitem">
      <p>Valor: {{ valor }}</p>
      <p>Fecha: {{ fecha }}</p>
      <p>Propina: {{ propina }}</p>
      <p>Compleatado: {{ completado }}</p>
      <p>Platos: {{ platosFactura }}</p>
    </li>
  </ul>
</template>

<script lang="js">

export default {
  name: "FacturaItem",
  props: {
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
