package co.edu.unaula.dataStructure.menu;

import co.edu.unaula.dataStructure.enums.ListTypes;
import co.edu.unaula.dataStructure.helpers.Input;

import static co.edu.unaula.dataStructure.helpers.Colors.DEFAULT_COLOR;

public class MenuLists {

    private final String[] options = {"Listas simples", "Lista doble", "Lista circular", "Salir/Terminar"};
    private final String description = "\n----MENÚ PRINCIPAL---- \n Elija una opción: ";

    public ListTypes showMenu() {

        Input input = new Input();
        String message = DEFAULT_COLOR + description;

        for (int i = 0; i < options.length; i++) {
            message += "\n" + (i+1) + " " + options[i];
        }

        message += "\n";

        return input.inputList(message);

    }
}
