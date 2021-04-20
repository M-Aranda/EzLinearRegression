package com.arandastock001.EzLinearRegression.Modelo;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Registro {

    private Integer id;
    private String valoresColumnaX;
    private String valoresColumnaY;
    private String fechaRegistro;

    public Registro() {

    }


    public Registro(Integer id, String valoresColumnaX, String valoresColumnaY, String fechaRegistro) {
        this.id = id;
        this.valoresColumnaX = valoresColumnaX;
        this.valoresColumnaY = valoresColumnaY;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValoresColumnaX() {
        return valoresColumnaX;
    }

    public void setValoresColumnaX(String valoresColumnaX) {
        this.valoresColumnaX = valoresColumnaX;
    }

    public String getValoresColumnaY() {
        return valoresColumnaY;
    }

    public void setValoresColumnaY(String valoresColumnaY) {
        this.valoresColumnaY = valoresColumnaY;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }


    @Override
    public String toString() {



        return "Registro realizado el " + fechaRegistro ;
    }
}

