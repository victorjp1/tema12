package com.victorlopez.tema12.Ejercicio13;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        String path = "/home/victor/tema12/primos.txt";
        final int nPrimos = 50;
        int contador = 0;
        String linea;
        int ultimo = 1;
        BufferedWriter bw = null;
        BufferedReader br = null;
        BufferedWriter bwAux = null;
        File fAux = null;
        File f = new File(path);
        try{
            bw = new BufferedWriter(new FileWriter(f));
            if (f.exists()){
                try {
                    br = new BufferedReader(new FileReader(f));
                    fAux = new File(path + "Aux");
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
                escribirPrimos(nPrimos,contador, bw);
            }
        }catch (IOException ioe){
            ioe.printStackTrace();
        }finally {
            try {
                if (bw != null)
                    bw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            try {
                if (br != null)
                    br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            try {
                if (bwAux != null)
                    bwAux.close();
                if (fAux != null)
                    fAux.renameTo(f);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * Este método calcula n Números primos, empezando por contador +1
     * @param nPrimos Número de primos a calcular
     * @param contador Número desde el cual empezar (el siguiente a este)
     * @param bwAux Archivo a escribir
     */
    public static void escribirPrimos(int nPrimos, int contador, BufferedWriter bwAux){
        String escribir;
        contador++;
        while (nPrimos >= 1){
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
            contador++;
        }
    }
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
