package com.example.a46990527d.ofertaajuntamentbcn;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.Snackbar;
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
        progress.setMessage("Carregant...");
        progress.hide();


        //valors posibles de cerca segons la documentació de la API
        String[] ensValues =
                {"Tots", "Ajuntament de Barcelona", "Institut Barcelona Esports", "Institut de Cultura de Barcelona", "Institut Municipal d'Educació de Barcelona", "Institut Municipal d'Hisenda",
                        "Institut Municipal d'Informàtica", "Institut Municipal de Mercats de Barcelona", "Institut Municipal del Paissatge Urbà", "Institut Municipal de Serveis Socials de Barcelona",
                        "Patronat Municipal de l'Habitatge de Barcelona"};

        String[] concursValues =
                {"Tots", "Concurs", "Lliure designació", "Mobilitat horitzontal", "Provisió oberta a altres administracions", "Oferta pública", "Promoció interna especial", "Borses de treball",
                        "Altres processos directius"};

        //Spinner amb els ens (layout personalitzat definit a spinner_item)
        spEns = (Spinner) view.findViewById(R.id.spinnerEns);
        ArrayAdapter<String> ensAdapter = new ArrayAdapter<String>(this.getActivity(), R.layout.spinner_item, ensValues);

        spEns.setAdapter(ensAdapter);

        //Spinner amb els tipus de concurs
        spConcurs = (Spinner) view.findViewById(R.id.spinnerConcurs);
        ArrayAdapter<String> concursAdapter = new ArrayAdapter<String>(this.getActivity(), R.layout.spinner_item, concursValues);

        spConcurs.setAdapter(concursAdapter);



        //button per a relaitzar la cerca
        Button btnCercar = (Button) view.findViewById(R.id.btnCercar);
        btnCercar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                switch (v.getId()) {
                    case R.id.btnCercar:

                        //comprovem si hi ha connexio
                        ConnectivityManager connMgr = (ConnectivityManager) getActivity()
                                .getSystemService(Context.CONNECTIVITY_SERVICE);

                        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

                        if (networkInfo != null && networkInfo.isConnected()) {
                            //si no hi ha realitzem la cerca
                            RefreshDataTask tarea = new RefreshDataTask();
                            tarea.execute();

                            break;
                        } else {
                            // si no mostrem un snackbar que informa que no tenim connexio
                            Snackbar.make(getActivity().findViewById(android.R.id.content), "No es troba la connexió a Internet", Snackbar.LENGTH_LONG)
                                    .show();

                        }

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

            return result;
        }

        @Override
        protected void onPostExecute(ArrayList<Selection> selections) {
            ArrayList<Selection> resultados = new ArrayList<>();
            String ent = spEns.getSelectedItem().toString();
            String concurs = spConcurs.getSelectedItem().toString();



            //Condicions de la cerca

            if(ent.equals("Tots") && concurs.equals("Tots")){
                resultados.addAll(selections);


            }else if(ent.equals("Tots") && !concurs.equals("Tots")){
                for (Selection sel: selections) {
                    if(concurs.equals(sel.getTipus())){
                        resultados.add(sel);
                    }
                }

            }else if(!ent.equals("Tots") && concurs.equals("Tots")){
                for (Selection sel: selections) {
                    if(ent.equals(sel.getEns())){
                        resultados.add(sel);
                    }
                }

            }else {
                for (Selection sel : selections) {
                    if (ent.equals(sel.getEns()) && concurs.equals(sel.getTipus())) {
                        resultados.add(sel);
                    }
                }

            }



            progress.hide();

            //preparem la apertura de la activity de resultats
            Intent i = new Intent(mContext, ResultadoActivity.class);
            OfertaAjuntamentBcn my = OfertaAjuntamentBcn.getInstance();

            //Girar arrayList para que aparezcan las convocatorias mas nuevas primero
            Collections.reverse(resultados);
            my.resultados.clear();
            my.resultados.addAll(resultados);

            //iniciem
            i.putExtra("ajuntament", ent);
            i.putExtra("concurs", concurs);
            startActivity(i);
        }
    }






}
