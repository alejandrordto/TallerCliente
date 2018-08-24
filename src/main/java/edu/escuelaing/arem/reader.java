package edu.escuelaing.arem;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class reader {

    private static ArrayList<String> list;
public static void main(String[] args) throws Exception {
    list=new ArrayList<String>();
    System.out.println("ingrese un URL");
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();
    URL google = new URL(input);
    try (BufferedReader reader =
        new BufferedReader(new InputStreamReader(google.openStream()))) {
    String inputLine = null;
    while ((inputLine = reader.readLine()) != null) {
        System.out.println(inputLine);
        
    }
    FileWriter fw = new FileWriter("/");
    BufferedWriter bw = new BufferedWriter(fw);
    
    bw.write(contenido);
    bw.close();
    } catch (IOException x) {
        System.err.println(x);
    }
    }
}