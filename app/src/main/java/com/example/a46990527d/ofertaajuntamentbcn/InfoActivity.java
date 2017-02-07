package com.example.a46990527d.ofertaajuntamentbcn;

import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;


//Activity amb informació sobre la app
public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
