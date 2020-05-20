package com.victorlopez.tema12.Ejercicio05;

import java.io.File;


public class Main {
    public static final String PATH = File.separator + "home" + File.separator + "victor" + File.separator + "tema12";
    public static void main(String[] args) {
        boolean creado = GestionArchivos.crearArchivo(PATH, "pruebaEjer5.txt");
        if (creado){
            System.out.println("El fichero se ha creado correctamente");
        }else {
            System.out.println("El fichero no se ha podido crear, revisa el nombre y la ruta");
        }
        GestionArchivos.listarDirectorio(PATH + File.separator + "lenguaje de marcas");
        GestionArchivos.verInfo(PATH, "lenguaje de marcas");
    }
}
