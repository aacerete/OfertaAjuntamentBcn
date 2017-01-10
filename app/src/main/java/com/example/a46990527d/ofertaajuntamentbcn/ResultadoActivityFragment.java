package com.example.a46990527d.ofertaajuntamentbcn;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A placeholder fragment containing a simple view.
 */
public class ResultadoActivityFragment extends Fragment {

    private ArrayList items;
    private ArrayAdapter<String> adapter;


    public ResultadoActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_resultado, container, false);

        ListView lvConcursos = (ListView) view.findViewById(R.id.lvConcursos);


        String[] data = {"oferta 1", "oferta 2", "oferta 3", "oferta 4", "oferta 5", "oferta 6",};

                items = new ArrayList<>(Arrays.asList(data));

        adapter = new ArrayAdapter<>(
                getContext(),
                R.layout.lv_concursos_row,
                R.id.tvEns,
                items
        );

        lvConcursos.setAdapter(adapter);

        return view;
    }
}
