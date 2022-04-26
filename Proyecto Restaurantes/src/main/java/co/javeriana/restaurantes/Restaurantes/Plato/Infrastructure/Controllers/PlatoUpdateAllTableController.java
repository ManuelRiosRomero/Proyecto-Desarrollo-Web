package co.javeriana.restaurantes.Restaurantes.Plato.Infrastructure.Controllers;

import co.javeriana.restaurantes.Restaurantes.Plato.Application.Update.PlatoUpdateAllPlatosTable;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@Tag(name = "Plato", description = "Plato REST API")
@RequestMapping(value = "/plato")
public class PlatoUpdateAllTableController {

    @Autowired
    PlatoUpdateAllPlatosTable updater;

    @PostMapping(value = "/update/all")
    public ResponseEntity<List<HashMap<String, Object>>> execute() {
        updater.execute();
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
