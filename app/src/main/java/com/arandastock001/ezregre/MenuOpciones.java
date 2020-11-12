package com.arandastock001.ezregre;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuOpciones extends AppCompatActivity {

    private Button btnCeleste, btnPurpura, btnNaranjo, btnVolverDesdeOpciones;
    private ConstraintLayout acercaDe,creacionDeArchivo, ingresoManual, menuOpciones, menuPrincipal, pasoAPaso, resumenDeResultados, verHistorial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_opciones);


        btnCeleste = (Button) findViewById(R.id.btnCeleste);
        btnPurpura = (Button) findViewById(R.id.btnRosa);
        btnNaranjo = (Button) findViewById(R.id.btnAmarillo);
        btnVolverDesdeOpciones = (Button) findViewById(R.id.btnVolverDesdeOpciones);




        acercaDe = (ConstraintLayout) findViewById(R.id.LayoutMenuOpciones);
        creacionDeArchivo = (ConstraintLayout)findViewById(R.id.LayoutMenuOpciones);
        ingresoManual = (ConstraintLayout)findViewById(R.id.LayoutMenuOpciones);
        menuOpciones = (ConstraintLayout)findViewById(R.id.LayoutMenuOpciones);
        menuPrincipal = (ConstraintLayout)findViewById(R.id.LayoutMenuOpciones);
        pasoAPaso = (ConstraintLayout) findViewById(R.id.LayoutMenuOpciones);
        resumenDeResultados = (ConstraintLayout) findViewById(R.id.LayoutMenuOpciones);
        verHistorial = (ConstraintLayout) findViewById(R.id.LayoutMenuOpciones);



        btnCeleste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                acercaDe.setBackgroundColor(Color.parseColor("#000000"));
                creacionDeArchivo.setBackgroundColor(Color.parseColor("#000000"));
                ingresoManual.setBackgroundColor(Color.parseColor("#000000"));
                menuOpciones.setBackgroundColor(Color.parseColor("#000000"));
                menuPrincipal.setBackgroundColor(Color.parseColor("#000000"));
                pasoAPaso.setBackgroundColor(Color.parseColor("#000000"));
                resumenDeResultados.setBackgroundColor(Color.parseColor("#000000"));
                verHistorial.setBackgroundColor(Color.parseColor("#000000"));


            }
        });

        btnPurpura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                acercaDe.setBackgroundColor(Color.parseColor("#000000"));
                creacionDeArchivo.setBackgroundColor(Color.parseColor("#000000"));
                ingresoManual.setBackgroundColor(Color.parseColor("#000000"));
                menuOpciones.setBackgroundColor(Color.parseColor("#000000"));
                menuPrincipal.setBackgroundColor(Color.parseColor("#000000"));
                pasoAPaso.setBackgroundColor(Color.parseColor("#000000"));
                resumenDeResultados.setBackgroundColor(Color.parseColor("#000000"));
                verHistorial.setBackgroundColor(Color.parseColor("#000000"));
            }
        });

        btnNaranjo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                acercaDe.setBackgroundColor(Color.parseColor("#000000"));
                creacionDeArchivo.setBackgroundColor(Color.parseColor("#000000"));
                ingresoManual.setBackgroundColor(Color.parseColor("#000000"));
                menuOpciones.setBackgroundColor(Color.parseColor("#000000"));
                menuPrincipal.setBackgroundColor(Color.parseColor("#000000"));
                pasoAPaso.setBackgroundColor(Color.parseColor("#000000"));
                resumenDeResultados.setBackgroundColor(Color.parseColor("#000000"));
                verHistorial.setBackgroundColor(Color.parseColor("#000000"));

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