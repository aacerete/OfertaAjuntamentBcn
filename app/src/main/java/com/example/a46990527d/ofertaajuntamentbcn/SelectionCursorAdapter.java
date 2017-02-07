package com.example.a46990527d.ofertaajuntamentbcn;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.example.a46990527d.ofertaajuntamentbcn.SeleccioAdapter.isInteger;

/**
 * Created by 46990527d on 01/02/17.
 */

//Adapter per al cupboard
public class SelectionCursorAdapter extends CupboardCursorAdapter<Selection> {

    public SelectionCursorAdapter(Context context, Class<Selection> entityClass) {
        super(context, entityClass);
    }

    @Override
    public View newView(Context context, Selection model, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View item = inflater.inflate(R.layout.lv_concursos_row, null);

        return item;
    }

    @Override
    public void bindView(View view, Context context, Selection model) {
        // A partir de la vista, recogeremos los controles que contiene para
        // poder manipularlos.
        // Recogemos el TextView para mostrar el nombre y establecemos el
        // nombre.
        TextView Ents = (TextView) view.findViewById(R.id.tvEns);
        Ents.setText(model.getEns());

        // Recogemos el TextView para mostrar el número de celda y lo
        // establecemos.
        String nom = model.getConvocatories().get(model.getConvocatories().size()-1).getTitle();
        TextView NomConvocatoria = (TextView) view.findViewById(R.id.tvNom);
        NomConvocatoria.setText(nom);
        TextView Places = (TextView) view.findViewById(R.id.tvPlaces);
        TextView termini = (TextView) view.findViewById(R.id.tvTermini);

        if (isInteger(model.getNombrePlaces())){
            Places.setText(model.getNombrePlaces() + " plaça/es");
        }else{
            Places.setText("");
        }

        TextView estat = (TextView) view.findViewById(R.id.tvEstatConv);

        Date today = new Date();
        String date = model.getFiPresentacio();
        System.out.println(date);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Date fin = null;
        try {
            fin = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (today.after(fin)){
            estat.setText(" Termini exhaurit");
            estat.setTextColor(Color.RED);
        }else{
            estat.setText(model.getFiPresentacio());
            estat.setTextColor(Color.GREEN);
        }
    }
}