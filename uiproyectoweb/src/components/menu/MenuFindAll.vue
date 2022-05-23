<template>
  <p>ID del Plato: {{ id }}</p>
  <p>Nombre del plato: {{ nombre }}</p>
  <p>Descripcion: {{ descripcion }}</p>
  <p>Costo Unitario: {{ costo }}</p>
  <p>ID del Restaurante: {{ restauranteId }}</p>
  <p>Lista de insumos: {{ insumos }}</p>
</template>

<script lang="js">
export default {
  name: "MenuFindAll",
  props: {
    id: {
      type: String,
      default: "",
      required: true
    },
    nombre: {
      type: String,
      default: ""
    },
    descripcion: {
      type: String,
      default: ""
    },
    costo: {
      type: Number,
    },
    restauranteId: {
      type: String,
      default: "",
      required: true
    },
    insumos: {
      type: String,
      default: ""
    }
  },
  /*
  setup(props, context) {
    const { newName } = pokemonPokedexDetailsUse()

    function cleanPokemon() {
      context.emit("clean")
    }

    function changeName() {
      context.emit("change", newName.value)
    }

    const isPokemonCaptured = computed(() => {
      return props.isCaptured ? "Si" : "No"
    })

    return {
      cleanPokemon,
      newName,
      changeName,
      isPokemonCaptured,
    }
  }
   */
};
</script>

<style scoped></style>
