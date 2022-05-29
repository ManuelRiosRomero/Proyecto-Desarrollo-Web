package co.javeriana.restaurantes.Restaurantes.Empleado.Infrastructure.Controllers;

import co.javeriana.restaurantes.Restaurantes.Empleado.Application.FindAll.EmpleadoFindAll;
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
@Tag(name = "Empleado", description = "Empleado REST API")
@RequestMapping(value = "/empleado")
public class EmpleadoFindAllController {

    @Autowired
    private EmpleadoFindAll all;

    @GetMapping(value = "/all")
    public ResponseEntity<List<HashMap<String, Object>>> execute() {
        EmpleadoFindAllResponse response = new EmpleadoFindAllResponse(all.execute());
        return ResponseEntity.status(HttpStatus.OK).body(response.response());
    }
}