package co.javeriana.restaurantes.Restaurantes.Plato.Infrastructure.Controllers;

import co.javeriana.restaurantes.Restaurantes.Plato.Application.FindAll.PlatoFindAll;
import co.javeriana.restaurantes.Restaurantes.Plato.Application.FindAll.PlatoFindAllResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@Tag(name = "Plato", description = "Plato REST API")
@RequestMapping(value = "/plato")
public class PlatoFinderAllController {

    @Autowired
    private PlatoFindAll all;

    @GetMapping(value = "/all")
    public ResponseEntity<List<HashMap<String, Object>>> execute() {
        PlatoFindAllResponse response = new PlatoFindAllResponse(all.execute());
        return ResponseEntity.status(HttpStatus.OK).body(response.response());
    }

}
