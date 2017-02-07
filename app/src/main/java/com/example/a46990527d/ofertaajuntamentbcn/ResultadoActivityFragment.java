package com.example.a46990527d.ofertaajuntamentbcn;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

//Fragment que conté els listviews amb les diferents convocatories
public class ResultadoActivityFragment extends Fragment {

    private ArrayList<Selection> seleccio = new ArrayList<>();
    private SeleccioAdapter adapter;

    public ResultadoActivityFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_resultado, container, false);

        //emmagatzem els resultats a través de la application
        OfertaAjuntamentBcn my = OfertaAjuntamentBcn.getInstance();
        if(my.resultados != null){
            seleccio.addAll(my.resultados);
        }


        ListView lvConcursos = (ListView) view.findViewById(R.id.lvConcursos);
        adapter = new SeleccioAdapter(getContext(), seleccio);
        lvConcursos.setAdapter(adapter);

        //obrim el details activity al fer click en qualsevol convocatoria
        lvConcursos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Selection seleccio = (Selection) adapterView.getItemAtPosition(i);

                Intent intent = new Intent(getContext(), DetailsActivity.class);
                intent.putExtra("seleccio", seleccio);

                startActivity(intent);
            }
        });


        return view;
    }
}
