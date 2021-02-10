package com.arandastock001.EzLinearRegression;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.arandastock001.EzLinearRegression.Modelo.ControladorDeColores;

public class MenuOpciones extends AppCompatActivity {

    private Button btnCeleste, btnRosa, btnNaranjo, btnVolverDesdeOpciones;
    private ConstraintLayout menuOpciones;
    private Integer codigoColor;
    private ControladorDeColores controladorDeColores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_opciones);


        btnCeleste = (Button) findViewById(R.id.btnCeleste);
        btnRosa = (Button) findViewById(R.id.btnRosa);
        btnNaranjo = (Button) findViewById(R.id.btnAmarillo);
        btnVolverDesdeOpciones = (Button) findViewById(R.id.btnVolverDesdeOpciones);


        menuOpciones = (ConstraintLayout)findViewById(R.id.layoutMenuOpciones);


        controladorDeColores= ControladorDeColores.getInstance();
        controladorDeColores.setObjetoConstraint(menuOpciones);




        btnCeleste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                codigoColor=1;
                controladorDeColores.setCodigoColor(codigoColor);
                controladorDeColores.cambiarColor();


            }
        });

        btnRosa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                codigoColor=2;
                controladorDeColores.setCodigoColor(codigoColor);
                controladorDeColores.cambiarColor();
            }
        });

        btnNaranjo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                codigoColor=3;
                controladorDeColores.setCodigoColor(codigoColor);
                controladorDeColores.cambiarColor();

            }
        });





        btnVolverDesdeOpciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MenuPrincipal.class);
                startActivity(i);
                finish();

            }
        });


    }





}