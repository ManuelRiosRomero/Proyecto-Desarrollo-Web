<template>
  <h2>Crear Plato</h2>
  <div class="wrapper-form">
    <div class="wrapper-input">
      <label>Id : </label>
      <input type="text" class="form" v-model="nuevoPlato.id" />
      <p>{{ errors.errorId }}</p>
    </div>
    <div class="wrapper-input">
      <label>Nombre : </label>
      <input type="text" class="form" v-model="nuevoPlato.nombre" />
      <p>{{ errors.errorName }}</p>
    </div>
    <div class="wrapper-input">
      <label>Descripcion : </label>
      <input type="text" class="form" v-model="nuevoPlato.descripcion" />
      <p>{{ errors.errorDescription }}</p>
    </div>
    <div class="wrapper-input">
      <label>Costo : </label>
      <input
        type="number"
        class="form"
        v-model="nuevoPlato.costo"
        @input="checkValue"
      />
      <div class="wrapper-error" v-if="errors.errorValue != ''">
        <p>{{ errors.errorValue }}</p>
      </div>
    </div>
    <div class="wrapper-input">
      <label>ID del Restaurante : </label>
      <input type="text" class="form" v-model="nuevoPlato.restauranteId" />
      <p>{{ errors.errorRestID }}</p>
    </div>
  </div>
  <button @click="createPlatoUse">Cargar Plato</button>
</template>

<script>
import { ref } from "vue";
import { menuUse } from "@/uses/MenuUse";

const { createPlato } = menuUse();
export default {
  name: "CrearPlato",
  setup() {
    const nuevoPlato = ref({
      id: "",
      nombre: "",
      descripcion: "",
      costo: 0,
      restauranteId: "",
    });
    const errors = ref({
      errorId: "",
      errorName: "",
      errorDescription: "",
      errorValue: "",
      errorRestID: "",
    });
    function checkValue(event) {
      const actualValue = event.target.value;
      if (actualValue < 0 || actualValue == 0) {
        errors.value.errorValue =
          "El valor de un plato no puede ser igual o menor que 0";
      } else {
        errors.value.errorValue = "";
      }
    }
    async function createPlatoUse(nuevoPlato) {
      await createPlato(JSON.stringify(nuevoPlato));
      //await createPlato(nuevoPlato);

      /*
        await createPlato(
        JSON.stringify(
          nuevoPlato.value.id,
          nuevoPlato.value.name,
          nuevoPlato.value.descripcion,
          nuevoPlato.value.costo,
          nuevoPlato.value.restauranteId
        )
      );
* */
    }
    return {
      nuevoPlato,
      errors,
      checkValue,
      createPlatoUse,
    };
  },
};
</script>

<style scoped>
.wrapper-error {
  border: 1px solid red;
}
</style>
