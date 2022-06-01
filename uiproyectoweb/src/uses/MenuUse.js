import { apiRestaurantes } from "@/services/restaurantesAPI/apiRestaurantes";
import { onMounted, ref } from "vue";
import { useRouter } from "vue-router";
import { resID } from "@/uses/ResID";

export function menuUse() {
  const router = useRouter();
  const platos = ref([]);
  const { getMenu } = apiRestaurantes();
  const { createPlato } = apiRestaurantes();

  onMounted(async () => {
    platos.value = (await getMenu()).content;
    console.log("Loaded: ");
    console.log(platos.value);
  });

  async function goToCrearPlato() {
    await router.push("/menu/crearplato");
  }

  function uuidv4() {
    return ([1e7] + -1e3 + -4e3 + -8e3 + -1e11).replace(/[018]/g, (c) =>
      (
        c ^
        (crypto.getRandomValues(new Uint8Array(1))[0] & (15 >> (c / 4)))
      ).toString(16)
    );
  }

  async function createPlatoUse(nombre, descripcion, costo) {
    if (nombre === "") {
      alert("El nombre no puede quedar vacio");
      return;
    }
    const plato = {
      id: uuidv4(),
      nombre: nombre,
      descripcion: descripcion,
      costo: costo,
      resId: resID().restaurant_id,
    };
    console.log("Attempted request with the following body: ");
    console.log(plato);

    await createPlato(plato);
  }

  return {
    goToCrearPlato,
    platos,
    getMenu,
    createPlatoUse,
  };
}
