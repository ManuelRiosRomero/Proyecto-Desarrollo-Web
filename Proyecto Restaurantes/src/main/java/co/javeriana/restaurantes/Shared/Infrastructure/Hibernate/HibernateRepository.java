package co.javeriana.restaurantes.Shared.Infrastructure.Hibernate;

import co.javeriana.restaurantes.Shared.Domain.Aggregate.CustomUUID;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
import java.util.Optional;

public abstract class HibernateRepository<T> {

    protected final SessionFactory sessionFactory;
    protected final Class<T> aggregateClass;

    public HibernateRepository(SessionFactory sessionFactory, Class<T> aggregateClass) {
        this.sessionFactory = sessionFactory;
        this.aggregateClass = aggregateClass;
    }

    protected void persist(T entity) {
        sessionFactory.getCurrentSession().saveOrUpdate(entity);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().clear();
    }

    protected Optional<List<T>> getAll() {
        CriteriaQuery<T> criteria = sessionFactory.getCriteriaBuilder().createQuery(aggregateClass);
        criteria.from(aggregateClass);
        return Optional.ofNullable(sessionFactory.getCurrentSession().createQuery(criteria).getResultList());
    }

    protected Optional<T> byId(CustomUUID id) {
        return Optional.ofNullable(sessionFactory.getCurrentSession().byId(aggregateClass).load(id));
    }

    protected void updateEntity(T entity) {
        sessionFactory.getCurrentSession().update(entity);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().clear();
    }

    protected void deleteEntity(T entity) {
        sessionFactory.getCurrentSession().delete(entity);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().clear();
    }
}
