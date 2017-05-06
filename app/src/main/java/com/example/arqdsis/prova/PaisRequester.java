package com.example.arqdsis.prova;
/**
 * Created by arqdsis on 24/03/2017.
 * @author Rafael Morcelli 201507944
 */
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by arqdsis on 31/03/2017.
 */
public class PaisRequester {

    OkHttpClient client = new OkHttpClient();

    public ArrayList<Pais> get(String url, String chave) throws IOException {
        ArrayList<Pais> lista = new ArrayList<>();

        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute(); //error aqui
        String jsonString = response.body().string();
        try {
            JSONArray root = new JSONArray(jsonString);
            JSONObject item = null;
            for (int i = 0; i < root.length(); i++) {
                item = (JSONObject) root.get(i);
                int id = item.getInt("id");
                String pais = item.getString("pais");
                String capital = item.getString("capital");
                String area = item.getString("area");
                String populacao = item.getString("populacao");
                String moeda = item.getString("moeda");
                Pais pais = new Pais(id,capital,area ,populacao, moeda);
                lista.add(pais);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public Bitmap getImage(String url) throws IOException {
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();

        InputStream is = response.body().byteStream();
        Bitmap img = BitmapFactory.decodeStream(is);
        is.close();

        return img;
    }

    public boolean isConnected(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();

    }
}
