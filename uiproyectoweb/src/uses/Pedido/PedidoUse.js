import { apiRestaurantes } from "@/services/restaurantesAPI/apiRestaurantes";
import { onMounted, ref } from "vue";
import { useRouter } from "vue-router";
import { resID } from "@/uses/ResID";

export function PedidoUse() {
  const router = useRouter();
  const facturas = ref([]);
  const pedidos = ref([]);
  const { getFacturas, getPlatosFactura, createFactura, addPlatoFactura } =
    apiRestaurantes();

  onMounted(async () => {
    facturas.value = (await getFacturas()).content;
    console.log("Loaded: ");
    console.log(facturas.value);
  });

  async function goToFactura() {
    await router.push("/factura");
  }
  async function goToCrearFactura() {
    await router.push("/factura/create");
  }
  async function goHome() {
    await router.push("home");
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

    await createFactura(factura);
    return factura;
  }

  function uuidv4() {
    return ([1e7] + -1e3 + -4e3 + -8e3 + -1e11).replace(/[018]/g, (c) =>
      (
        c ^
        (crypto.getRandomValues(new Uint8Array(1))[0] & (15 >> (c / 4)))
      ).toString(16)
    );
  }

  async function createPlatoFacturaUse(
    precio,
    facturaID,
    platoID,
    cantidad,
    nombre
  ) {
    const platoFactura = {
      precio: precio,
      facturaID: facturaID,
      platoID: platoID,
      cantidad: cantidad,
      nombre: nombre,
    };

    await addPlatoFactura(platoFactura);
  }

  return {
    goToFactura,
    facturas,
    pedidos,
    getPlatosFactura,
    getFacturas,
    goToCrearFactura,
    createFactura,
    createFacturaUse,
    createPlatoFacturaUse,
    goHome,
  };
}
