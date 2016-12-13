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

    //a Partir de l'objecte JSON rebut (que conte Selections amb Totes les seleccions juntes), alimentem el nostre arraylist Selections per a interactuar mes endavant
    public static ArrayList<Selection> ConvertirEnSelection(JSONObject JsonObjectselection) throws JSONException {

        ArrayList<Selection> selections = new ArrayList<>();
        JSONArray JSONArraySelections = JsonObjectselection.getJSONArray("Seleccions");

        for (int i = 0; i < JSONArraySelections.length(); i++) {

            Selection selection = new Selection();
            JSONObject objectProves = JSONArraySelections.getJSONObject(i);


            JSONArray sollicitudsParticipacionsArray = objectProves.getJSONArray("sollicitudsParticipacions");
            ArrayList<Proves> sollicitudsParticipacions = new ArrayList<>();

            for ( int j = 0; j < sollicitudsParticipacionsArray.length(); j++) {

                Proves solicitudParticipacio = new Proves();
                JSONObject objetosolicitudParticipacio = JSONArraySelections.getJSONObject(j);

                solicitudParticipacio.setUrl(objetosolicitudParticipacio.getString("url"));
                solicitudParticipacio.setDoc(objetosolicitudParticipacio.getString("doc"));
                solicitudParticipacio.setTitle(objetosolicitudParticipacio.getString("title"));
                solicitudParticipacio.setAvis(objetosolicitudParticipacio.getBoolean("avis"));
                solicitudParticipacio.setNoPublicarTransparencia(objetosolicitudParticipacio.getBoolean("noPublicarTransparencia"));

                sollicitudsParticipacions.add(solicitudParticipacio);
            }


            JSONArray convocatoriaProvesEntrevistesArray = objectProves.getJSONArray("convocatoriesProvesEntrevistes");
            ArrayList<Proves> convocatoriesProvesEntrevistes = new ArrayList<>();

            for ( int j = 0; j < convocatoriaProvesEntrevistesArray.length(); j++) {

                Proves convocatoriaProvesEntrevistes = new Proves();

                JSONObject objectConvocatoria = JSONArraySelections.getJSONObject(j);

                convocatoriaProvesEntrevistes.setUrl(objectConvocatoria.getString("url"));
                convocatoriaProvesEntrevistes.setDoc(objectConvocatoria.getString("doc"));
                convocatoriaProvesEntrevistes.setTitle(objectConvocatoria.getString("title"));
                convocatoriaProvesEntrevistes.setAvis(objectConvocatoria.getBoolean("avis"));
                convocatoriaProvesEntrevistes.setNoPublicarTransparencia(objectConvocatoria.getBoolean("noPublicarTransparencia"));

                convocatoriesProvesEntrevistes.add(convocatoriaProvesEntrevistes);
            }

            selection.setNumExpedient(objectProves.getString("numExpedient"));
            selection.setNombrePlaces(objectProves.getInt("nombrePlaces"));
            selection.setFiPresentacio(objectProves.getString("fiPresentacio"));

            JSONArray resultatsProvesArray = objectProves.getJSONArray("resultatsProvesEntrevistes");
            ArrayList<Proves> resultats = new ArrayList<>();

            for ( int j = 0; j < resultatsProvesArray.length(); j++) {

                Proves resultat = new Proves();

                JSONObject objectResultats = JSONArraySelections.getJSONObject(j);

                resultat.setUrl(objectResultats.getString("url"));
                resultat.setDoc(objectResultats.getString("doc"));
                resultat.setTitle(objectResultats.getString("title"));
                resultat.setAvis(objectResultats.getBoolean("avis"));
                resultat.setNoPublicarTransparencia(objectResultats.getBoolean("noPublicarTransparencia"));

                resultats.add(resultat);
            }

            selection.setIniciPresentacio(objectProves.getString("iniciPresentacio"));

            JSONArray resultatsConvocatoriesArray = objectProves.getJSONArray("convocatories");
            ArrayList<Proves> resultatsConvocatories = new ArrayList<>();

            for ( int j = 0; j < resultatsConvocatoriesArray.length(); j++) {

                Proves resultatConvocatoria = new Proves();

                JSONObject objectConvocatories = JSONArraySelections.getJSONObject(j);

                resultatConvocatoria.setUrl(objectConvocatories.getString("url"));
                resultatConvocatoria.setDoc(objectConvocatories.getString("doc"));
                resultatConvocatoria.setTitle(objectConvocatories.getString("title"));
                resultatConvocatoria.setAvis(objectConvocatories.getBoolean("avis"));
                resultatConvocatoria.setNoPublicarTransparencia(objectConvocatories.getBoolean("noPublicarTransparencia"));

                resultatsConvocatories.add(resultatConvocatoria);
            }

            JSONArray llistatsAdmesosExclososArray = objectProves.getJSONArray("convocatories");
            ArrayList<Proves> llistatsAdmesosExclosos = new ArrayList<>();

            for ( int j = 0; j < llistatsAdmesosExclososArray.length(); j++) {

                Proves llistaAdmesosExclosos = new Proves();

                JSONObject objectAdmesosExclosos = JSONArraySelections.getJSONObject(j);

                llistaAdmesosExclosos.setUrl(objectAdmesosExclosos.getString("url"));
                llistaAdmesosExclosos.setDoc(objectAdmesosExclosos.getString("doc"));
                llistaAdmesosExclosos.setTitle(objectAdmesosExclosos.getString("title"));
                llistaAdmesosExclosos.setAvis(objectAdmesosExclosos.getBoolean("avis"));
                llistaAdmesosExclosos.setNoPublicarTransparencia(objectAdmesosExclosos.getBoolean("noPublicarTransparencia"));

                llistatsAdmesosExclosos.add(llistaAdmesosExclosos);
            }

            selection.setEns(objectProves.getString("ens"));
            selection.setPublicacio(objectProves.getString("publicacio"));

            JSONArray resolucionsConvocatoriesArray = objectProves.getJSONArray("resolucionsConvocatories");
            ArrayList <Proves> resolucionsConvocatories = new ArrayList<>();

            for ( int j = 0; j < resolucionsConvocatoriesArray.length(); j++) {

                Proves resolucioConvocatoria = new Proves();

                JSONObject objectresolucionsConvocatoriesArray = JSONArraySelections.getJSONObject(j);

                resolucioConvocatoria.setUrl(objectresolucionsConvocatoriesArray.getString("url"));
                resolucioConvocatoria.setDoc(objectresolucionsConvocatoriesArray.getString("doc"));
                resolucioConvocatoria.setTitle(objectresolucionsConvocatoriesArray.getString("title"));
                resolucioConvocatoria.setAvis(objectresolucionsConvocatoriesArray.getBoolean("avis"));
                resolucioConvocatoria.setNoPublicarTransparencia(objectresolucionsConvocatoriesArray.getBoolean("noPublicarTransparencia"));

                resolucionsConvocatories.add(resolucioConvocatoria);
            }

            selection.setDataPublicacio(objectProves.getString("dataPublicacio"));
            selection.setIdioma(objectProves.getString("idioma"));
            selection.setTipus(objectProves.getString("tipus"));

            selections.add(selection);
        }

        return selections;
    }


    public static ArrayList<Selection> getSelections() {


        Uri builtUri = Uri.parse(BASE_URL_CA);

        return CridaApi(builtUri);


    }
}
