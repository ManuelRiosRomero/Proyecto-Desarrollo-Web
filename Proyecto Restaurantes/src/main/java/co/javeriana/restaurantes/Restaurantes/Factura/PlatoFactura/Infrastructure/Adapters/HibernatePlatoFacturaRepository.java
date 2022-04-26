package co.javeriana.restaurantes.Restaurantes.Factura.PlatoFactura.Infrastructure.Adapters;

import co.javeriana.restaurantes.Restaurantes.Factura.PlatoFactura.Domain.PlatoFactura;
import co.javeriana.restaurantes.Restaurantes.Factura.PlatoFactura.Domain.Ports.PlatoFacturaRepository;
import co.javeriana.restaurantes.Shared.Infrastructure.Hibernate.HibernateRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional("transactional-manager")
public class HibernatePlatoFacturaRepository extends HibernateRepository<PlatoFactura> implements PlatoFacturaRepository {

    public HibernatePlatoFacturaRepository(@Qualifier("session-factory")SessionFactory sessionFactory) {
        super(sessionFactory, PlatoFactura.class);
    }


    @Override
    public void save(PlatoFactura platoFactura) {
        persist(platoFactura);
    }

    @Override
    public void update(PlatoFactura platoFactura) {
        updateEntity(platoFactura);
    }

    @Override
    public Optional<List<PlatoFactura>> findByPlatoFacturaID(String platoID, String facturaID) {
        return Optional.empty();
    }

    @Override
    public Optional<List<PlatoFactura>> all() {
        return getAll();
    }

    @Override
    public void delete(PlatoFactura platoFactura) {
        deleteEntity(platoFactura);
    }
}
