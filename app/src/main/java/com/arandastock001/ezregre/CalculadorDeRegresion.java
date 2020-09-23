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
            columnaX2.add(numero);
        }

        return columnaX2;

    }

    public List<Integer> calcularColumnaY2(){
        List<Integer> columnaY2 = new ArrayList<>();

        for(Integer numero : this.getColumnaY()){
            columnaY2.add(numero);
        }

        return columnaY2;
    }

    public List<Integer> calcularColumnaXPorY (){
        List<Integer> columnaXY = new ArrayList<>();

        for (Integer numero : this.getColumnaY()){
            columnaXY.add(numero);
        }

        return columnaXY;
    }







}
