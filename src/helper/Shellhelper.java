package helper;

import java.util.Scanner;
import java.util.logging.Logger;
// creation du scanner

public class Shellhelper {

    private static final Logger LOGGER  = Logger.getLogger(Shellhelper.class.getName());
    public static final int IVALID_OPTION = -1;
    private static Scanner scanner = new Scanner(System.in);


    //on creer l exception pour ne pas bugguer le system
    public static int readOption() {
        try {
            return Integer.parseInt(scanner.nextLine());
        }
        catch (NumberFormatException exception){
            LOGGER.warning(exception.getMessage());
            //on peut faire autrement avec un message
            //LOGGER.warning(
            //() -> String.format("error reading entry : [%s]",exception.getMessage()) );
            return IVALID_OPTION;
        }
    }

    public static String readEntry() {
        return String.valueOf(scanner.nextLine());
    }
}