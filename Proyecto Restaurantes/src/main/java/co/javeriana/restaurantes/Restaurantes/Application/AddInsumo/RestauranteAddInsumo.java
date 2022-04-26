package co.javeriana.restaurantes.Restaurantes.Application.AddInsumo;

import co.javeriana.restaurantes.Restaurantes.Domain.Entities.InsumoRestaurante;
import co.javeriana.restaurantes.Restaurantes.Domain.Ports.RestauranteRepository;
import co.javeriana.restaurantes.Restaurantes.Domain.Restaurante;
import co.javeriana.restaurantes.Restaurantes.Domain.ValueObjects.RestauranteID;

import java.util.Optional;

public class RestauranteAddInsumo {

    private RestauranteRepository repository;

    public RestauranteAddInsumo(RestauranteRepository repository){
        this.repository = repository;
    }

    public void execute(String restauranteId, String insumoId, String nombre,  int cantidad, double costo){

        Optional<Restaurante> optionalRestaurante = repository.findById(new RestauranteID(restauranteId));
        System.out.println("Encuentra el restaurante");
        if(optionalRestaurante.isPresent()){
            Restaurante restaurante = optionalRestaurante.get();

            restaurante.addInsumo(new InsumoRestaurante(insumoId, nombre, cantidad, costo));
            this.repository.update(restaurante);

        }
    }
}
