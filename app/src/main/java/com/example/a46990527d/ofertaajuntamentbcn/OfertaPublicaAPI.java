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
            ArrayList<Proves> sollicitudsParticipacions = new ArrayList<>();

            for ( int j = 0; j < sollicitudsParticipacionsArray.length(); j++) {

                Proves solicitudParticipacio = new Proves();
                JSONObject objetosolicitudParticipacio = JSONArraySelections.getJSONObject(j);

                if (solicitudParticipacio.getUrl()==null){
                    solicitudParticipacio.setUrl("");
                }else{
                    solicitudParticipacio.setUrl(objetosolicitudParticipacio.getString("url"));
                }
                if (solicitudParticipacio.getDoc()==null){
                    solicitudParticipacio.setDoc("");
                }else{
                    solicitudParticipacio.setDoc(objetosolicitudParticipacio.getString("doc"));
                }

                if (solicitudParticipacio.getTitle()==null){
                    solicitudParticipacio.setTitle("Sense títol");
                }else{
                    solicitudParticipacio.setTitle(objetosolicitudParticipacio.getString("title"));
                }



                sollicitudsParticipacions.add(solicitudParticipacio);
            }


            JSONArray convocatoriaProvesEntrevistesArray = objectProves.getJSONArray("convocatoriesProvesEntrevistes");
            ArrayList<Proves> convocatoriesProvesEntrevistes = new ArrayList<>();

            for ( int j = 0; j < convocatoriaProvesEntrevistesArray.length(); j++) {

                Proves convocatoriaProvesEntrevistes = new Proves();

                JSONObject objectConvocatoria = JSONArraySelections.getJSONObject(j);

                if (convocatoriaProvesEntrevistes.getUrl()==null){
                    convocatoriaProvesEntrevistes.setUrl("");
                }else{
                    convocatoriaProvesEntrevistes.setUrl(objectConvocatoria.getString("url"));
                }
                if (convocatoriaProvesEntrevistes.getDoc()==null){
                    convocatoriaProvesEntrevistes.setDoc("");
                }else{
                    convocatoriaProvesEntrevistes.setDoc(objectConvocatoria.getString("doc"));
                }

                if (convocatoriaProvesEntrevistes.getTitle()==null){
                    convocatoriaProvesEntrevistes.setTitle("Sense títol");
                }else{
                    convocatoriaProvesEntrevistes.setTitle(objectConvocatoria.getString("title"));
                }



                convocatoriesProvesEntrevistes.add(convocatoriaProvesEntrevistes);
            }

            selection.setNumExpedient(objectProves.getString("numExpedient"));
            selection.setNombrePlaces(objectProves.getString("nombrePlaces"));
            selection.setFiPresentacio(objectProves.getString("fiPresentacio"));

            JSONArray resultatsProvesArray = objectProves.getJSONArray("resultatsProvesEntrevistes");
            ArrayList<Proves> resultats = new ArrayList<>();

            for ( int j = 0; j < resultatsProvesArray.length(); j++) {

                Proves resultat = new Proves();

                JSONObject objectResultats = JSONArraySelections.getJSONObject(j);

                if (resultat.getUrl()==null){
                    resultat.setUrl("");
                }else{
                    resultat.setUrl(objectResultats.getString("url"));
                }
                if (resultat.getDoc()==null){
                    resultat.setDoc("");
                }else{
                    resultat.setDoc(objectResultats.getString("doc"));
                }

                if (resultat.getTitle()==null){
                    resultat.setTitle("Sense títol");
                }else{
                    resultat.setTitle(objectResultats.getString("title"));
                }




                resultats.add(resultat);
            }

            selection.setIniciPresentacio(objectProves.getString("iniciPresentacio"));

            JSONArray resultatsConvocatoriesArray = objectProves.getJSONArray("convocatories");
            ArrayList<Proves> resultatsConvocatories = new ArrayList<>();

            for ( int j = 0; j < resultatsConvocatoriesArray.length(); j++) {

                Proves resultatConvocatoria = new Proves();

                JSONObject objectConvocatories = JSONArraySelections.getJSONObject(j);

                if (resultatConvocatoria.getUrl()==null){
                    resultatConvocatoria.setUrl("");
                }else{
                    resultatConvocatoria.setUrl(objectConvocatories.getString("url"));
                }
                if (resultatConvocatoria.getDoc()==null){
                    resultatConvocatoria.setDoc("");
                }else{
                    resultatConvocatoria.setDoc(objectConvocatories.getString("doc"));
                }

                if (resultatConvocatoria.getTitle()==null){
                    resultatConvocatoria.setTitle("Sense títol");
                }else{
                    resultatConvocatoria.setTitle(objectConvocatories.getString("title"));
                }




                resultatsConvocatories.add(resultatConvocatoria);
            }

            JSONArray llistatsAdmesosExclososArray = objectProves.getJSONArray("convocatories");
            ArrayList<Proves> llistatsAdmesosExclosos = new ArrayList<>();

            for ( int j = 0; j < llistatsAdmesosExclososArray.length(); j++) {

                Proves llistaAdmesosExclosos = new Proves();

                JSONObject objectAdmesosExclosos = JSONArraySelections.getJSONObject(j);

                if (llistaAdmesosExclosos.getUrl()==null){
                    llistaAdmesosExclosos.setUrl("");
                }else{
                    llistaAdmesosExclosos.setUrl(objectAdmesosExclosos.getString("url"));
                }
                if (llistaAdmesosExclosos.getDoc()==null){
                    llistaAdmesosExclosos.setDoc("");
                }else{
                    llistaAdmesosExclosos.setDoc(objectAdmesosExclosos.getString("doc"));
                }

                if (llistaAdmesosExclosos.getTitle()==null){
                    llistaAdmesosExclosos.setTitle("Sense títol");
                }else{
                    llistaAdmesosExclosos.setTitle(objectAdmesosExclosos.getString("title"));
                }




                llistatsAdmesosExclosos.add(llistaAdmesosExclosos);
            }

            selection.setEns(objectProves.getString("ens"));
            selection.setPublicacio(objectProves.getString("publicacio"));

            JSONArray resolucionsConvocatoriesArray = objectProves.getJSONArray("resolucionsConvocatories");
            ArrayList <Proves> resolucionsConvocatories = new ArrayList<>();

            for ( int j = 0; j < resolucionsConvocatoriesArray.length(); j++) {

                Proves resolucioConvocatoria = new Proves();

                JSONObject objectresolucionsConvocatoriesArray = JSONArraySelections.getJSONObject(j);

                if (resolucioConvocatoria.getUrl()==null){
                    resolucioConvocatoria.setUrl("");
                }else{
                    resolucioConvocatoria.setUrl(objectresolucionsConvocatoriesArray.getString("url"));
                }
                if (resolucioConvocatoria.getDoc()==null){
                    resolucioConvocatoria.setDoc("");
                }else{
                    resolucioConvocatoria.setDoc(objectresolucionsConvocatoriesArray.getString("doc"));
                }

                if (resolucioConvocatoria.getTitle()==null){
                    resolucioConvocatoria.setTitle("Sense títol");
                }else{
                    resolucioConvocatoria.setTitle(objectresolucionsConvocatoriesArray.getString("title"));
                }




                resolucionsConvocatories.add(resolucioConvocatoria);
            }

            selection.setDataPublicacio(objectProves.getString("dataPublicacio"));
            selection.setIdioma(objectProves.getString("idioma"));
            selection.setTipus(objectProves.getString("tipus"));

            selections.add(selection);
        }

        return selections;
    }




}
