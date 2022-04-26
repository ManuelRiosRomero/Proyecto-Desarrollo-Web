package co.javeriana.restaurantes.Restaurantes.Plato.PlatoInsumo.Domain;

import co.javeriana.restaurantes.Restaurantes.Plato.PlatoInsumo.Domain.DomainEvents.PlatoInsumoCreatedDomainEvent;
import co.javeriana.restaurantes.Restaurantes.Plato.PlatoInsumo.Domain.ValueObjects.*;
import co.javeriana.restaurantes.Shared.Domain.Aggregate.AggregateRoot;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashMap;
public class PlatoInsumo extends AggregateRoot {
    private InsumoID insumoID;
    private PlatoID platoID;

    private PlatoInsumoNombre nombreinsumo;

    private PlatoInsumoCantidadNecesaria cantidadNecesaria;

    @EmbeddedId
    private PlatoInsumoIdentity platoInsumoID;

    public PlatoInsumo(InsumoID insumoID, PlatoInsumoNombre nombreinsumo, PlatoID platoID, PlatoInsumoCantidadNecesaria cantidadNecesaria) {
        this.insumoID = insumoID;
        this.platoID = platoID;
        this.nombreinsumo = nombreinsumo;
        this.cantidadNecesaria = cantidadNecesaria;
        this.platoInsumoID = new PlatoInsumoIdentity(platoID.value(),insumoID.value());
    }


    public static PlatoInsumo create(InsumoID insumoID, PlatoInsumoNombre nombreinsumo, PlatoID platoID, PlatoInsumoCantidadNecesaria cantidadNecesaria) {{
            PlatoInsumo platoInsumo = new PlatoInsumo(
                    insumoID,
                    nombreinsumo,
                    platoID,
                    cantidadNecesaria);


            //Crear Evento de Dominio PlatoInsumoCreated
        platoInsumo.record(new PlatoInsumoCreatedDomainEvent
                (insumoID.value(), nombreinsumo.value(), cantidadNecesaria.value(),platoID.value()));


            return platoInsumo;
        }
    }

    public HashMap<String, Object> data() {
        HashMap<String, Object> data = new HashMap<>();
        data.put("id", insumoID.value());
        data.put("nombre", nombreinsumo);
        data.put("platoID", platoID.value());
        data.put("cantidadNecesaria", cantidadNecesaria);
        return data;
    }

    public PlatoInsumo(){}
    public PlatoInsumoIdentity getPlatoInsumoID() {
        return platoInsumoID;
    }
    public void setPlatoInsumoIdentity(PlatoInsumoIdentity platoInsumoID) {
        this.platoInsumoID = platoInsumoID;
    }

}

