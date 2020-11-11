package com.arandastock001.ezregre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IngresoManual extends AppCompatActivity {


    private Button btnVolverDesdeIngresoManual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingreso_manual);

        btnVolverDesdeIngresoManual = (Button) findViewById(R.id.btnVolverDesdeIngresoManual);




        btnVolverDesdeIngresoManual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MenuPrincipal.class);
                startActivity(i);
                finish();
            }
        });

    }
}