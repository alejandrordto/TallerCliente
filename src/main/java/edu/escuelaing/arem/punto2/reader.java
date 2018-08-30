package edu.escuelaing.arem.punto2;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class reader {

    private static ArrayList<String> list;

    public static void main(String[] args) throws Exception {
        list = new ArrayList<String>();
        System.out.println("ingrese un URL");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println("ingrese un donde guardara su archivo, Encontrara un archivo llamado resultado donde decida guardarlo.");
        String direccion = br.readLine();
        direccion=direccion +"/resultado.html";
        URL google = new URL(input);
        try (BufferedReader reader
                = new BufferedReader(new InputStreamReader(google.openStream()))) {
            String inputLine = null;
            while ((inputLine = reader.readLine()) != null) {
                list.add(inputLine);
            }
            File archivo = new File(direccion);
            if (!archivo.exists()) {
                FileWriter fw = new FileWriter(archivo);
                BufferedWriter bw = new BufferedWriter(fw);
                for (String i : list) {
                    bw.write(i);
                }
                bw.close();
            } else {
                System.out.println("El archivo ingresado no es valido o ya existe.");
            }

        } catch (IOException x) {
            System.err.println(x);
        }
    }
}
