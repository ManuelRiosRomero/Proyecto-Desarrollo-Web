package co.javeriana.restaurantes.Restaurantes.Factura.Infrastructure.Controllers;

import co.javeriana.restaurantes.Restaurantes.Factura.Application.Calculate.FacturaCalculateTotal;
import co.javeriana.restaurantes.Restaurantes.Factura.Application.Calculate.FacturaCalculateTotalResponse;
import co.javeriana.restaurantes.Restaurantes.Factura.Application.FindAll.FacturaFindAllResponse;
import co.javeriana.restaurantes.Restaurantes.Factura.Domain.ValueObjects.FacturaID;
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
import java.util.List;

@RestController
@Tag(name="Factura", description = "Factura REST API")
@RequestMapping(value="/factura")
public class FacturaCalculateTotalController {

    @Autowired
    private FacturaCalculateTotal calculate;

    @GetMapping(value = "/total")
    public ResponseEntity<HashMap<String, Object>> execute(@RequestBody FacturaCalculateTotalController.facturaCalculateTotalRequest request) {

        double total = calculate.execute(new FacturaID(request.getFacturaid()));
        String facturaId = request.getFacturaid();
        FacturaCalculateTotalResponse response = new FacturaCalculateTotalResponse(total, facturaId);

        return ResponseEntity.status(HttpStatus.OK).body(response.response());

    }

    static class facturaCalculateTotalRequest{
        @Schema(description = "Factura id", example = "87ede4a8-c413-11ec-9d64-0242ac120002")
        private String facturaid;

        public String getFacturaid() {
            return facturaid;
        }

        public void setFacturaid(String facturaid) {
            this.facturaid = facturaid;
        }
    }



}
