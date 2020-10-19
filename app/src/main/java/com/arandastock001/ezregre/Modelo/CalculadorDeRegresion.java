package com.arandastock001.ezregre.Modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CalculadorDeRegresion implements Serializable {
    

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


    public Double calcularPendiente(){


       Double resultado = Double.valueOf(((this.getColumnaX().size())*(this.calcularSumaDeTodasLasXY()) - (this.calcularSumaDeTodasLasX()*this.calcularSumaDeTodasLasY())))/(this.getColumnaX().size()*this.calcularSumaDeTodasLasXCuadrado() -(this.calcularSumaDeTodasLasX()*this.calcularSumaDeTodasLasX()));
        System.out.println("El decimal es "+resultado.toString());
        return resultado;


    }


    public Double calcularInterseccion(){


        Double resultado = Double.valueOf((this.calcularSumaDeTodasLasY()-(calcularPendiente()*this.calcularSumaDeTodasLasX())))/this.getColumnaX().size();
        System.out.println("El decimal es "+resultado.toString());

        return resultado;
    }

    public String mostrarResultadosbreves(){
        String texto = "La suma de todas las X es: "+this.calcularSumaDeTodasLasX().toString()+"\n"+
                "La suma de todas las Y es: "+this.calcularSumaDeTodasLasY().toString()+"\n"+
                "La suma de todas las X2 es: "+this.calcularSumaDeTodasLasXCuadrado().toString()+"\n"+
                "La suma de todas las Y2 es: "+this.calcularSumaDeTodasLasYCuadrado().toString()+"\n"+
                "La suma de todas las XY es: "+this.calcularSumaDeTodasLasXY().toString()+"\n";

        return texto;
    }

    public String mostrarPasoAPaso(){

        String pasos ="";

        //Resultados de columna X
     String pasosX = "1) Primero se suman todos los valores de la columa X (";
        for (int i = 0; i < this.getColumnaX().size(); i++) {
            if (i<this.getColumnaX().size()-1){
                pasosX.concat(this.getColumnaX().get(i).toString()+" + ");
            }else{
                pasosX.concat(this.getColumnaX().get(i).toString()+")\n");
            }
        }
        String resultadoSumaX = "Esta suma da como resultado: "+this.calcularSumaDeTodasLasX().toString();
        pasosX.concat(resultadoSumaX);


        //Resultados de columna Y
        String pasosY = "2) Luego se suman todos los valores de la columna Y (";
        for (int i = 0; i < this.getColumnaX().size(); i++) {
            if (i<this.getColumnaX().size()-1){
                pasosY.concat(this.getColumnaX().get(i).toString()+" + ");
            }else{
                pasosY.concat(this.getColumnaX().get(i).toString()+")\n");
            }
        }
        String resultadoSumaY = "Esta suma da como resultado: "+this.calcularSumaDeTodasLasY().toString();
        pasosY.concat(resultadoSumaY);


        //Resultados de columna X al cuadrado
        String pasosX2 = "3) Después se elevan al cuadrado todos los valores de la columna X para obtener los valores de la columna X2 (";
        for (int i = 0; i < this.getColumnaX().size(); i++) {
            if (i<this.getColumnaX().size()-1){
                pasosX2.concat(this.getColumnaX().get(i).toString()+" * "+this.getColumnaX().get(i).toString());
            }else{
                pasosX2.concat(this.getColumnaX().get(i).toString()+" * "+this.getColumnaX().get(i).toString() +")\n");
            }
        }

        String pasosX2Continuacion =  "La suma de dichos valores quedaría como =";
        for (int i = 0; i < this.getColumnaX().size(); i++) {
            if (i<this.getColumnaX().size()-1){
                pasosX2Continuacion.concat(this.calcularColumnaX2().get(i).toString()+" + ");
            }else{
                pasosX2Continuacion.concat(this.calcularColumnaX2().get(i).toString()+")\n");
            }
        }
        String resultadoSumaX2 = "Dando como resultado: "+this.calcularSumaDeTodasLasXCuadrado().toString();
        pasosX2.concat(pasosX2Continuacion);
        pasosX2.concat(resultadoSumaX2);


        //Resultados de columna Y al cuadrado
        String pasosY2 = "4) Después se elevan al cuadrado todos los valores de la columna Y para obtener los valores de la columna Y2 (";
        for (int i = 0; i < this.getColumnaY().size(); i++) {
            if (i<this.getColumnaY().size()-1){
                pasosY2.concat(this.getColumnaY().get(i).toString()+" * "+this.getColumnaY().get(i).toString());
            }else{
                pasosY2.concat(this.getColumnaY().get(i).toString()+" * "+this.getColumnaY().get(i).toString() +")\n");
            }
        }

        String pasosY2Continuacion =  "La suma de dichos valores quedaría como =";
        for (int i = 0; i < this.getColumnaX().size(); i++) {
            if (i<this.calcularColumnaY2().size()-1){
                pasosX2Continuacion.concat(this.calcularColumnaY2().get(i).toString()+" + ");
            }else{
                pasosY2Continuacion.concat(this.calcularColumnaY2().get(i).toString()+")\n");
            }
        }
        String resultadoSumaY2 = "Dando como resultado: "+this.calcularSumaDeTodasLasYCuadrado().toString();
        pasosX2.concat(pasosY2Continuacion);
        pasosX2.concat(resultadoSumaY2);


        //Resultados de columna XY
        String pasosXY = "5) Después se multiplican todos los valores de la columna X por todos los valores de la columna Y, para obtener la columna XY (";
        for (int i = 0; i < this.getColumnaY().size(); i++) {
            if (i<this.getColumnaY().size()-1){
                pasosXY.concat(this.getColumnaX().get(i).toString()+" * "+this.getColumnaY().get(i).toString());
            }else{
                pasosXY.concat(this.getColumnaX().get(i).toString()+" * "+this.getColumnaY().get(i).toString() +")\n");
            }
        }

        String pasosXYContinuacion =  "La suma de dichos valores quedaría como =";
        for (int i = 0; i < this.getColumnaX().size(); i++) {
            if (i<this.calcularColumnaY2().size()-1){
                pasosXYContinuacion.concat(this.getColumnaX().get(i).toString()+" + "+this.getColumnaY().get(i)+" + ");
            }else{
                pasosXYContinuacion.concat(this.getColumnaX().get(i).toString()+this.getColumnaY().get(i)+")\n");
            }
        }
        String resultadoSumaXY = "Dando como resultado: "+this.calcularSumaDeTodasLasXY().toString();
        pasosXY.concat(pasosXYContinuacion);
        pasosXY.concat(resultadoSumaXY);



        // Calculos para pendiente
        String pasosPendiente = "6) Ahora, para calcular la pendiente se multiplica la cantidad de numeros en la columna X ("+this.getColumnaX().size()+") por la suma de todos los valores en la columna XY ("+this.calcularSumaDeTodasLasXY().toString()+")\n menos el resultado de" +
                "la suma de todas las X("+this.calcularSumaDeTodasLasX().toString()+") por la suma de todas las Y("+this.calcularSumaDeTodasLasY().toString()+")\n.Luego, todo eso se divide por la cantidad de numeros en la columna X ("+this.getColumnaX().size()+") por la suma de todas" +
                "las X al cuadrado ("+this.calcularSumaDeTodasLasXCuadrado().toString()+"),\n menos la suma de todas las X("+this.calcularSumaDeTodasLasX().toString()+"), al cuadrado ("+this.calcularSumaDeTodasLasX().toString()+" * "+this.calcularSumaDeTodasLasX().toString()+")";


        //Calculos para la interseccion
        String pasosInterseccion = "7) Para el calculo de la intersección, a la suma de todas las Y ("+this.calcularSumaDeTodasLasY().toString()+"), se le resta la pendiente ("+this.calcularPendiente().toString().toString()+") por la suma de todas las X("+this.calcularSumaDeTodasLasX()+") y al resultado se le divide por" +
                "la cantidad de valores en la columna X ("+this.getColumnaX().size()+")";


        pasos.concat(pasosX);
        pasos.concat("\n");
        pasos.concat(pasosY);
        pasos.concat("\n");
        pasos.concat(pasosX2);
        pasos.concat("\n");
        pasos.concat(pasosY2);
        pasos.concat("\n");
        pasos.concat(pasosXY);
        pasos.concat("\n");
        pasos.concat(pasosPendiente);
        pasos.concat("\n");
        pasos.concat(pasosInterseccion);




        return pasos;
    }










}
