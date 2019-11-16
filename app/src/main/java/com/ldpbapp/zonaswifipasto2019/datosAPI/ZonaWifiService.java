package com.ldpbapp.zonaswifipasto2019.datosAPI;

import com.ldpbapp.zonaswifipasto2019.models.ZonaWifi;
import com.ldpbapp.zonaswifipasto2019.models.ZonaWifiRespuesta;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ZonaWifiService {

    @GET("resource/pkga-gxrz.json")
    Call<ArrayList<ZonaWifi>> obtenerListaZonaWifi();
}
