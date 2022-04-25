package co.javeriana.restaurantes.Restaurantes.Plato.PlatoInsumo.Infrastucture.Controllers;

import co.javeriana.restaurantes.Restaurantes.Plato.PlatoInsumo.Application.Create.PlatoInsumoCreate;
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
@Tag(name = "Plato Insumo", description = "Plato Insumo REST API")
@RequestMapping(value = "/plato")
public class PlatoInsumoCreateController {


    @Autowired
    private PlatoInsumoCreate creator;

    @PostMapping(value = "/insumo/create")
    public ResponseEntity execute(@RequestBody PlatoInsumoCreateController.PlatoInsumoCreatorRequest request) {
        creator.execute(request.getInsumoid(), request.getNombreinsumo(), request.getPlatoid(), request.getCantidadnecesaria());
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }
    static class PlatoInsumoCreatorRequest{

        @Schema(description = "insumo id", example = "17efg4a8-c413-15ec-9d62-02454c120002")
        private String insumoid;
        @Schema(description = "nombre insumo", example = "queso")
        private String nombreinsumo;
        @Schema(description = "Plato id", example = "87ede4a8-c413-11ec-9d64-0242ac120002")
        private String platoid;
        @Schema(description = "Cantidad necesaria del insumo", example = "1 | 2 | 3")
        private int cantidadnecesaria;

        public String getInsumoid() {
            return insumoid;
        }

        public void setInsumoid(String insumoid) {
            this.insumoid = insumoid;
        }

        public String getNombreinsumo() {
            return nombreinsumo;
        }

        public void setNombreinsumo(String nombreinsumo) {
            this.nombreinsumo = nombreinsumo;
        }

        public String getPlatoid() {
            return platoid;
        }

        public void setPlatoid(String platoid) {
            this.platoid = platoid;
        }

        public int getCantidadnecesaria() {
            return cantidadnecesaria;
        }

        public void setCantidadnecesaria(int cantidadnecesaria) {
            this.cantidadnecesaria = cantidadnecesaria;
        }
    }



}
