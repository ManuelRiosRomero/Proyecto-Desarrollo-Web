package co.javeriana.restaurantes.Restaurantes.Factura.Infrastructure.Controllers;

import co.javeriana.restaurantes.Restaurantes.Factura.Application.Create.FacturaCreate;
import co.javeriana.restaurantes.Restaurantes.Factura.Domain.Exceptions.FechaIngresoInvalida;
import co.javeriana.restaurantes.Restaurantes.Plato.Domain.Exceptions.CantidadNegativa;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@Tag(name = "Factura", description = "Factura REST API")
@RequestMapping(value = "/factura")
public class FacturaCreateController {

    @Autowired
    private FacturaCreate creator;

    @PostMapping(value = "/create")
    public ResponseEntity execute(@RequestBody FacturaCreatorRequest request) {
        creator.execute(request.getId(), request.getValor(), request.getFecha(), request.getPropina(), request.getResId());
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @ExceptionHandler(CantidadNegativa.class)
    @ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE)
    public ResponseEntity<HashMap> handleCantidadNegativa(RuntimeException ex){
        HashMap<String, String> response = new HashMap<>(){{
            put("error", ex.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(response);
    }

    @ExceptionHandler(FechaIngresoInvalida.class)
    @ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE)
    public ResponseEntity<HashMap> handleFechaIngresoInvalida(RuntimeException ex){
        HashMap<String, String> response = new HashMap<>(){{
            put("error", ex.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(response);
    }

    static class FacturaCreatorRequest {
        @Schema(description = "Factura id", example = "87ede4a8-c413-11ec-9d64-0242ac120002")
        private String id;
        @Schema(description = "Valor de la factura", example = "30000")
        private double valor;
        @Schema(description = "Fecha de la factura", example = "2022-10-15")
        private String fecha;
        @Schema(description = "Propina de la factura", example = "2000")
        private double propina;
        @Schema(description = "Id del restaurante", example = "0f1c4b36-e610-4446-a3a3-a6083902b587")
        private String resId;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public double getValor() {
            return valor;
        }

        public void setValor(double valor) {
            this.valor = valor;
        }

        public String getFecha() {
            return fecha;
        }

        public void setFecha(String fecha) {
            this.fecha = fecha;
        }

        public double getPropina() {
            return propina;
        }

        public void setPropina(double propina) {
            this.propina = propina;
        }

        public String getResId() {
            return resId;
        }

        public void setResId(String resId) {
            this.resId = resId;
        }
    }
}
