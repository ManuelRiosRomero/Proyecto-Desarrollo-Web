package co.javeriana.restaurantes.Restaurantes.Plato.Infrastructure.Controllers;

import co.javeriana.restaurantes.Restaurantes.Plato.Application.Create.PlatoCreate;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@Tag(name = "Plato", description = "Plato REST API")
@RequestMapping(value = "/plato")
public class PlatoCreateController {

    @Autowired
    private PlatoCreate creator;

    @PostMapping(value = "/create")
    public ResponseEntity execute(@RequestBody PlatoCreatorRequest request) {
        creator.execute(request.getId(), request.getNombre(), request.getDescripcion(), request.getCosto(), request.getResId());
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    static class PlatoCreatorRequest {
        @Schema(description = "Plato id", example = "87ede4a8-c413-11ec-9d64-0242ac120002")
        private String id;
        @Schema(description = "Plato nombre", example = "Arroz con pollo")
        private String nombre;
        @Schema(description = "Plato descripcion", example = "Plato mediano de arroz con pollo con papas")
        private String descripcion;
        @Schema(description = "Plato costo", example = "15000")
        private double costo;
        @Schema(description = "ID de restaurante", example = "27ede4a8-c413-11ec-9d64-0242ac120002")
        private String resId;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        public double getCosto() {
            return costo;
        }

        public void setCosto(double costo) {
            this.costo = costo;
        }

        public String getResId() {
            return resId;
        }

        public void setResId(String resId) {
            this.resId = resId;
        }
    }

}