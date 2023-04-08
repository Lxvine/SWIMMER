package com.example.nadador;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ListAdapter extends BaseAdapter {

    private final Context context;
    private final List<Entrenamiento> trainingList;

    public ListAdapter(Context context, List<Entrenamiento> trainingList) {
        this.context = context;
        this.trainingList = trainingList;
    }

    @Override
    public int getCount() {
        return trainingList.size();
    }

    @Override
    public Object getItem(int position) {
        return trainingList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        @SuppressLint("ViewHolder") View v = View.inflate(context, R.layout.item_list, null);
        TextView fecha = (TextView) v.findViewById(R.id.fecha);
        TextView tiempo = (TextView) v.findViewById(R.id.tiempo);
        TextView distancia = (TextView) v.findViewById(R.id.distancia);

        fecha.setText(trainingList.get(position).getFecha());
        tiempo.setText(trainingList.get(position).getSegundos() + " segundos.");
        distancia.setText(trainingList.get(position).getDistancia() + " kilometros.");

        v.setTag(trainingList.get(position).getId());

        return v;
    }
}