package co.javeriana.restaurantes.Restaurantes.Infrastructure.Controllers;


import co.javeriana.restaurantes.Restaurantes.Application.FindAll.RestauranteFindAll;
import co.javeriana.restaurantes.Restaurantes.Application.FindAll.RestauranteFindAllResponse;
import co.javeriana.restaurantes.Restaurantes.Empleado.Application.FindAll.EmpleadoFindAllResponse;
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
@Tag(name = "Restaurante", description = "Restaurante REST API")
@RequestMapping(value = "/restaurante")
public class RestauranteFindAllController {

    @Autowired
    private RestauranteFindAll all;

    @GetMapping(value = "/all")
    public ResponseEntity<List<HashMap<String, Object>>> execute() {
        RestauranteFindAllResponse response = new RestauranteFindAllResponse(all.execute());
        return ResponseEntity.status(HttpStatus.OK).body(response.response());
    }
}
