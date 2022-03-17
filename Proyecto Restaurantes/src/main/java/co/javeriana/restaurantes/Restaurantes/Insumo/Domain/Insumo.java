package co.javeriana.restaurantes.Restaurantes.Insumo.Domain;

import co.javeriana.restaurantes.Restaurantes.Insumo.Domain.ValueObjects.InsumoCantidad;
import co.javeriana.restaurantes.Restaurantes.Insumo.Domain.ValueObjects.InsumoID;
import co.javeriana.restaurantes.Restaurantes.Insumo.Domain.ValueObjects.InsumoNombre;

import java.util.HashMap;

public class Insumo {

    private InsumoID id;
    private InsumoCantidad cantidad;
    private InsumoNombre nombre;

    public Insumo(InsumoID id, InsumoCantidad cantidad, InsumoNombre nombre) {
        this.id = id;
        this.cantidad = cantidad;
        this.nombre = nombre;
    }

    private Insumo() {}

    public HashMap<String, Object> data() {
        HashMap<String, Object> data = new HashMap<>() {{
            put("id", id);
            put("cantidad", cantidad);
            put("nombre", nombre);
        }};
        return data;
    }

}
