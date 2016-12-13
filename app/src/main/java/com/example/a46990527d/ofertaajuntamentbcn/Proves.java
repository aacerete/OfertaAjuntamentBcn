package com.example.a46990527d.ofertaajuntamentbcn;

/**
 * Created by 46990527d on 13/12/16.
 */

public class Proves {

    String url;
    String doc;
    String title;
    boolean avis;
    boolean noPublicarTransparencia;

    public Proves() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isAvis() {
        return avis;
    }

    public void setAvis(boolean avis) {
        this.avis = avis;
    }

    public boolean isNoPublicarTransparencia() {
        return noPublicarTransparencia;
    }

    public void setNoPublicarTransparencia(boolean noPublicarTransparencia) {
        this.noPublicarTransparencia = noPublicarTransparencia;
    }

    @Override
    public String toString() {
        return "Proves{" +
                "url='" + url + '\'' +
                ", doc='" + doc + '\'' +
                ", title='" + title + '\'' +
                ", avis=" + avis +
                ", noPublicarTransparencia=" + noPublicarTransparencia +
                '}';
    }
}
