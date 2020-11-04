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
    private static final String TABLA_REGISTRO = "CREATE TABLE REGISTRO(_id INTEGER PRIMARY KEY AUTOINCREMENT, _valoresColumnaX TEXT, _valoresColumnaY TEXT, _fechaRegistro DATE);";


    public Data(@Nullable Context context) {
        super(context, NOMBRE_BD, null, VERSION_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(TABLA_REGISTRO);

    }



    public void insertarRegistro(Registro r){
        SQLiteDatabase bd = getWritableDatabase();

        if (bd != null){
            String query="INSERT INTO REGISTRO VALUES (NULL, '"+r.getValoresColumnaX()+"' ,'"+r.getValoresColumnaY()+"', '"+r.getFechaRegistro()+"');";
            bd.execSQL(query);

            System.out.println(query);
        }else{
            System.out.println("No existe bd");
        }
        bd.close();
    }



    public List<Registro> getRegistros(){
        List<Registro> registros = new ArrayList<>();

        SQLiteDatabase bd = getReadableDatabase();
        Cursor leer = bd.rawQuery("SELECT * FROM REGISTRO; ",null);

        Registro r;
        while(leer.moveToNext()){
            r = new Registro();
            r.setId(leer.getInt(0));
            r.setValoresColumnaX(leer.getString(1));
            r.setValoresColumnaY(leer.getString(2));
            r.setFechaRegistro(leer.getString(3));

            registros.add(r);

        }

        bd.close();

        return registros;
    }








    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        System.out.println("Upgrade");
    }



}
