package co.javeriana.restaurantes.Restaurantes.Factura.PlatoFactura.Application.FindAll;

import co.javeriana.restaurantes.Restaurantes.Factura.PlatoFactura.Domain.PlatoFactura;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class PlatoFacturaFindAllResponse {

    private List<PlatoFactura> platoFacturas;

    public PlatoFacturaFindAllResponse(List<PlatoFactura> platoFacturas) {
        this.platoFacturas = platoFacturas;
    }

    public List<HashMap<String, Object>> response() {
        List<HashMap<String,Object>> response = platoFacturas.stream().map(platoFactura -> platoFactura.data()).collect(Collectors.toList());
        return response;
    }
}
