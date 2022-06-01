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
    <button @click="goToCrearPlato">Agregar Plato</button>
  </div>
</template>

<script>
import MenuItem from "@/components/menu/MenuItem";
import { menuUse } from "@/uses/MenuUse";

export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: "Menu",
  components: { MenuItem },
  setup() {
    const { platos, goToCrearPlato } = menuUse();
    return {
      platos,
      goToCrearPlato,
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
