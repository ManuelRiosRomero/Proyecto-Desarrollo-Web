package co.javeriana.restaurantes.Restaurantes.Empleado.Infrastructure.Adapters;

import co.javeriana.restaurantes.Restaurantes.Empleado.Domain.Empleado;
import co.javeriana.restaurantes.Restaurantes.Empleado.Domain.Ports.EmpleadoRepository;
import co.javeriana.restaurantes.Restaurantes.Empleado.Domain.ValueObjects.EmpleadoID;
import co.javeriana.restaurantes.Shared.Infrastructure.Hibernate.HibernateRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

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
    public Optional<List<Empleado>> all() {
        return getAll();
    }

    @Override
    public void delete(Empleado empleado) {
        deleteEntity(empleado);
    }

}