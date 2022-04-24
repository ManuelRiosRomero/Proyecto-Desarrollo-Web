package co.javeriana.restaurantes.Restaurantes.Insumo.Application.FindByID;

import co.javeriana.restaurantes.Restaurantes.Insumo.Domain.Insumo;

import java.util.HashMap;

public class InsumoFindByIdResponse {

    private Insumo insumo;

    public InsumoFindByIdResponse(Insumo insumo) {
        this.insumo = insumo;
    }

    public HashMap<String, Object> response() {

        HashMap<String, Object> response = insumo.data();
        return response;
    }


}
