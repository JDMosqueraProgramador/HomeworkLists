package co.edu.unaula.dataStructure.lists;

import co.edu.unaula.dataStructure.nodes.Nodes;
import lombok.Getter;

public class SimpleList {
    private Nodes firstNode;
    private  Nodes lastNode;
    private Nodes newNode;
    private @Getter int size;

    private final String lnMsg = "\n";
    private final String emptyMsg = "La lista está vacía.";
    private final String dataMsg = "Dato ";
    private final String listMsg = " De la lista:";


    public SimpleList() {
        this.firstNode = null;
        this.lastNode = null;
        this.size = 0;
    }

    private boolean isEmpty() { return getSize() == 0; }

    private void incrementSize() { size++; }
    private void decrementSize() { size--; }

    public SimpleList addNode(String data) {
        try {
            this.newNode = new Nodes(data);

            if(isEmpty()) {
                firstNode = newNode;
                lastNode = newNode;
                newNode.setPrompter(newNode);

            } else {
                lastNode.setPrompter(newNode);
                lastNode = newNode;
            }

            incrementSize();

            return this;

        } catch (Exception e) {
            throw e;
        }

    }

    public SimpleList deleteNode() {
        try {

            if(isEmpty()) {
                return null;
            }

            if(getSize() == 1) {
                firstNode = null;
                lastNode = null;
            } else {
                Nodes actNode = firstNode;

                while (actNode.getPrompter() != lastNode) {
                    actNode = actNode.getPrompter();
                }
                actNode.setPrompter(null);
                lastNode = actNode;
            }

            decrementSize();

            return this;

        } catch (Exception e) {
            throw e;
        }
    }

    public String print(){

        if(isEmpty()) {
            return emptyMsg;
        }

        Nodes auxNode = firstNode;
        String message = "";

        for (int i = 0; i < size; i++) {
            message = message + dataMsg + (i+1) + listMsg;
            message = message + " " + auxNode.getData() + lnMsg;

            auxNode = auxNode.getPrompter();
        }

        return message;

    }

}
