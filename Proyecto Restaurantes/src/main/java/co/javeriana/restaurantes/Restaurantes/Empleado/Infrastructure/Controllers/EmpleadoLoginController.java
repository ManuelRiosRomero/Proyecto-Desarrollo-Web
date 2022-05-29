package co.javeriana.restaurantes.Restaurantes.Empleado.Infrastructure.Controllers;

import co.javeriana.restaurantes.Restaurantes.Empleado.Application.Login.EmpleadoLogin;
import co.javeriana.restaurantes.Restaurantes.Empleado.Domain.Exceptions.AuthenticateFailed;
import co.javeriana.restaurantes.Restaurantes.Empleado.Domain.Exceptions.NoType;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
@CrossOrigin
@RestController
@Tag(name = "Empleado", description = "Empleado REST API")
@RequestMapping(value = "/empleado")
public class EmpleadoLoginController {

    @Autowired
    private EmpleadoLogin login;

    @PostMapping(value = "/login")
    public ResponseEntity execute(@RequestBody EmpleadoLoginRequest request) {
        login.execute(request.getCedula(), request.getPassword());
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @ExceptionHandler(AuthenticateFailed.class)
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public ResponseEntity<HashMap> handleFailedAuthenticate(RuntimeException ex) {
        HashMap<String, String> response = new HashMap<>() {{
            put("error", ex.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }


    static class EmpleadoLoginRequest {
        private String cedula;
        private String password;

        public String getCedula() {
            return cedula;
        }

        public void setCedula(String cedula) {
            this.cedula = cedula;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

}
