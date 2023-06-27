/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author AntonioOlveira
 */
public class NodoABB {
    private int data;
    private NodoABB left;
    private NodoABB right;
    private Lista name = new Lista();
    private Lista lastname = new Lista();

    public NodoABB(int data){
        this.data = data;
        this.left = null;
        this.right = null;
        this.name = null;
        this.lastname = null;
    }
    
    public NodoABB(int data, String name, String lastname){
        this.data = data;
        this.left = null;
        this.right = null;
        this.name.agregarElemento(name);
        this.lastname.agregarElemento(lastname);
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public NodoABB getLeft() {
        return left;
    }

    public void setLeft(NodoABB left) {
        this.left = left;
    }

    public NodoABB getRight() {
        return right;
    }

    public void setRight(NodoABB right) {
        this.right = right;
    }

    public Lista getNames() {
        return name;
    }

    public void addName(String name) {
        this.name.agregarElemento(name);
    }

    public Lista getLastnames() {
        return lastname;
    }

    public void addLastname(String lastname) {
        this.lastname.agregarElemento(lastname);
    }
    public void printnames(NodoABB node){
        Lista names = new Lista();
        names = node.getNames();
        Lista lastnames = new Lista();
        lastnames = node.getLastnames();
        Nodo currentname = names.getpFirst();
        Nodo currentlastname = lastnames.getpFirst();
        System.out.println("Historial de hospedaje en la habitacion seleccionada: ");
        while (true){
            
            if (currentname == null){
                break;
            }else if(currentlastname == null){
                break;
            }
            System.out.println(currentname.getInfo() + " " + currentlastname.getInfo());
            
            currentname = currentname.getpNext();
            currentlastname = currentlastname.getpNext();
        }
            
    }

    
    
    
    
    
}
