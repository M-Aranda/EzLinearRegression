package com.arandastock001.EzLinearRegression;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.arandastock001.EzLinearRegression.Modelo.CalculadoraDeValores;
import com.arandastock001.EzLinearRegression.Modelo.ControladorDeColores;

import java.io.Serializable;

public class UsarEcuacionDeLaRecta extends AppCompatActivity {

    private ConstraintLayout usarEcuacionDeLaRecta;
    private ControladorDeColores controladorDeColores;
    private TextView txtEcuaciónDeLaRecta, txtYIgualA, txtMasB, txtResultado ;
    private Button btnCalcularResultado, btnVolverDesdeER;
    private EditText txtFieldX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usar_ecuacion_de_la_recta);
        usarEcuacionDeLaRecta = (ConstraintLayout) findViewById(R.id.layoutUsarEcuacionDeLaRecta);


        txtEcuaciónDeLaRecta = (TextView) findViewById(R.id.txtEcuaciónDeLaRecta);
        txtYIgualA = (TextView) findViewById(R.id.txtYIgualA);
        txtMasB = (TextView) findViewById(R.id.txtMasB);
        txtResultado = (TextView) findViewById(R.id.txtResultado);
        btnCalcularResultado = (Button) findViewById(R.id.btnCalcularResultado);
        btnVolverDesdeER = (Button) findViewById(R.id.btnVolverDesdeER);
        txtFieldX = (EditText) findViewById(R.id.txtFieldX);



        ControladorDeColores controladorDeColores = ControladorDeColores.getInstance();
        controladorDeColores.setObjetoConstraint(usarEcuacionDeLaRecta);
        controladorDeColores.cambiarColor();

        txtEcuaciónDeLaRecta.setText("Ecuación de la recta");

        Intent i = getIntent();
        CalculadoraDeValores cr = (CalculadoraDeValores) i.getSerializableExtra("calculosRealizados");


        txtYIgualA.setText("Y = "+cr.calcularPendiente().toString()+" * ");
        txtMasB.setText("+ "+cr.calcularInterseccion());

        txtResultado.setText("El valor de Y es: ...");





        btnCalcularResultado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               try{
                Double resultado = 0.0;
                int valorDeX = 0;
                valorDeX = Integer.parseInt(txtFieldX.getText().toString());
                resultado = cr.calcularValorDependiente(cr.calcularPendiente(),valorDeX,cr.calcularInterseccion());
                txtResultado.setText("El valor de Y es: "+ resultado);
               }catch(Exception error){
                   Toast toast = Toast.makeText(getApplicationContext(),
                           "Sólo se aceptan números enteros",
                           Toast.LENGTH_LONG);
                   toast.setGravity(Gravity.CENTER, 0, 0);

                   toast.show();
                }
            }
        });



        btnVolverDesdeER.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                CalculadoraDeValores calculosRealizados = (CalculadoraDeValores) i.getSerializableExtra("calculosRealizados");

                startActivity(new Intent(UsarEcuacionDeLaRecta.this, CreacionDeArchivo.class).putExtra("calculosRealizados", (Serializable) calculosRealizados));
                finish();
            }
        });




    }
}