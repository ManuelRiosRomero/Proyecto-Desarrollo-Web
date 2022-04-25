package co.javeriana.restaurantes.Restaurantes.Plato.PlatoInsumo.Infrastucture.Controllers;

import co.javeriana.restaurantes.Restaurantes.Plato.Infrastructure.Controllers.PlatoCreateController;
import co.javeriana.restaurantes.Restaurantes.Plato.PlatoInsumo.Application.Create.PlatoInsumoCreate;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Plato", description = "Plato REST API")
@RequestMapping(value = "/plato")
public class PlatoInsumoCreateController {

    /*
    @Autowired
    private PlatoInsumoCreate creator;

    @PostMapping(value = "/insumo/create")
    public ResponseEntity execute(@RequestBody PlatoCreateController.PlatoCreatorRequest request) {
        creator.execute(request.getId(), request.getNombre(), request.getDescripcion(), request.getCosto(), request.getResId());
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

     */



}
