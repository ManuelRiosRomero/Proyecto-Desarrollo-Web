package co.javeriana.restaurantes.Restaurantes.Insumo.Infrastructure.Controllers;

import co.javeriana.restaurantes.Restaurantes.Insumo.Application.FindByID.InsumoFindById;
import co.javeriana.restaurantes.Restaurantes.Insumo.Application.FindByID.InsumoFindByIdResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@Tag(name = "Insumo", description = "Insumo REST API")
@RequestMapping(value = "/insumo")
public class InsumoFindByIdController {

    @Autowired
    private InsumoFindById findInsumo;

    @GetMapping(value = "/id")
    public ResponseEntity<HashMap<String, Object>> execute(@RequestBody InsumoFindByIdController.InsumoFindByIdRequest request) {
        InsumoFindByIdResponse response = new InsumoFindByIdResponse(findInsumo.execute(request.getId()));
        return ResponseEntity.status(HttpStatus.OK).body(response.response());
    }

    static class InsumoFindByIdRequest {

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
