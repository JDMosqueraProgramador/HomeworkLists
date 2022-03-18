package co.edu.unaula.dataStructure.menu;

import co.edu.unaula.dataStructure.enums.ListTypes;
import co.edu.unaula.dataStructure.helpers.Input;

public class MenuLists {

    public static final String ansiWhite = "\u001B[37m";

    private final String[] options = {"Listas simples", "Lista doble", "Lista circular", "Salir/Terminar"};
    private final String description = "\n----MENÚ PRINCIPAL---- \n Elija una opción: ";

    public ListTypes showMenu() {

        Input input = new Input();
        String message = ansiWhite + description;

        for (int i = 0; i < options.length; i++) {
            message += "\n" + (i+1) + " " + options[i];
        }

        message += "\n";

        return input.inputList(message);

    }
}
