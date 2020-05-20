package com.victorlopez.tema12.Ejercicio03;

import java.io.File;

// 3. Obtén las siguientes propiedades de la carpeta del ejercicio:
// a) El nombre de la carpeta
// b) La ruta absoluta
// c) Si se puede leer
// d) Si se puede escribir
public class Main {
    public static final String PATH = File.separator + "home" + File.separator + "victor" + File.separator + "tema12";
    public static void main(String[] args) {
        File f = new File(PATH);
        System.out.println("Nombre de la carpeta:");
        System.out.println(f.getName());
        System.out.println("Ruta absoluta de la carpeta:");
        System.out.println(f.getAbsolutePath());
        if (f.canRead()){
            System.out.println("Podemos leer en esta carpeta");
        }else{
            System.out.println("No podemos leer en esta carpeta");
        }
        if (f.canWrite()){
            System.out.println("Podemos escribir en esta carpeta");
        }else {
            System.out.println("No podemos escribir en esta carpeta");
        }
    }
}
