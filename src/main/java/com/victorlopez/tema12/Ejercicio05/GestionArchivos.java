package com.victorlopez.tema12.Ejercicio05;

import java.io.File;
import java.io.IOException;

public class GestionArchivos {
    /**
     * Método para crear un archivo
     * @param directorio directorio en el que crearlo
     * @param archivo nombre del archivo
     * @return true si se ha podido crear, false si no.
     */
    public static boolean crearArchivo(String directorio, String archivo) {
        File f = new File(directorio, archivo);
        try {
            f.createNewFile();
            return true;
        }catch (IOException ioe){
            return false;
        }
    }

    /**
     * Método para listar un directorio
     * @param directorio directorio que mirar
     */
    public static void listarDirectorio(String directorio){
        File f = new File(directorio);
        String aux = "";
        aux += f.getName();
        if (f.isDirectory()){
            aux += "    d   ";
        }else{
            aux += "    f   ";
        }
        long size = f.length();
        aux += size + " bytes   ";
        if (f.canRead())
            aux += "r";
        if (f.canWrite())
            aux += "w";
        if (f.canExecute()){
            aux += "x";
        }
        System.out.println(aux);
    }

    /**
     * Método para leer un el contenido de un fichero de texto
     * @param directorio directorio en el que se encuentra
     * @param archivo archivo a leer
     */
    public static void mostrarArchivo(String directorio, String archivo){
        File f = new File(directorio, archivo);

    }
    /**
     * visualizará el nombre, la ruta absoluta, si se
     * puede escribir, si se puede leer, el tamaño, si es un directorio y si es un archivo.
     * @param directorio ruta
     * @param archivo fichero al cual acceder
     */
    public static void verInfo(String directorio, String archivo){
        String aux = "";
        File f = new File(directorio, archivo);
        System.out.println("Nombre del archivo:");
        System.out.println(f.getName());
        System.out.println("Ruta absoluta:");
        System.out.println(f.getAbsolutePath());
        System.out.println("Tamaño del fichero:");
        System.out.println(f.length() + " bytes");
        if (f.isDirectory()){
            System.out.println("Es un directorio");
        }else{
            System.out.println("Es un fichero");
        }
        System.out.println("Permisos fichero:");
        if (f.canRead())
            aux += "r";
        if (f.canWrite())
            aux += "w";
        if (f.canExecute()){
            aux += "x";
        }
        System.out.println(aux);
    }
}
