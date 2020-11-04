package com.arandastock001.ezregre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.arandastock001.ezregre.Modelo.Data;
import com.arandastock001.ezregre.Modelo.Registro;

import java.util.ArrayList;

public class VerHistorial extends AppCompatActivity {

    private Button btnVolverDesdeHistorial;
    private ListView lstRegistros;
    private ArrayList<Registro> registros;
    private Data db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_historial);

        btnVolverDesdeHistorial = findViewById(R.id.btnVolverDesdeHistorial);
        lstRegistros = findViewById(R.id.lstRegistros);


        db = new Data(this.getApplicationContext());
        registros = (ArrayList<Registro>) db.getRegistros();


        ArrayAdapter adaptadorDeRegistros = new ArrayAdapter<Registro>(VerHistorial.this, android.R.layout.simple_list_item_1, registros);
        lstRegistros.setAdapter(adaptadorDeRegistros);





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