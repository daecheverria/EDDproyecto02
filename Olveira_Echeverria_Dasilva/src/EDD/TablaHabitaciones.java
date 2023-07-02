/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

import EDD.Habitacion;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author daniel
 */
public class TablaHabitaciones {
    private static TablaHabitaciones instancia;
    private HashTableH habitacionesTabla;

    private void CrearTablaHab() {
        String projectPath = System.getProperty("user.dir");
        String csvFile = "Booking_hotel - habitaciones.csv";
        Path csvFilePath = Paths.get(projectPath).resolve(csvFile);
        String line;
        boolean isFirstLine = true;
        habitacionesTabla = new HashTableH();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath.toString()))) {
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
    public static TablaHabitaciones getInstancia() {
        if (instancia == null) {
            instancia = new TablaHabitaciones();
            instancia.CrearTablaHab();
        }
        return instancia;
    }
    public HashTableH getHabitacionesTabla() {
        return habitacionesTabla;
    }
    
    public Habitacion get(String numeroHabitacion) {
        return habitacionesTabla.get(numeroHabitacion);

    }
     public Habitacion buscarHabitacionDisponible(String tipoHabitacion) {
        for (Elemento elemento : habitacionesTabla.tabla) {
            Elemento actual = elemento;

            while (actual != null) {
                if (actual.habitacion.getTipoHabitacion().equals(tipoHabitacion) && !actual.habitacion.getOcupada()) {
                    actual.habitacion.setOcupada(true);
                    return actual.habitacion;
                }

                actual = actual.next;
            }
        }

        return null;
    }
    public Habitacion liberarHabitacion(String numeroHabitacion) {
    for (Elemento elemento : habitacionesTabla.tabla) {
        Elemento actual = elemento;

        while (actual != null) {
            if (actual.habitacion.getNumeroHabitacion().equals(numeroHabitacion) && actual.habitacion.getOcupada()) {
                actual.habitacion.setOcupada(false);
                return actual.habitacion;
            }

            actual = actual.next;
        }
    }

    return null;
}

     
    public static class HashTableH {

        private static int tamano = 300;
        private Elemento[] tabla;

        public HashTableH() {
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

    }
    private static class Elemento {

            private String key;
            private Habitacion habitacion;
            private Elemento next;

            public Elemento(String key, Habitacion habitacion) {
                this.key = key;
                this.habitacion = habitacion;
            }
        }

}
