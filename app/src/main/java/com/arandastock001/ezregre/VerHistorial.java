package com.arandastock001.ezregre;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.arandastock001.ezregre.Modelo.Data;
import com.arandastock001.ezregre.Modelo.Registro;

import java.util.ArrayList;

public class VerHistorial extends AppCompatActivity {

    private ArrayList<Registro> registros;
    private Data db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_historial);

        db = new Data(this.getApplicationContext());
        registros = (ArrayList<Registro>) db.getRegistros();









    }
}