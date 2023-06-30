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
public class TablaRegistro {

    public static void main(String[] args) {
        TablaHabitaciones habitaciones = new TablaHabitaciones();
        habitaciones.CrearTablaHab();
        String csvFile = "C:\\Users\\olvei\\Downloads\\Booking_hotel - estado.csv";
        String line;
        boolean isFirstLine = true;
        HashTable registroTabla = new HashTable();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                String[] data = line.split(",");

                String numeroHabitacion = data[0];
                String nombre = data[1];
                String apellido = data[2];
                String email = data[3];
                String genero = data[4];
                String celular = data[5];
                String llegada = data[6];
                String salida = null;
                String cedula = null;

                if (numeroHabitacion != null && !numeroHabitacion.isEmpty()) {
                Habitacion habitacion = habitaciones.get(numeroHabitacion);
                
                if (habitacion != null && !habitacion.isOcupada()) {
                    habitacion.setOcupada(true);
                    Cliente cliente = new Cliente(cedula, nombre, apellido, email, genero, numeroHabitacion, celular, llegada, salida);
                    registroTabla.agregar(nombre, apellido, cliente);
                }

            }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class HashTable {

        private static int tamano = 300;
        private Elemento[] tabla;

        public HashTable() {
            tabla = new Elemento[tamano];
        }

        public void agregar(String nombre, String apellido, Cliente cliente) {
            int hash = getHash(nombre, apellido);
            Elemento elemento = new Elemento(nombre, apellido, cliente);

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

        public Cliente get(String nombre, String apellido) {
            int hash = getHash(nombre, apellido);

            if (tabla[hash] != null) {
                Elemento actual = tabla[hash];

                while (actual != null) {
                    if (actual.nombre.equals(nombre) && actual.apellido.equals(apellido)) {
                        return actual.cliente;
                    }

                    actual = actual.next;
                }
            }

            return null;
        }

        private int getHash(String nombre, String apellido) {
            int hash = (nombre + apellido).hashCode() % tamano;
            return (hash < 0) ? hash + tamano : hash;
        }

        private class Elemento {

            private String nombre;
            private String apellido;
            private Cliente cliente;
            private Elemento next;

            public Elemento(String nombre, String apellido, Cliente cliente) {
                this.nombre = nombre;
                this.apellido = apellido;
                this.cliente = cliente;
            }
        }
    }

}
