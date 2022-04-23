package co.javeriana.restaurantes.Restaurantes.Insumo.Infrastructure.Adapters;

import co.javeriana.restaurantes.Restaurantes.Insumo.Domain.Insumo;
import co.javeriana.restaurantes.Restaurantes.Insumo.Domain.Ports.InsumoRepository;
import co.javeriana.restaurantes.Restaurantes.Insumo.Domain.ValueObjects.InsumoID;
import co.javeriana.restaurantes.Restaurantes.Insumo.Domain.ValueObjects.RestauranteID;
import co.javeriana.restaurantes.Shared.Infrastructure.Hibernate.HibernateRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.Optional;

public class HibernateInsumoRepository extends HibernateRepository<Insumo> implements InsumoRepository {

    public HibernateInsumoRepository(@Qualifier("session-factory") SessionFactory sessionFactory) {
        super(sessionFactory, Insumo.class);
    }

    @Override
    public void save(Insumo insumo) {
        persist(insumo);
    }

    @Override
    public void update(Insumo insumo) {
        updateEntity(insumo);
    }

    @Override
    public Optional<Insumo> find(InsumoID insumoId) {
        return byId(insumoId);
    }

    @Override
    public Optional<List<Insumo>> all() {
        return getAll();
    }

    @Override
    public void delete(Insumo insumo) {
        deleteEntity(insumo);
    }
}
