package com.example.a46990527d.ofertaajuntamentbcn;

import java.io.Serializable;

/**
 * Created by 46990527d on 13/12/16.
 */

public class Proves implements Serializable {

    String url;
    String doc;
    String title;


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



    @Override
    public String toString() {
        return "Proves{" +
                "url='" + url + '\'' +
                ", doc='" + doc + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
