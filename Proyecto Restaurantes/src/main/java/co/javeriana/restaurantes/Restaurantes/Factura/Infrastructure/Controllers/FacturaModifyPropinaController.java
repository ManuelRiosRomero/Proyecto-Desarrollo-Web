package co.javeriana.restaurantes.Restaurantes.Factura.Infrastructure.Controllers;

import co.javeriana.restaurantes.Restaurantes.Factura.Application.Calculate.FacturaCalculateTotal;
import co.javeriana.restaurantes.Restaurantes.Factura.Application.ModifyPropina.FacturaModifyPropina;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
@CrossOrigin
@RestController
@Tag(name="Factura", description = "Factura REST API")
@RequestMapping(value="/factura")
public class FacturaModifyPropinaController {
    @Autowired
    private FacturaModifyPropina modifyPropina;
    @GetMapping(value = "/modify")
    public ResponseEntity<HashMap<String, Object>> execute(@RequestBody FacturaCalculateTotalController.facturaCalculateTotalRequest request) {
        return null;
    }

    }
