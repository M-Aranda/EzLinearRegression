package com.arandastock001.ezregre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class ConfirmacionDeNumeros extends AppCompatActivity {

    private TextView txtPruebaX, txtPruebaY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion_de_numeros);


        txtPruebaX = (TextView) findViewById(R.id.txtPruebaX);
        txtPruebaY = (TextView) findViewById(R.id.txtPruebaY);

        Intent i = getIntent();
        ArrayList<String> stringDeCaraceresReconocidos = (ArrayList<String>) i.getSerializableExtra("caracteresReconocidos");



        ArrayList<Integer> listadoDeNumerosX = new ArrayList<>();
        ArrayList<Integer> listadoDeNumerosY = new ArrayList<>();




        String [] parteX = stringDeCaraceresReconocidos.get(0).split("\n");
        String [] parteY = stringDeCaraceresReconocidos.get(1).split("\n");






        for (int j = 0; j < parteX.length; j++) {
            listadoDeNumerosX.add(Integer.parseInt(parteX[j]));

        }




        for (int j = 0; j < parteY.length  ; j++) {
                listadoDeNumerosY.add(Integer.parseInt(parteY[j]));

        }



        CalculadorDeRegresion cr = new CalculadorDeRegresion(listadoDeNumerosX,listadoDeNumerosY);




        txtPruebaX.setText(cr.calcularSumaDeTodasLasX().toString());
        txtPruebaY.setText(cr.calcularSumaDeTodasLasY().toString());



    }
}
