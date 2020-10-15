package com.arandastock001.ezregre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AcercaDe extends AppCompatActivity {

    private Button btnVolverAMenuPrincipal;
    private TextView txtDescripcionApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);


        btnVolverAMenuPrincipal = (Button)findViewById(R.id.btnVolverAMenuPrincipal);
        txtDescripcionApp = (TextView)findViewById(R.id.txtDescripcionApp);

        txtDescripcionApp.setText("Ez regression es un aplicación creada por Marcelo Aranda como proyecto de Tesis." +"\n"+
                " Es de libre uso." +"\n"+
                " Instrucciones: "+ "\n"+
                "Apunte y capture la columna x primero, y luego la columna y." +"\n"+
                " El programa resolvera el ejercicio de regresón lineal simple." +"\n"+
                "Se puede exportar el resultado a PDF, Excel o archivo Txt ");


        btnVolverAMenuPrincipal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),MenuPrincipal.class);
                startActivity(i);
                finish();
            }
        });






    }
}
