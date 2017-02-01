package com.example.a46990527d.ofertaajuntamentbcn;

import nl.littlerobots.cupboard.tools.provider.CupboardContentProvider;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

/**
 * Created by 46990527d on 01/02/17.
 */

public class OfertaAjuntamentBcnContentProvider extends CupboardContentProvider {

        public static final String AUTHORITY = BuildConfig.APPLICATION_ID + ".provider";

        static {
            cupboard().register(Selection.class);
        }

        public OfertaAjuntamentBcnContentProvider(){
            super(AUTHORITY,1);
        }

}
