<template>
  <div id="north"></div>
  <div id="east"></div>
  <div id="west">
    <h3>En pedido</h3>
    <ul class="menu">
      <li class="pedido_item" v-for="plato in platos_agregados" :key="plato.id">
        {{ plato.nombre }} X{{ plato.cantidad }}
        <button class="agregar" @click="eliminar_plato(plato)">Eliminar</button>
      </li>
    </ul>
    <p>Costo: {{ costo_platos }}</p>
  </div>
  <div id="center">
    <h2>Menu</h2>
    <ul class="menu">
      <li class="menuitem" v-for="plato in platos" :key="plato.id">
        <img class="img" src="../../assets/item.png" />
        <p class="nombre">{{ plato.nombre }}</p>
        <p class="descripcion">{{ plato.descripcion }}</p>
        <p class="costo">${{ plato.costo }}</p>
        <button class="agregar" @click="agregar_plato(plato)">Agregar</button>
      </li>
    </ul>
  </div>
  <div id="south">
    <button @click="agregar_plato_facturas">Terminar y agregar plato</button>
  </div>
</template>

<script>
import { menuUse } from "@/uses/MenuUse";
import { ref } from "vue";
import { PedidoUse } from "@/uses/Pedido/PedidoUse";

export default {
  name: "AgregarPlatos",
  setup() {
    const { platos } = menuUse();
    const platos_agregados = ref([]);
    const costo_platos = ref(0);
    const { createFacturaUse, createPlatoFacturaUse, goHome } = PedidoUse();

    function agregar_plato(plato) {
      if (!plato.cantidad) {
        plato.cantidad = 1;
      }
      console.log(plato);
      if (platos_agregados.value.some((element) => element.id === plato.id)) {
        platos_agregados.value.map((element) => {
          if (element.id === plato.id) element.cantidad += 1;
          console.log("Se agrego una nueva cantidad a un plato existente");
        });
      } else {
        console.log("Se agrego un plato nuevo a la lista");
        platos_agregados.value.push(plato);
        console.log(platos_agregados.value.length);
      }
      costo_platos.value = platos_agregados.value.reduce(
        (previousValue, currentValue) =>
          previousValue + currentValue.costo * currentValue.cantidad,
        0
      );
      console.log("Nuevo costo: " + costo_platos.value);
    }

    function eliminar_plato(plato) {
      platos_agregados.value.map((element) => {
        if (element.id === plato.id) {
          if (element.cantidad > 1) {
            element.cantidad -= 1;
          } else {
            const index = platos_agregados.value.findIndex((element) => {
              return element.id === plato.id;
            });
            platos_agregados.value.splice(index, 1);
          }
        }
        costo_platos.value = platos_agregados.value.reduce(
          (previousValue, currentValue) =>
            previousValue + currentValue.costo * currentValue.cantidad,
          0
        );
      });
    }

    async function agregar_plato_facturas() {
      const today = new Date();
      const dd = String(today.getDate()).padStart(2, "0");
      const mm = String(today.getMonth() + 1).padStart(2, "0");
      const yyyy = today.getFullYear();
      const fecha = yyyy + "-" + mm + "-" + dd;

      const factura = await createFacturaUse(costo_platos.value, fecha, 0);
      console.log("Se agrego la nueva factura: ");
      console.log(factura);
      const id = factura.id;
      for (const element of platos_agregados.value) {
        await createPlatoFacturaUse(
          element.costo * element.cantidad,
          id,
          element.id,
          element.cantidad,
          element.nombre
        );
        console.log("Se agrego un elemento a la factura");
      }
      alert("Se agrego una nueva factura");
      await goHome();
    }

    return {
      platos,
      platos_agregados,
      agregar_plato,
      costo_platos,
      eliminar_plato,
      agregar_plato_facturas,
      goHome,
    };
  },
};
</script>

<style scoped>
.agregar {
  margin: 5px;
}
.pedido_item {
  margin-bottom: 10px;
}
.menuitem {
  background-color: aliceblue;
  margin: 10px;
}
.img {
  width: 100px;
}
.nombre {
  padding: 10px;
  font-weight: bold;
  color: #2c3e50;
}
.menu {
  margin-right: auto;
  margin-left: auto;
  width: 60%;
  list-style-type: none;
  padding: 2%;
}
#north {
  margin: 0;
  padding: 1em;
}
#south {
  margin: 0;
  padding: 1em;
}
#east {
  margin: 0;
  padding: 1em;
  width: 6em;
  height: 22em;
  float: right;
  margin-right: 1.1em;
}
#west {
  margin: 0;
  padding: 1em;
  width: 6em;
  height: auto;
  float: left;
  margin-left: 1.1em;
}
#center {
  margin: 0;
  padding: 1em;
  padding-bottom: 0em;
}
#center:after {
  content: " ";
  clear: both;
  display: block;
  height: 0;
  overflow: hidden;
}
</style>
