package modelos;

import java.math.BigDecimal;

/**
 * Created by bpastene on 22-05-16.
 */
public class Lugar {
    private String nombrePub;
    private String descripcionPub;
    private int valoracionPub;
    private String codigoPub;
    private int TipoPublicacionPub;
    private BigDecimal latPub;
    private BigDecimal lonPub;
    private int sumavalPub;
    private int cantidavalPub;

    public Lugar(String codigoPub, String descripcionPub, String nombrePub, int tipoPub, int valoracionPub) {
        this.codigoPub = codigoPub;
        this.descripcionPub = descripcionPub;
        this.nombrePub = nombrePub;
        this.TipoPublicacionPub = tipoPub;
        this.valoracionPub = valoracionPub;
    }

    public String getNombrePub() {
        return nombrePub;
    }

    public void setNombrePub(String nombrePub) {
        this.nombrePub = nombrePub;
    }

    public String getDescripcionPub() {
        return descripcionPub;
    }

    public void setDescripcionPub(String descripcionPub) {
        this.descripcionPub = descripcionPub;
    }

    public int getValoracionPub() {
        return valoracionPub;
    }

    public void setValoracionPub(int valoracionPub) {
        this.valoracionPub = valoracionPub;
    }

    public String getCodigoPub() {
        return codigoPub;
    }

    public void setCodigoPub(String codigoPub) {
        this.codigoPub = codigoPub;
    }

    public int getTipoPublicacionPub() {
        return TipoPublicacionPub;
    }

    public void setTipoPublicacionPub(int tipoPublicacionPub) {
        TipoPublicacionPub = tipoPublicacionPub;
    }

    public BigDecimal getLatPub() {
        return latPub;
    }

    public void setLatPub(BigDecimal latPub) {
        this.latPub = latPub;
    }

    public BigDecimal getLonPub() {
        return lonPub;
    }

    public void setLonPub(BigDecimal lonPub) {
        this.lonPub = lonPub;
    }

    public int getSumavalPub() {
        return sumavalPub;
    }

    public void setSumavalPub(int sumavalPub) {
        this.sumavalPub = sumavalPub;
    }

    public int getCantidavalPub() {
        return cantidavalPub;
    }

    public void setCantidavalPub(int cantidavalPub) {
        this.cantidavalPub = cantidavalPub;
    }
}
