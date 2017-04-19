package com.example.chmykel.pfaversion1;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

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
public class ActualiteActivity extends AppCompatActivity {


         ListView listString;
     String url_all_actualite = "http://10.0.2.2/siteAssurance/admin-assurance/android_connect/get_all_actualite.php";
      // public static String url_all_actualite = "http://192.168.1.37:80/siteAssurance/admin-assurance/android_connect/get_all_actualite.php";

    private ArrayList<Actualite> actualites;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualite);
        listString = (ListView) findViewById(R.id.listAct);
        actualites = new ArrayList<Actualite>();
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);
        final Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                MyAdapter adapter = new MyAdapter(ActualiteActivity.this, actualites);
                listString.setAdapter(adapter);
               progressBar.setVisibility(View.GONE);



            }
        };

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    parseData();
                    handler.sendEmptyMessage(0);
                } catch (Throwable t) {
                    Log.i("Annimation", "Thread exception", t);

                }

            }
        });
        thread.start();


    }

    private void parseData() {

        try {
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpResponse response = httpClient.execute(new HttpGet(url_all_actualite));
            HttpEntity httpEntity = response.getEntity();
            String inputStream = EntityUtils.toString(httpEntity);
            Log.i("result", inputStream);
            JSONObject actualiteObject = new JSONObject(inputStream);
            JSONArray restaurantArray = actualiteObject.getJSONArray("results");
            for (int i = 0; i < restaurantArray.length(); i++) {
                JSONObject restObject = restaurantArray.getJSONObject(i);
                Actualite actualite = new Actualite();
                actualite.setTitreActualite(restObject.getString("titreActualite"));
                actualite.setDescriptionActualite(restObject.getString("descriptionActualite"));
                actualite.setDatePublicationActualite(restObject.getString("datePublicationActualite"));
                actualite.setPieceJointeActualite(restObject.getString("pieceJointeActualite"));
                actualite.setActualiteActive(restObject.getString("actualiteActive"));

                actualites.add(actualite);

            }
            Log.i("res", "" + actualites.size());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
