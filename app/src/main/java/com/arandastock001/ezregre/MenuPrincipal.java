package com.arandastock001.ezregre;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.lang.reflect.Method;

public class MenuPrincipal extends AppCompatActivity {

    private Button btnProcederACamara, btnAcercaDe, btnVerHistorial;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        btnProcederACamara  = (Button)findViewById(R.id.btnProcederACamara);
        btnAcercaDe = (Button)findViewById(R.id.btnAcercaDe);
        btnVerHistorial = (Button)findViewById(R.id.btnVerHistorial);






        btnProcederACamara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),CapturaActivity.class);
                startActivity(i);
                finish();

            }
        });

        btnAcercaDe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                 Intent i = new Intent(getApplicationContext(),AcercaDe.class);
                startActivity(i);
                finish();

            }
        });



        btnVerHistorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),VerHistorial.class);
                startActivity(i);
                finish();

            }
        });

        Toast toast = Toast.makeText(getApplicationContext(),
                "Bienvenido a la aplicación",
                Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);

        toast.show();




    }
}
