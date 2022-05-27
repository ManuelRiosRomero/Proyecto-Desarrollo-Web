<template>
  <div class="home">
    <img alt="Restaurante Logo" src="../assets/logo-restaurante.png" />
    <HelloWorld msg="Proyecto WEB: Restaurantes" />
  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from "@/components/HelloWorld.vue";

export default {
  name: "HomeView",
  components: {
    HelloWorld,
  },
};
</script>
