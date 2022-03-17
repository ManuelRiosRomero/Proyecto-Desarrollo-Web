package co.javeriana.restaurantes.Restaurantes.Domain.Entities;

import co.javeriana.restaurantes.Restaurantes.Domain.ValueObjects.UbicacionCiudad;
import co.javeriana.restaurantes.Restaurantes.Domain.ValueObjects.UbicacionDireccion;
import co.javeriana.restaurantes.Restaurantes.Domain.ValueObjects.UbicacionID;
import co.javeriana.restaurantes.Restaurantes.Domain.ValueObjects.UbicacionPais;

import java.util.HashMap;

public class Ubicacion {

    private UbicacionID id;
    private UbicacionPais pais;
    private UbicacionCiudad ciudad;
    private UbicacionDireccion direccion;

    private Ubicacion() {}

    public Ubicacion(UbicacionID id, UbicacionPais pais, UbicacionCiudad ciudad, UbicacionDireccion direccion) {
        this.id = id;
        this.pais = pais;
        this.ciudad = ciudad;
        this.direccion = direccion;
    }

    public HashMap<String, Object> data() {
        HashMap<String, Object> data = new HashMap<>() {{
            put("id", id);
            put("pais", pais);
            put("ciudad", ciudad);
            put("direccion", direccion);
        }};
        return data;
    }

}
