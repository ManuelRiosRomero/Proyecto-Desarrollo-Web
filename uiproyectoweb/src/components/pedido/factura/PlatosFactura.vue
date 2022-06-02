<template>
  <ul class="wrapper-list">
    <li class="facturaitem">
      <p>platos: {{ platos }}</p>
    </li>
  </ul>
</template>

<script>
export default {
  name: "PlatosFactura",
  props: {
    platos: {
      type: String,
    },
    cantidad: {
      type: Number,
    },
    precio: {
      type: Number,
    },
  },
};
</script>

<style scoped></style>
