/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author AntonioOlveira
 */
public class ArbolB {

    private NodoABB root;
    
    //constructor de la clase
    public ArbolB() {
        root = null;
    }

    //Metodos de la clase
    public void simpleinsert(int data, String name, String lastname) {
        if (root == null) {
            root = new NodoABB(data, name, lastname);
            return;
        }

        NodoABB currentNode = root;
        while (true) {
            if (data == currentNode.getData()){
                currentNode.addName(name);
                currentNode.addLastname(lastname);
                return;
            }else if (data < currentNode.getData()) {
                if (currentNode.getLeft() == null) {
                    currentNode.setLeft(new NodoABB(data, name, lastname));
                    return;
                }else {
                    currentNode = currentNode.getLeft();
                }
            } else {
                if (currentNode.getRight() == null) {
                    currentNode.setRight(new NodoABB(data, name, lastname));
                    return;
                }else {
                    currentNode = currentNode.getRight();
                }
            }
        }
    }
    public void complexinsert(int data, String name, String lastname, String correo, String genero, String tipo_hab, String celular, String llegada, String salida) {
        if (root == null) {
            root = new NodoABB(data, name, lastname, correo, genero, tipo_hab, celular, llegada, salida);
            return;
        }

        NodoABB currentNode = root;
        while (true) {
            if (data == currentNode.getData()){
                currentNode.addName(name);
                currentNode.addLastname(lastname);
                currentNode.AddCorreo(correo);
                currentNode.AddGenero(genero);
                currentNode.AddTipo_hab(tipo_hab);
                currentNode.AddCelular(celular);
                currentNode.AddLlegada(llegada);
                currentNode.AddSalida(salida);
                
                return;
            }else if (data < currentNode.getData()) {
                if (currentNode.getLeft() == null) {
                    currentNode.setLeft(new NodoABB(data, name, lastname, correo, genero, tipo_hab, celular, llegada, salida));
                    return;
                }else {
                    currentNode = currentNode.getLeft();
                }
            } else {
                if (currentNode.getRight() == null) {
                    currentNode.setRight(new NodoABB(data, name, lastname, correo, genero, tipo_hab, celular, llegada, salida));
                    return;
                }else {
                    currentNode = currentNode.getRight();
                }
            }
        }
    }   
    
    //busqueda con complejidad aproximada de O(log(n))
    public NodoABB search(int data) {
        if (root == null) {
            return null;
        }
       
        NodoABB currentNode = root;
        while (currentNode != null) {
            if (data == currentNode.getData()) {
                break;
            } else if (data < currentNode.getData()) {
                currentNode = currentNode.getLeft();
            } else {
                currentNode = currentNode.getRight();
            }
        }

        return currentNode;
    }
}

