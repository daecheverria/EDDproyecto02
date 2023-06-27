/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;
import java.util.ArrayList;

/**
 *
 * @author AntonioOlveira
 */
public class ArbolB {

    private NodoABB root;

    public ArbolB() {
        root = null;
    }

    public void insert(int data, String name, String lastname) {
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

    public ArrayList<Integer> traverseInOrder() {
        ArrayList<Integer> list = new ArrayList<>();
        traverseInOrder(root, list);
        return list;
    }

    private void traverseInOrder(NodoABB node, ArrayList<Integer> list) {
        if (node == null) {
            return;
        }

        traverseInOrder(node.getLeft(), list);
        list.add(node.getData());
        traverseInOrder(node.getRight(), list);
    }

    
}

