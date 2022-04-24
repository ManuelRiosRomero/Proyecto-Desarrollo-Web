package co.javeriana.restaurantes.Restaurantes.Factura.Infrastructure.Controllers;

import co.javeriana.restaurantes.Restaurantes.Factura.Application.FindAll.FacturaFindAll;
import co.javeriana.restaurantes.Restaurantes.Factura.Application.FindAll.FacturaFindAllResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@Tag(name="Factura", description = "Factura REST API")
@RequestMapping(value="/factura")
public class FacturaFinderAllController {

    @Autowired
    private FacturaFindAll all;

    @GetMapping(value = "/all")
    public ResponseEntity<List<HashMap<String, Object>>> execute() {
        FacturaFindAllResponse response = new FacturaFindAllResponse(all.execute());
        return ResponseEntity.status(HttpStatus.OK).body(response.response());
    }

}
