import { apiRestaurantes } from "@/services/restaurantesAPI/apiRestaurantes";
import { onMounted, ref } from "vue";
import { useRouter } from "vue-router";
import { resID } from "@/uses/ResID";

export function PedidoUse() {
  const router = useRouter();
  const facturas = ref([]);
  const pedidos = ref([]);
  const { getFactura, getPlatosFactura, createFactura } = apiRestaurantes();

  onMounted(async () => {
    facturas.value = (await getFactura()).content;
    console.log("Loaded: ");
    console.log(facturas.value);
  });

  async function goToFactura() {
    await router.push("/factura");
  }
  async function goToCrearFactura() {
    await router.push("/factura/create");
  }
  async function createFacturaUse(valor, fecha, propina) {
    if (valor === "") {
      alert("El valor no puede quedar vacio");
      return;
    }
    const factura = {
      id: uuidv4(),
      valor: valor,
      fecha: fecha,
      propina: propina,
      resId: resID().restaurant_id,
    };
    console.log("Attempted request with the following body: ");
    console.log(factura);

    await router.push("/menu/agregarInsumos");

    await createFactura(factura);
  }

  function uuidv4() {
    return ([1e7] + -1e3 + -4e3 + -8e3 + -1e11).replace(/[018]/g, (c) =>
      (
        c ^
        (crypto.getRandomValues(new Uint8Array(1))[0] & (15 >> (c / 4)))
      ).toString(16)
    );
  }

  return {
    goToFactura,
    facturas,
    pedidos,
    getPlatosFactura,
    getFactura,
    goToCrearFactura,
    createFactura,
    createFacturaUse,
  };
}
