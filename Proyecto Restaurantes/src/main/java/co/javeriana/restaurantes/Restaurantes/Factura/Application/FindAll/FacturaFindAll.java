package co.javeriana.restaurantes.Restaurantes.Factura.Application.FindAll;

import co.javeriana.restaurantes.Restaurantes.Factura.Domain.Factura;
import co.javeriana.restaurantes.Restaurantes.Factura.Domain.Ports.FacturaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FacturaFindAll {

    private FacturaRepository repository;

    public FacturaFindAll(FacturaRepository repository){
        this.repository = repository;
    }

    public List<Factura> execute(){
        List<Factura> platos = new ArrayList<>();
        Optional<List<Factura>> optionalFactura = repository.all();
        if(optionalFactura.isPresent()){
            platos = optionalFactura.get();
        }
        return platos;
    }
}
