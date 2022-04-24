package co.javeriana.restaurantes.Restaurantes.Factura.Infrastructure.Controllers;


import co.javeriana.restaurantes.Restaurantes.Factura.Application.FindAll.FacturaFindAll;
import co.javeriana.restaurantes.Restaurantes.Factura.Application.FindAll.FacturaFindAllResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;

public class FacturaFinderAllController {


    @Autowired
    private FacturaFindAll all;

    @GetMapping(value = "/all")
    public ResponseEntity<List<HashMap<String, Object>>> execute() {
        FacturaFindAllResponse response = new FacturaFindAllResponse(all.execute());
        return ResponseEntity.status(HttpStatus.OK).body(response.response());
    }

}
