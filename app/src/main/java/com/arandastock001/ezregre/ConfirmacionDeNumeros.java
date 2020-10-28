package com.arandastock001.ezregre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.arandastock001.ezregre.Modelo.CalculadorDeRegresion;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class ConfirmacionDeNumeros extends AppCompatActivity {

    private TextView txtPruebaX, txtPruebaY, txtSumaX2, txtSumaY2, txtSumaXY ,txtPendiente, txtInterseccion, txtr2, txtr;
    private Button btnContinuarConfirmacionDeNumeros, btnContinuarADesarrollo;
    private CalculadorDeRegresion calculosRealizados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion_de_numeros);


        txtPruebaX = (TextView) findViewById(R.id.txtPruebaX);
        txtPruebaY = (TextView) findViewById(R.id.txtPruebaY);
        txtSumaX2 = (TextView) findViewById(R.id.txtSumaX2);
        txtSumaY2 = (TextView) findViewById(R.id.txtSumaY2);
        txtSumaXY = (TextView) findViewById(R.id.txtSumaXY);
        txtPendiente = (TextView) findViewById(R.id.txtPendiente);
        txtInterseccion = (TextView) findViewById(R.id.txtInterseccion);
        txtr2 = (TextView) findViewById(R.id.txtr2);
        txtr = (TextView) findViewById(R.id.txtr);

        btnContinuarADesarrollo = (Button) findViewById(R.id.btnContinuarADesarrollo);
        btnContinuarConfirmacionDeNumeros = (Button) findViewById(R.id.btnContinuarConfirmacionDeNumeros);

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
        calculosRealizados = cr;


        DecimalFormat df = new DecimalFormat("#.####");



        txtPruebaX.setText("La suma de todas las x es :"+cr.calcularSumaDeTodasLasX().toString());
        txtPruebaY.setText("La suma de todas las y es: "+cr.calcularSumaDeTodasLasY().toString());
        txtSumaX2.setText("La suma de todas las x2 es: "+cr.calcularSumaDeTodasLasXCuadrado().toString());
        txtSumaY2.setText("La suma de todas las y2 es: "+cr.calcularSumaDeTodasLasYCuadrado().toString());
        txtSumaXY.setText("La suma de todas las xy es: "+cr.calcularSumaDeTodasLasXY().toString());

        txtPendiente.setText("La pendiente es "+df.format(cr.calcularPendiente()).toString());
        txtInterseccion.setText("La intersección es "+df.format(cr.calcularInterseccion()).toString());

        txtr2.setText("El valor de r2 es "+df.format(cr.calcularR2()).toString());

        txtr.setText("El valor de r es "+df.format(cr.calcularR()).toString());



        System.out.println(cr.calcularR2().toString());
        System.out.println(cr.calcularR().toString());


        btnContinuarConfirmacionDeNumeros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                startActivity(new Intent(ConfirmacionDeNumeros.this, CreacionDeArchivo.class).putExtra("calculosRealizados", (Serializable) calculosRealizados));
                finish();


            }
        });


        btnContinuarADesarrollo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ConfirmacionDeNumeros.this, CreacionDeArchivo.class).putExtra("calculosRealizados", (Serializable) calculosRealizados));
                finish();
            }
        });





    }
}
