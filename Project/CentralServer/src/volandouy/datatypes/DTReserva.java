package volandouy.datatypes;

public class DTReserva {
    private DtFecha fecha;
    private EnumAsiento tipoAsiento;
    private int unidadesEquipExtra;
    private int cantPasajes;
    private float costo;

    public DTReserva(DtFecha fecha, EnumAsiento tipoAsiento, int unidadesEquipExtra, 
                     int cantPasajes, float costo) {
        this.fecha = fecha;
        this.tipoAsiento = tipoAsiento;
        this.unidadesEquipExtra = unidadesEquipExtra;
        this.cantPasajes = cantPasajes;
        this.costo = costo;
    }

    public DtFecha getFecha() {
        return fecha;
    }

    public void setFecha(DtFecha fecha) {
        this.fecha = fecha;
    }

    public EnumAsiento getTipoAsiento() {
        return tipoAsiento;
    }

    public void setTipoAsiento(EnumAsiento tipoAsiento) {
        this.tipoAsiento = tipoAsiento;
    }

    public int getUnidadesEquipExtra() {
        return unidadesEquipExtra;
    }

    public void setUnidadesEquipExtra(int unidadesEquipExtra) {
        this.unidadesEquipExtra = unidadesEquipExtra;
    }

    public int getCantPasajes() {
        return cantPasajes;
    }

    public void setCantPasajes(int cantPasajes) {
        this.cantPasajes = cantPasajes;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }
}
