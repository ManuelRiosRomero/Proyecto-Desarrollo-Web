package co.javeriana.restaurantes.Restaurantes.Infrastructure.Adapters;

import co.javeriana.restaurantes.Restaurantes.Domain.Ports.RestauranteRepository;
import co.javeriana.restaurantes.Restaurantes.Domain.Restaurante;
import co.javeriana.restaurantes.Restaurantes.Domain.ValueObjects.RestauranteID;
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
public class HibernateRestauranteRepository extends HibernateRepository<Restaurante> implements RestauranteRepository {

    public HibernateRestauranteRepository(@Qualifier("session-factory") SessionFactory sessionFactory) {
        super(sessionFactory, Restaurante.class);
    }

    @Override
    public void save(Restaurante restaurante) {
        persist(restaurante);
    }

    @Override
    public void update(Restaurante restaurante) {
        updateEntity(restaurante);
    }

    @Override
    public Optional<Restaurante> findById(RestauranteID id) {
        Restaurante res = null;
        CriteriaBuilder cb = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<Restaurante> cr = cb.createQuery(Restaurante.class);
        Root<Restaurante> root = cr.from(Restaurante.class);
        cr.select(root).where(cb.equal(root.get("id"), id));
        List<Restaurante> restaurantes = sessionFactory.getCurrentSession().createQuery(cr).getResultList();
        if(!restaurantes.isEmpty()) {
            res = restaurantes.get(0);
        }
        return Optional.ofNullable(res);
    }

    @Override
    public Optional<List<Restaurante>> all() {
        return getAll();
    }

    @Override
    public void delete(Restaurante restaurante) {
        deleteEntity(restaurante);
    }
}
