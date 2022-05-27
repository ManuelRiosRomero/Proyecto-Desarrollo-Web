<template>
  <div class="about">
    <h1>Grupo 2 WEB</h1>
    <ul class="wrapper-miembros">
      <h2>Miembros:</h2>
      <p>Manuel Rios</p>
      <p>Richard Fonseca</p>
      <p>David Palacios</p>
      <p>Sebastian Molano</p>
    </ul>
    <ul class="wrapper-description">
      <h2>Descripcion del Proyecto:</h2>
      <p>
        Sistema para registro y mantenimiento de una cadena de restaurantes.
        Debe poder manejar inventarios, informes, agregar elementos de cocina,
        contabilidad, facturas, transferir insumos de un restaurante a otro.
      </p>
    </ul>
  </div>
</template>

<script>
export default {
  name: "AboutView",
  components: {},
  setup() {
    return {};
  },
};
</script>

<style scoped lang="css">
.wrapper-miembros {
  background-color: #4ac19a;
  padding: 0.1rem;
  width: 40%;
  margin-left: auto;
  margin-right: auto;
}
.wrapper-description {
  background-color: burlywood;
  padding: 0.1rem;
  width: 60%;
  margin-left: auto;
  margin-right: auto;
}
</style>
