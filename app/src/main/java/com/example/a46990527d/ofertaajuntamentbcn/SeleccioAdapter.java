package com.example.a46990527d.ofertaajuntamentbcn;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static android.content.ContentValues.TAG;

/**
 * Created by Usuario on 29/01/2017.
 */

//Adapter per al listView de seleccions
public class SeleccioAdapter extends ArrayAdapter {
    private Context context;

    public SeleccioAdapter (Context context, ArrayList data) {
        super(context, R.layout.lv_concursos_row, data);
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // En primer lugar "inflamos" una nueva vista, que será la que se
        // mostrará en la celda del ListView. Para ello primero creamos el
        // inflater, y después inflamos la vista.
        LayoutInflater inflater = LayoutInflater.from(context);
        View item = inflater.inflate(R.layout.lv_concursos_row, null);
        // Selection seleccio = data.get(position);
        Selection seleccio = (Selection) getItem(position);
        // A partir de la vista, recogeremos los controles que contiene para
        // poder manipularlos.
        // Recogemos el TextView para mostrar el nombre y establecemos el
        // nombre.
        TextView Ents = (TextView) item.findViewById(R.id.tvEns);
        Ents.setText(seleccio.getEns());

        // Recogemos el TextView para mostrar el número de celda y lo
        // establecemos.
        String nom = seleccio.getConvocatories().get(seleccio.getConvocatories().size()-1).getTitle();
        TextView NomConvocatoria = (TextView) item.findViewById(R.id.tvNom);
        NomConvocatoria.setText(nom);
        TextView Places = (TextView) item.findViewById(R.id.tvPlaces);
        TextView termini = (TextView) item.findViewById(R.id.tvTermini);

        if (isInteger(seleccio.getNombrePlaces())){
            Places.setText(seleccio.getNombrePlaces() + " plaça/es");
        }else{
            Places.setText("");
        }

        TextView estat = (TextView) item.findViewById(R.id.tvEstatConv);


        //Farem servir DATEs per a tractar les dates i distingir entre les que estan obertes i tancades
        Date today = new Date();
        String date = seleccio.getFiPresentacio();
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
            estat.setText(seleccio.getFiPresentacio());
            estat.setTextColor(Color.GREEN);
        }

        // Devolvemos la vista para que se muestre en el ListView.
        return item;
    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        } catch(NullPointerException e) {
            return false;
        }

        return true;
    }
}
