package co.javeriana.restaurantes.Restaurantes.Plato.Application.AddPlatoInsumo;

import co.javeriana.restaurantes.Restaurantes.Plato.Domain.Entities.PlatoInsumo;
import co.javeriana.restaurantes.Restaurantes.Plato.Domain.Plato;
import co.javeriana.restaurantes.Restaurantes.Plato.Domain.Ports.PlatoRepository;
import co.javeriana.restaurantes.Restaurantes.Plato.Domain.ValueObjects.PlatoID;

import java.util.Optional;

public class PlatoAddPlatoInsumo {
    private PlatoRepository repository;

    public PlatoAddPlatoInsumo(PlatoRepository repository) {
        this.repository = repository;
    }

    public void execute(String platoid, String insumoid, int cantidadnecesaria, String nombreinsumo) {
        Optional<Plato> optionalPlato = repository.findByID(new PlatoID(platoid));
        if(optionalPlato.isPresent()) {
            //Agregar insumo al plato
            Plato plato = optionalPlato.get();
            plato.addInsumo(new PlatoInsumo(insumoid, cantidadnecesaria, nombreinsumo));
            this.repository.update(plato);
        }

    }


}
