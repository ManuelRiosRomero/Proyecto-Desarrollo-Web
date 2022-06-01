<template>
  <h2>Agregar Plato</h2>
  <form class="agregar">
    <input
      class="nombre"
      type="text"
      id="plato_nombre"
      placeholder="Nombre del plato"
      v-model="nuevoPlato.nombre"
    />
    <textarea
      rows="5"
      class="desc"
      id="plato_desc"
      placeholder="Descripcion"
      v-model="nuevoPlato.descripcion"
    />
    <div class="costo">
      <label for="">Costo</label>
      <input
        type="number"
        class="costo"
        id="plato_costo"
        v-model="nuevoPlato.costo"
      />
    </div>
  </form>
  <button class="submit" @click="agregarPlato">Agregar Plato</button>
</template>

<script>
import { ref } from "vue";
import { menuUse } from "@/uses/MenuUse";

export default {
  name: "CrearPlato",
  setup() {
    const { createPlatoUse } = menuUse();
    const nuevoPlato = ref({
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

    async function agregarPlato() {
      console.log("Llamado a agregar plato");
      await createPlatoUse(
        nuevoPlato.value.nombre,
        nuevoPlato.value.descripcion,
        nuevoPlato.value.costo
      );
    }

    return {
      agregarPlato,
      nuevoPlato,
      errors,
      createPlatoUse,
    };
  },
};
</script>

<style scoped>
.agregar {
  margin: auto;
  width: 50%;
  padding: 10px;
}

.nombre {
  display: block;
  width: 50%;
  margin: 20px auto;
}

.desc {
  display: block;
  width: 50%;
  margin: 20px auto;
  height: 20%;
}

.costo {
  margin: 0 20px;
}

.submit {
  margin: 20px;
}
</style>
