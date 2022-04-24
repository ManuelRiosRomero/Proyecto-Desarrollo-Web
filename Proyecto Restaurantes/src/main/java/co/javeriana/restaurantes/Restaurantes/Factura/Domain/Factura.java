package co.javeriana.restaurantes.Restaurantes.Factura.Domain;

import co.javeriana.restaurantes.Restaurantes.Factura.Domain.Entities.FacturaPlato;
import co.javeriana.restaurantes.Restaurantes.Factura.Domain.ValueObjects.*;
import co.javeriana.restaurantes.Restaurantes.Insumo.Domain.ValueObjects.RestauranteID;
import co.javeriana.restaurantes.Restaurantes.Plato.Domain.Entities.PlatoInsumo;
import co.javeriana.restaurantes.Restaurantes.Plato.Domain.Plato;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Factura {
    private FacturaID id;
    private FacturaCompletado completado;
    private Optional<List<FacturaPlato>> platos;
    private FacturaValor valor;
    private FacturaFecha fecha;
    private FacturaPropina propina;
    private RestauranteID restauranteId;

    public Factura(FacturaID id, FacturaCompletado completado, Optional<List<FacturaPlato>> platos, FacturaValor valor, FacturaFecha fecha, FacturaPropina propina, RestauranteID restauranteId) {
        this.id = id;
        this.completado = completado;
        this.platos = platos;
        this.valor = valor;
        this.fecha = fecha;
        this.propina = propina;
        this.restauranteId = restauranteId;
    }

    public HashMap<String, Object> data() {
        HashMap<String, Object> data = new HashMap<>() {{
            put("id", id);
            put("completado", completado);
            put("valor", valor);
            put("fecha", fecha);
            put("propina", propina);
            put("platos", createPlatos());
            put("restauranteId",restauranteId.value());
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
    private Factura(){platos = Optional.empty();}

}
