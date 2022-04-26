package co.javeriana.restaurantes.Shared.Domain.Aggregate;


import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class CustomUUID implements Serializable {

    private String value;

    protected CustomUUID() {}

    public CustomUUID(String value) {
        validate(value);
        this.value = value;
    }

    public String value() {
        return value;
    }

    private void validate(String value) {
        validFormat(value);
    }

    private void validFormat(String value) {
        try {
            UUID.fromString(value);
        }
        catch (Exception ex)
        {
            throw new RuntimeException("El UUID no tiene un formato valido");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomUUID that = (CustomUUID) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}