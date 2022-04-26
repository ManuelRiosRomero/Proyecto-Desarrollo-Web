package co.javeriana.restaurantes.Restaurantes.Factura.Application.Calculate;

import co.javeriana.restaurantes.Restaurantes.Factura.Domain.Factura;

import java.util.HashMap;

public class FacturaCalculateTotalResponse {
    private double total;
    private String facturaId;
    public FacturaCalculateTotalResponse(double total, String facturaId) {
        this.total = total;
        this.facturaId = facturaId;
    }

    public HashMap<String, Object> response()
    {
        HashMap<String, Object> response = new HashMap<>();
        response.put("facturaid", facturaId);
        response.put("total", total);
        return response;
    }

}
