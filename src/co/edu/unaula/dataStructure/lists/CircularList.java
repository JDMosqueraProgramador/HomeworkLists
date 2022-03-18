package co.edu.unaula.dataStructure.lists;

import co.edu.unaula.dataStructure.nodes.CircularListNodes;

public class CircularList {

    public static final String ansiRed = "\u001B[31m";


    private CircularListNodes firstNode;
    private CircularListNodes lastNode;
    private CircularListNodes newNode;

    public static final String msgEmpty = "La lista está vacía. \n";
    public static final String smgNobody = "No hay nodos para eliminar \n";

    public CircularList() {
        firstNode = null;
        lastNode = null;
    }

    private boolean isEmpty() {
        return firstNode == null && lastNode == null;
    }

    public CircularList addNode(String data){
        try{
            newNode = new CircularListNodes(data);

            if(isEmpty()) {
                firstNode = newNode;
                firstNode.setNextNode(newNode);
            } else {
                lastNode.setNextNode(newNode);
            }

            lastNode = newNode;
            lastNode.setNextNode(firstNode);

            return this;

        } catch (Exception e) {
            throw e;
        }
    }

    private boolean hasOne() {return firstNode == lastNode;}

    public CircularList deleteNode() {

        try {
            if(isEmpty()) {
                System.out.println(ansiRed+smgNobody);
                return null;
            }

            if(hasOne()) {
                firstNode = null;
                lastNode = null;
            } else {

                CircularListNodes current = firstNode;
                while (current.getNextNode() != lastNode) {
                    current = current.getNextNode();
                }

                current.setNextNode(firstNode);
                lastNode = current;
            }

            return this;

        } catch (Exception e) {
            throw e;
        }

    }

    public void print() {

        try {
            if(!isEmpty()) {
                CircularListNodes aux;
                aux = firstNode;

                do {

                    System.out.println(aux.getData());
                    aux = aux.getNextNode();

                } while (aux != firstNode);

            } else {
                System.out.println(ansiRed+msgEmpty);
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
