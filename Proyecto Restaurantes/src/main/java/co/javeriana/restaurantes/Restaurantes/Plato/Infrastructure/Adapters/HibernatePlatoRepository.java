package co.javeriana.restaurantes.Restaurantes.Plato.Infrastructure.Adapters;

import co.javeriana.restaurantes.Restaurantes.Plato.Domain.Plato;
import co.javeriana.restaurantes.Restaurantes.Plato.Domain.Ports.PlatoRepository;
import co.javeriana.restaurantes.Restaurantes.Plato.Domain.ValueObjects.PlatoID;
import co.javeriana.restaurantes.Shared.Infrastructure.Hibernate.HibernateRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional("transactional-manager")
public class HibernatePlatoRepository extends HibernateRepository<Plato> implements PlatoRepository {

    public HibernatePlatoRepository(@Qualifier("session-factory") SessionFactory sessionFactory) {
        super(sessionFactory, Plato.class);
        //System.out.println("HibernatePlatoRepository");
    }

    @Override
    public void save(Plato plato) {
        persist(plato);
    }

    @Override
    public void update(Plato plato) {
        updateEntity(plato);
    }

    @Override
    public Optional<Plato> findByID(PlatoID platoID) {
        return byId(platoID);
    }

    @Override
    public Optional<List<Plato>> all() {
        return getAll();
    }

    @Override
    public void delete(Plato plato) {
        deleteEntity(plato);
    }
}

