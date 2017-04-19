package com.example.chmykel.pfaversion1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ActualiteDetail extends AppCompatActivity {

    private TextView tv_titreAct , tv_dateAct, tv_descriptionAct;
    private ImageView imageActDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualite_detail);

        tv_titreAct = (TextView) findViewById(R.id.tv_titreAct);
        tv_dateAct = (TextView) findViewById(R.id.tv_dateAct);
        tv_descriptionAct = (TextView) findViewById(R.id.tv_descriptionAct);
        imageActDetail = (ImageView) findViewById(R.id.imageActDetail);


        Bundle extras = getIntent().getExtras();
        String titreActualite = extras.getString("title");
        String descActualite = extras.getString("description");
        String dateAct = extras.getString("dateActualite");
        String imgAct = extras.getString("image");

        tv_titreAct.setText(titreActualite);
        tv_descriptionAct.setText(descActualite);
        tv_dateAct.setText(dateAct);
        Picasso.with(this).load(imgAct).into(imageActDetail);


    }
}
