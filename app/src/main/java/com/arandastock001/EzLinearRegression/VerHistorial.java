package com.arandastock001.EzLinearRegression;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.arandastock001.EzLinearRegression.Modelo.CalculadoraDeValores;
import com.arandastock001.EzLinearRegression.Modelo.ControladorDeColores;
import com.arandastock001.EzLinearRegression.Modelo.Data;
import com.arandastock001.EzLinearRegression.Modelo.Registro;

import java.io.Serializable;
import java.util.ArrayList;

public class VerHistorial extends AppCompatActivity {

    private Button btnVolverDesdeHistorial;
    private ListView lstRegistros;
    private ArrayList<Registro> registros;
    private Data db;
    private ConstraintLayout verHistorial;
    private ControladorDeColores controladorDeColores;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_historial);

        btnVolverDesdeHistorial = findViewById(R.id.btnVolverDesdeHistorial);
        lstRegistros = findViewById(R.id.lstRegistros);


        verHistorial = (ConstraintLayout) findViewById(R.id.LayoutVerHistorial);


        ControladorDeColores controladorDeColores= ControladorDeColores.getInstance();
        controladorDeColores.setObjetoConstraint(verHistorial);
        controladorDeColores.cambiarColor();

        switch (controladorDeColores.getCodigoColor()){
            case 1:{
                lstRegistros.setBackgroundColor(Color.parseColor("#69D0F1"));
                break;
            }
            case 2:{
                lstRegistros.setBackgroundColor(Color.parseColor("#F778E4"));
                break;
            }
            case 3:{
                lstRegistros.setBackgroundColor(Color.parseColor("#FC9A2B"));
                break;
            }

            default:
                System.out.println("No pasa nada");
                break;

        }


        db = new Data(this.getApplicationContext());
        registros = (ArrayList<Registro>) db.getRegistros();


        ArrayAdapter adaptadorDeRegistros = new ArrayAdapter<Registro>(VerHistorial.this, android.R.layout.simple_list_item_1, registros);
        lstRegistros.setAdapter(adaptadorDeRegistros);



        lstRegistros.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                Registro registro = (Registro) lstRegistros.getItemAtPosition(position);


                ArrayList<Integer> listadoDeNumerosX = new ArrayList<>();
                ArrayList<Integer> listadoDeNumerosY = new ArrayList<>();

                String[] parteX = registro.getValoresColumnaX().split("\n");
                String[] parteY = registro.getValoresColumnaY().split("\n");



                for (int j = 0; j < parteX.length; j++) {
                    listadoDeNumerosX.add(Integer.parseInt(parteX[j]));

                }


                for (int j = 0; j < parteY.length; j++) {
                    listadoDeNumerosY.add(Integer.parseInt(parteY[j]));

                }

                CalculadoraDeValores cr = new CalculadoraDeValores(listadoDeNumerosX,listadoDeNumerosY);
                startActivity(new Intent(VerHistorial.this, ResumenDeResultados.class).putExtra("calculosRealizados", (Serializable) cr));
                finish();
            }
        });



        btnVolverDesdeHistorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MenuPrincipal.class);
                startActivity(i);
                finish();
            }
        });






    }
}