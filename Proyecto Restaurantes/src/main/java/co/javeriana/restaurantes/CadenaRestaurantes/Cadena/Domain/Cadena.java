package co.javeriana.restaurantes.CadenaRestaurantes.Cadena.Domain;


import co.javeriana.restaurantes.CadenaRestaurantes.Cadena.Domain.ValueObjects.CadenaID;
import co.javeriana.restaurantes.CadenaRestaurantes.Cadena.Domain.ValueObjects.CadenaNombreEmpresarial;
import co.javeriana.restaurantes.CadenaRestaurantes.Cadena.Domain.ValueObjects.CadenaNumeroContacto;
import co.javeriana.restaurantes.Restaurantes.Domain.Restaurante;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Cadena {
    private CadenaID id;
    private Optional<List<Restaurante>> restaurantes;
    private CadenaNombreEmpresarial nombre;
    private CadenaNumeroContacto numero;


    public Cadena(CadenaID id, Optional<List<Restaurante>> restaurantes, CadenaNombreEmpresarial nombre, CadenaNumeroContacto numero) {
        this.id = id;
        this.restaurantes = restaurantes;
        this.nombre = nombre;
        this.numero = numero;
    }

    public static Cadena create(CadenaID id, CadenaNombreEmpresarial nombre, CadenaNumeroContacto numero){
        Cadena cadena = new Cadena(id, Optional.empty(),nombre, numero);
        return cadena;
    }
    //HashMaps
    public HashMap<String, Object> data() {
        HashMap<String, Object> data = new HashMap<>() {{
            put("id",id);
            put("restauranes", createRestaurante());
            put("nombre",nombre);
            put("numero",numero);

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





}

