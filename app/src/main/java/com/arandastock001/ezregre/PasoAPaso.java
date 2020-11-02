package com.arandastock001.ezregre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.arandastock001.ezregre.Modelo.CalculadorDeRegresion;

import java.io.Serializable;

public class PasoAPaso extends AppCompatActivity {


    private Button btnVolverDesdePasoAPaso;
    private TextView txtPasoAPasoDetallado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paso_a_paso);

        Button btnVolverDesdePasoAPaso = (Button) findViewById(R.id.btnVolverDesdePasoAPaso);
        TextView txtPasoAPasoDetallado = (TextView) findViewById(R.id.txtPasoAPasoDetallado);



        Intent i = getIntent();
        CalculadorDeRegresion calculosRealizados = (CalculadorDeRegresion) i.getSerializableExtra("calculosRealizados");

        txtPasoAPasoDetallado.setText(calculosRealizados.mostrarPasoAPaso());
        txtPasoAPasoDetallado.setMovementMethod(new ScrollingMovementMethod());






        btnVolverDesdePasoAPaso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = getIntent();
                CalculadorDeRegresion calculosRealizados = (CalculadorDeRegresion) i.getSerializableExtra("calculosRealizados");

                startActivity(new Intent(PasoAPaso.this, ConfirmacionDeNumeros.class).putExtra("calculosRealizados", (Serializable) calculosRealizados));
                finish();

            }
        });
    }
}