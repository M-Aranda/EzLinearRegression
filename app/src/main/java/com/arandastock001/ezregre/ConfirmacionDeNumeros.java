package com.arandastock001.ezregre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class ConfirmacionDeNumeros extends AppCompatActivity {

    private TextView txtPrueba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion_de_numeros);


        txtPrueba = (TextView) findViewById(R.id.txtPrueba);

        Intent i = getIntent();
        String stringDeCaraceresReconocidos = ((String) i.getSerializableExtra("caracteresReconocidos"));



        ArrayList<Integer> listadoDeNumeros = new ArrayList<>();

        char[] partes = stringDeCaraceresReconocidos.toCharArray();


        Integer suma = 0;
       //String partes [] = stringDeCaraceresReconocidos.split("");
        for (int j = 0; j < partes.length  ; j++) {


            listadoDeNumeros.add(Character.getNumericValue(partes[j]));

            suma = suma + Character.getNumericValue(partes[j]);

            System.out.println(partes[j]);


        }





        txtPrueba.setText(suma.toString());


    }
}
