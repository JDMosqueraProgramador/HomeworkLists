package co.edu.unaula.dataStructure.menu;

import co.edu.unaula.dataStructure.enums.Options;
import co.edu.unaula.dataStructure.helpers.Input;

import static co.edu.unaula.dataStructure.helpers.Colors.DEFAULT_COLOR;

public class MenuOptions {

    private final String[] defaultOptions = {"Agregar nodos","Eliminar nodo", "Imprimir nodos", "Regresar al menú principal"};
    private final String[] doubleOptions = {"Agregar nodo al inicio", "Agregar nodo al final","Eliminar nodo", "Imprimir nodos", "Regresar al menú principal"};
    private final String[] description = {"\n----MENÚ DE LISTA SIMPLE/CIRCULAR----", "\n----MENÚ DE LISTA DOBLE----"};

    public Options showMenu(boolean type) {

        Input input = new Input();
        String message;

        if(type) {
            message = DEFAULT_COLOR + description[0];
            for (int i = 0; i < defaultOptions.length; i++) {
                message += "\n" + (i+1) + " " + defaultOptions[i];
            }
        } else {
            message = DEFAULT_COLOR + description[1];
            for (int i = 0; i < doubleOptions.length; i++) {
                message += "\n" + (i+1) + " " + doubleOptions[i];
            }
        }

        message += "\n";

        return input.inputOption(message, type);

    }
}
