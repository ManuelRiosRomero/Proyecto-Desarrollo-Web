package co.javeriana.restaurantes.Restaurantes.Pedido.Domain.ValueObjects;

import co.javeriana.restaurantes.Shared.Domain.Aggregate.BooleanValueObject;

public class PedidoCompletado extends BooleanValueObject {
    private PedidoCompletado() {}

    public PedidoCompletado(Boolean value) {
        this.value = value;
    }
}
