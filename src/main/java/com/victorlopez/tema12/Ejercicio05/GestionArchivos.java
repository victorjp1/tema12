package com.victorlopez.tema12.Ejercicio05;

import java.io.*;
import java.util.HashMap;

public class GestionArchivos {
    private static HashMap<Byte, Character> binarioHexadecimal;
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
        int numCaracter;
        boolean fin = false;
        try{
            FileReader fr = new FileReader(directorio + File.separator + archivo);
            System.out.println("Contenido del fichero " + archivo + ":");
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
            fr.close();
        }catch (IOException ieo){
            System.out.println("No se ha encontrado el fichero");
        }
    }
    private static void rellenarHashmap(){
        binarioHexadecimal = new HashMap<>();
        byte b1 = (byte)0000;
        byte b2 = (byte)0001;
        byte b3 = (byte)0010;
        byte b4 = (byte)0011;
        byte b5 = (byte)0100;
        byte b6 = (byte)0101;
        byte b7 = (byte)0111;
        byte b8 = (byte)1000;
        byte b9 = (byte) 1001;
        byte b10 = (byte)1010;
        byte b11 = (byte)1011;
        byte b12 = (byte)1100;
        byte b13 = (byte)1101;
        byte b14 = (byte)1110;
        byte b15 = (byte)1111;
        binarioHexadecimal.put(b1, '0');
        binarioHexadecimal.put(b2, '1');
        binarioHexadecimal.put(b3, '2');
        binarioHexadecimal.put(b4, '3');
        binarioHexadecimal.put(b5, '4');
        binarioHexadecimal.put(b6, '5');
        binarioHexadecimal.put(b7, '6');
        binarioHexadecimal.put(b8, '7');
        binarioHexadecimal.put(b9, '8');
        binarioHexadecimal.put(b10, '9');
        binarioHexadecimal.put(b11, 'A');
        binarioHexadecimal.put(b12, 'B');
        binarioHexadecimal.put(b13, 'C');
        binarioHexadecimal.put(b14, 'D');
        binarioHexadecimal.put(b15, 'E');
    }
    /**
     * Método para leer un el contenido de un fichero binario
     * en formato hexadecimal agrupados en grupos de 2
     * @param directorio directorio en el que se encuentra
     * @param archivo archivo a leer
     */
    public static void mostrarArchivoHexadecimal(String directorio, String archivo){
        int numsCaracter;
        boolean fin = false;
        String hexadecimal = "";
        rellenarHashmap();
        try {
            FileInputStream fr = new FileInputStream(directorio + File.separator + archivo);
            byte[] bytes = new byte[4];
            try {
                numsCaracter = fr.read(bytes);
                hexadecimal += binarioHexadecimal.get(numsCaracter);
                System.out.printf(hexadecimal);
            }catch (IOException ioe){
                System.out.println("No se ha podido leer");
            }
        }catch(FileNotFoundException fnfe){
            System.out.println("Fichero no encontrado");
        }
    }
    private static char convertirBinarioHexacedimal(int numsCaracter){
        String digitosHexa = "0123456789ABCDEF";
        char hexadecimal = ' ';
        int contador = 1000;
        for (int i = 0; i < digitosHexa.length(); i++) {
            if (numsCaracter == contador){
                hexadecimal = digitosHexa.charAt(i);
            }
            contador++;
        }
        return hexadecimal;
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
