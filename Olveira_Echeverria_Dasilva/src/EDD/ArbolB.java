/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
    
    //Metodo de insercion
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
        if (currentNode == null){
            return null;
        }
        if (currentNode.getNames() == null) {
            return null;
        }
    
        return currentNode;
    }
    
    //Metodos que cargan los datos provenientes de los archivos csv al arbol
    public void Addsimpledatabase(ArbolB arbol, String direction){
        String file = direction;
        String line;
        boolean isFirstLine = true;
        
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((line = br.readLine()) != null) {
               
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                String[] data = line.split(",");

                String ci = data[0];
                String primerNombre = data[1];
                String apellido = data[2];
                String email = data[3];
                String genero = data[4];
                String llegada = data[5];
                int habitacion = Integer.parseInt(data[6]);
                
                Historial historial = new Historial(ci, primerNombre, apellido, email, genero, llegada, habitacion);
                arbol.simpleinsert(historial.getHabitacion(), historial.getNombre(), historial.getApellido());
            }
        } catch (IOException e) {
            e.printStackTrace();
            
        }
    }
    public void Addcomplexdatabase(ArbolB arbol, String direction){
        String file = direction;
        String line;
        boolean isFirstLine = true;
        
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((line = br.readLine()) != null) {
               
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                String[] data = line.split(",");
                try{
                    String[] strci = data[0].split(",");
                String strci2= "";
                for (String n : strci) {
                    strci2 += n;
                }
                int ci = Integer.parseInt(strci2);
                String nombre = data[1];
                String apellido = data[2];
                String correo = data[3];
                String genero = data[4];
                String tipo_hab = data[5];
                String celular = data[6];
                String llegada = data[7];
                String salida = data[8];
                arbol.complexinsert(ci, nombre, apellido, correo, genero, tipo_hab, celular, llegada, salida);
                
                }catch (Exception e){
                    String[] strci = data[0].split("\\.");
                    String strci2= "";
                    for (String n : strci) {
                        strci2 += n;
                    }
                    int ci = Integer.parseInt(strci2);
                    
                    String nombre = data[1];
                    String apellido = data[2];
                    String correo = data[3];
                    String genero = data[4];
                    String tipo_hab = data[5];
                    String celular = data[6];
                    String llegada = data[7];
                    String salida = data[8];
                arbol.complexinsert(ci, nombre, apellido, correo, genero, tipo_hab, celular, llegada, salida);
                }
                
                
            }
        } catch (Exception e) {
            e.printStackTrace();
            
        }
    }
}

