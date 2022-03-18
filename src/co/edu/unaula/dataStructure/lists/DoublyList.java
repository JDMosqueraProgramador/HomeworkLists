package co.edu.unaula.dataStructure.lists;

import co.edu.unaula.dataStructure.nodes.DoublyListNodes;


public class DoublyList {

    public static final String smgNobody = "No hay un nodos en la lista para eliminar.";
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
                System.out.println(smgNobody);
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
            DoublyListNodes current = tail;
            String text;

            while (current != null){
                text = "Elemento previo: ";

                if(current.getPreviousEle() == null){
                    text = text + "null";
                } else {
                    text = text + current.getPreviousEle().getData().toString();
                }

                text = text + "\nDato: " + current.getData().toString() + "\nElemento siguiente: ";

                if(current.getNextEle() == null){
                    text = text + "null";
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
