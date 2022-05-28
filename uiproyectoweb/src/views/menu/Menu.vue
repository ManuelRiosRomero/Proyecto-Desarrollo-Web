<template>
  <!--
  <div class="grid-container">
    <h1>Plato1</h1>
    <h1>Plato2</h1>
    <h1>Plato3</h1>
  </div>
  -->
  <h2>Menu</h2>
  <ul class="menu">
    <menu-item
      v-for="plato in platos"
      :key="plato.id"
      :nombre="plato.nombre"
      :descripcion="plato.descripcion"
      :path="path"
    ></menu-item>
  </ul>
  <div class="bottom">
    <button class="but">Agregar Plato</button>
  </div>
</template>

<script>
import MenuItem from "@/components/menu/MenuItem";
import { menuUse } from "@/uses/MenuUse";

export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: "Menu",
  components: { MenuItem },
  data() {
    return {
      items: [
        {
          id: "531fcea8-c4ea-11ec-9d64-0242ac120002",
          descripcion:
            "Ensalada compuesta por lechuga, tomate, crutones y trozos de pollo,queso",
          nombre: "Ensalada de Pollo",
        },
        {
          id: "a4ba8004-bf4b-11ec-9d64-0242ac120002",
          descripcion: "Un arroz con pollo completo sin bebida",
          nombre: "Arroz con pollo",
        },
      ],
      path: "../assets/logo.png",
    };
  },
  setup() {
    const { platos } = menuUse();
    return {
      platos,
    };
  },
};
</script>

<style scoped lang="css">
.menu {
  list-style-type: none;
  padding: 2%;
}
.grid-container {
  display: grid;
  grid-template-columns: auto auto auto;
  background-color: #4ac19a;
  padding: 10px;
  margin: 20px;
}
</style>
