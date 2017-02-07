package com.example.a46990527d.ofertaajuntamentbcn;


import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


//Fragment que contindrá les convocatories marcades com a favorites
public class FavoritesFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor> {

    private SelectionCursorAdapter adapter;

    public FavoritesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_resultado, container, false);

        ListView lvConcursos = (ListView) view.findViewById(R.id.lvConcursos);
        adapter = new SelectionCursorAdapter(getContext(), Selection.class);
        lvConcursos.setAdapter(adapter);

        lvConcursos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Selection seleccio = (Selection) adapterView.getItemAtPosition(i);

                Intent intent = new Intent(getContext(), DetailsActivity.class);
                intent.putExtra("seleccio", seleccio);

                startActivity(intent);
            }
        });

        //Carreuguem els favorits
        getLoaderManager().initLoader(0, null, this);

        return view;
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return DataManager.getCursorLoader(getContext());
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        adapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        adapter.swapCursor(null);
    }

}
