package com.example.a46990527d.ofertaajuntamentbcn;

import android.content.Context;
import android.net.Uri;
import android.support.v4.content.CursorLoader;

import java.util.ArrayList;

import nl.littlerobots.cupboard.tools.provider.UriHelper;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

/**
 * Created by 46990527d on 01/02/17.
 */

//Classe per a tractar la informació del cupboard
public class DataManager {
    private static UriHelper URI_HELPER = UriHelper.with(OfertaAjuntamentBcnContentProvider.AUTHORITY);
    private static Uri SELECTION_URI = URI_HELPER.getUri(Selection.class);

    static void saveSelections(ArrayList<Selection> convocatorias, Context context) {
        cupboard().withContext(context).put(SELECTION_URI, Selection.class, convocatorias);
    }

    static void saveSelection(Selection convocatoria, Context context) {
        cupboard().withContext(context).put(SELECTION_URI, Selection.class, convocatoria);
    }

    static void deleteSelection(Context context, int id) {
        cupboard().withContext(context).delete(SELECTION_URI, "_id =", String.valueOf(id));
    }

    static CursorLoader getCursorLoader(Context context) {
        return new CursorLoader(context, SELECTION_URI, null, null, null, null);
    }

}