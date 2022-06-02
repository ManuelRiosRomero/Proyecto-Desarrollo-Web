import { useRouter } from "vue-router";

export function HomeUse() {
  const router = useRouter();

  async function goToMenu() {
    await router.push("/menu/");
  }

  async function goToAbout() {
    await router.push("/about");
  }

  async function goToPedido() {
    await router.push("/pedido");
  }
  async function goToFactura() {
    await router.push("/factura");
  }

  return {
    goToMenu,
    goToAbout,
    goToPedido,
    goToFactura,
  };
}
