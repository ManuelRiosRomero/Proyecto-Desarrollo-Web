package co.javeriana.restaurantes.Restaurantes.Plato.Domain.Entities;

import java.util.HashMap;

public class PlatoInsumo {

    private String id;
    private String nombre;
    private int cantidadnecesaria;

    //private double costo;


    public PlatoInsumo(String id, int cantidadnecesaria, String nombre) {
        this.id = id;
        this.cantidadnecesaria = cantidadnecesaria;
        this.nombre = nombre;
    }

    public HashMap<String, Object> data() {
        HashMap<String, Object> data = new HashMap<>();
        data.put("id", id);
        data.put("cantidadnecesaria", cantidadnecesaria);
        data.put("nombre", nombre);
        return data;
    }

}
