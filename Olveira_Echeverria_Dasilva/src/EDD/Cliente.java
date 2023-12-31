/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author daniel
 */
public class Cliente {
    private String ci;
    private String nombre;
    private String apellido;
    private String email;
    private String genero;
    private String habitacion;
    private String celular;
    private String llegada;
    private String salida;

    public Cliente(String ci, String nombre, String apellido, String email, String genero, String habitacion, String celular, String llegada, String salida) {
        this.ci = ci;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.genero = genero;
        this.habitacion = habitacion;
        this.celular = celular;
        this.llegada = llegada;
        this.salida = salida;
    }

    public String getCi() {
        return ci;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public String getGenero() {
        return genero;
    }

    public String getHabitacion() {
        return habitacion;
    }

    public String getCelular() {
        return celular;
    }

    public String getLlegada() {
        return llegada;
    }

    public String getSalida() {
        return salida;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public void setNombre(String Nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void TipoHabitacion(String habitacion) {
        this.habitacion = habitacion;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public void setLlegada(String llegada) {
        this.llegada = llegada;
    }

    public void setSalida(String salida) {
        this.salida = salida;
    }
            
}
