package com.example.a46990527d.ofertaajuntamentbcn;

import android.app.Application;

import java.util.ArrayList;

/**
 * Created by Usuario on 29/01/2017.
 */

public class OfertaAjuntamentBcn extends Application {

    // Singleton instance
    private static OfertaAjuntamentBcn sInstance = null;
    ArrayList<Selection> resultados = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
        // Setup singleton instance
        sInstance = this;
    }

    // Getter to access Singleton instance
    public static OfertaAjuntamentBcn getInstance() {
        return sInstance ;
    }
}