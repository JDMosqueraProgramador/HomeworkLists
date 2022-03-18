package co.edu.unaula.dataStructure.nodes;

import lombok.Getter;
import lombok.Setter;

public class DoublyListNodes {
    private @Getter @Setter DoublyListNodes previousEle;
    private @Getter Object data;
    private @Getter @Setter DoublyListNodes nextEle;

    public DoublyListNodes(Object data) {
        this.data = data;
        this.previousEle = null;
        this.nextEle = null;
    }

}
