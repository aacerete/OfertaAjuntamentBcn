package com.example.a46990527d.ofertaajuntamentbcn;

import com.google.gson.Gson;

import nl.littlerobots.cupboard.tools.gson.GsonListFieldConverterFactory;
import nl.littlerobots.cupboard.tools.provider.CupboardContentProvider;
import nl.qbusict.cupboard.CupboardBuilder;
import nl.qbusict.cupboard.CupboardFactory;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

/**
 * Created by 46990527d on 01/02/17.
 */

public class OfertaAjuntamentBcnContentProvider extends CupboardContentProvider {

        public static final String AUTHORITY = BuildConfig.APPLICATION_ID + ".provider";

        static {
            CupboardFactory.setCupboard(new CupboardBuilder().
                    registerFieldConverterFactory(new GsonListFieldConverterFactory(new Gson())).build());
            cupboard().register(Selection.class);
            cupboard().register(Proves.class);
        }

        public OfertaAjuntamentBcnContentProvider(){
            super(AUTHORITY,1);
        }

}
