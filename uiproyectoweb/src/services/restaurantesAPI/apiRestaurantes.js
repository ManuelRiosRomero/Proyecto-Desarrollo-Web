export function apiRestaurantes() {
  // Funcion de recibir el menu
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
      console.error("Hubo un error recibiendo todos los platos");
    }

    const content = await response.json();
    console.log("Fetched: ");
    console.log(content);

    return {
      content,
    };
  }
  // Funcion de crear un plato
  async function createPlato(body) {
    const url = "http://localhost:8080/plato/create";
    const config = {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: body,
    };

    const response = await fetch(url, config);

    const content = await response.json();
    console.log("Fetched: ");
    console.log(content);

    if (!response.ok) {
      console.error("Hubo un error al crear un plato");
    }
  }
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
