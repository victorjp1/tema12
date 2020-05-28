package com.victorlopez.tema12.Ejercicio08;

import com.victorlopez.tema12.Ejercicio05.GestionArchivos;

public class Ejercicio08 {
    public static void main(String[] args) {
        if (args.length >= 1){
            GestionArchivos.mostrarArchivo(args[0]);
        }else {
            System.out.println("Añade una ruta como parámetro");
        }
    }
}
