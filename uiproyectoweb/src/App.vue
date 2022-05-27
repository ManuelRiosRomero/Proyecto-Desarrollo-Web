<template>
  <ul class="wrapper-header">
    <li>
      <router-link to="/test">Home</router-link>
    </li>
  </ul>
  <router-view />
</template>

<script>
import { onErrorCaptured, ref } from "vue";

export default {
  name: "App",
  setup() {
    const title = ref("Ejemplo");

    onErrorCaptured((error) => {
      alert(error.message);
    });

    return {
      title,
    };
  },
};
</script>
<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}
.wrapper-header {
  margin-left: auto;
}
</style>
