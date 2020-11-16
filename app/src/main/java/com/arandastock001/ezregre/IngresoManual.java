package com.arandastock001.ezregre;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.arandastock001.ezregre.Modelo.CalculadorDeRegresion;
import com.arandastock001.ezregre.Modelo.ControladorDeColores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class IngresoManual extends AppCompatActivity {


    private Button btnVolverDesdeIngresoManual, btnCalcular;
    private EditText txtFieldColumnaX, txtFieldColumnaY;
    private ConstraintLayout ingresoManual;
    private ControladorDeColores controladorDeColores;

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




        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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


                CalculadorDeRegresion calculosRealizados = new CalculadorDeRegresion(numerosDeX, numerosDeY);



                startActivity(new Intent(IngresoManual.this, ResumenDeResultados.class).putExtra("calculosRealizados", (Serializable) calculosRealizados));



                finish();


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