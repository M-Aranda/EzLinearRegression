package com.arandastock001.ezregre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.arandastock001.ezregre.Modelo.CalculadorDeRegresion;
import com.arandastock001.ezregre.Modelo.Data;
import com.arandastock001.ezregre.Modelo.Registro;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ResumenDeResultados extends AppCompatActivity {

    private TextView txtPruebaX, txtPruebaY, txtSumaX2, txtSumaY2, txtSumaXY ,txtPendiente, txtInterseccion, txtr2, txtr;
    private Button btnContinuarConfirmacionDeNumeros, btnContinuarADesarrollo;
    private CalculadorDeRegresion calculosRealizados;
    private Data db;

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

        db = new Data(this.getApplicationContext());

        Intent i = getIntent();

        ArrayList<Integer> listadoDeNumerosX = new ArrayList<>();
        ArrayList<Integer> listadoDeNumerosY = new ArrayList<>();

        CalculadorDeRegresion cr = null;

        //datos vienene de activity de captura (camara), o sea, los calculos tienene que hacerse todavia
        if( i.getSerializableExtra("caracteresReconocidos")!=null) {


            ArrayList<String> stringDeCaraceresReconocidos = (ArrayList<String>) i.getSerializableExtra("caracteresReconocidos");


            String[] parteX = stringDeCaraceresReconocidos.get(0).split("\n");
            String[] parteY = stringDeCaraceresReconocidos.get(1).split("\n");


           String parteXComoString = "";
           String parteYComoString = "";


            for (int j = 0; j < parteX.length; j++) {
                listadoDeNumerosX.add(Integer.parseInt(parteX[j]));
                parteXComoString=parteXComoString+parteX[j]+"\n";
            }


            for (int j = 0; j < parteY.length; j++) {
                listadoDeNumerosY.add(Integer.parseInt(parteY[j]));
                parteYComoString=parteYComoString+parteY[j]+"\n";
            }


            //Para ver si se agregaron los caracteres
            System.out.println(parteXComoString);
            System.out.println(parteYComoString);
            Date momentoActual = Calendar.getInstance().getTime();
            String momentoActualComoString = momentoActual.toString();


            //Para ingresar registro a db
            Registro r = new Registro();
            r.setValoresColumnaX(parteXComoString);
            r.setValoresColumnaY(parteYComoString);
            r.setFechaRegistro(momentoActualComoString);
            db.insertarRegistro(r); //Registro se hizo





            cr = new CalculadorDeRegresion(listadoDeNumerosX,listadoDeNumerosY);
            calculosRealizados = cr;


            // datos NO vienen de captura, o sea, los calculos ya se hicieron
        }else if( i.getSerializableExtra("caracteresReconocidos")==null){
            cr = (CalculadorDeRegresion) i.getSerializableExtra("calculosRealizados");
            calculosRealizados = cr;
        }




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


                startActivity(new Intent(ResumenDeResultados.this, CreacionDeArchivo.class).putExtra("calculosRealizados", (Serializable) calculosRealizados));
                finish();


            }
        });


        btnContinuarADesarrollo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResumenDeResultados.this, PasoAPaso.class).putExtra("calculosRealizados", (Serializable) calculosRealizados));
                finish();
            }
        });





    }
}
