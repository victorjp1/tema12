package com.victorlopez.tema12.Ejercicio01;

import java.io.File;

public class Ejercicio01 {
    public static final String PATH = File.separator + "home" + File.separator + "victor" + File.separator + "tema12";
    public static void main(String[] args) {
        File f = new File(PATH);
        if (f.exists()){
            System.out.println("Existe");
        }else{
            System.out.println("No existe");
        }
        if (f.isDirectory()){
            System.out.println("Es un directorio");
        }else{
            System.out.println("No es un directorio");
        }
        System.out.println(f.getAbsolutePath());
    }
}
