package com.example.a46990527d.ofertaajuntamentbcn;

import java.util.ArrayList;

/**
 * Created by 46990527d on 13/12/16.
 */

public class Selection {

    private ArrayList<Proves> sollicitudsParticipacions = null;
    private ArrayList<Proves> convocatoriesProvesEntrevistes = null;
    private String numExpedient;
    private int nombrePlaces;
    private String fiPresentacio;
    private ArrayList<Proves> resultatsProvesEntrevistes = null;
    private String iniciPresentacio;
    private ArrayList<Proves> convocatories = null;
    private ArrayList<Proves> llistatsAdmesosExclosos = null;
    private String ens;
    private String publicacio;
    private ArrayList<Proves> resolucionsConvocatories = null;
    private String dataPublicacio;
    private String idioma;
    private String tipus;

    public Selection() {
    }

    public void setSollicitudsParticipacions(ArrayList<Proves> sollicitudsParticipacions) {
        this.sollicitudsParticipacions = sollicitudsParticipacions;
    }

    public ArrayList<Proves> getSollicitudsParticipacions() {
        return sollicitudsParticipacions;
    }

    public ArrayList<Proves> getConvocatoriesProvesEntrevistes() {
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

    public int getNombrePlaces() {
        return nombrePlaces;
    }

    public void setNombrePlaces(int nombrePlaces) {
        this.nombrePlaces = nombrePlaces;
    }

    public ArrayList<Proves> getLlistatsAdmesosExclosos() {
        return llistatsAdmesosExclosos;
    }

    public void setLlistatsAdmesosExclosos(ArrayList<Proves> llistatsAdmesosExclosos) {
        this.llistatsAdmesosExclosos = llistatsAdmesosExclosos;
    }

    public ArrayList<Proves> getConvocatories() {
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

    public ArrayList<Proves> getResultatsProvesEntrevistes() {
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

    public ArrayList<Proves> getResolucionsConvocatories() {
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
