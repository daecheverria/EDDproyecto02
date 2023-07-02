/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author daniel
 */
public class Habitacion {

    private String numeroHabitacion;
    private String tipoHabitacion;
    private String piso;
    private Boolean ocupada;
//constructor
    public Habitacion(String numeroHabitacion, String tipoHabitacion, String piso, Boolean ocupada) {
        this.numeroHabitacion = numeroHabitacion;
        this.tipoHabitacion = tipoHabitacion;
        this.piso = piso;
        this.ocupada = ocupada;
    }

    /**
     * @return the numeroHabitacion
     */
    public String getNumeroHabitacion() {
        return numeroHabitacion;
    }

    /**
     * @param numeroHabitacion the numeroHabitacion to set
     */
    public void setNumeroHabitacion(String numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    /**
     * @return the tipoHabitacion
     */
    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    /**
     * @param tipoHabitacion the tipoHabitacion to set
     */
    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    /**
     * @return the piso
     */
    public String getPiso() {
        return piso;
    }

    /**
     * @param piso the piso to set
     */
    public void setPiso(String piso) {
        this.piso = piso;
    }

    /**
     * @return the ocupada
     */
    public Boolean getOcupada() {
        return ocupada;
    }

    /**
     * @param ocupada the ocupada to set
     */
    public void setOcupada(Boolean ocupada) {
        this.ocupada = ocupada;
    }

}
