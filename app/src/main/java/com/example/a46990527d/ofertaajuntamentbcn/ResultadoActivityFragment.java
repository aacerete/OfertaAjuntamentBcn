package com.example.a46990527d.ofertaajuntamentbcn;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * A placeholder fragment containing a simple view.
 */
public class ResultadoActivityFragment extends Fragment {

    public ResultadoActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);

        ListView lvConcursos = (ListView) view.findViewById(R.id.lvConcursos);

        return view;
    }
}
