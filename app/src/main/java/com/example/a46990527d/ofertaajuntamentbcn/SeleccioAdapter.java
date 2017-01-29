package com.example.a46990527d.ofertaajuntamentbcn;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Usuario on 29/01/2017.
 */

public class SeleccioAdapter extends ArrayAdapter {
    private Context context;
    private ArrayList<Selection> data;

    public SeleccioAdapter (Context context, ArrayList data) {
        super(context, R.layout.lv_concursos_row, data);
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // En primer lugar "inflamos" una nueva vista, que será la que se
        // mostrará en la celda del ListView. Para ello primero creamos el
        // inflater, y después inflamos la vista.
        LayoutInflater inflater = LayoutInflater.from(context);
        View item = inflater.inflate(R.layout.lv_concursos_row, null);
        Selection seleccio = data.get(position);
        // A partir de la vista, recogeremos los controles que contiene para
        // poder manipularlos.
        // Recogemos el TextView para mostrar el nombre y establecemos el
        // nombre.
        TextView Ents = (TextView) item.findViewById(R.id.tvEns);
        Ents.setText(seleccio.getEns());

        // Recogemos el TextView para mostrar el número de celda y lo
        // establecemos.
        TextView NomConvocatoria = (TextView) item.findViewById(R.id.tvNom);
        NomConvocatoria.setText(seleccio.getConvocatories().get(seleccio.getConvocatories().size()-1).getTitle());

        // Devolvemos la vista para que se muestre en el ListView.
        return item;
    }
}
