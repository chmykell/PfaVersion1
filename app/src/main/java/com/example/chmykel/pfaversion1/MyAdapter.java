package com.example.chmykel.pfaversion1;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by chmykel on 09/03/17.
 */

public class MyAdapter extends BaseAdapter {

    ArrayList<Actualite> list;


    public MyAdapter(ActualiteActivity actualiteActivity, ArrayList<Actualite> list){

        this.list=list;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) viewGroup.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.actualite_item, viewGroup, false);
        TextView titre = (TextView) view.findViewById(R.id.name);
        TextView description = (TextView) view.findViewById(R.id.descriptionActualite);
        //TextView address = (TextView) view.findViewById(R.id.listItemAddress);
        ImageView img = (ImageView) view.findViewById(R.id.img);
        //******************Teest Image actualite with daa base********
        String imageUrl = list.get(i).getPieceJointeActualite();
        Log.i("piece jointe", imageUrl);
        final String image = "http://10.0.2.2/siteAssurance/admin-assurance/images/actualite/" + imageUrl;
       //final String image = "http://192.168.1.37:80/siteAssurance/admin-assurance/images/actualite/"+ imageUrl;
        Log.i("image", image);

        final String titreActualite = list.get(i).getTitreActualite();
        final String descriptionActualite = list.get(i).getDescriptionActualite();
        final String dateDescriptionActualite = list.get(i).getDatePublicationActualite();
        final String imageActualite = list.get(i).getPieceJointeActualite();


        //************* end test image*************
       Picasso.with(viewGroup.getContext()).load(image).into(img);
        titre.setText(list.get(i).getTitreActualite());
        description.setText(list.get(i).getDescriptionActualite());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ActualiteDetail.class);
                intent.putExtra("title", titreActualite);
                intent.putExtra("description", descriptionActualite);
                intent.putExtra("image", image);
                intent.putExtra("dateActualite", dateDescriptionActualite);
                v.getContext().startActivity(intent);
            }
        });



        return view;
    }


}
