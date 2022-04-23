package co.javeriana.restaurantes.Restaurantes.Pedido.Domain.ValueObjects;

import co.javeriana.restaurantes.Shared.Domain.Aggregate.CustomUUID;

public class PedidoID extends CustomUUID {

    private PedidoID() {}

    public PedidoID(String value) {
        super(value);
    }
}
