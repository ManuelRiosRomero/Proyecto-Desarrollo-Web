package co.javeriana.restaurantes.Restaurantes.Plato.PlatoInsumo.Domain;

import co.javeriana.restaurantes.Restaurantes.Insumo.Domain.Insumo;
import co.javeriana.restaurantes.Restaurantes.Plato.PlatoInsumo.Domain.DomainEvents.PlatoInsumoCreatedDomainEvent;
import co.javeriana.restaurantes.Restaurantes.Plato.PlatoInsumo.Domain.ValueObjects.PlatoID;
import co.javeriana.restaurantes.Restaurantes.Plato.PlatoInsumo.Domain.ValueObjects.InsumoID;
import co.javeriana.restaurantes.Restaurantes.Plato.PlatoInsumo.Domain.ValueObjects.PlatoInsumoCantidadNecesaria;
import co.javeriana.restaurantes.Restaurantes.Plato.PlatoInsumo.Domain.ValueObjects.PlatoInsumoNombre;
import co.javeriana.restaurantes.Shared.Domain.Aggregate.AggregateRoot;

import java.util.HashMap;

public class PlatoInsumo extends AggregateRoot {
    private InsumoID insumoID;
    private PlatoID platoID;
    private PlatoInsumoNombre nombreinsumo;
    private PlatoInsumoCantidadNecesaria cantidadNecesaria;

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PlatoInsumo(InsumoID insumoID, PlatoInsumoNombre nombreinsumo, PlatoID platoID, PlatoInsumoCantidadNecesaria cantidadNecesaria) {
        this.insumoID = insumoID;
        this.platoID = platoID;
        this.nombreinsumo = nombreinsumo;
        this.cantidadNecesaria = cantidadNecesaria;
    }

    public static PlatoInsumo create(InsumoID insumoID, PlatoInsumoNombre nombreinsumo, PlatoID platoID, PlatoInsumoCantidadNecesaria cantidadNecesaria) {{
            PlatoInsumo platoInsumo = new PlatoInsumo(
                    insumoID,
                    nombreinsumo,
                    platoID,
                    cantidadNecesaria);


            //Crear Evento de Dominio PLatoInsumoCreated
        platoInsumo.record(new PlatoInsumoCreatedDomainEvent
                (insumoID.value(),insumoID.value(),
                        nombreinsumo.value(), cantidadNecesaria.value(),platoID.value()));


            return platoInsumo;
        }
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

