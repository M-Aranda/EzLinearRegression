package com.arandastock001.EzLinearRegression.Modelo;

import android.graphics.Color;

import androidx.constraintlayout.widget.ConstraintLayout;

public class ControladorDeColores {

    private Integer codigoColor;
    private ConstraintLayout objetoConstraint;
    private static ControladorDeColores instance = new ControladorDeColores();


    public ControladorDeColores() {
    }


    public Integer getCodigoColor() {
        return codigoColor;
    }

    public void setCodigoColor(Integer codigoColor) {
        this.codigoColor = codigoColor;
    }

    public ConstraintLayout getObjetoConstraint() {
        return objetoConstraint;
    }

    public void setObjetoConstraint(ConstraintLayout objetoConstraint) {
        this.objetoConstraint = objetoConstraint;
    }

    public static ControladorDeColores getInstance() {
        return instance;
    }

    public void cambiarColor (){

            switch(this.codigoColor){
                case 1:
                {
                    this.objetoConstraint.setBackgroundColor(Color.parseColor("#69D0F1"));
                    break;
                }
                case 2:
                {
                    this.objetoConstraint.setBackgroundColor(Color.parseColor("#F778E4"));
                    break;
                }
                case 3:
                {
                    this.objetoConstraint.setBackgroundColor(Color.parseColor("#FC9A2B"));
                    break;
                }
                default:
                    System.out.println("Ningun color seleccionado");
            }

    }


}
