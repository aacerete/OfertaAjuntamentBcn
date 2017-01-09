package com.example.a46990527d.ofertaajuntamentbcn;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {




    public MainActivityFragment() {
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);


        String [] ensValues =
                { "Tots", "Ajuntament de Barcelona", "Institut Barcelona Esports", "Institut de Cultura de Barcelona", "Institut Municipal d'Educació de Barcelona", "Institut Municipal d'Hisenda",
                        "Institut Municipal d'Informàtica", "Institut Municipal de Mercats de Barcelona", "Institut Municipal del Paissatge Urbà", "Institut Municipal de Serveis Socials de Barcelona",
                        "Patronat Municipal de l'Habitatge de Barcelona"};

        String [] concursValues =
                {"Tots", "Concurs", "Lliure designació", "Mobilitat horitzontal", "Provisió oberta a altres administracions", "Oferta pública", "Promoció interna especial", "Borses de treball",
                 "Altres processos directius"   };

        //Spinner 1
        Spinner spEns = (Spinner) view.findViewById(R.id.spinnerEns);
        ArrayAdapter<String> ensAdapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, ensValues);
        ensAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spEns.setAdapter(ensAdapter);


        //Spinner 2
        Spinner spConcurs = (Spinner) view.findViewById(R.id.spinnerConcurs);
        ArrayAdapter<String> concursAdapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, concursValues);
        ensAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spConcurs.setAdapter(concursAdapter);


        //button

        Button btnCercar = (Button) view.findViewById(R.id.btnCercar);
        btnCercar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btnCercar:
                        //what to put here

                        Intent i = new Intent(getContext(), ResultadoActivity.class);
                        i.putExtra("ajuntament", "tots");
                        i.putExtra("concurs", "tots");
                        startActivity(i);

                 
                        break;
                }
            }
        });

        return view;
    }


}
