package com.victorlopez.tema12.Ejercicio05;

import java.io.*;
import java.util.HashMap;

public class GestionArchivos {
    private static HashMap<String, Character> binarioHexadecimal;
    public GestionArchivos() {
        //No interesa crear instancias!!
    }

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
        File[] f2 = f.listFiles();
        for (int i = 0; i < f2.length; i++) {
            String aux = "";
            aux += f2[i].getName();
            if (f2[i].isDirectory()){
                aux += "    d   ";
            }else{
                aux += "    f   ";
            }
            long size = f2[i].length();
            aux += size + " bytes   ";
            if (f2[i].canRead())
                aux += "r";
            if (f2[i].canWrite())
                aux += "w";
            if (f2[i].canExecute()){
                aux += "x";
            }
            System.out.println(aux);
        }
    }

    /**
     * Método para leer un el contenido de un fichero de texto
     * @param directorio directorio en el que se encuentra
     * @param archivo archivo a leer
     */
    public static void mostrarArchivo(String directorio, String archivo){
        mostrarArchivo(directorio + archivo);
    }
    /**
     * Método para leer un el contenido de un fichero de texto
     * @param ruta ruta del fichero
     */
    public static void mostrarArchivo(String ruta){
        int numCaracter;
        boolean fin = false;
        FileReader fr = null;
        try{
            fr = new FileReader(ruta);
            System.out.println("Contenido del fichero " + ruta + ":");
            do{
                numCaracter = fr.read();
                if (numCaracter == -1){
                    fin = true;
                    System.out.println("Cerrando el fichero...");
                }else{
                    System.out.print((char)numCaracter);
                }
            }while (!fin);
            System.out.println();
        }catch (IOException ieo){
            System.out.println("No se ha encontrado el fichero");
        }finally {
            try{
                if (fr != null){
                    fr.close();
                }
            }catch (IOException ioe){
            }
        }
    }
    /**
     * Método para leer un el contenido de un fichero binario
     * en formato hexadecimal agrupados en grupos de 2
     * @param directorio directorio en el que se encuentra
     * @param archivo archivo a leer
     */
    public static void mostrarArchivoHexadecimal(String directorio, String archivo){
        int numByte;
        FileInputStream fr = null;
        boolean fin = false;
        int contador = 0;
        String hexadecimal;
        try {
            fr = new FileInputStream(directorio + File.separator + archivo);
                do {
                    if (fr.available() >= 1){
                        contador++;
                        numByte = fr.read();
                        hexadecimal = String.format("%-02X ", numByte);
                        System.out.printf(hexadecimal);
                        if (contador == 22){
                            contador = 0;
                            System.out.println();
                        }
                    }else{
                        System.out.println("\nCerrando fichero...");
                        fin = true;
                    }
                }while (!fin);
        }catch (FileNotFoundException fnfe){
                System.out.println("No se ha podido leer");
                fnfe.printStackTrace();
        } catch(IOException ioe) {
            System.out.println("Fichero no encontrado");
            ioe.printStackTrace();
        }finally {
            if (fr != null){
                try{
                    fr.close();
                }catch (IOException ioe){
                    ioe.printStackTrace();
                }
            }
        }
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
