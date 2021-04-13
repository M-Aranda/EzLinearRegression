package com.arandastock001.EzLinearRegression;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.arandastock001.EzLinearRegression.Modelo.CalculadoraDeValores;
import com.arandastock001.EzLinearRegression.Modelo.ControladorDeColores;
import com.arandastock001.EzLinearRegression.Modelo.Data;
import com.arandastock001.EzLinearRegression.Modelo.Registro;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class IngresoManual extends AppCompatActivity {


    private Button btnVolverDesdeIngresoManual, btnCalcular;
    private EditText txtFieldColumnaX, txtFieldColumnaY;
    private ConstraintLayout ingresoManual;
    private ControladorDeColores controladorDeColores;
    private Data db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingreso_manual);

        btnVolverDesdeIngresoManual = (Button) findViewById(R.id.btnVolverDesdeIngresoManual);
        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        txtFieldColumnaX = (EditText) findViewById(R.id.txtFieldColumnaX);
        txtFieldColumnaY = (EditText) findViewById(R.id.txtFieldColumnaY);
        ingresoManual= (ConstraintLayout) findViewById(R.id.LayoutIngresoManual);

       ControladorDeColores controladorDeColores= ControladorDeColores.getInstance();
       controladorDeColores.setObjetoConstraint(ingresoManual);
       controladorDeColores.cambiarColor();

        db = new Data(this.getApplicationContext());




        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                try {

                    String columnaX = txtFieldColumnaX.getText().toString();
                    String columnaY = txtFieldColumnaY.getText().toString();

                    String [] numerosX = columnaX.split(" ");
                    String [] numerosY = columnaY.split(" ");

                    ArrayList<Integer> numerosDeX = new ArrayList<>();
                    ArrayList<Integer> numerosDeY = new ArrayList<>();



                    for (int i = 0; i <numerosX.length ; i++) {
                        numerosDeX.add(Integer.parseInt(numerosX[i]));
                    }

                    for (int i = 0; i <numerosX.length ; i++) {
                        numerosDeY.add(Integer.parseInt(numerosY[i]));
                    }

                    if(numerosX.length==numerosY.length){



                    CalculadoraDeValores calculosRealizados = new CalculadoraDeValores(numerosDeX, numerosDeY);

                    startActivity(new Intent(IngresoManual.this, ResumenDeResultados.class).putExtra("calculosRealizados", (Serializable) calculosRealizados));


                    Date momentoActual = Calendar.getInstance().getTime();
                    String momentoActualComoString = momentoActual.toString();

                    String parteXComoString = "";
                    String parteYComoString = "";


                    for (int j = 0; j < numerosDeX.size(); j++) {

                        parteXComoString=parteXComoString+numerosDeX.get(j)+"\n";
                    }


                    for (int j = 0; j < numerosDeY.size(); j++) {
                        parteYComoString=parteYComoString+numerosDeY.get(j)+"\n";
                    }


                    //insertar registro
                    Registro r = new Registro();
                    r.setValoresColumnaX(parteXComoString);
                    r.setValoresColumnaY(parteYComoString);
                    r.setFechaRegistro(momentoActualComoString);
                    db.insertarRegistro(r);

                    finish();
                    }else{
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "La cantidad de numeros ingresados debe ser la misma en ambas columnas",
                                Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER, 0, 0);

                        toast.show();
                        txtFieldColumnaX.setText("");
                        txtFieldColumnaY.setText("");
                    }




                }catch (Exception error){

                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Solo se aceptan numeros enteros separados por espacios.",
                            Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);

                    toast.show();
                    txtFieldColumnaX.setText("");
                    txtFieldColumnaY.setText("");
                }





            }
        });

        btnVolverDesdeIngresoManual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MenuPrincipal.class);
                startActivity(i);
                finish();
            }
        });



        Toast toast = Toast.makeText(getApplicationContext(),
                "Ingrese numeros separados por espacios.",
                Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);

        toast.show();

    }
}