package com.arandastock001.ezregre;

import java.util.ArrayList;
import java.util.List;

public class CalculadorDeRegresion {
    

    private ArrayList<Integer> columnaX;
    private ArrayList<Integer> columnaY;

    public CalculadorDeRegresion(ArrayList<Integer> columnaX, ArrayList<Integer> columnaY) {
        this.columnaX = columnaX;
        this.columnaY = columnaY;
    }

    public ArrayList<Integer> getColumnaX() {
        return columnaX;
    }

    public void setColumnaX(ArrayList<Integer> columnaX) {
        this.columnaX = columnaX;
    }

    public ArrayList<Integer> getColumnaY() {
        return columnaY;
    }

    public void setColumnaY(ArrayList<Integer> columnaY) {
        this.columnaY = columnaY;
    }

    public List<Integer> calcularColumnaX2(){
        List<Integer> columnaX2 = new ArrayList<>();

        for (Integer numero: this.getColumnaX()){
            columnaX2.add(numero*numero);
        }

        return columnaX2;

    }

    public List<Integer> calcularColumnaY2(){
        List<Integer> columnaY2 = new ArrayList<>();

        for(Integer numero : this.getColumnaY()){
            columnaY2.add(numero*numero);
        }

        return columnaY2;
    }

    public List<Integer> calcularColumnaXY (){
        List<Integer> columnaXY = new ArrayList<>();

        Integer numero = 0;

        for (int i = 0; i < columnaX.size(); i++) {
            numero = getColumnaX().get(i)*getColumnaY().get(i);
            columnaXY.add(numero);
        }

        return columnaXY;
    }


    public Integer calcularSumaDeTodasLasX (){
        Integer suma = 0;
        System.out.println(this.getColumnaX().toString());

        for (Integer i: this.getColumnaX()) {
            suma = suma + i;
        }
        return suma;
    }

    public Integer calcularSumaDeTodasLasY (){
        Integer suma = 0;
        System.out.println(this.getColumnaY().toString());
        for (Integer i: this.getColumnaY()) {
            suma = suma + i;

        }

        return suma;
    }

    public Integer calcularSumaDeTodasLasXY(){
        Integer suma = 0;
        for (Integer i: this.calcularColumnaXY()) {
            suma = suma +i;
        }


        return suma;
    }


    public Integer calcularSumaDeTodasLasXCuadrado (){
        Integer suma = 0;
        for (Integer i: this.calcularColumnaX2()) {
            suma = suma +i;
        }

        return suma;
    }

    public Integer calcularSumaDeTodasLasYCuadrado (){
        Integer suma = 0;
        for (Integer i: this.calcularColumnaY2()) {
            suma = suma +i;
        }

        return suma;
    }











}
