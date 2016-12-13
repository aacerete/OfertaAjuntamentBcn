package com.example.a46990527d.ofertaajuntamentbcn;

import android.net.Uri;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by 46990527d on 13/12/16.
 */

public class OfertaPublicaAPI {

    private static final String BASE_URL_CA = "https://apidata.barcelona.cat/opendata/oferta-publica/ca";
    private static final String BASE_URL_ES = "https://apidata.barcelona.cat/opendata/oferta-publica/es";

    public static ArrayList <Selection> CridaApi  ( Uri builtUri ){

        try {
            String url = builtUri.toString();
            Log.d("URL", url);
            String JsonResponse = HttpUtils.get(url);
            //creem un objecte Json a partir de l'string de resposta amb el metode
            JSONObject JSONCards = TratarStringRespuesta(JsonResponse);

            return ConvertirEnSelection(JSONCards);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException j) {
            j.printStackTrace();
        }
        return null;
    }

    // A partir de l'String , el convertim a un objecte JSON per poder tractar-lo
    public static JSONObject TratarStringRespuesta(String respuesta) throws JSONException {

        JSONObject obj = new JSONObject(respuesta);

        return obj;
    }

    //a Partir de l'objecte JSON rebut (que conte Cards amb Totes les cartes juntes), alimentem el nostre arraylist Card per a interactuar mes endavant
    public static ArrayList<Selection> ConvertirEnSelection(JSONObject selections) throws JSONException {

        ArrayList<Selection> cards = new ArrayList<>();
        JSONArray JSONCards = selections.getJSONArray("selection");

        for (int i = 0; i < JSONCards.length(); i++) {

            JSONObject objeto = JSONCards.getJSONObject(i);

            Selection selection = new Selection();
            selection.setName(objeto.getString("name"));
            selection.setType(objeto.getString("type"));
            selection.setRarity(objeto.getString("rarity"));
            if (objeto.has("text")){
                selection.setText(objeto.getString("text"));
            }

            if (objeto.has("colors")) {
                selection.setColors(objeto.getString("colors"));
            } else {
                selection.setColors(null);
            }

            if (objeto.has("imageUrl")){
                selection.setImageUrl(objeto.getString("imageUrl"));
            }else{
                selection.setImageUrl(null);
            }

            cards.add(selection);
        }

        return cards;
    }


    public static ArrayList<Selection> getSelections() {


        Uri builtUri = Uri.parse(BASE_URL_ES);

        return builtUri;


    }
}
