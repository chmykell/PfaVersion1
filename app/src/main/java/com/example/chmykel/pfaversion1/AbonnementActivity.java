package com.example.chmykel.pfaversion1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AbonnementActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_autres_abon, btn_mes_abon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abonnement);

        btn_autres_abon = (Button) findViewById(R.id.autre_abonnements);
        btn_mes_abon = (Button) findViewById(R.id.my_abonnement);


        btn_autres_abon.setOnClickListener(this);
        btn_mes_abon.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.autre_abonnements: {
                Intent intent = new Intent(AbonnementActivity.this, AutresAbonnementsActivity.class);
                startActivity(intent);
            }
            break;
            case R.id.my_abonnement: {
                Intent intent = new Intent(AbonnementActivity.this, MyAbonnementsActivity.class);
                startActivity(intent);
            }
            break;
        }
    }
}
