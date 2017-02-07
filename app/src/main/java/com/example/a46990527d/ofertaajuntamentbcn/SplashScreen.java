package com.example.a46990527d.ofertaajuntamentbcn;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Usuario on 01/02/2017.
 */

//Activity que es mostrara al carregar la app
public class SplashScreen extends Activity {

        // setejem la duració de la pantalla de inici
        private static final long SPLASH_SCREEN_DELAY = 3000;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            // Setejem orientació
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            // Amaguem la barra de titol
            requestWindowFeature(Window.FEATURE_NO_TITLE);

            //mostrem el layout definit a splash.xml
            setContentView(R.layout.splash);

            TimerTask task = new TimerTask() {
                @Override
                public void run() {

                    // Iniciem la activity
                    Intent mainIntent = new Intent().setClass(
                            SplashScreen.this, MainActivity.class);
                    startActivity(mainIntent);


                    //la tanquem per a que l'usuari no pugui tornar enrere

                    finish();
                }
            };

            // Simulem un proces de carrega de la app al començar.
            Timer timer = new Timer();
            timer.schedule(task, SPLASH_SCREEN_DELAY);
        }

    }
