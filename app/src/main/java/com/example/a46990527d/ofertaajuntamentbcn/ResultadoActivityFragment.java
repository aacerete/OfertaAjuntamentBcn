package com.example.a46990527d.ofertaajuntamentbcn;

import android.support.annotation.Nullable;
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

    private ArrayList<Selection> seleccio = new ArrayList<>();
    private SeleccioAdapter adapter;



    public ResultadoActivityFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            Bundle extras = getActivity().getIntent().getExtras();
            if(extras == null) {
                seleccio = new ArrayList<>();
            } else {
                ArrayList<Selection> res = (ArrayList<Selection>) extras.getSerializable("resultados");
                if(res != null) {
                    seleccio.addAll((ArrayList<Selection>) extras.getSerializable("resultados"));
                }
            }
        } else {
            seleccio.addAll((ArrayList<Selection>) savedInstanceState.getSerializable("resultados"));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_resultado, container, false);

        ListView lvConcursos = (ListView) view.findViewById(R.id.lvConcursos);

        adapter = new SeleccioAdapter(getContext(), seleccio);

        lvConcursos.setAdapter(adapter);

        return view;
    }
}
