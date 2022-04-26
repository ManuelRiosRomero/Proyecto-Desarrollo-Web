package co.javeriana.restaurantes.Restaurantes.Factura.PlatoFactura.Domain.ValueObjects;

//import co.javeriana.restaurantes.Restaurantes.Domain.Exceptions.;
import co.javeriana.restaurantes.Shared.Domain.Aggregate.IntegerValueObject;

public class PlatoFacturaCantidad extends IntegerValueObject {

    private PlatoFacturaCantidad(){}

    public PlatoFacturaCantidad(Integer value){
        validate(value);
        this.value = value;
    }

    private void validate(Integer value) {
        cantidadNoNegativa(value);
    }
    private void cantidadNoNegativa(Integer value) {
        if (value <= 0) {
            throw new RuntimeException("La cantidad de insumos debe ser mayor a 0");
        }
    }
}

