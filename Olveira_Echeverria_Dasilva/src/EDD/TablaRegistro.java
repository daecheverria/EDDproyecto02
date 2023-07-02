/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author daniel
 */
public class TablaRegistro {

    public HashTableR registroTabla;
    private TablaHabitaciones.HashTableH habitaciones;
    private static TablaRegistro instancia;
//metodo para agregar los datos a la tabla
    private void CrearTablaReg() {

        TablaHabitaciones tablahab = TablaHabitaciones.getInstancia();
        habitaciones = tablahab.getHabitacionesTabla();
        System.out.println(habitaciones.getClass().getSimpleName());
        String projectPath = System.getProperty("user.dir");
        String csvFile = "Booking_hotel - estado.csv";
        Path csvFilePath = Paths.get(projectPath).resolve(csvFile);
        String line;
        boolean isFirstLine = true;
        registroTabla = new HashTableR();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath.toString()))) {
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

                    if (habitacion != null && !habitacion.getOcupada()) {
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
//Metodo para que solo haya una instancia de la tabla y no se cree una nueva en cada ventana
    public static TablaRegistro getInstancia() {
        if (instancia == null) {
            instancia = new TablaRegistro();
            instancia.CrearTablaReg();
        }
        return instancia;
    }
//metodos para acceder y obtener/eliminar un elemento de la tabla
    public Cliente get(String nombre, String apellido) {
        return registroTabla.get(nombre, apellido);
    }
    public void eliminar(String nombre, String apellido) {
        registroTabla.eliminar(nombre,apellido);
    }
   //constructor de la tabla
    public static class HashTableR {

        private static int tamano = 300;
        private Elemento[] tabla;

        public HashTableR() {
            tabla = new Elemento[tamano];
        }
//agregar un elemento a la tabla
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
//obtener un elemento de la tabla
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
//obtener valor unico
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
//eliminar elemento de la tabla
        public void eliminar(String nombre, String apellido) {
            int hash = getHash(nombre, apellido);

            if (tabla[hash] != null) {
                Elemento actual = tabla[hash];
                Elemento anterior = null;

                while (actual != null) {
                    if (actual.nombre.equals(nombre) && actual.apellido.equals(apellido)) {
                        if (anterior != null) {
                            anterior.next = actual.next;
                        } else {
                            tabla[hash] = actual.next;
                        }
                        return;
                    }

                    anterior = actual;
                    actual = actual.next;
                }
            }
        }

    }

}
