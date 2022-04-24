package co.javeriana.restaurantes.Restaurantes.Factura.Infrastructure.Hibernate;

import co.javeriana.restaurantes.Restaurantes.Factura.Domain.Entities.FacturaPlato;
import co.javeriana.restaurantes.Restaurantes.Plato.Domain.Entities.PlatoInsumo;
import co.javeriana.restaurantes.Restaurantes.Plato.Domain.Plato;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class FacturaPlatoCustomType implements UserType {
    @Override
    public int[] sqlTypes() {
        return new int[] {Types.LONGNVARCHAR};
    }

    @Override
    public Class returnedClass() {
        return List.class;
    }

    @Override
    public boolean equals(Object x, Object y) throws HibernateException {
        return Objects.equals(x, y);
    }

    @Override
    public int hashCode(Object x) throws HibernateException {
        return Objects.hashCode(x);
    }

    @Override
    public Object nullSafeGet(ResultSet rs, String[] names, SharedSessionContractImplementor session, Object owner) throws HibernateException, SQLException {
        List<FacturaPlato> response=null;
        try {
            Optional<String> value = Optional.ofNullable(rs.getString(names[0]));
            if(value.isPresent()){
                List<HashMap<String, Object>> objects = new ObjectMapper().readValue(value.get(), List.class);
                response = objects.stream().map(element -> new FacturaPlato((String) element.get("id"),
                        (String) element.get("nombre"),
                        (String) element.get("descripcion"),
                        (double) element.get("costo"),
                        (List<Plato>) element.get("platos")
                        )).collect(Collectors.toList());
            }
        }
        catch (Exception e) {
            throw new HibernateException("Error ar reading map of UserAddress " + e.toString());
        }
        return Optional.ofNullable(response);
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index, SharedSessionContractImplementor session) throws HibernateException, SQLException {
        Optional<List<FacturaPlato>> object = (value==null)? Optional.empty() : (Optional<List<FacturaPlato>>) value;
        try{
            if(object.isEmpty()){
                st.setNull(index, Types.LONGNVARCHAR);
            }
            else{
                ObjectMapper mapper = new ObjectMapper();
                List<HashMap<String,Object>> objects = object.get()
                        .stream().map(element -> element.data()).collect(Collectors.toList());
                String serializedObject = mapper.writeValueAsString(objects).replace("\\", "");
                st.setString(index, serializedObject);
            }

        }catch (Exception e){
            throw new HibernateException("Error serializing value of FacturaPlato " + e.toString());
        }

    }

    @Override
    public Object deepCopy(Object value) throws HibernateException {
        return null;
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public Serializable disassemble(Object value) throws HibernateException {
        return null;
    }

    @Override
    public Object assemble(Serializable cached, Object owner) throws HibernateException {
        return null;
    }

    @Override
    public Object replace(Object original, Object target, Object owner) throws HibernateException {
        return null;
    }
}
