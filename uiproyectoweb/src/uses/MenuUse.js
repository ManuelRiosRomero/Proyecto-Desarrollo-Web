import { apiRestaurantes } from "@/services/restaurantesAPI/apiRestaurantes";
import { onMounted, ref } from "vue";

export function menuUse() {
  const platos = ref([]);
  const { getMenu } = apiRestaurantes();

  onMounted(async () => {
    platos.value = (await getMenu()).content;
    console.log("Loaded: ");
    console.log(platos.value);
  });

  return {
    platos,
    getMenu,
  };
}
