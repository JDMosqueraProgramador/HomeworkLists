package co.edu.unaula.dataStructure.lists;

import co.edu.unaula.dataStructure.nodes.DoublyListNodes;

import static co.edu.unaula.dataStructure.helpers.Colors.ERROR_COLOR;

public class DoublyList {

    private final String MSG_NOBODY = "No hay un nodos en la lista para eliminar.";
    private final String MSG_PREVIOUS = "Elemento previo: ";
    private final String MSG_NULL = "null";
    private final String MSG_DATA = "\nDato: ";
    private final String MSG_NEXT_ELEMENT = "\nElemento siguiente: ";
    private final String MSG_WITHOUT_NODES = "No hay nodos para mostrar. \n";

    private DoublyListNodes tail;
    private DoublyListNodes head;
    private DoublyListNodes newNode;

    public DoublyList() {
        tail = null;
        head = null;
    }

    private boolean isEmpty() {
        return tail == null && head == null;
    }

    public DoublyList addFirst(Object data) {
        try {

            newNode = new DoublyListNodes(data);

            if(isEmpty()){
                head = newNode;
            } else {
                newNode.setNextEle(tail);
                tail.setPreviousEle(newNode);
            }
            tail = newNode;

            return this;
        } catch (Exception e) {
            throw e;
        }
    }

    public DoublyList addLast(Object data) {
        try {
            newNode = new DoublyListNodes(data);

            if(isEmpty()){
                tail = newNode;
            } else {
                head.setNextEle(newNode);
                newNode.setPreviousEle(head);
            }
            head = newNode;

            return this;
        } catch (Exception e) {
            throw e;
        }
    }

    public boolean existNode(){
        return tail == head;
    }

    public DoublyList deleteNode(){

        try {
            if (isEmpty()){
                System.out.println(ERROR_COLOR + MSG_NOBODY);
                return null;
            }

            if (existNode()){
                tail = null;
                head = null;
            }else{

                DoublyListNodes current = tail;

                while (current.getNextEle() != head) {
                    current = current.getNextEle();
                }

                current.setNextEle(null);
                head = current;
            }

            return this;
        } catch (Exception e) {
            throw e;
        }

    }

    public void printTail(){
        try {

            if (isEmpty()){
                System.out.println(ERROR_COLOR + MSG_WITHOUT_NODES);
            }

            DoublyListNodes current = tail;
            String text;

            while (current != null){
                text = MSG_PREVIOUS;

                if(current.getPreviousEle() == null){
                    text = text + MSG_NULL;
                } else {
                    text = text + current.getPreviousEle().getData().toString();
                }

                text = text + MSG_DATA + current.getData().toString() + MSG_NEXT_ELEMENT;

                if(current.getNextEle() == null){
                    text = text + MSG_NULL;
                } else {
                    text = text + current.getNextEle().getData().toString();
                }

                System.out.println(text + "\n");
                current = current.getNextEle();
            }

        } catch (Exception e) {
            throw e;
        }
    }

}
