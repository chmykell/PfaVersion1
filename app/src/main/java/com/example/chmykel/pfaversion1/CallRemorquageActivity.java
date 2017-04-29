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

public class CallRemorquageActivity extends AppCompatActivity implements View.OnClickListener{
    Button btn_call , btn_retour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_remorquage);
        btn_call = (Button) findViewById(R.id.btn_callNow);
        btn_retour = (Button) findViewById(R.id.btn_back);

        btn_call.setOnClickListener(this);
        btn_retour.setOnClickListener(this);






    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_back: {
                Intent intent = new Intent(CallRemorquageActivity.this, MainActivity.class);
                startActivity(intent);
            }
            break;
            case R.id.btn_callNow: {
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

            default:
                break;
        }
    }
}
