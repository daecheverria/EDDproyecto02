/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author daniel
 */
public class TablaHabitaciones {
    private HashTable habitacionesTabla;
    public void CrearTablaHab() {
        String csvFile = "C:\\Users\\olvei\\Downloads\\Booking_hotel - habitaciones.csv";
        String line;
        boolean isFirstLine = true;
        habitacionesTabla = new HashTable();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                String[] data = line.split(",");

                String numeroHabitacion = data[0];
                String tipoHabitacion = data[1];
                String piso = data[2];
                Boolean ocupada = false;
                Habitacion habitacion = new Habitacion(numeroHabitacion, tipoHabitacion, piso, ocupada);
                habitacionesTabla.agregar(numeroHabitacion, habitacion);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Habitacion get(String numeroHabitacion) {
        return habitacionesTabla.get(numeroHabitacion);
    }

    public static class HashTable {

        private static int tamano = 300;
        private Elemento[] tabla;

        public HashTable() {
            tabla = new Elemento[tamano];
        }

        public void agregar(String key, Habitacion habitacion) {
            int hash = getHash(key);
            Elemento elemento = new Elemento(key, habitacion);

            if (tabla[hash] == null) {
                tabla[hash] = elemento;
            } else {
                Elemento actual = tabla[hash];

                while (actual.next != null) {
                    actual = actual.next;
                }

                actual.next = elemento;
            }
        }

        public Habitacion get(String key) {
            int hash = getHash(key);

            if (tabla[hash] != null) {
                Elemento actual = tabla[hash];

                while (actual != null) {
                    if (actual.key.equals(key)) {
                        return actual.habitacion;
                    }

                    actual = actual.next;
                }
            }

            return null;
        }

        private int getHash(String key) {
            int hash = key.hashCode() % tamano;
            return (hash < 0) ? hash + tamano : hash;
        }

        private class Elemento {

            private String key;
            private Habitacion habitacion;
            private Elemento next;

            public Elemento(String key, Habitacion habitacion) {
                this.key = key;
                this.habitacion = habitacion;
            }
        }
    }

}
