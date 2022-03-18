package co.edu.unaula.dataStructure.lists;

import co.edu.unaula.dataStructure.nodes.Nodes;
import lombok.Getter;

import static co.edu.unaula.dataStructure.helpers.Colors.DEFAULT_COLOR;
import static co.edu.unaula.dataStructure.helpers.Colors.ERROR_COLOR;

public class SimpleList {

    public static final String ansiRed = "\u001B[31m";
    public static final String ansiWhite = "\u001B[37m";

    private Nodes firstNode;
    private  Nodes lastNode;
    private Nodes newNode;
    private @Getter int size;

    private final String MSG_EMPTY = "La lista está vacía.";
    private final String MSG_DATA = "Dato ";
    private final String MSG_LIST = " De la lista:";

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
            return ERROR_COLOR + MSG_EMPTY;
        }

        Nodes auxNode = firstNode;
        String message = "";

        for (int i = 0; i < size; i++) {
            message = message + DEFAULT_COLOR + MSG_DATA + (i+1) + MSG_LIST;
            message = message + " " + auxNode.getData() + "\n";

            auxNode = auxNode.getPrompter();
        }

        return message;

    }

}
