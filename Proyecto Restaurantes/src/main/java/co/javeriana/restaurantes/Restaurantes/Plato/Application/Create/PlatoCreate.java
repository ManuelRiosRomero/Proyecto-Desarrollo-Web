package co.javeriana.restaurantes.Restaurantes.Plato.Application.Create;

import co.javeriana.restaurantes.Restaurantes.Plato.Domain.Plato;
import co.javeriana.restaurantes.Restaurantes.Plato.Domain.Ports.PlatoRepository;
import co.javeriana.restaurantes.Restaurantes.Plato.Domain.ValueObjects.*;

public class PlatoCreate {

    private PlatoRepository repository;

    public PlatoCreate(PlatoRepository repository) {
        this.repository = repository;
    }

    public void execute(String id, String nombre, String descripcion, double costo, String resId) {
        Plato plato = Plato.create(new PlatoID(id), new PlatoNombre(nombre), new PlatoDescripcion(descripcion),
                new PlatoCosto(costo), new RestauranteID(resId));
        repository.save(plato);
    }
}
