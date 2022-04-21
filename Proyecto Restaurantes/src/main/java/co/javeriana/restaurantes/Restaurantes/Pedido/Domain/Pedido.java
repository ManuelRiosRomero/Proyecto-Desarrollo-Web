package co.javeriana.restaurantes.Restaurantes.Pedido.Domain;

import co.javeriana.restaurantes.Restaurantes.Factura.Domain.Factura;
import co.javeriana.restaurantes.Restaurantes.Pedido.Domain.ValueObjects.PedidoCompletado;
import co.javeriana.restaurantes.Restaurantes.Pedido.Domain.ValueObjects.PedidoID;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Pedido {
    private PedidoID id;
    private Optional<List<Factura>> facturas;
    private PedidoCompletado compleatdo;

    public Pedido(PedidoID id, Optional<List<Factura>> facturas, PedidoCompletado compleatdo) {
        this.id = id;
        this.facturas = facturas;
        this.compleatdo = compleatdo;
    }
    public HashMap<String, Object> data() {
        HashMap<String, Object> data = new HashMap<>() {{
            put("id", id);
            put("compleatdo", compleatdo);
            put("facturas", createFacturas());
        }};
        return data;
    }
    private List<HashMap<String, Object>> createFacturas() {
        List<HashMap<String, Object>> list = new ArrayList<>();
        if (!facturas.isEmpty()) {
            list = facturas.get().stream().map(facturas -> facturas.data()).collect(Collectors.toList());
        }
        return list;
    }


}

