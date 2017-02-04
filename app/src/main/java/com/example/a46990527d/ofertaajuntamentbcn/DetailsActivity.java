package com.example.a46990527d.ofertaajuntamentbcn;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import nl.littlerobots.cupboard.tools.provider.UriHelper;

import static android.R.drawable.star_big_on;
import static java.security.AccessController.getContext;
import static nl.qbusict.cupboard.CupboardFactory.cupboard;

public class DetailsActivity extends AppCompatActivity {

    Selection seleccio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        Intent i = getIntent();
        if (i != null) {
            seleccio = (Selection) i.getSerializableExtra("seleccio");
        }

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(seleccio != null) {
                    UriHelper helper = UriHelper.with(OfertaAjuntamentBcnContentProvider.AUTHORITY);
                    Uri selectionUri = helper.getUri(Selection.class);
                    cupboard().withContext(getApplicationContext()).put(selectionUri, Selection.class, seleccio);

                    Snackbar.make(view, "Convocatoria afegida a favorites", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();

                    fab.setImageResource(star_big_on);
                }
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
