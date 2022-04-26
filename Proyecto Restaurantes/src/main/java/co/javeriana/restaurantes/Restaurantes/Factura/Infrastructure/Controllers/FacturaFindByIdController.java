package co.javeriana.restaurantes.Restaurantes.Factura.Infrastructure.Controllers;

import co.javeriana.restaurantes.Restaurantes.Factura.Application.FindById.FacturaFindById;
import co.javeriana.restaurantes.Restaurantes.Factura.Application.FindById.FacturaFindByIdResponse;
import co.javeriana.restaurantes.Restaurantes.Insumo.Application.FindByID.InsumoFindByIdResponse;
import co.javeriana.restaurantes.Restaurantes.Insumo.Infrastructure.Controllers.InsumoFindByIdController;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@Tag(name = "Factura", description = "Insumo REST API")
@RequestMapping(value = "/factura")
public class FacturaFindByIdController {

    @Autowired
    private FacturaFindById findFactura;

    @PostMapping(value = "id")
    public ResponseEntity<HashMap<String, Object>> execute(@RequestBody FacturaFindByIdRequest request) {
        FacturaFindByIdResponse response = new FacturaFindByIdResponse(findFactura.execute(request.getId()));
        return ResponseEntity.status(HttpStatus.OK).body(response.response());
    }

    static class FacturaFindByIdRequest {

        @Schema(description = "Debe ser un UUID valido", example = "5518418e-51a3-4da7-8dfb-e11d1abce4ba")
        private String id;

        public String getId() {
            return id;
        }

        public void setId(String insumoId) {
            this.id = insumoId;
        }
    }


}
