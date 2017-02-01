package com.example.a46990527d.ofertaajuntamentbcn;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 46990527d on 13/12/16.
 */

public class Selection implements Serializable {

    private List<Proves> sollicitudsParticipacions = null;
    private List<Proves> convocatoriesProvesEntrevistes = null;
    private String numExpedient;
    private String nombrePlaces;
    private String fiPresentacio;
    private List<Proves> resultatsProvesEntrevistes = null;
    private String iniciPresentacio;
    private List<Proves> convocatories = null;
    private List<Proves> llistatsAdmesosExclosos = null;
    private String ens;
    private String publicacio;
    private List<Proves> resolucionsConvocatories = null;
    private String dataPublicacio;
    private String idioma;
    private String tipus;

    public Selection() {
    }

    public void setSollicitudsParticipacions(List<Proves> sollicitudsParticipacions) {
        this.sollicitudsParticipacions = sollicitudsParticipacions;
    }

    public List<Proves> getSollicitudsParticipacions() {
        return sollicitudsParticipacions;
    }

    public List<Proves> getConvocatoriesProvesEntrevistes() {
        return convocatoriesProvesEntrevistes;
    }

    public void setConvocatoriesProvesEntrevistes(ArrayList<Proves> convocatoriesProvesEntrevistes) {
        this.convocatoriesProvesEntrevistes = convocatoriesProvesEntrevistes;
    }

    public String getNumExpedient() {
        return numExpedient;
    }

    public void setNumExpedient(String numExpedient) {
        this.numExpedient = numExpedient;
    }

    public String getNombrePlaces() {
        return nombrePlaces;
    }

    public void setNombrePlaces(String nombrePlaces) {
        this.nombrePlaces = nombrePlaces;
    }

    public List<Proves> getLlistatsAdmesosExclosos() {
        return llistatsAdmesosExclosos;
    }

    public void setLlistatsAdmesosExclosos(ArrayList<Proves> llistatsAdmesosExclosos) {
        this.llistatsAdmesosExclosos = llistatsAdmesosExclosos;
    }

    public List<Proves> getConvocatories() {
        return convocatories;
    }

    public void setConvocatories(ArrayList<Proves> convocatories) {
        this.convocatories = convocatories;
    }

    public String getIniciPresentacio() {
        return iniciPresentacio;
    }

    public void setIniciPresentacio(String iniciPresentacio) {
        this.iniciPresentacio = iniciPresentacio;
    }

    public List<Proves> getResultatsProvesEntrevistes() {
        return resultatsProvesEntrevistes;
    }

    public void setResultatsProvesEntrevistes(ArrayList<Proves> resultatsProvesEntrevistes) {
        this.resultatsProvesEntrevistes = resultatsProvesEntrevistes;
    }

    public String getFiPresentacio() {
        return fiPresentacio;
    }

    public void setFiPresentacio(String fiPresentacio) {
        this.fiPresentacio = fiPresentacio;
    }

    public String getEns() {
        return ens;
    }

    public void setEns(String ens) {
        this.ens = ens;
    }

    public String getPublicacio() {
        return publicacio;
    }

    public void setPublicacio(String publicacio) {
        this.publicacio = publicacio;
    }

    public String getDataPublicacio() {
        return dataPublicacio;
    }

    public void setDataPublicacio(String dataPublicacio) {
        this.dataPublicacio = dataPublicacio;
    }

    public List<Proves> getResolucionsConvocatories() {
        return resolucionsConvocatories;
    }

    public void setResolucionsConvocatories(ArrayList<Proves> resolucionsConvocatories) {
        this.resolucionsConvocatories = resolucionsConvocatories;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public boolean isPresentable(){

        Date today = new Date();
        String date = this.getFiPresentacio();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date fin = null;
        try {
            fin = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (today.after(fin)){
            return false;
        }else{
            return true;
        }
           }

    @Override
    public String toString() {
        return "Selection{" +
                "sollicitudsParticipacions=" + sollicitudsParticipacions +
                ", convocatoriesProvesEntrevistes=" + convocatoriesProvesEntrevistes +
                ", numExpedient='" + numExpedient + '\'' +
                ", nombrePlaces=" + nombrePlaces +
                ", fiPresentacio='" + fiPresentacio + '\'' +
                ", resultatsProvesEntrevistes=" + resultatsProvesEntrevistes +
                ", iniciPresentacio='" + iniciPresentacio + '\'' +
                ", convocatories=" + convocatories +
                ", llistatsAdmesosExclosos=" + llistatsAdmesosExclosos +
                ", ens='" + ens + '\'' +
                ", publicacio='" + publicacio + '\'' +
                ", resolucionsConvocatories=" + resolucionsConvocatories +
                ", dataPublicacio='" + dataPublicacio + '\'' +
                ", idioma='" + idioma + '\'' +
                ", tipus='" + tipus + '\'' +
                '}';
    }
}
