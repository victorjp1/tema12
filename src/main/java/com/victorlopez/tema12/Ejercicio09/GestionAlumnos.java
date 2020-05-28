package com.victorlopez.tema12.Ejercicio09;

import java.io.*;

public class GestionAlumnos {
    private String path;

    public GestionAlumnos(String path) {
        this.path = path;
    }
    public void insertarAlumnos(String... alumnos){
        BufferedWriter bw = null;
        try{
            bw = new BufferedWriter(new FileWriter(path));
            for (int i = 0; i < alumnos.length; i++) {
                bw.write(alumnos[i] + "\n");
            }
            bw.flush();
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
        }
    }

    public String getPath() {
        return path;
    }

    public boolean eliminarAlumno(String nombre){
        String linea;
        boolean encontrado = false;
        File fichero;
        File ficheroTemporal;
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            fichero = new File(path);
            ficheroTemporal = new File(path + "temporal");
            br = new BufferedReader(new FileReader(fichero));
            bw = new BufferedWriter(new FileWriter(ficheroTemporal));
            while ((linea = br.readLine()) != null){
                if (linea.equalsIgnoreCase(nombre)){
                    encontrado = true;
                }else{
                    bw.write((linea + "\n"));
                }
            }
            bw.flush();
            if (ficheroTemporal != null){
                ficheroTemporal.renameTo(fichero);
            }
        }catch (IOException ioe){
            ioe.printStackTrace();
        }finally {
            if (bw != null){
                try {
                    bw.close();
                }catch (IOException ioe){
                    ioe.printStackTrace();
                }
            }
            if (br != null){
                try {
                    br.close();
                }catch (IOException ioe){
                    ioe.printStackTrace();
                }
            }
        }
        return encontrado;
    }
}
