package co.javeriana.restaurantes.Restaurantes.Plato.PlatoInsumo.Domain.ValueObjects;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.io.Serializable;
import java.util.Objects;

public class PlatoInsumoIdentity implements Serializable {
    @NotNull
    @Size(min=36, max=36)
    private String platoid;

    @NotNull
    @Size(min=36, max=36)
    private String insumoid;

    public PlatoInsumoIdentity() {
    }

    public PlatoInsumoIdentity(String platoid, String insumoid) {
        this.platoid = platoid;
        this.insumoid = insumoid;
    }

    public String value() {
        return platoid + "," + insumoid;
    }

    public String getPlatoid() {
        return this.platoid;
    }

    public void setPlatoid(String platoid) {
        this.platoid = platoid;
    }

    public String getInsumoid() {
        return insumoid;
    }

    public void setInsumoid(String insumoid) {
        this.insumoid = insumoid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlatoInsumoIdentity that = (PlatoInsumoIdentity) o;
        return Objects.equals(platoid, that.platoid) && Objects.equals(insumoid, that.insumoid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(platoid, insumoid);
    }
}
