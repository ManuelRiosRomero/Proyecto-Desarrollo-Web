export function apiRestaurantes() {
  async function getMenu() {
    const url = "http://localhost:8080/plato/all";
    const config = {
      method: "GET",
      headers: {
        "Content-Type": "application/json",
      },
    };

    const response = await fetch(url, config);

    if (!response.ok) {
      console.error("Hubo un error");
    }

    const content = await response.json();
    console.log("Fetched: ");
    console.log(content);

    return {
      content,
    };
  }
  async function createPlato() {}
  async function addInsumoPlato() {}

  async function createFactura() {}
  async function getPlatosFactura() {}
  async function addPlatoFactura() {}

  return {
    getMenu,
    createPlato,
    addInsumoPlato,
    createFactura,
    getPlatosFactura,
    addPlatoFactura,
  };
}
