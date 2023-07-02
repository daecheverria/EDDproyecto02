/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author daniel
 */
public class Reserva {
    private String ci;
    private String ingreso;
    private String salida;
//constructor
    public Reserva(String ci, String ingreso, String salida) {
        this.ci = ci;
        this.ingreso = ingreso;
        this.salida = salida;
    }

    /**
     * @return the ci
     */
    public String getCi() {
        return ci;
    }

    /**
     * @param ci the ci to set
     */
    public void setCi(String ci) {
        this.ci = ci;
    }

    /**
     * @return the ingreso
     */
    public String getIngreso() {
        return ingreso;
    }

    /**
     * @param ingreso the ingreso to set
     */
    public void setIngreso(String ingreso) {
        this.ingreso = ingreso;
    }

    /**
     * @return the salida
     */
    public String getSalida() {
        return salida;
    }

    /**
     * @param salida the salida to set
     */
    public void setSalida(String salida) {
        this.salida = salida;
    }
    
}
