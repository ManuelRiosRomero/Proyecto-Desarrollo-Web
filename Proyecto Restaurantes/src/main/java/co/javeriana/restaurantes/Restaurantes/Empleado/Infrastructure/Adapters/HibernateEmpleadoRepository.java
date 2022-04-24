package co.javeriana.restaurantes.Restaurantes.Empleado.Infrastructure.Adapters;

import co.javeriana.restaurantes.Restaurantes.Empleado.Domain.Empleado;
import co.javeriana.restaurantes.Restaurantes.Empleado.Domain.Ports.EmpleadoRepository;
import co.javeriana.restaurantes.Restaurantes.Empleado.Domain.ValueObjects.EmpleadoCedula;
import co.javeriana.restaurantes.Restaurantes.Empleado.Domain.ValueObjects.EmpleadoID;
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
public class HibernateEmpleadoRepository extends HibernateRepository<Empleado> implements EmpleadoRepository {

    public HibernateEmpleadoRepository(@Qualifier("session-factory") SessionFactory sessionFactory) {
        super(sessionFactory, Empleado.class);
    }

    @Override
    public void save(Empleado empleado) {
        persist(empleado);
    }

    @Override
    public void update(Empleado empleado) {
        updateEntity(empleado);
    }

    @Override
    public Optional<Empleado> find(EmpleadoID empleadoId) {
        return byId(empleadoId);
    }

    @Override
    public Optional<Empleado> findByCedula(EmpleadoCedula empleadoCedula) {
        Empleado empleado = null;
        CriteriaBuilder cb = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<Empleado> cr = cb.createQuery(Empleado.class);
        Root<Empleado> root = cr.from(Empleado.class);
        cr.select(root).where(cb.equal(root.get("cedula"), empleadoCedula));
        List<Empleado> empleados = sessionFactory.getCurrentSession().createQuery(cr).getResultList();
        if(!empleados.isEmpty()) {
            empleado = empleados.get(0);
        }
        return Optional.ofNullable(empleado);
    }

    @Override
    public Optional<List<Empleado>> all() {
        return getAll();
    }

    @Override
    public void delete(Empleado empleado) {
        deleteEntity(empleado);
    }

}