<template>
  <div class="wrapper-form">
    <div class="wrapper-input">
      <label> : </label>
      <input type="text" class="form" v-model="nuevoPlato.id" />
      <p>{{ errors.errorName }}</p>
    </div>
    <div class="wrapper-input">
      <label> : </label>
      <input type="text" class="form" v-model="nuevoPlato.nombre" />
      <p>{{ errors.errorName }}</p>
    </div>
    <div class="wrapper-input">
      <label> : </label>
      <input type="text" class="form" v-model="nuevoPlato.descripcion" />
      <p>{{ errors.errorName }}</p>
    </div>
    <div class="wrapper-input">
      <label> : </label>
      <input type="text" class="form" v-model="nuevoPlato.costo" />
      <p>{{ errors.errorName }}</p>
    </div>
    <div class="wrapper-input">
      <label> : </label>
      <input type="text" class="form" v-model="nuevoPlato.restauranteId" />
      <p>{{ errors.errorName }}</p>
    </div>

    <button @click="showInfo">Mostrar Datos</button>
  </div>
  <button @click="addCounter">Cargar Plato</button>
</template>

<script>
import { ref } from "vue";

export default {
  name: "PlatoItem",
  setup() {
    const counter = ref(0);
    const nuevoPlato = ref({
      id: "",
      nombre: "",
      descripcion: "",
      costo: 0,
      restauranteId: "",
    });
    const person = ref({
      name: "",
      lastname: "",
      cellphone: "",
      age: 0,
    });
    const errors = ref({
      errorName: "",
      errorLastName: "",
      errorCellphone: "",
      errorAge: "",
    });

    function checkAge(event) {
      const actualAge = event.target.value;
      if (actualAge > 25) {
        errors.value.errorAge = "Edad fuera de rango";
      } else {
        errors.value.errorAge = "";
      }
    }
    // const name = ref("");
    // const lastname = ref("");
    // const cellphone = ref("");
    // const age = ref(0);

    function addCounter() {
      counter.value--;
    }

    function showInfo() {
      console.log(person.value);
      // console.log(lastname)
      // console.log(cellphone)
      // console.log(age)
    }

    // watch(
    //     () => name.value,
    //     () => {
    //       console.log(name.value);
    //     }
    // );

    return {
      counter,
      addCounter,
      // name,
      // lastname,
      // cellphone,
      // age,
      showInfo,
      person,
      nuevoPlato,
      errors,
      checkAge,
    };
  },
};
</script>

<style scoped>
.form {
  margin-top: 2rem;
}

.wrapper-error {
  border: 1px solid red;
}
</style>
