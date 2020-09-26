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
        //hay que hacerle un trim, sino reemplaza por -1's?

        System.out.println("columna x es "+stringDeCaraceresReconocidos.get(0));

        String parteXString = stringDeCaraceresReconocidos.get(0).replace(" ", "");
        String parteYString = stringDeCaraceresReconocidos.get(1).replace(" ", "");

        String [] parteX = stringDeCaraceresReconocidos.get(0).split("\n");



        //char [] parteX = parteXString.toCharArray();
        char [] parteY = parteYString.toCharArray();

        int laSuma = 0;
        for (int j = 0; j < parteX.length; j++) {
            listadoDeNumerosX.add(Integer.parseInt(parteX[j]));
            System.out.println(parteX[j]);
            System.out.println("El array tiene " +parteX.length + " partes " );
            laSuma = laSuma + Integer.parseInt(parteX[j]);
        }





        System.out.println("la suma hasta aqui es "+laSuma);
        //Creo que pasa algo en la clase de calculo de regresion








        for (int j = 0; j < parteY.length  ; j++) {

    //        if(Character.getNumericValue(parteY[j])!=-1){
                listadoDeNumerosX.add(Character.getNumericValue(parteY[j]));
      //      }

        }



        CalculadorDeRegresion cr = new CalculadorDeRegresion(listadoDeNumerosX,listadoDeNumerosY);



        //txtPruebaX.setText(stringDeCaraceresReconocidos.get(0).trim());
        //txtPruebaY.setText(stringDeCaraceresReconocidos.get(1).trim());


        txtPruebaX.setText(cr.calcularSumaDeTodasLasX().toString());
        txtPruebaY.setText(cr.calcularSumaDeTodasLasY().toString());



    }
}
