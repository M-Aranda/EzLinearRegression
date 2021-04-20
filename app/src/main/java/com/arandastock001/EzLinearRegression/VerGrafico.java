package com.arandastock001.EzLinearRegression;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.arandastock001.EzLinearRegression.Modelo.CalculadoraDeValores;
import com.arandastock001.EzLinearRegression.Modelo.ControladorDeColores;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.PointsGraphSeries;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class VerGrafico extends AppCompatActivity {


    private Button btnVolverDesdeGrafico;
    private ConstraintLayout layoutVerGrafico;
    private GraphView grafico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_grafico);

         btnVolverDesdeGrafico = (Button) findViewById(R.id.btnVolverDesdeGrafico);
         layoutVerGrafico = (ConstraintLayout) findViewById(R.id.layoutVerGrafico);
         grafico = (GraphView) findViewById(R.id.grafico);






        Intent i = getIntent();
        CalculadoraDeValores calculosRealizados = (CalculadoraDeValores) i.getSerializableExtra("calculosRealizados");

        ControladorDeColores cont=ControladorDeColores.getInstance();
        cont.setObjetoConstraint(layoutVerGrafico);
        cont.cambiarColor();


        DataPoint [] puntosDeDatos = new DataPoint[]{ };
        ArrayList<DataPoint> datos =  new ArrayList<>();

        for (int j = 0; j <calculosRealizados.getColumnaX().size() ; j++) {
            datos.add(new DataPoint(calculosRealizados.getColumnaX().get(j),calculosRealizados.getColumnaY().get(j)));

            addToDataPointToArray(puntosDeDatos, new DataPoint(calculosRealizados.getColumnaX().get(j),calculosRealizados.getColumnaY().get(j)));

        }

        PointsGraphSeries<DataPoint> posicionesDePuntos = new PointsGraphSeries<>(datos.toArray(new DataPoint[0]));



        //Esto añade datos al grafico (los puntos)
        grafico.addSeries(posicionesDePuntos);
        posicionesDePuntos.setShape(PointsGraphSeries.Shape.POINT);
        posicionesDePuntos.setColor(Color.RED);



        //Esto  agrega la recta
        DataPoint[] lineaRecta = new DataPoint[]{};

        ArrayList<DataPoint> datosLineaRecta = new ArrayList<>();

        int valorXMasBajo = calculosRealizados.getColumnaX().get(0);
        int valorYMasBajo = calculosRealizados.getColumnaY().get(0);

        int valorASumar =  (int)Math.round(calculosRealizados.calcularPendiente());

        for (int j = 0; j <calculosRealizados.getColumnaX().size() ; j++) {

            if(j==0){
                valorXMasBajo = calculosRealizados.getColumnaX().get(j)-valorASumar;
                valorYMasBajo = calculosRealizados.getColumnaY().get(j)-valorASumar;


                datosLineaRecta.add(new DataPoint(valorXMasBajo,valorYMasBajo));

                addToDataPointToArray(lineaRecta, new DataPoint(valorXMasBajo,valorYMasBajo));

            }else if(j+1==calculosRealizados.getColumnaX().size()){
                valorXMasBajo = calculosRealizados.getColumnaX().get(j)+valorASumar;
                valorYMasBajo = calculosRealizados.getColumnaY().get(j)+valorASumar;


                datosLineaRecta.add(new DataPoint(valorXMasBajo,valorYMasBajo));

                addToDataPointToArray(lineaRecta, new DataPoint(valorXMasBajo,valorYMasBajo));
            }



        }



        LineGraphSeries<DataPoint> lineaDibujo = new LineGraphSeries<>(datosLineaRecta.toArray(new DataPoint[0]));


        grafico.addSeries(lineaDibujo);






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


    public DataPoint[] addToDataPointToArray(DataPoint[] oldArray, DataPoint newPoint)
    {
        DataPoint[] newArray = Arrays.copyOf(oldArray, oldArray.length+1);
        newArray[oldArray.length] = newPoint;
        return newArray;
    }

}