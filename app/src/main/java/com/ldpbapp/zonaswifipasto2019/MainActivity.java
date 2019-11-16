package com.ldpbapp.zonaswifipasto2019;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.ldpbapp.zonaswifipasto2019.datosAPI.ZonaWifiService;
import com.ldpbapp.zonaswifipasto2019.models.ZonaWifi;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private Retrofit retrofit;
    private static final String TAG="ZONASWIFI";
    public RecyclerView recyclerView;
    private ListaZonasWifiAdapter listaZonasWifiAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView.setAdapter(listaZonasWifiAdapter);
        GridLayoutManager layoutManager = new GridLayoutManager(this,1);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        listaZonasWifiAdapter = new ListaZonasWifiAdapter();

        retrofit = new Retrofit.Builder()
                .baseUrl("https://www.datos.gov.co/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        obtenerDatos();

    }
    private void  obtenerDatos(){

        ZonaWifiService service = retrofit.create(ZonaWifiService.class);
        Call<ArrayList<ZonaWifi>> zonawifiRespuestaCall = service.obtenerListaZonaWifi();
        zonawifiRespuestaCall.enqueue(new Callback<ArrayList<ZonaWifi>>() {
            @Override
            public void onResponse(Call<ArrayList<ZonaWifi>> call, Response<ArrayList<ZonaWifi>> response) {

                if(response.isSuccessful()){

                    ArrayList lista = response.body();

                    listaZonasWifiAdapter.adicionarListaZonasWifi(lista);


                    /*for(int i=0;i<lista.size();i++)
                    {

                        ZonaWifi zonaWifi=(ZonaWifi) lista.get(i);

                        Log.i(TAG," ZonasWifi: "+zonaWifi.getPuntoWifi()+ " Direccion: " +zonaWifi.getDireccion());
                    }*/

                }else
                {
                    Log.e(TAG, " onResponse: "+response.errorBody());
                }

            }

            @Override
            public void onFailure(Call<ArrayList<ZonaWifi>> call, Throwable t) {

            }
        });
    }



}
