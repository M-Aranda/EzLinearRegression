package com.arandastock001.ezregre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class ConfirmacionDeNumeros extends AppCompatActivity {

    private TextView txtPruebaX, txtPruebaY, txtSumaX2, txtSumaY2, txtSumaXY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion_de_numeros);


        txtPruebaX = (TextView) findViewById(R.id.txtPruebaX);
        txtPruebaY = (TextView) findViewById(R.id.txtPruebaY);
        txtSumaX2 = (TextView) findViewById(R.id.txtSumaX2);
        txtSumaY2 = (TextView) findViewById(R.id.txtSumaY2);
        txtSumaXY = (TextView) findViewById(R.id.txtsumaXY);

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




        txtPruebaX.setText("La suma de todas las x es :"+cr.calcularSumaDeTodasLasX().toString());
        txtPruebaY.setText("La suma de todas las y es: "+cr.calcularSumaDeTodasLasY().toString());
        txtSumaX2.setText("La suma de todas las x2 es: "+cr.calcularSumaDeTodasLasXCuadrado().toString());
        txtSumaY2.setText("La suma de todas las y2 es: "+cr.calcularSumaDeTodasLasYCuadrado().toString());
        txtSumaXY.setText("La suma de todas las xy es: "+cr.calcularSumaDeTodasLasXY().toString());



    }
}
