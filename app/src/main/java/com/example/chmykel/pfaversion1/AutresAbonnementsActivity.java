package com.example.chmykel.pfaversion1;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class AutresAbonnementsActivity extends AppCompatActivity {

    private ArrayList<Categorie> categories;
    Spinner spinner_categ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autres_abonnements);
        spinner_categ = (Spinner) findViewById(R.id.spinner_categ);

        categories = new ArrayList<Categorie>();
        final Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                Spinner mySpinner = (Spinner)findViewById(R.id.spinner_categ);
               // mySpinner.setAdapter(new ArrayAdapter<Categorie>(this, android.R.layout.simple_spinner_item, categories));



            }
        };

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    parseData();
                    handler.sendEmptyMessage(0);
                    //handler.sendEmptyMessage(0);
                } catch (Throwable t) {
                    Log.i("Annimation", "Thread exception", t);

                }

            }
        });
        thread.start();
        Spinner mySpinner = (Spinner)findViewById(R.id.spinner_categ);
        mySpinner.setAdapter(new ArrayAdapter<Categorie>(this, android.R.layout.simple_spinner_item, categories));

    }

    private void parseData() {

        try {
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpResponse response = httpClient.execute(new HttpGet(Config.DATA_URL_categories));
            HttpEntity httpEntity = response.getEntity();
            String inputStream = EntityUtils.toString(httpEntity);
            Log.i("result", inputStream);
            JSONObject categorieObject = new JSONObject(inputStream);
            JSONArray categorieArray = categorieObject.getJSONArray("results");
            for (int i = 0; i < categorieArray.length(); i++) {
                JSONObject restObject = categorieArray.getJSONObject(i);
                Categorie categorie = new Categorie();
                categorie.setNomCategorie(restObject.getString("nom"));
                categorie.setDescriptionCategorie(restObject.getString("descriptionCategorie"));
                categorie.setEtat_categorie(restObject.getInt("etat_categorie"));
                categorie.setIdcategorie(restObject.getInt("idCategorie"));
                categorie.setImgCateg(restObject.getString("imgCateg"));


                categories.add(categorie);

            }
            Log.i("res", "" + categories.size());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}

