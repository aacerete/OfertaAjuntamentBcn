package com.example.a46990527d.ofertaajuntamentbcn;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
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

        OfertaAjuntamentBcn my = OfertaAjuntamentBcn.getInstance();
        if(my.resultados != null){
            seleccio.addAll(my.resultados);
        }


        ListView lvConcursos = (ListView) view.findViewById(R.id.lvConcursos);

        adapter = new SeleccioAdapter(getContext(), seleccio);

        lvConcursos.setAdapter(adapter);

        return view;
    }
}
