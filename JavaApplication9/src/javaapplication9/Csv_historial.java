package javaapplication9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import EDD.ArbolB;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author AntonioOlveira
 */
public class Csv_historial {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArbolB database = new ArbolB();
        String file = "C:\\Users\\olvei\\Downloads\\Booking_hotel - Historico.csv";
        String line;
        boolean isFirstLine = true;
        
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((line = br.readLine()) != null) {
               
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                String[] data = line.split(",");

                String ci = data[0];
                String primerNombre = data[1];
                String apellido = data[2];
                String email = data[3];
                String genero = data[4];
                String llegada = data[5];
                int habitacion = Integer.parseInt(data[6]);
                
                Historial historial = new Historial(ci, primerNombre, apellido, email, genero, llegada, habitacion);
                database.simpleinsert(historial.getHabitacion(), historial.getNombre(), historial.getApellido());
            }
        } catch (IOException e) {
            e.printStackTrace();
            
        }
        //prueba temporal
//        NodoABB finds = database.search(277);
//        
//        finds.printnames(finds);
    }
}
