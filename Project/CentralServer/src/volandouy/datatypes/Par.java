package volandouy.datatypes;

import java.util.Objects;

public final class Par {
    private final String pais;
    private final String ciudad;

    public Par(String pais, String ciudad) {
        this.pais = pais;
        this.ciudad = ciudad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Par that = (Par) o;
        return Objects.equals(pais, that.pais) &&
               Objects.equals(ciudad, that.ciudad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pais, ciudad);
    }

    public String getPais() {
        return pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    @Override
    public String toString() {
        return "(" + pais + ", " + ciudad + ")";
    }
}