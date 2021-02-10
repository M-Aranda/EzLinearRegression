package com.arandastock001.EzLinearRegression;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.arandastock001.EzLinearRegression.Modelo.ControladorDeColores;

public class AcercaDe extends AppCompatActivity {

    private Button btnVolverAMenuPrincipal;
    private TextView txtDescripcionApp;
    private ConstraintLayout acercaDe;
    private ControladorDeColores controladorDeColores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);


        btnVolverAMenuPrincipal = (Button)findViewById(R.id.btnVolverAMenuPrincipal);
        txtDescripcionApp = (TextView)findViewById(R.id.txtDescripcionApp);

        acercaDe = (ConstraintLayout) findViewById(R.id.layoutAcercaDe);

        txtDescripcionApp.setText("Ez regression es un aplicación creada por Marcelo Aranda como proyecto de Tesis." +"\n"+
                " Es de libre uso." +"\n"+
                " Instrucciones: "+ "\n"+
                "Apunte y capture la columna x primero, y luego la columna y." +"\n"+
                " El programa resolvera el ejercicio de regresón lineal simple de manera automática y sin necesidad de realizar pasos adicionales." +"\n"+
                "Se puede exportar el resultado a PDF, Excel o archivo Txt. También es posible crear un gráfico de la regresión"
                );

        controladorDeColores= ControladorDeColores.getInstance();
       controladorDeColores.setObjetoConstraint(acercaDe);
       controladorDeColores.cambiarColor();




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
