package com.victorlopez.tema12.Ejercicio02;

import java.io.File;
public class Ejercicio02 {
    public static final String PATH = File.separator + "home" + File.separator + "victor" + File.separator + "tema12";
    public static void main(String[] args) {
        File f = new File(PATH);
        String[] contenido = f.list();
        for (int i = 0; i < contenido.length; i++) {
            System.out.println(contenido[i]);
        }
    }
}
