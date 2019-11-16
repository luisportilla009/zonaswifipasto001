package com.ldpbapp.zonaswifipasto2019;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ldpbapp.zonaswifipasto2019.models.ZonaWifi;

import java.util.ArrayList;

public class ListaZonasWifiAdapter extends RecyclerView.Adapter<ListaZonasWifiAdapter.ViewHolder> {


    private ArrayList<ZonaWifi> dataset;

    public ListaZonasWifiAdapter(){
        dataset= new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_zonawifi,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ZonaWifi zonaWifi = dataset.get(position);
        holder.nombreTextView.setText(zonaWifi.getPuntoWifi());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public void adicionarListaZonasWifi(ArrayList lista) {
        dataset.addAll(lista);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView nombreTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nombreTextView = itemView.findViewById(R.id.nombreTextView);
        }
    }
}
