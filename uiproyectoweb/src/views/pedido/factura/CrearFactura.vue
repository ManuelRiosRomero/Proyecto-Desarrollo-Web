<template>
  <h2>Agregar Factura</h2>
  <ul class="menu">
    <MenuItemBoton
      v-for="plato in platos"
      :key="plato.id"
      :nombre="plato.nombre"
      :descripcion="plato.descripcion"
      :path="path"
    ></MenuItemBoton>
  </ul>
  <form class="agregar">
    <label for="factura_valor">Valor</label>
    <input
      class="valor"
      type="text"
      id="factura_valor"
      placeholder="Valor de la Factura"
      v-model="nuevaFactura.valor"
    />
    <label for="fecha">Fecha:</label>
    <input type="date" id="fecha" name="fecha" v-model="nuevaFactura.fecha" />
    <div class="propina">
      <label>Propina</label>
      <input
        type="number"
        class="propina"
        id="factura_propina"
        v-model="nuevaFactura.propina"
      />
    </div>
  </form>
  <button class="submit" @click="agregarFactura">Agregar Factura</button>
</template>

<script>
import { ref } from "vue";
import { PedidoUse } from "@/uses/Pedido/PedidoUse";
import MenuItemBoton from "@/components/menu/MenuItemBoton";
import { menuUse } from "@/uses/MenuUse";

export default {
  name: "CrearFactura",
  components: { MenuItemBoton },
  setup() {
    const { platos } = menuUse();
    const { createFacturaUse } = PedidoUse();
    const nuevaFactura = ref({
      valor: 0,
      fecha: "",
      propina: 0,
      compleatdo: "",
      platos: "",
    });
    async function agregarFactura() {
      console.log("Llamado a agregar factura");
      await createFacturaUse(
        nuevaFactura.value.valor,
        nuevaFactura.value.fecha,
        nuevaFactura.value.propina
      );
    }

    return {
      agregarFactura,
      nuevaFactura,
      createFacturaUse,
      platos,
    };
  },
};
</script>

<style scoped>
.agregar {
  margin: auto;
  width: 50%;
  padding: 10px;
}

/*
.valor {
  display: block;
  width: 10%;
  margin: 20px auto;
}
*/

.fecha {
  display: block;
  width: 50%;
  margin: 20px auto;
  height: 20%;
}

.propina {
  margin: 0 20px;
}

.submit {
  margin: 20px;
}
</style>
