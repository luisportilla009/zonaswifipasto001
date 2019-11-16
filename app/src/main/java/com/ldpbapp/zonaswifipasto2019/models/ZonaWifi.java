package com.ldpbapp.zonaswifipasto2019.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ZonaWifi {

    @SerializedName("direccion")
    @Expose
    private String direccion;
    @SerializedName("punto_wifi")
    @Expose
    private String puntoWifi;
    @SerializedName("coordenadas_puntos_wifi")
    @Expose
    private CoordenadasPuntosWifi coordenadasPuntosWifi;
    @SerializedName("ubicaci_n_en_dos_columnas")
    @Expose
    private UbicaciNEnDosColumnas ubicaciNEnDosColumnas;

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPuntoWifi() {
        return puntoWifi;
    }

    public void setPuntoWifi(String puntoWifi) {
        this.puntoWifi = puntoWifi;
    }

    public CoordenadasPuntosWifi getCoordenadasPuntosWifi() {
        return coordenadasPuntosWifi;
    }

    public void setCoordenadasPuntosWifi(CoordenadasPuntosWifi coordenadasPuntosWifi) {
        this.coordenadasPuntosWifi = coordenadasPuntosWifi;
    }

    public UbicaciNEnDosColumnas getUbicaciNEnDosColumnas() {
        return ubicaciNEnDosColumnas;
    }

    public void setUbicaciNEnDosColumnas(UbicaciNEnDosColumnas ubicaciNEnDosColumnas) {
        this.ubicaciNEnDosColumnas = ubicaciNEnDosColumnas;
    }

}