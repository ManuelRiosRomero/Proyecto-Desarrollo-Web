package co.javeriana.restaurantes.Restaurantes.Domain.Entities;


import java.util.HashMap;

public class InsumoRestaurante {
    private String id;
    private String nombre;
    private int cantidad;
    private double costo;

    public InsumoRestaurante(String id, String nombre, int cantidad, double costo) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.costo = costo;
    }

    public HashMap<String, Object> data() {
        HashMap<String, Object> data = new HashMap<>();
        data.put("id", id);
        data.put("nombre", nombre);
        data.put("cantidad", cantidad);
        data.put("costo", costo);
        return data;
    }


}
