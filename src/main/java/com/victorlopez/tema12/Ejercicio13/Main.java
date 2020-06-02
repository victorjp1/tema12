package com.victorlopez.tema12.Ejercicio13;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        String path = "/home/victor/tema12/primos.txt";
        final long nPrimos = 50;
        int contador = 0;
        String linea;
        int ultimo = 1;
        BufferedWriter bw = null;
        BufferedReader br = null;
        BufferedWriter bwAux = null;
        File fAux = null;
        File f = new File(path);
        try{
            if (f.exists()){
                try {
                    br = new BufferedReader(new FileReader(f));
                    fAux = new File(path + ".Aux");
                    bwAux = new BufferedWriter(new FileWriter(fAux));
                    while ((linea = br.readLine()) != null) {
                        try {
                            bwAux.write(linea);
                            bwAux.newLine();
                            ultimo= Integer.parseInt(linea);
                        }catch (NumberFormatException nfe){
                            System.out.println("Formato del fichero incorrecto");
                        }
                    }
                    escribirPrimos(nPrimos,ultimo, bwAux);
                }catch (FileNotFoundException fnfe){
                    fnfe.printStackTrace();
                }
            }else{
                bw = new BufferedWriter(new FileWriter(f));
                escribirPrimos(nPrimos,contador, bw);
            }
        }catch (IOException ioe){
            ioe.printStackTrace();
        }finally {
            cerrarBufferedWriter(bw);
            cerrarBufferedReader(br);
            cerrarBufferedWriter(bwAux);
            if (fAux != null)
                fAux.renameTo(f);
        }
        if (sonIguales(f, new File("/home/victor/tema12/prueba1.txt"))){
            System.out.println("Los ficheros son iguales");
        }else {
            System.out.println("Los ficheros son distintos");
        }
    }

    /**
     * Método para cerrar un BufferedReader, en caso de que exista
     * @param br BufferedReader a cerrar
     */
    public static void cerrarBufferedReader(BufferedReader br){
        try {
            if (br != null)
                br.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Método para cerrar un BufferedWriter, en caso de que exista
     * @param bw BufferedWriter a cerrar
     */
    public static void cerrarBufferedWriter(BufferedWriter bw){
        try {
            if (bw != null)
                bw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Método para saber si el contenido de dos ficheros es igual
     * @param f1 Fichero 1 a comprobar
     * @param f2 Fichero 2 a comprobar
     * @return si son iguales devuelve true, si son distintos devuelve false
     */
    public static boolean sonIguales(File f1, File f2){
        BufferedReader br1 = null;
        BufferedReader br2 = null;
        String linea1;
        if (!f1.exists() || !f2.exists())
            return false;
        try{
            br1 = new BufferedReader(new FileReader(f1));
            br2 = new BufferedReader(new FileReader(f2));
            while ((linea1 = br1.readLine()) != null){
                if (linea1 != br2.readLine()){
                    br1.close();
                    br2.close();
                    return false;
                }
            }
        }catch (IOException ioe){
            ioe.printStackTrace();
        }finally {
            cerrarBufferedReader(br1);
            cerrarBufferedReader(br2);
        }
        return true;
    }
    /**
     * Este método calcula n Números primos, empezando por contador +1
     * @param nPrimos Número de primos a calcular
     * @param contador Número desde el cual empezar (el siguiente a este)
     * @param bwAux Archivo a escribir
     */
    public static void escribirPrimos(long nPrimos, int contador, BufferedWriter bwAux){
        String escribir;
        while (nPrimos >= 1){
            contador++;
            if (esPrimo(contador)){
                nPrimos --;
                try{
                    escribir = String.valueOf(contador);
                    bwAux.write(escribir);
                    bwAux.newLine();
                }catch (IOException ioe){
                    ioe.printStackTrace();
                }
            }
        }
    }

    /**
     * Método que comprueba si un número es primo
     * @param numero Número a comprobar
     * @return true si es primo, false si no lo es
     */
    public static boolean esPrimo(int numero){
        int contador = 2;
        boolean primo=true;
        while ((primo) && (contador!=numero)){
            if (numero % contador == 0)
                primo = false;
            contador++;
        }
        return primo;
    }
}
