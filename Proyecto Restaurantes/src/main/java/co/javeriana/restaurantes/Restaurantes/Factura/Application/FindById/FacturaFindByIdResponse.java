package co.javeriana.restaurantes.Restaurantes.Factura.Application.FindById;

import co.javeriana.restaurantes.Restaurantes.Factura.Domain.Factura;

import java.util.HashMap;

public class FacturaFindByIdResponse {

    private Factura factura;

    public FacturaFindByIdResponse(Factura factura) {
        this.factura = factura;
    }

    public HashMap<String, Object> response() {

        HashMap<String, Object> response = factura.data();
        return response;
    }

}
