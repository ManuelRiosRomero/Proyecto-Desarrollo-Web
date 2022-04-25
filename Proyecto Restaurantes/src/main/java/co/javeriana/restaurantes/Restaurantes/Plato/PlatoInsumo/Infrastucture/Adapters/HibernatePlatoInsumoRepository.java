package co.javeriana.restaurantes.Restaurantes.Plato.PlatoInsumo.Infrastucture.Adapters;

import co.javeriana.restaurantes.Restaurantes.Plato.PlatoInsumo.Domain.PlatoInsumo;
import co.javeriana.restaurantes.Restaurantes.Plato.PlatoInsumo.Domain.Ports.PlatoInsumoRepository;
import co.javeriana.restaurantes.Shared.Infrastructure.Hibernate.HibernateRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@Transactional("transactional-manager")
public class HibernatePlatoInsumoRepository extends HibernateRepository<PlatoInsumo> implements PlatoInsumoRepository {

    public HibernatePlatoInsumoRepository(@Qualifier("session-factory") SessionFactory sessionFactory) {
        super(sessionFactory, PlatoInsumo.class);
        //System.out.println("HibernatePlatoRepository");
    }

    @Override
    public void save(PlatoInsumo platoInsumo) {
        persist(platoInsumo);
    }

    @Override
    public void update(PlatoInsumo platoInsumo) {
        updateEntity(platoInsumo);
    }

    @Override
    public Optional<List<PlatoInsumo>> findByPlatoId(String platoID) {
        CriteriaBuilder cb = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<PlatoInsumo> cr = cb.createQuery(PlatoInsumo.class);
        Root<PlatoInsumo> root = cr.from(PlatoInsumo.class);
        cr.select(root).where(cb.equal(root.get("platoID"), platoID));
        List<PlatoInsumo> platos = sessionFactory.getCurrentSession().createQuery(cr).getResultList();
        return Optional.ofNullable(platos);
    }

    @Override
    public Optional<List<PlatoInsumo>> findByInsumoId(String insumoID) {
        CriteriaBuilder cb = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<PlatoInsumo> cr = cb.createQuery(PlatoInsumo.class);
        Root<PlatoInsumo> root = cr.from(PlatoInsumo.class);
        cr.select(root).where(cb.equal(root.get("insumoID"), insumoID));
        List<PlatoInsumo> platos = sessionFactory.getCurrentSession().createQuery(cr).getResultList();
        return Optional.ofNullable(platos);
    }

    @Override
    public Optional<List<PlatoInsumo>> all() {
        return getAll();
    }

    @Override
    public void delete(PlatoInsumo platoInsumo) {
        deleteEntity(platoInsumo);

    }
}
