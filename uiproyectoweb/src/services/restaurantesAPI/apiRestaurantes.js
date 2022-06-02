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
    } else console.log(response);

    const content = await response.json();
    console.log("Fetched: ");
    console.log(content);

    return {
      content,
    };
  }
  // Funcion de crear un plato
  async function createPlato(body) {
    console.log(body);
    const url = "http://localhost:8080/plato/create";
    const config = {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(body),
    };

    const response = await fetch(url, config);

    const content = await response.json();
    console.log("Fetched: ");
    console.log(content);

    if (!response.ok) {
      console.error("Hubo un error al crear un plato");
      console.error(response.status);
    }
  }
  async function addInsumoPlato() {}
  //Funcion de recibir todas las facturas
  async function getFactura() {
    const url = "http://localhost:8080/factura/all";
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
  async function createFactura(body) {
    const url = "http://localhost:8080/factura/create";
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
      console.error("Hubo un error al crear una factura");
    }
  }
  async function getPlatosFactura() {}
  async function addPlatoFactura() {}

  return {
    getMenu,
    getFactura,
    createPlato,
    addInsumoPlato,
    createFactura,
    getPlatosFactura,
    addPlatoFactura,
  };
}
