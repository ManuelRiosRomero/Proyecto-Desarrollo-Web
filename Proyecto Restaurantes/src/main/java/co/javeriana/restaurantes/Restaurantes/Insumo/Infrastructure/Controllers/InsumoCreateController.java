package co.javeriana.restaurantes.Restaurantes.Insumo.Infrastructure.Controllers;

import co.javeriana.restaurantes.Restaurantes.Insumo.Application.Create.InsumoCreate;
import co.javeriana.restaurantes.Restaurantes.Insumo.Domain.Exceptions.InsumoNombreInvalido;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@Tag(name = "Insumo", description = "Insumo REST API")
@RequestMapping(value = "/insumo")
public class InsumoCreateController {

    @Autowired
    private InsumoCreate creator;

    @PostMapping(value = "/create")
    public ResponseEntity execute(@RequestBody InsumoCreateRequest request) {
        creator.execute(request.getId(), request.getCantidad(), request.getNombre(), request.getCosto(), request.getRestauranteId());
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @ExceptionHandler(InsumoNombreInvalido.class)
    @ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE)
    public ResponseEntity<HashMap> handleInsumoNombreInvalido(RuntimeException ex){
        HashMap<String, String> response = new HashMap<>(){{
            put("error", ex.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(response);
    }


    static class InsumoCreateRequest {
        private String id;
        private int cantidad;
        private String nombre;
        private double costo;
        private String restauranteId;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getCantidad() {
            return cantidad;
        }

        public void setCantidad(int cantidad) {
            this.cantidad = cantidad;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public double getCosto() {
            return costo;
        }

        public void setCosto(double costo) {
            this.costo = costo;
        }

        public String getRestauranteId() {
            return restauranteId;
        }

        public void setRestauranteId(String restauranteId) {
            this.restauranteId = restauranteId;
        }
    }

}
