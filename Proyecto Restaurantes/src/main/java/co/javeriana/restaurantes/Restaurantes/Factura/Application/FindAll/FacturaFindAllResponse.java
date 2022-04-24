package co.javeriana.restaurantes.Restaurantes.Factura.Application.FindAll;

import co.javeriana.restaurantes.Restaurantes.Factura.Domain.Factura;


import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class FacturaFindAllResponse {

    private List<Factura> facturas;

    public FacturaFindAllResponse(List<Factura> facturas) {
        this.facturas = facturas;
    }

    public List<HashMap<String,Object>> response(){
        List<HashMap<String,Object>> response = facturas.stream().map(factura -> factura.data()).collect(Collectors.toList());
        return response;
    }

}
