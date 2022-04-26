package co.javeriana.restaurantes.Restaurantes.Plato.Application.Update;

import co.javeriana.restaurantes.Restaurantes.Plato.Domain.Plato;
import co.javeriana.restaurantes.Restaurantes.Plato.Domain.Ports.PlatoRepository;
import co.javeriana.restaurantes.Restaurantes.Plato.PlatoInsumo.Domain.PlatoInsumo;
import co.javeriana.restaurantes.Restaurantes.Plato.PlatoInsumo.Domain.Ports.PlatoInsumoRepository;
import co.javeriana.restaurantes.Restaurantes.Plato.PlatoInsumo.Domain.ValueObjects.PlatoID;
import co.javeriana.restaurantes.Shared.Domain.Bus.Event.EventBus;

import java.util.List;
import java.util.Optional;

public class PlatoUpdateAllPlatosTable {
    private PlatoInsumoRepository insumoRepository;
    private PlatoRepository platoRepository;
    private final EventBus eventBus;

    public PlatoUpdateAllPlatosTable(PlatoInsumoRepository insumoRepository, PlatoRepository platoRepository, EventBus eventBus) {
        this.insumoRepository = insumoRepository;
        this.platoRepository = platoRepository;
        this.eventBus = eventBus;
    }

    public void execute(){
        //Get all platos from platorepository
        Optional<List<Plato>> platos = platoRepository.all();
        if(platos.isPresent()){
            //For each plato, obtain all insumo from insumorepository
            for(Plato plato : platos.get()){
                Optional<List< PlatoInsumo >> insumos = insumoRepository.findByPlatoId(new PlatoID((String) plato.data().get("id")));
                if(insumos.isPresent()){
                    //Get List of insumos
                    List< PlatoInsumo > insumoList = insumos.get();
                    //For each insumo, add it to the plato
                    for(PlatoInsumo insumo : insumoList){
                        String insumoID =(String) insumo.data().get("id");
                        String insumoNombre = (String) insumo.data().get("nombre");
                        int insumoCantidadNecesaria =(Integer) insumo.data().get("cantidadNecesaria");

                        plato.addInsumo(
                                new co.javeriana.restaurantes.Restaurantes.Plato.Domain.Entities.PlatoInsumo
                                        (insumoID,insumoCantidadNecesaria,insumoNombre));

                        //Publish event to update the table
                        this.eventBus.publish(insumo.pullDomainEvents());
                    }

                }
            }
        }



    }
}
