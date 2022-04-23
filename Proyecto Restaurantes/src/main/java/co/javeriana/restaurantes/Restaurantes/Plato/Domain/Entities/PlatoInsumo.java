package co.javeriana.restaurantes.Restaurantes.Plato.Domain.Entities;

import java.util.HashMap;

public class PlatoInsumo {

    private String id;
    private int cantidad;
    private String nombre;
    private double costo;


    public PlatoInsumo(String id, int cantidad, String nombre, double costo) {
        this.id = id;
        this.cantidad = cantidad;
        this.nombre = nombre;
        this.costo = costo;
    }

    public HashMap<String, Object> data() {
        HashMap<String, Object> data = new HashMap<>();
        data.put("id", id);
        data.put("cantidad", cantidad);
        data.put("nombre", nombre);
        data.put("costo", costo);
        return data;
    }

}
