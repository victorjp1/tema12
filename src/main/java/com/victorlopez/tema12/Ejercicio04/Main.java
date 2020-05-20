package com.victorlopez.tema12.Ejercicio04;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static final String PATH = File.separator + "home" + File.separator + "victor" + File.separator + "tema12";
    public static void main(String[] args) {
        File f = new File(PATH, "prueba1.txt");
        System.out.println("Nombre del archivo:");
        System.out.println(f.getName());
        System.out.println("Ruta absoluta del fichero");
        System.out.println(f.getAbsolutePath());
        if (f.isHidden()){
            System.out.println("El fichero es oculto");
        }else {
            System.out.println("El fichero es visible");
        }
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
        long sizeBytes = f.length();
        Long tiempoMod = f.lastModified();
        String pattern = "yyyy-MM-dd hh:mm aa";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date fechaModificacion = new Date(tiempoMod );
        System.out.println( "El fichero fue modificado por última vez el " + simpleDateFormat.format(fechaModificacion));
        System.out.println("El fichero ocupa " + sizeBytes + " bytes");
        System.out.println("El fichero ocupa " + (float)sizeBytes/1024 + " MB");
        System.out.println("El fichero ocupa " + (float)sizeBytes*1024 + " KB");

    }
}
