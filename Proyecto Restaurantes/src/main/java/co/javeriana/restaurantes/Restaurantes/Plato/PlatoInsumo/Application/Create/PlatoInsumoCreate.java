package co.javeriana.restaurantes.Restaurantes.Plato.PlatoInsumo.Application.Create;

import co.javeriana.restaurantes.Restaurantes.Plato.PlatoInsumo.Domain.PlatoInsumo;
import co.javeriana.restaurantes.Restaurantes.Plato.PlatoInsumo.Domain.Ports.PlatoInsumoRepository;
import co.javeriana.restaurantes.Restaurantes.Plato.PlatoInsumo.Domain.ValueObjects.InsumoID;
import co.javeriana.restaurantes.Restaurantes.Plato.PlatoInsumo.Domain.ValueObjects.PlatoID;
import co.javeriana.restaurantes.Restaurantes.Plato.PlatoInsumo.Domain.ValueObjects.PlatoInsumoCantidadNecesaria;
import co.javeriana.restaurantes.Restaurantes.Plato.PlatoInsumo.Domain.ValueObjects.PlatoInsumoNombre;

public class PlatoInsumoCreate {

    private PlatoInsumoRepository repository;

    public PlatoInsumoCreate(PlatoInsumoRepository repository) {
        this.repository = repository;
    }
    public void execute(String insumoID, String nombreInsumo, String platoID, int cantidad)
    {
        PlatoInsumo platoInsumo = new PlatoInsumo(new InsumoID(insumoID), new PlatoInsumoNombre(nombreInsumo), new PlatoID(platoID), new PlatoInsumoCantidadNecesaria(cantidad));
        repository.save(platoInsumo);
    }
}
