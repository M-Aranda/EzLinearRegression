package com.arandastock001.ezregre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuPrincipal extends AppCompatActivity {

    private Button btnProcederACamara, btnAcercaDe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        btnProcederACamara  = (Button)findViewById(R.id.btnProcederACamara);
        btnAcercaDe = (Button)findViewById(R.id.btnAcercaDe);




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

        Toast toast = Toast.makeText(getApplicationContext(),
                "Bienvenido a la aplicación",
                Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);

        toast.show();






    }
}
