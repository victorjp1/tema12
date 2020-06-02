package com.victorlopez.tema12.Ejercicio12;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        operacionesDNI("/home/victor/tema12/prueba1.txt");
    }
    public static void operacionesDNI(String path){
        String linea = "";
        int dni;
        BufferedWriter bw = null;
        BufferedReader br = null;
        File f = new File(path);
        File f2 = new File(path + "_conLetras");
        if (!f.exists()){
            System.out.println("El fichero no se ha encontrado...");
        }
        try{
            bw = new BufferedWriter(new FileWriter(f2));
            br = new BufferedReader(new FileReader(f));
            while ((linea = br.readLine()) != null) {
                if (linea.length() < 8){
                    dni = Integer.valueOf(linea);
                    linea = String.format("%08d", dni);
                    linea += obtenerLetraDNI(dni);
                    bw.write(linea);
                    bw.newLine();
                }
            }
        }catch (FileNotFoundException fnfe){
            fnfe.printStackTrace();
        }catch (IOException ioe){
            ioe.printStackTrace();
        }finally {
            if (bw != null){
                try{
                    bw.close();
                }catch (IOException ioe){
                    ioe.printStackTrace();
                }
            }
            if (br != null){
                try{
                    br.close();
                }catch (IOException ioe){
                    ioe.printStackTrace();
                }
            }
        }

    }
    /**
     * Obtener la letra correspondiente del dni
     * @param dni dni a valorar
     * @return letra correcta de deni
     */
    public static char obtenerLetraDNI(int dni) {
        String tabla = "TRWAGMYFPDXBNJZSQVHLCKE";
        return tabla.charAt(dni % 23);
    }
}
