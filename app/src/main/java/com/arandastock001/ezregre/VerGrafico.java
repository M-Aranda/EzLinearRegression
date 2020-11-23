package com.arandastock001.ezregre;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.arandastock001.ezregre.Modelo.CalculadoraDeValores;
import com.arandastock001.ezregre.Modelo.ControladorDeColores;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.io.Serializable;
import java.util.ArrayList;

public class VerGrafico extends AppCompatActivity {


    private Button btnVolverDesdeGrafico;
    private ConstraintLayout layoutVerGrafico;
    private GraphView grafico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_grafico);

        Button btnVolverDesdeGrafico = (Button) findViewById(R.id.btnVolverDesdeGrafico);
        ConstraintLayout layoutVerGrafico = (ConstraintLayout) findViewById(R.id.layoutVerGrafico);
        GraphView graph = (GraphView) findViewById(R.id.grafico);





        Intent i = getIntent();
        CalculadoraDeValores calculosRealizados = (CalculadoraDeValores) i.getSerializableExtra("calculosRealizados");

        ControladorDeColores cont=ControladorDeColores.getInstance();
        cont.setObjetoConstraint(layoutVerGrafico);
        cont.cambiarColor();


        ArrayList<DataPoint>datos =  new ArrayList<>();
        for (int j = 0; j <calculosRealizados.getColumnaX().size() ; j++) {
            datos.add(new DataPoint(calculosRealizados.getColumnaX().get(j),calculosRealizados.getColumnaY().get(j)));
        }


       // DataPoint puntosDeDatos[]  = (DataPoint[]) datos.toArray();


        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[]{
                new DataPoint(1,2),
                new DataPoint(3,4),
                new DataPoint(5,6)
        });



        graph.addSeries(series);



        btnVolverDesdeGrafico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                CalculadoraDeValores calculosRealizados = (CalculadoraDeValores) i.getSerializableExtra("calculosRealizados");

                startActivity(new Intent(VerGrafico.this, PasoAPaso.class).putExtra("calculosRealizados", (Serializable) calculosRealizados));
                finish();
            }
        });



    }
}