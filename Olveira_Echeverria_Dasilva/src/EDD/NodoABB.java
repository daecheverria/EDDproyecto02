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
    private Lista correo = new Lista();
    private Lista genero = new Lista();
    private Lista tipo_hab = new Lista();
    private Lista celular = new Lista();
    private Lista llegada = new Lista();
    private Lista salida = new Lista();
        
    //constructores de la clase
    public NodoABB(int data){
        this.data = data;
        this.left = null;
        this.right = null;
        this.name = null;
        this.lastname = null;
        this.correo = null;
        this.genero = null;
        this.tipo_hab = null;
        this.celular = null;
        this.llegada = null;
        this.salida = null;
    }
    
    public NodoABB(int data, String name, String lastname){
        this.data = data;
        this.left = null;
        this.right = null;
        this.name.agregarElemento(name);
        this.lastname.agregarElemento(lastname);
        this.correo = null;
        this.genero = null;
        this.tipo_hab = null;
        this.celular = null;
        this.llegada = null;
        this.salida = null;
    }
    public NodoABB(int data, String name, String lastname, String correo, String genero, String tipo_hab, String celular, String llegada, String salida){
        this.data = data;
        this.left = null;
        this.right = null;
        this.name.agregarElemento(name);
        this.lastname.agregarElemento(lastname);
        this.correo.agregarElemento(correo);
        this.genero.agregarElemento(genero);
        this.tipo_hab.agregarElemento(tipo_hab);
        this.celular.agregarElemento(celular);
        this.llegada.agregarElemento(llegada);
        this.salida.agregarElemento(salida);
    }

    //getters and setters
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

    public void AddCorreo(String correo) {
        this.correo.agregarElemento(correo);
    }

    public void AddGenero(String genero) {
        this.genero.agregarElemento(genero);
    }

    public void AddTipo_hab(String tipo_hab) {
        this.tipo_hab.agregarElemento(tipo_hab);
    }

    public void AddCelular(String celular) {
        this.celular.agregarElemento(celular);
    }

    public void AddLlegada(String llegada) {
        this.llegada.agregarElemento(llegada);
    }

    public void AddSalida(String salida) {
        this.salida.agregarElemento(salida);
    }

    public Lista getCorreo() {
        return correo;
    }

    public Lista getGenero() {
        return genero;
    }

    public Lista getTipo_hab() {
        return tipo_hab;
    }

    public Lista getCelular() {
        return celular;
    }

    public Lista getLlegada() {
        return llegada;
    }

    public Lista getSalida() {
        return salida;
    }
    
    //metodo temporal de prueba
    public String Getnames(NodoABB node){
        Lista names;
        names = node.getNames();
        Lista lastnames;
        lastnames = node.getLastnames();
        Nodo currentname = names.getpFirst();
        String names_return = "";
        Nodo currentlastname = lastnames.getpFirst();
//        System.out.println("Historial de hospedaje en la habitacion seleccionada: ");
        
        while (true){
            
            if (currentname == null){
                break;
            }else if(currentlastname == null){
                break;
            }
//            System.out.println(currentname.getInfo() + " " + currentlastname.getInfo());
            names_return += (currentname.getInfo() + " " + currentlastname.getInfo() + " ");
            names_return += "\n";
            
            currentname = currentname.getpNext();
            currentlastname = currentlastname.getpNext();
        }
        return names_return;
            
    }
    //Metodo que permite llevar la informacion registrada en un nodo a string
    public String GetInfo(NodoABB node){
        Lista names;
        names = node.getNames();
        Lista lastnames;
        lastnames = node.getLastnames();
        Lista correo1;
        correo1 = node.getCorreo();
        Lista genero1;
        genero1 = node.getGenero();
        Lista tipo_hab1;
        tipo_hab1 = node.getTipo_hab();
        Lista celular1;
        celular1 = node.getCelular();
        Lista llegada1;
        llegada1 = node.getLlegada();
        Lista salida1;
        salida1 = node.getSalida();
        
        Nodo currentname = names.getpFirst();
        Nodo currentlastname = lastnames.getpFirst();
        Nodo currentcorreo = correo1.getpFirst();
        Nodo currentgenero = genero1.getpFirst();
        Nodo currenttipo_hab = tipo_hab1.getpFirst();
        Nodo currentcelular = celular1.getpFirst();
        Nodo currentllegada = llegada1.getpFirst();
        Nodo currentsalida = salida1.getpFirst();
        String info_return = "";
//        System.out.println("Informacion de la reservacion: ");
        while (true){
            
            if (currentname == null){
                break;
            }else if(currentlastname == null){
                break;
            }
//            System.out.println(currentname.getInfo() + " " + currentlastname.getInfo() + " " + currentcorreo.getInfo() + " " + currentgenero.getInfo() + " " + currenttipo_hab.getInfo() + " " + currentcelular.getInfo() + " " + currentllegada.getInfo() + " " + currentsalida.getInfo());
            info_return += currentname.getInfo() + " " + currentlastname.getInfo() + " | " + currentcorreo.getInfo() + " | " + currentgenero.getInfo() + " | " + currenttipo_hab.getInfo() + " | " + currentcelular.getInfo() + " | " + currentllegada.getInfo() + " | " + currentsalida.getInfo();
            info_return += "\n";
            currentname = currentname.getpNext();
            currentlastname = currentlastname.getpNext();
            currentcorreo = currentcorreo.getpNext();
            currentgenero = currentgenero.getpNext();
            currenttipo_hab = currenttipo_hab.getpNext();
            currentcelular = currentcelular.getpNext();
            currentllegada = currentllegada.getpNext();
            currentsalida = currentsalida.getpNext();
        }
        return info_return;
    }
}
