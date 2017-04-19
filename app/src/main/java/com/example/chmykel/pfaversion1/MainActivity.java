package com.example.chmykel.pfaversion1;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton btnActualite;
    private ImageButton btnAppel, btn_reclamation, btn_abonnements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnActualite = (ImageButton) findViewById(R.id.btnActualite);
        btnAppel = (ImageButton) findViewById(R.id.btnAppel);
        btn_reclamation = (ImageButton) findViewById(R.id.btnReclamation);
        btn_abonnements = (ImageButton) findViewById(R.id.btnCompte);
        btn_reclamation.setOnClickListener(this);
        btnAppel.setOnClickListener(this);
        btnActualite.setOnClickListener(this);
        btn_abonnements.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnActualite: {
                Intent intent = new Intent(MainActivity.this, ActualiteActivity.class);
                startActivity(intent);
            }
            break;
            case R.id.btnAppel: {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:71364100"));
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(callIntent);


            }
            break;
            case R.id.btnReclamation: {
                Intent intent = new Intent(MainActivity.this, ReclamationActivity.class);
                startActivity(intent);
            }
            break;
            case R.id.btnCompte: {
                Intent intent = new Intent(MainActivity.this, AbonnementActivity.class);
                startActivity(intent);

            }
            break;


            default:
                break;

        }

    }
}
