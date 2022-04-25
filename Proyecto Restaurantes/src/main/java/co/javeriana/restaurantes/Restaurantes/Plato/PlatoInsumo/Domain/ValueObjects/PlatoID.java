package co.javeriana.restaurantes.Restaurantes.Plato.PlatoInsumo.Domain.ValueObjects;

import co.javeriana.restaurantes.Shared.Domain.Aggregate.CustomUUID;

public class PlatoID extends CustomUUID {
    private PlatoID(){};

    private PlatoID(String value){
        super(value);
    }



}
