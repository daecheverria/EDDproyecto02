/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package EDD;

import EDD.Cliente;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author danie
 */
public class Csv_prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String csvFile = "C:\\Users\\danie\\Downloads\\Booking_hotel - reservas.csv";
        String line;
        boolean isFirstLine = true;
        
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
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
                String habitacion = data[6];
                String celular = null;
                String salida = null;
                Cliente cliente = new Cliente(ci, primerNombre, apellido, email, genero, habitacion, celular, llegada, salida);
//                System.out.println(cliente.getApellido());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
