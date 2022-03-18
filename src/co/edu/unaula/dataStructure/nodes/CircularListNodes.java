package co.edu.unaula.dataStructure.nodes;

import lombok.Getter;
import lombok.Setter;

public class CircularListNodes {
    private @Getter String data;
    private @Getter @Setter CircularListNodes nextNode;

    public CircularListNodes(String data) {
        this.data = data;
        this.nextNode = null;
    }
}
