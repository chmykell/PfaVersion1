package com.example.chmykel.pfaversion1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    Button bt_valider;
    EditText et_nom , et_password;
    TextView tv_neuf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bt_valider = (Button) findViewById(R.id.bt_valider);
        et_nom = (EditText) findViewById(R.id.et_nom);
        et_password = (EditText) findViewById(R.id.et_password);
        tv_neuf = (TextView) findViewById(R.id.tv_neuf);
        bt_valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });
        tv_neuf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, ActualiteActivity.class);
                startActivity(intent);

            }
        });

    }
}
