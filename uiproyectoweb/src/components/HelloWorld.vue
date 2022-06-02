<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <ul class="wrapper-botones">
      <button @click="goToMenu">Revisar Menu</button>
      <button @click="goToPedido">Realizar Pedido(s)</button>
      <button @click="goToFactura">Ver Todas las Facturas</button>
      <button @click="goToAbout">About del Proyecto</button>
    </ul>
    <h3>Essential Links</h3>
    <ul>
      <li>
        <a
          href="https://github.com/ManuelRiosRomero/Proyecto-Desarrollo-Web"
          target="_blank"
          rel="noopener"
          >Repositorio en GitHub</a
        >
      </li>
      <br />
      <li>
        <a
          href="https://lucid.app/lucidchart/61518bca-b084-4191-9d68-8d8801230b67/edit?invitationId=inv_a77f603d-10e1-46d6-8a37-2c6d41226d9c"
          target="_blank"
          rel="noopener"
          >Casos de Uso</a
        >
      </li>
      <li>
        <a
          href="https://lucid.app/lucidchart/040a0efb-1a10-4fff-926c-f1ca7a9b6036/edit?page=0_0#shared=true&page=0_0"
          target="_blank"
          rel="noopener"
          >Diagrama Bundle Context</a
        >
      </li>
      <li>
        <a
          href="https://app.quickdatabasediagrams.com/#/d/o11HgW"
          target="_blank"
          rel="noopener"
          >Diagrama de Bases de Datos</a
        >
      </li>
      <li>
        <a
          href="https://trello.com/b/TJZS24Up/proyecto-web-restaurantes"
          target="_blank"
          rel="noopener"
          >Trello del Grupo</a
        >
      </li>
    </ul>
  </div>
</template>

<script>
import { HomeUse } from "../uses/HomeUse";
export default {
  name: "HelloWorld",
  props: {
    msg: String,
  },
  setup() {
    const { goToMenu, goToAbout, goToPedido, goToFactura } = HomeUse();

    return { goToMenu, goToAbout, goToPedido, goToFactura };
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
.wrapper-botones {
  background-color: antiquewhite;
  border-spacing: 0.1rem;
}
</style>
