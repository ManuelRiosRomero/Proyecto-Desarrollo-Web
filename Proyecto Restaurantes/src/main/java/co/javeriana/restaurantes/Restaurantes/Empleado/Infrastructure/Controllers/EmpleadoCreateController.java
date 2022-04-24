package co.javeriana.restaurantes.Restaurantes.Empleado.Infrastructure.Controllers;

import co.javeriana.restaurantes.Restaurantes.Empleado.Application.Create.EmpleadoCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Empleado", description = "Empleado REST API")
@RequestMapping(value = "/empleado")
public class EmpleadoCreateController {

    @Autowired
    private EmpleadoCreator creator;

    @PostMapping(value = "/create")
    public ResponseEntity execute(@RequestBody EmpleadoCreatorRequest request) {
        creator.execute(request.getId(), request.getCedula(), request.getNombre(), request.getPuesto(), request.getPassword(), request.getRestauranteId());
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    static class EmpleadoCreatorRequest {
        @Schema(description = "Empleado id", example = "0f1c4b36-e610-4446-a3a3-a6083902b587")
        private String id;
        @Schema(description = "Empleado cedula", example = "100345211")
        private String cedula;
        @Schema(description = "Empleado nombre", example = "Juan Guaido")
        private String nombre;
        @Schema(description = "Empleado puesto", example = "Cajero")
        private String puesto;
        @Schema(description = "Empleado password", example = "abhfjsab@")
        private String password;
        @Schema(description = "Restaurante ID", example = "0f1c4b36-e610-4446-a3a3-a6083902b587")
        private String restauranteId;

        public String getId() {
            return id;
        }

        public String getCedula() {
            return cedula;
        }

        public String getNombre() {
            return nombre;
        }

        public String getPuesto() {
            return puesto;
        }

        public String getPassword() {
            return password;
        }

        public String getRestauranteId() {
            return restauranteId;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setCedula(String cedula) {
            this.cedula = cedula;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public void setPuesto(String puesto) {
            this.puesto = puesto;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public void setRestauranteId(String restauranteId) {
            this.restauranteId = restauranteId;
        }
    }

}
