package co.javeriana.restaurantes.Restaurantes.Plato.Domain.ValueObjects;
import co.javeriana.restaurantes.Shared.Domain.Aggregate.CustomUUID;
public class PlatoID extends CustomUUID{

    private PlatoID() {}

    public PlatoID(String value) {
        super(value);
    }
}
