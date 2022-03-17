package co.javeriana.restaurantes.Shared.Domain.Aggregate;

import java.time.LocalDateTime;
import java.util.Objects;

public class DateTimeValueObject {

    protected LocalDateTime dateTime;

    protected DateTimeValueObject() {}

    public LocalDateTime value() {
        return dateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DateTimeValueObject that = (DateTimeValueObject) o;
        return Objects.equals(dateTime, that.dateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateTime);
    }
}
