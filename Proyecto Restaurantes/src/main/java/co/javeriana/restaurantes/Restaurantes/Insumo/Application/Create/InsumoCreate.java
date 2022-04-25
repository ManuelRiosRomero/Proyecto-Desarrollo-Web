package co.javeriana.restaurantes.Restaurantes.Insumo.Application.Create;

import co.javeriana.restaurantes.Restaurantes.Insumo.Domain.Insumo;
import co.javeriana.restaurantes.Restaurantes.Insumo.Domain.Ports.InsumoRepository;
import co.javeriana.restaurantes.Restaurantes.Insumo.Domain.ValueObjects.*;

public class InsumoCreate {

    InsumoRepository insumoRepository;

    public InsumoCreate(InsumoRepository insumoRepository) {
        this.insumoRepository = insumoRepository;
    }

    public void execute(String id, int cantidad, String nombre, double costo, String restauranteId) {
        Insumo insumo = Insumo.create(new InsumoID(id), new InsumoCantidad(cantidad), new InsumoNombre(nombre), new InsumoCosto(costo),
                new RestauranteID(restauranteId));
        insumoRepository.save(insumo);
    }
}
