package co.javeriana.restaurantes.Restaurantes.Factura.Domain;

import co.javeriana.restaurantes.Restaurantes.Factura.Domain.ValueObjects.*;
import co.javeriana.restaurantes.Restaurantes.Plato.Domain.Plato;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Factura {
    private FacturaID id;
    private FacturaDescripcion descripcion;
    private Optional<List<Plato>> platos;
    private FacturaValor valor;
    private FacturaFecha fecha;
    private FacturaPropina propina;

    public Factura(FacturaID id, FacturaDescripcion descripcion, Optional<List<Plato>> platos, FacturaValor valor, FacturaFecha fecha, FacturaPropina propina) {
        this.id = id;
        this.descripcion = descripcion;
        this.platos = platos;
        this.valor = valor;
        this.fecha = fecha;
        this.propina = propina;
    }

    public HashMap<String, Object> data() {
        HashMap<String, Object> data = new HashMap<>() {{
            put("id", id);
            put("descripcion", descripcion);
            put("valor", valor);
            put("fecha", fecha);
            put("propina", propina);
            put("platos", createPlatos());
        }};
        return data;
    }

    private List<HashMap<String, Object>> createPlatos() {
        List<HashMap<String, Object>> list = new ArrayList<>();
        if (!platos.isEmpty()) {
            list = platos.get().stream().map(plato -> plato.data()).collect(Collectors.toList());
        }
        return list;
    }

}
