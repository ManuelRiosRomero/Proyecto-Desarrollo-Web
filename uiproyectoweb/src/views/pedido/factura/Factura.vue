<template>
  <h2>Facturas</h2>
  <ul class="factura">
    <FacturaItem
      v-for="factura in facturas"
      :key="factura.id"
      :id="factura.id"
      :valor="factura.valor"
      :fecha="factura.fecha"
      :propina="factura.propina"
      :completado="factura.completado"
      :platos="factura.platosFactura"
    />
  </ul>
  <div class="bottom"></div>
</template>

<script lang="js">
import { PedidoUse } from "@/uses/Pedido/PedidoUse";
import FacturaItem from "@/components/pedido/factura/FacturaItem";
//import { ref } from "vue";
export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: "Factura",
  components: { FacturaItem },
  setup() {
    const { goToFactura, facturas } = PedidoUse()
    return {
      goToFactura,
      facturas,
    };
  },
};
</script>

<style scoped>
.wrapper-error {
  border: 1px solid red;
}
</style>
