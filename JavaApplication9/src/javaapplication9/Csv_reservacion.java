/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication9;

import EDD.ArbolB;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import EDD.NodoABB;

/**
 *
 * @author AntonioOlveira
 */
public class Csv_reservacion {
    /**
     * @param args the command line arguments
     */
    public class reservacion{
        
    }
    
    public static void main(String[] args) {
        ArbolB database2 = new ArbolB();
        String file = "C:\\Users\\olvei\\Downloads\\Booking_hotel - reservas.csv";
        String line;
        boolean isFirstLine = true;
        
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((line = br.readLine()) != null) {
               
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                String[] data = line.split(",");
                try{
                    String[] strci = data[0].split(",");
                String strci2= "";
                for (String n : strci) {
                    strci2 += n;
                }
                int ci = Integer.parseInt(strci2);
                String nombre = data[1];
                String apellido = data[2];
                String correo = data[3];
                String genero = data[4];
                String tipo_hab = data[5];
                String celular = data[6];
                String llegada = data[7];
                String salida = data[8];
                database2.complexinsert(ci, nombre, apellido, correo, genero, tipo_hab, celular, llegada, salida);
                
                }catch (Exception e){
                    String[] strci = data[0].split("\\.");
                    String strci2= "";
                    for (String n : strci) {
                        strci2 += n;
                    }
                    int ci = Integer.parseInt(strci2);
                    
                    String nombre = data[1];
                    String apellido = data[2];
                    String correo = data[3];
                    String genero = data[4];
                    String tipo_hab = data[5];
                    String celular = data[6];
                    String llegada = data[7];
                    String salida = data[8];
                database2.complexinsert(ci, nombre, apellido, correo, genero, tipo_hab, celular, llegada, salida);
                }
                
                
                
               
                
            }
        } catch (Exception e) {
            e.printStackTrace();
            
        }
        //prueba temporal
//        NodoABB finds = database2.search(19783261);
//        
//        finds.printinfo(finds);
    }
}
