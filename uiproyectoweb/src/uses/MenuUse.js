import { apiRestaurantes } from "@/services/restaurantesAPI/apiRestaurantes";
import { onMounted, ref } from "vue";
import { useRouter } from "vue-router";

export function menuUse() {
  const router = useRouter();
  const platos = ref([]);
  const { getMenu } = apiRestaurantes();

  onMounted(async () => {
    platos.value = (await getMenu()).content;
    console.log("Loaded: ");
    console.log(platos.value);
  });

  async function goToCrearPlato() {
    await router.push("/menu/crearplato");
  }

  async function createPlato(id, nombre, descripcion, costo, resId) {
    const plato = {
      id: id,
      nombre: nombre,
      descripcion: descripcion,
      costo: costo,
      resId: resId,
    };

    await createPlato(JSON.stringify(plato));
  }

  return {
    goToCrearPlato,
    platos,
    getMenu,
    createPlato,
  };
}
