package co.javeriana.restaurantes.CadenaRestaurantes.Cadena.Domain;

import co.javeriana.restaurantes.CadenaRestaurantes.Factura.Domain.Factura;
import co.javeriana.restaurantes.Restaurantes.Domain.Restaurante;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Cadena {
    private Optional<List<Restaurante>> restaurantes;
    private Optional<List<Factura>> facturas;

    public Cadena(Optional<List<Restaurante>> restaurantes, Optional<List<Factura>> facturas) {
        this.restaurantes = restaurantes;
        this.facturas = facturas;
    }

    public static Cadena create(){
        Cadena cadena = new Cadena(Optional.empty(), Optional.empty());
        return cadena;
    }
    //HashMaps
    public HashMap<String, Object> data() {
        HashMap<String, Object> data = new HashMap<>() {{
            put("restauranes", createRestaurante());
            put("isumos", createFacturas());
        }};
        return data;
    }

    private List<HashMap<String, Object>> createRestaurante() {
        List<HashMap<String, Object>> list = new ArrayList<>();
        if (!restaurantes.isEmpty()) {
            list = restaurantes.get().stream().map(restaurante -> restaurante.data()).collect(Collectors.toList());
        }
        return list;
    }

    private List<HashMap<String, Object>> createFacturas() {
        List<HashMap<String, Object>> list = new ArrayList<>();
        if (!facturas.isEmpty()) {
            list = facturas.get().stream().map(factura -> factura.data()).collect(Collectors.toList());
        }
        return list;
    }



}

