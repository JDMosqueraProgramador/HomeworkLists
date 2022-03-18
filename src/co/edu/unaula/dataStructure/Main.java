package co.edu.unaula.dataStructure;

import co.edu.unaula.dataStructure.helpers.Input;
import co.edu.unaula.dataStructure.lists.CircularList;
import co.edu.unaula.dataStructure.lists.DoublyList;
import co.edu.unaula.dataStructure.lists.SimpleList;
import co.edu.unaula.dataStructure.enums.ListTypes;
import co.edu.unaula.dataStructure.menu.MenuLists;
import co.edu.unaula.dataStructure.menu.MenuOptions;
import co.edu.unaula.dataStructure.enums.Options;

import static co.edu.unaula.dataStructure.helpers.Colors.SUCCESS_COLOR;

public class Main {

    private static String data = "";
    private static Input input = new Input();
    private static MenuLists menuLists = new MenuLists();
    private static MenuOptions menuOptions = new MenuOptions();
    private static SimpleList lst = new SimpleList();
    private static DoublyList dbLst = new DoublyList();
    private static CircularList cLst = new CircularList();
    private static Object response = null;

    private static final String MSG_DATA = "Ingrese el dato para la lista: ";
    private static final String[] addMsg = {"Se produjo un error. No se agregó el nodo.\n", "Nodo agregado.\n"};
    private static final String[] delMsg = {"Se produjo un error. No se eliminó el nodo.\n", "El último nodo ha sido eliminado.\n"};

    public static void main(String[] args) {
        try {
            ListTypes type;

            do {

                type = menuLists.showMenu();
                if(type != ListTypes.FINISH) {
                    handleLists(type);
                }

            } while (type != ListTypes.FINISH);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void handleLists(ListTypes type) {

        try {

            Options option;

            do {

                option = menuOptions.showMenu(type != ListTypes.DOUBLE);

                switch (option) {

                    case ADD:

                        data = input.inputString(MSG_DATA);

                        switch (type) {
                            case DOUBLE:
                                response = dbLst.addLast(data);
                                break;
                            case SIMPLE:
                                response = lst.addNode(data);
                                break;
                            case CIRCULAR:
                                response = cLst.addNode(data);
                                break;

                        }

                        System.out.println(SUCCESS_COLOR + addMsg[(response == null) ? 0 : 1]);

                        break;

                    case ADDFIRST:

                        data = input.inputString(MSG_DATA);
                        response = dbLst.addFirst(data);

                        System.out.println( SUCCESS_COLOR + addMsg[(response == null) ? 0 : 1]);

                        break;

                    case DELETE:

                        switch (type) {
                            case DOUBLE:
                                response = dbLst.deleteNode();
                                break;
                            case SIMPLE:
                                response = lst.deleteNode();
                                break;
                            case CIRCULAR:
                                response = cLst.deleteNode();
                                break;

                        }

                        System.out.println(SUCCESS_COLOR +delMsg[(response == null) ? 0 : 1]);

                        break;
                    case PRINT:

                        switch (type) {
                            case DOUBLE:
                                dbLst.printTail();
                                break;
                            case SIMPLE:
                                System.out.println(lst.print() + "\n\n");
                                break;
                            case CIRCULAR:
                                cLst.print();
                                break;
                        }
                        break;

                }
            } while (option != Options.FINISH);

        } catch (Exception e) {
            throw e;
        }
    }

}

