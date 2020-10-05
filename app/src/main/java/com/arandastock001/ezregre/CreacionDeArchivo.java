package com.arandastock001.ezregre;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CreacionDeArchivo extends AppCompatActivity {

    private Button btnCrearExcel, btnCrearPDF, btnCrearTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creacion_de_archivo);

        btnCrearExcel = (Button) findViewById(R.id.btnCrearExcel);
        btnCrearPDF = (Button) findViewById(R.id.btnCrearPDF);
        btnCrearTxt = (Button) findViewById(R.id.btnCrearTxt);




        btnCrearExcel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        btnCrearPDF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnCrearTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });







    }


}
