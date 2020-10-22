package com.arandastock001.ezregre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.os.Environment;
import android.print.pdf.PrintedPdfDocument;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.arandastock001.ezregre.Modelo.CalculadorDeRegresion;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

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

                Intent i = getIntent();
                CalculadorDeRegresion cr = (CalculadorDeRegresion) i.getSerializableExtra("calculosRealizados");


                Date momentoActual = Calendar.getInstance().getTime();
                String nombreArchivo = "txt creado el "+momentoActual.toString()+".pdf";

                String texto = cr.mostrarPasoAPaso();


                File path = getApplicationContext().getExternalFilesDir(null);

                final File file = new File(path, nombreArchivo);
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                FileOutputStream fOut = null;
                try {
                    fOut = new FileOutputStream(file);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }


                PdfDocument document = new PdfDocument();
                PdfDocument.PageInfo pageInfo = new
                        PdfDocument.PageInfo.Builder(100, 100, 1).create();
                PdfDocument.Page page = document.startPage(pageInfo);


                Canvas canvas = page.getCanvas();
                Paint paint = new Paint();

                canvas.drawText(texto, 10, 10, paint);



                document.finishPage(page);
                try {
                    document.writeTo(fOut);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                document.close();






            }
        });

        btnCrearTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = getIntent();
                CalculadorDeRegresion cr = (CalculadorDeRegresion) i.getSerializableExtra("calculosRealizados");


                Date momentoActual = Calendar.getInstance().getTime();
                String nombreArchivo = "txt creado el "+momentoActual.toString()+".txt";

                String texto = cr.mostrarPasoAPaso();


                // no usar?
                File path = getApplicationContext().getExternalFilesDir(null);

                //deprecado?
                File dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);

                File file = new File(path, nombreArchivo);





                FileOutputStream stream = null;
                try {
                    stream = new FileOutputStream(file);

                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Archivo guardado",
                            Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);

                    toast.show();


                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                try {
                    try {
                        stream.write(texto.getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } finally {
                    try {
                        stream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }









            }
            }

        );







    }


}
