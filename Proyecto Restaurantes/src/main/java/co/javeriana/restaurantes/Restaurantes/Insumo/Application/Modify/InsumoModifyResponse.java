package co.javeriana.restaurantes.Restaurantes.Insumo.Application.Modify;

import co.javeriana.restaurantes.Restaurantes.Insumo.Domain.Insumo;

import java.util.HashMap;

public class InsumoModifyResponse {
    private Insumo insumo;

    public InsumoModifyResponse(Insumo insumo) {
        this.insumo = insumo;
    }

    public HashMap<String, Object> response() {

        HashMap<String, Object> response = insumo.data();
        return response;
    }
}
