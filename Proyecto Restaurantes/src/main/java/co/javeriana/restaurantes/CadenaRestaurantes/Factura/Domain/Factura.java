package co.javeriana.restaurantes.CadenaRestaurantes.Factura.Domain;

import co.javeriana.restaurantes.CadenaRestaurantes.Factura.Domain.ValueObjects.*;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class Factura {
    private FacturaRestauranteID facturaRestauranteID;
    private FacturaDescripcion facturaDescripcion;
    private FacturaInsumos facturaInsumos;
    private FacturaValor facturaValor;
    private FacturaFecha facturaFecha;

    public Factura(FacturaRestauranteID facturaRestauranteID, FacturaDescripcion facturaDescripcion, FacturaInsumos facturaInsumos, FacturaValor facturaValor, FacturaFecha facturaFecha) {
        this.facturaRestauranteID = facturaRestauranteID;
        this.facturaDescripcion = facturaDescripcion;
        this.facturaInsumos = facturaInsumos;
        this.facturaValor = facturaValor;
        this.facturaFecha = facturaFecha;
    }

    public static Factura create(FacturaRestauranteID facturaRestauranteID, FacturaDescripcion facturaDescripcion, FacturaInsumos facturaInsumos, FacturaValor facturaValor){
        Factura factura = new Factura (facturaRestauranteID,
                                        facturaDescripcion,
                                        facturaInsumos,
                                        facturaValor,
                                        new FacturaFecha(Calendar.getInstance().getTime()));
        return factura;
    }

    //HashMap
    public HashMap<String, Object> data(){
        HashMap<String, Object> data = new HashMap<>(){{
            //put("id", facturaRestauranteID.value());
            put("descripcion", facturaDescripcion.value());
            put("insumos", facturaInsumos.value());
            put("valor", facturaValor.value());
            put("fecha", facturaFecha.value());
        }};
        return data;
    }
}
