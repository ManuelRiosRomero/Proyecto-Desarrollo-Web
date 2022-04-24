package co.javeriana.restaurantes.Restaurantes.Empleado.Application.FindAll;

import co.javeriana.restaurantes.Restaurantes.Empleado.Domain.Empleado;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class EmpleadoFindAllResponse {

    private List<Empleado> empleados;

    public EmpleadoFindAllResponse(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public List<HashMap<String, Object>> response() {
        List<HashMap<String, Object>> response = empleados.stream().map(empleado-> empleado.data()).collect(Collectors.toList());
        return response;
    }

}
