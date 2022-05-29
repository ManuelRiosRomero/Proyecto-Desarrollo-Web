package co.javeriana.restaurantes.Restaurantes.Insumo.Infrastructure.Controllers;

import co.javeriana.restaurantes.Restaurantes.Insumo.Application.FindAll.InsumoFindAll;
import co.javeriana.restaurantes.Restaurantes.Insumo.Application.FindAll.InsumoFindAllResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
@CrossOrigin
@RestController
@Tag(name = "Insumo", description = "Insumo REST API")
@RequestMapping(value = "/insumo")
public class InsumoFindAllController {

    @Autowired
    private InsumoFindAll all;

    @GetMapping(value = "/all")
    public ResponseEntity<List<HashMap<String, Object>>> execute() {
        InsumoFindAllResponse response = new InsumoFindAllResponse(all.execute());
        return ResponseEntity.status(HttpStatus.OK).body(response.response());
    }
}
