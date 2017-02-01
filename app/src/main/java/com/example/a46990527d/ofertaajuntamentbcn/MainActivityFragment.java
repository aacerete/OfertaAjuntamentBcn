package com.example.a46990527d.ofertaajuntamentbcn;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.os.AsyncTask;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {


    Spinner spEns;
    Spinner spConcurs;
    ProgressDialog progress;
    Context mContext;
    CheckBox cbIns;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        mContext = getContext();
        progress = new ProgressDialog(getContext());
        progress.hide();

        String[] ensValues =
                {"Tots", "Ajuntament de Barcelona", "Institut Barcelona Esports", "Institut de Cultura de Barcelona", "Institut Municipal d'Educació de Barcelona", "Institut Municipal d'Hisenda",
                        "Institut Municipal d'Informàtica", "Institut Municipal de Mercats de Barcelona", "Institut Municipal del Paissatge Urbà", "Institut Municipal de Serveis Socials de Barcelona",
                        "Patronat Municipal de l'Habitatge de Barcelona"};

        String[] concursValues =
                {"Tots", "Concurs", "Lliure designació", "Mobilitat horitzontal", "Provisió oberta a altres administracions", "Oferta pública", "Promoció interna especial", "Borses de treball",
                        "Altres processos directius"};

        //Spinner 1
        spEns = (Spinner) view.findViewById(R.id.spinnerEns);
        ArrayAdapter<String> ensAdapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, ensValues);
        ensAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spEns.setAdapter(ensAdapter);


        //Spinner 2
        spConcurs = (Spinner) view.findViewById(R.id.spinnerConcurs);
        ArrayAdapter<String> concursAdapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, concursValues);
        ensAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spConcurs.setAdapter(concursAdapter);

        CheckBox cbIns = (CheckBox) view.findViewById(R.id.cbIns);

        //button
        Button btnCercar = (Button) view.findViewById(R.id.btnCercar);
        btnCercar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btnCercar:
                        //what to put here
                        //asynktask
                        RefreshDataTask tarea = new RefreshDataTask();
                        tarea.execute();

                        break;
                }
            }
        });


        return view;
    }

    //metode que s'executara en segon pla i fara la crida a l'api
       private class RefreshDataTask extends AsyncTask<Void, Void, ArrayList<Selection>> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progress.show();
        }

        @Override
                protected ArrayList<Selection> doInBackground(Void... voids) {

                        ArrayList <Selection> result = OfertaPublicaAPI.getSelections();

                       Log.d("DEBUG", result.toString());

                                return result;
                    }

        @Override
        protected void onPostExecute(ArrayList<Selection> selections) {
            ArrayList<Selection> resultados = new ArrayList<>();
            String ent = spEns.getSelectedItem().toString();
            String concurs = spConcurs.getSelectedItem().toString();



                if(ent.equals("Tots") && concurs.equals("Tots")){
                    resultados.addAll(selections);
                    System.out.println("sense filtres");

                }else if(ent.equals("Tots") && !concurs.equals("Tots")){
                    for (Selection sel: selections) {
                        if(concurs.equals(sel.getTipus())){
                            resultados.add(sel);
                        }
                    }
                    System.out.println("filtran concurs");
                }else if(!ent.equals("Tots") && concurs.equals("Tots")){
                    for (Selection sel: selections) {
                        if(ent.equals(sel.getEns())){
                            resultados.add(sel);
                        }
                    }
                    System.out.println("filtran entitat");
                }else {
                    for (Selection sel : selections) {
                        if (ent.equals(sel.getEns()) && concurs.equals(sel.getTipus())) {
                            resultados.add(sel);
                        }
                    }
                    System.out.println("filtran entitat i concurs");
                }


            System.out.println("Resultats: "+resultados.size());
            progress.hide();
            Intent i = new Intent(mContext, ResultadoActivity.class);
            OfertaAjuntamentBcn my = OfertaAjuntamentBcn.getInstance();

            //Girar arrayList para que aparezcan las convocatorias mas nuevas primero
            Collections.reverse(resultados);
            my.resultados.clear();
            my.resultados.addAll(resultados);


            i.putExtra("ajuntament", ent);
            i.putExtra("concurs", concurs);
            startActivity(i);
        }
    }




}
