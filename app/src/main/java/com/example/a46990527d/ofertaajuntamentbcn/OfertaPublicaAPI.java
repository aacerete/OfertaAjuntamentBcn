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


    public static ArrayList<Selection> getSelections() {


        Uri builtUri = Uri.parse(BASE_URL_CA);

        return CridaApi(builtUri);

    }

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

    //a Partir de l'objecte JSON rebut (que conte Selections amb Totes les seleccions juntes), alimentem el nostre arraylist Selections per a interactuar mes endavant
    public static ArrayList<Selection> ConvertirEnSelection(JSONObject JsonObjectselection) throws JSONException {

        ArrayList<Selection> selections = new ArrayList<>();

        JSONArray JSONArraySelections = JsonObjectselection.getJSONArray("Seleccions");

        for (int i = 0; i < JSONArraySelections.length(); i++) {

            Selection selection = new Selection();
            JSONObject objectProves = JSONArraySelections.getJSONObject(i);


            JSONArray sollicitudsParticipacionsArray = objectProves.getJSONArray("sollicitudsParticipacions");
            ArrayList<Proves> sollicitudsParticipacions = procesaProves(sollicitudsParticipacionsArray);
            selection.setSollicitudsParticipacions(sollicitudsParticipacions);

            JSONArray convocatoriaProvesEntrevistesArray = objectProves.getJSONArray("convocatoriesProvesEntrevistes");
            ArrayList<Proves> convocatoriesProvesEntrevistes = procesaProves(convocatoriaProvesEntrevistesArray);
            selection.setConvocatoriesProvesEntrevistes(convocatoriesProvesEntrevistes);

            selection.setNumExpedient(objectProves.getString("numExpedient"));
            selection.setNombrePlaces(objectProves.getString("nombrePlaces"));
            selection.setFiPresentacio(objectProves.getString("fiPresentacio"));

            JSONArray resultatsProvesArray = objectProves.getJSONArray("resultatsProvesEntrevistes");
            ArrayList<Proves> resultats = procesaProves(resultatsProvesArray);
            selection.setResultatsProvesEntrevistes(resultats);

            selection.setIniciPresentacio(objectProves.getString("iniciPresentacio"));

            JSONArray resultatsConvocatoriesArray = objectProves.getJSONArray("convocatories");
            ArrayList<Proves> resultatsConvocatories = procesaProves(resultatsConvocatoriesArray);
            selection.setConvocatories(resultatsConvocatories);

            JSONArray llistatsAdmesosExclososArray = objectProves.getJSONArray("convocatories");
            ArrayList<Proves> llistatsAdmesosExclosos = procesaProves(llistatsAdmesosExclososArray);
            selection.setLlistatsAdmesosExclosos(llistatsAdmesosExclosos);

            selection.setEns(objectProves.getString("ens"));
            selection.setPublicacio(objectProves.getString("publicacio"));

            JSONArray resolucionsConvocatoriesArray = objectProves.getJSONArray("resolucionsConvocatories");
            ArrayList <Proves> resolucionsConvocatories = procesaProves(resolucionsConvocatoriesArray);
            selection.setResolucionsConvocatories(resolucionsConvocatories);

            selection.setDataPublicacio(objectProves.getString("dataPublicacio"));
            selection.setIdioma(objectProves.getString("idioma"));
            selection.setTipus(objectProves.getString("tipus"));

            selections.add(selection);
        }

        return selections;
    }



    public static ArrayList<Proves> procesaProves(JSONArray jsonarr) throws JSONException{
        ArrayList<Proves> sol = new ArrayList<>();

        for ( int j = 0; j < jsonarr.length(); j++) {

            Proves solicitudParticipacio = new Proves();
            JSONObject objeto = jsonarr.getJSONObject(j);
            if(objeto.has("url")) {
                solicitudParticipacio.setUrl(objeto.getString("url"));
            }

            if(objeto.has("doc")) {
                solicitudParticipacio.setDoc(objeto.getString("doc"));
            }

            if(objeto.has("title")) {
                solicitudParticipacio.setTitle(objeto.getString("title"));
            }


            sol.add(solicitudParticipacio);
        }
        return sol;
    }


}
