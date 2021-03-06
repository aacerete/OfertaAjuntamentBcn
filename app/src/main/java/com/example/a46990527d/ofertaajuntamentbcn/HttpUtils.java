package com.example.a46990527d.ofertaajuntamentbcn;

/**
 * Created by 46990527d on 13/12/16.
 */

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static android.util.Xml.Encoding.ISO_8859_1;


//Classe hhtpUtils per a realitzar la conexio
public class HttpUtils {
    public static String get(String dataUrl) throws IOException {

        URL url = new URL(dataUrl);
        String response = null;
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            response = readStream(in);
        } finally {
            urlConnection.disconnect();
        }
        return response;
    }

    private static String readStream(InputStream in) throws IOException {
        InputStreamReader is = new InputStreamReader(in, String.valueOf(ISO_8859_1));
        BufferedReader rd = new BufferedReader(is);
        String line;
        StringBuilder response = new StringBuilder();
        while ((line = rd.readLine()) != null) {
            response.append(line);
            response.append('\r');
        }
        rd.close();
        return response.toString();
    }
}
