<template>
  <p>ID de la Factura: {{ id }}</p>
  <p>Valor: {{ valor }}</p>
  <p>Fecha: {{ fecha }}</p>
  <p>Propina: {{ propina }}</p>
  <p>ID del Restaurante: {{ restauranteId }}</p>
  <p>Completado: {{ completado }}</p>
  <p>Platos: {{ platosFactura }}</p>
</template>

<script lang="js">
export default {
  name: "FacturaFindAll",
  props: {
    id: {
      type: String,
      default: "",
      required: true
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
    restauranteId: {
      type: String,
      default: "",
      required: true
    },
    completado: {
      type: Boolean,
    },
    platosFactura: {
      type: String,
      default: ""
    }
  },

};
</script>

<style scoped></style>
