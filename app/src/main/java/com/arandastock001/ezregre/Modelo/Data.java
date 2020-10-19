package com.arandastock001.ezregre.Modelo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


import java.util.ArrayList;
import java.util.List;



public class Data extends SQLiteOpenHelper{

    private static final String NOMBRE_BD = "BD_APP_EZ_REGRESSION";
    private static final int VERSION_BD = 1;
    //private static final String TABLA_REGION = "CREATE TABLE REGION(_id INTEGER PRIMARY KEY AUTOINCREMENT, _nombre TEXT);";
    //private static final String TABLA_CIUDAD = "CREATE TABLE CIUDAD(_id INTEGER PRIMARY KEY AUTOINCREMENT, _nombre TEXT, _fkRegion INT, FOREIGN KEY (_fkRegion) REFERENCES REGION (_id));";
    //private static final String TABLA_BIBLIOTECA = "CREATE TABLE BIBLIOTECA(_id INTEGER PRIMARY KEY AUTOINCREMENT, _nombre TEXT, _direccion TEXT, _telefono TEXT, _sitioWeb TEXT, _esPublica INT, _fkCiudad BOOLEAN, _latitud REAL, _longitud REAL, FOREIGN KEY (_fkCiudad) REFERENCES CIUDAD (_id));";

    public Data(@Nullable Context context) {
        super(context, NOMBRE_BD, null, VERSION_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

       // db.execSQL(TABLA_REGION);

    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        System.out.println("Upgrade");
    }



}
