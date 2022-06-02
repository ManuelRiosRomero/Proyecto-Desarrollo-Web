<template>
  <ul class="view-titulo">
    <p>Pantalla de Pedidos</p>
    <button @click="goToFactura">Ver Facturas</button>
    <button @click="goToCrearFactura">Crear Factura</button>
  </ul>
</template>

<script lang="js">
import { PedidoUse } from "@/uses/Pedido/PedidoUse";
export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: "Pedido",
  components: {},
  setup() {
    const { goToFactura, goToCrearFactura } = PedidoUse()
    return {
      goToFactura,
      goToCrearFactura,
    };
  },
};
</script>

<style scoped lang="css">
.view-titulo {
  background-color: #42b983;
  padding: 0.1rem;
}
</style>
