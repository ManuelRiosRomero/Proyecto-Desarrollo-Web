package co.javeriana.restaurantes.Restaurantes.Factura.Infrastructure.Adapters;

import co.javeriana.restaurantes.Restaurantes.Factura.Domain.Factura;
import co.javeriana.restaurantes.Restaurantes.Factura.Domain.Ports.FacturaRepository;
import co.javeriana.restaurantes.Restaurantes.Factura.Domain.ValueObjects.FacturaID;
import co.javeriana.restaurantes.Restaurantes.Plato.Domain.Plato;
import co.javeriana.restaurantes.Shared.Infrastructure.Hibernate.HibernateRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.Optional;


public class HibernateFacturaRepository extends HibernateRepository<Factura> implements FacturaRepository {

    public HibernateFacturaRepository(@Qualifier("session-factory") SessionFactory sessionFactory) {
        super(sessionFactory, Factura.class);
        System.out.println("HibernateFacturaRepository");
    }

    @Override
    public void save(Factura factura) {

    }

    @Override
    public void update(Factura factura) {

    }

    @Override
    public Optional<Factura> findByID(FacturaID facturaId) {
        return Optional.empty();
    }

    @Override
    public Optional<List<Factura>> all() {
        return Optional.empty();
    }

    @Override
    public void delete(Factura factura) {

    }
}
