package com.example.chmykel.pfaversion1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class CallRemorquageActivity extends AppCompatActivity {
    Button btn_call , btn_retour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_remorquage);
        btn_call = (Button) findViewById(R.id.btn_callNow);


    }
}
