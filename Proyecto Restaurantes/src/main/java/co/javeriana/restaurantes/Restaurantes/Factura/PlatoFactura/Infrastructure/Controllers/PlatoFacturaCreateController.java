package co.javeriana.restaurantes.Restaurantes.Factura.PlatoFactura.Infrastructure.Controllers;

import co.javeriana.restaurantes.Restaurantes.Factura.PlatoFactura.Application.Create.PlatoFacturaCreate;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Factura", description = "Factura REST API")
@RequestMapping(value = "factura")
public class PlatoFacturaCreateController {

    @Autowired
    private PlatoFacturaCreate creator;

    @PostMapping(value = "/plato/create")
    public ResponseEntity execute(@RequestBody PlatoFacturaCreatorRequest request) {
        creator.execute(request.getFacturaID(), request.getPlatoID(), request.getNombre(), request.getCantidad(),
                request.getPrecio());
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    static class PlatoFacturaCreatorRequest {
        private String facturaID;
        private String platoID;
        private String nombre;
        private int cantidad;
        private double precio;

        public String getFacturaID() {
            return facturaID;
        }

        public void setFacturaID(String facturaID) {
            this.facturaID = facturaID;
        }

        public String getPlatoID() {
            return platoID;
        }

        public void setPlatoID(String platoID) {
            this.platoID = platoID;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public int getCantidad() {
            return cantidad;
        }

        public void setCantidad(int cantidad) {
            this.cantidad = cantidad;
        }

        public double getPrecio() {
            return precio;
        }

        public void setPrecio(double precio) {
            this.precio = precio;
        }
    }

}
