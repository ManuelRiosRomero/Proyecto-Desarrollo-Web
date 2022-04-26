package co.javeriana.restaurantes.Restaurantes.Factura.Application.ModifyPropina;

import co.javeriana.restaurantes.Restaurantes.Factura.Domain.Factura;
import co.javeriana.restaurantes.Restaurantes.Insumo.Domain.Insumo;
import co.javeriana.restaurantes.Restaurantes.Insumo.Domain.ValueObjects.InsumoID;

import java.util.HashMap;
import java.util.Optional;

public class FacturaModifyPropinaResponse {
    private double propina;
    private String facturaId;
    public FacturaModifyPropinaResponse(double propina, String facturaId) {
        this.propina = propina;
        this.facturaId = facturaId;
    }

    public HashMap<String, Object> response()
    {
        HashMap<String, Object> response = new HashMap<>();
        response.put("facturaid", facturaId);
        response.put("propina", propina);
        return response;
    }
}
