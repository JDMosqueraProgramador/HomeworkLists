package co.edu.unaula.dataStructure.nodes;

import lombok.Getter;
import lombok.Setter;

public class Nodes {

    private @Getter String data;
    private @Getter @Setter Nodes prompter;

    public Nodes(String data) {
        this.data = data;
        prompter = null;
    }

}
