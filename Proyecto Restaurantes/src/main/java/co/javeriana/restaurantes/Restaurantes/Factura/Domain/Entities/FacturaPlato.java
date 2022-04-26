package co.javeriana.restaurantes.Restaurantes.Factura.Domain.Entities;

import co.javeriana.restaurantes.Restaurantes.Plato.Domain.Plato;

import java.util.HashMap;
import java.util.List;

public class FacturaPlato {
    private String id;
    private String nombre;
    private int cantidad;
    private double precio;

    public FacturaPlato(String id, String nombre, int cantidad, double precio) {
        this.id = id;
        this.cantidad = cantidad;
        this.nombre = nombre;
        this.precio = precio;
    }

    public HashMap<String, Object> data() {
        HashMap<String, Object> data = new HashMap<>();
        data.put("id", id);
        data.put("nombre", nombre);
        data.put("cantidad", cantidad);
        data.put("precio", precio);
        return data;
    }
}























