package co.edu.unaula.dataStructure.helpers;

import co.edu.unaula.dataStructure.enums.ListTypes;
import co.edu.unaula.dataStructure.enums.Options;
import lombok.NoArgsConstructor;

import java.util.Scanner;

@NoArgsConstructor
public class Input {

    private Scanner read = new Scanner(System.in).useDelimiter("\n");
    public static final String smgEmpty = "El texto no puede quedar vacío.";
    private final String optionMsg = "Ha ingresado una opción incorrecta.";

    public Options inputOption(String message, boolean type) {
        try {
            Options option = null;

            while (option == null) {

                System.out.println(message);
                String value = read.next();

                if(type) {

                    switch (value) {
                        case "1":
                            option = Options.ADD;
                            break;
                        case "2":
                            option = Options.DELETE;
                            break;
                        case "3":
                            option = Options.PRINT;
                            break;

                        case "4":
                            option = Options.FINISH;
                            break;

                        default:
                            System.out.println(optionMsg);
                            break;

                    }
                } else {
                    switch (value) {
                        case "1":
                            option = Options.ADDFIRST;
                            break;
                        case "2":
                            option = Options.ADD;
                            break;
                        case "3":
                            option = Options.DELETE;
                            break;
                        case "4":
                            option = Options.PRINT;
                            break;

                        case "5":
                            option = Options.FINISH;
                            break;

                        default:
                            System.out.println(optionMsg);
                            break;

                    }
                }


            }

            return option;
        } catch (Exception e) {
            throw e;
        }
    }

    public ListTypes inputList(String message) {

        try {
            ListTypes option = null;

            while (option == null) {

                System.out.println(message);
                String value = read.next();

                switch (value) {
                    case "1":
                        option = ListTypes.SIMPLE;
                        break;
                    case "2":
                        option = ListTypes.DOUBLE;
                        break;
                    case "3":
                        option = ListTypes.CIRCULAR;
                        break;

                    case "4":
                        option = ListTypes.FINISH;
                        break;

                    default:
                        System.out.println(optionMsg);
                        break;

                }
            }

            return option;
        } catch (Exception e) {
            throw e;
        }
    }

    public String inputString(String message) {

        try {
            String data = "";

            while (data.equals("")) {
                System.out.println(message);
                data = read.next();

                if(data.equals("")) {
                    System.out.println(smgEmpty);
                }
            }

            return data;
        } catch (Exception e) {
            throw e;
        }

    }

}
