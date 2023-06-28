/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication9;

/**
 *
 * @author daniel
 */
public class Persona {
    private String ci;
    private String primerNombre;
    private String segundoNombre;
    private String email;
    private String genero;
    private String Habitacion;
    private String celular;
    private String llegada;
    private String salida;

    public Persona(String ci, String primerNombre, String segundoNombre, String email, String genero, String Habitacion, String celular, String llegada, String salida) {
        this.ci = ci;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.email = email;
        this.genero = genero;
        this.Habitacion = Habitacion;
        this.celular = celular;
        this.llegada = llegada;
        this.salida = salida;
    }

    public String getCi() {
        return ci;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public String getEmail() {
        return email;
    }

    public String getGenero() {
        return genero;
    }

    public String getHabitacion() {
        return Habitacion;
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

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void TipoHabitacion(String Habitacion) {
        this.Habitacion = Habitacion;
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
