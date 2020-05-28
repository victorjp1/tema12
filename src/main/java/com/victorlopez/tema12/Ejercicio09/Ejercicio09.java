package com.victorlopez.tema12.Ejercicio09;

import com.victorlopez.tema12.Ejercicio05.GestionArchivos;

public class Ejercicio09 {
    public static void main(String[] args) {
        GestionAlumnos ga = new GestionAlumnos("/home/victor/tema12/prueba1.txt");
        ga.insertarAlumnos("Ruben", "Arturo", "Luis");
        GestionArchivos.mostrarArchivo(ga.getPath());
        ga.eliminarAlumno("Arturo");
        GestionArchivos.mostrarArchivo(ga.getPath());
    }
}
