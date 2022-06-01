<template>
  <h1>Login</h1>
  <div class="wrapper-input">
    <label>Email: </label>
    <input type="text" v-model="formLogin.email" />
  </div>
  <div class="wrapper-input">
    <label>Password: </label>
    <input type="password" v-model="formLogin.password" />
  </div>
  <button @click="authenticate" :disabled="enableButton">Ingresar</button>
</template>

<script lang="js">
import { LoginUse } from "@/uses/LoginUse";

export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: "Login",
    setup(){
    const { formLogin, authenticate, enableButton } = LoginUse()
      return{
        formLogin,
        authenticate,
        enableButton,
      }
    }
};
</script>

<style scoped></style>
