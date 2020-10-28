package com.arandastock001.ezregre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PasoAPaso extends AppCompatActivity {


    private Button btnVolverDesdePasoAPaso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paso_a_paso);

        Button btnVolverDesdePasoAPaso = (Button) findViewById(R.id.btnVolverDesdePasoAPaso);



        btnVolverDesdePasoAPaso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),ConfirmacionDeNumeros.class);
                startActivity(i);
                finish();

            }
        });
    }
}