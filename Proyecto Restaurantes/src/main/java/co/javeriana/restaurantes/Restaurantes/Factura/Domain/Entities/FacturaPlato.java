package co.javeriana.restaurantes.Restaurantes.Factura.Domain.Entities;

import co.javeriana.restaurantes.Restaurantes.Plato.Domain.Plato;

import java.util.HashMap;
import java.util.List;

public class FacturaPlato {
    private String id;
    private String nombre;
    private String descripcion;
    private double costo;
    private List<Plato> platos;

    public FacturaPlato(String id, String nombre, String descripcion, double costo, List<Plato> platos) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.costo = costo;
        this.platos = platos;
    }

    public HashMap<String, Object> data() {
        HashMap<String, Object> data = new HashMap<>();
        data.put("id", id);
        data.put("nombre", nombre);
        data.put("descripcion", descripcion);
        data.put("costo", costo);
        data.put("platos", platos);
        return data;
    }

    /*
    private List<HashMap<String, Object>> createPlatos() {
        List<HashMap<String, Object>> list = new ArrayList<>();
        if (!platos.isEmpty()) {
            list = platos.get().stream().map(plato -> plato.data()).collect(Collectors.toList());
        }
        return list;
    }

     */
}























