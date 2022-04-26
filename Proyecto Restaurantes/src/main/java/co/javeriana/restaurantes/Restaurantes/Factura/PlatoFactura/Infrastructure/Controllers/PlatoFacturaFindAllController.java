package co.javeriana.restaurantes.Restaurantes.Factura.PlatoFactura.Infrastructure.Controllers;

import co.javeriana.restaurantes.Restaurantes.Factura.PlatoFactura.Application.FindAll.PlatoFacturaFindAll;
import co.javeriana.restaurantes.Restaurantes.Factura.PlatoFactura.Application.FindAll.PlatoFacturaFindAllResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Factura", description = "Factura REST API")
@RequestMapping(value = "/factura")
public class PlatoFacturaFindAllController {

    @Autowired
    private PlatoFacturaFindAll all;

    @GetMapping(value = "/plato/all")
    public ResponseEntity execute() {
        PlatoFacturaFindAllResponse response = new PlatoFacturaFindAllResponse(all.execute());
        return ResponseEntity.status(HttpStatus.OK).body(response.response());
    }


}
