package co.javeriana.restaurantes.Restaurantes.Plato.PlatoInsumo.Domain;

import co.javeriana.restaurantes.Restaurantes.Plato.PlatoInsumo.Domain.ValueObjects.PlatoID;
import co.javeriana.restaurantes.Restaurantes.Plato.PlatoInsumo.Domain.ValueObjects.InsumoID;
import co.javeriana.restaurantes.Restaurantes.Plato.PlatoInsumo.Domain.ValueObjects.PlatoInsumoCantidadNecesaria;
import co.javeriana.restaurantes.Restaurantes.Plato.PlatoInsumo.Domain.ValueObjects.PlatoInsumoNombre;

import java.util.HashMap;

public class PlatoInsumo {
    private InsumoID insumoID;
    private PlatoID platoID;
    private PlatoInsumoNombre nombreinsumo;
    private PlatoInsumoCantidadNecesaria cantidadNecesaria;

    public PlatoInsumo(InsumoID insumoID, PlatoInsumoNombre nombreinsumo, PlatoID platoID, PlatoInsumoCantidadNecesaria cantidadNecesaria) {
        this.insumoID = insumoID;
        this.platoID = platoID;
        this.nombreinsumo = nombreinsumo;
        this.cantidadNecesaria = cantidadNecesaria;
    }

    public HashMap<String, Object> data() {
        HashMap<String, Object> data = new HashMap<>();
        data.put("id", insumoID.value());
        data.put("nombre", nombreinsumo.value());
        data.put("platoID", platoID.value());
        data.put("cantidadNecesaria", cantidadNecesaria.value());
        return data;
    }

    private PlatoInsumo(){}

}

