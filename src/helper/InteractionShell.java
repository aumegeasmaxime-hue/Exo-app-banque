package helper;

import services.BankServices;


import java.util.logging.Logger;

public class InteractionShell {
    private static final Logger LOGGER = Logger.getLogger(InteractionShell.class.getName());
    private static final String APP_NAME = "Bank Application v_1.0.";
    private static final BankServices service = new BankServices();


    public static void loadAuthInterface(){
        LOGGER.info("loading auth interface");
        boolean exit = false;
        while (!exit)
        {
            loadAuthMenu();
            int option = Shellhelper.readOption();
            switch (option)
            {
                case 1 :
                    service.createAccount();
                    break;
                case 2:
                    service.connectToAccount();
                    break;
                case 3:
                    LOGGER.info("Exiting application");
                    System.out.println("Thank you for trusting us!!");
                    exit = true;
                    break;
                default:
                    LOGGER.warning("Invalid: "+option);
            }
        }
    }

    public static void loadAccountInterface() {
        LOGGER.info("loading account interface");
        boolean exit = false;
        while (!exit)
        {
            loadAuthMenu();
            int option = Shellhelper.readOption();
            switch (option)
            {
                case 1 :
                    service.createAccount();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    LOGGER.warning("Invalid: "+option);
            }
        }
    }
    private static void loadAuthMenu() {
        System.out.println("-------------------------------------------");
        LOGGER.info("loading auth interface");
        System.out.println(">");
        System.out.println("1.Create Account");
        System.out.println(">");
        System.out.println("2.Connect to Account ");
        System.out.println(">");
        System.out.println("3.Exit");

    }
    private static void loadAccountMenu(){
        System.out.println("-------------------------------------------");
        LOGGER.info("loading account interface");
        System.out.println(">");
        System.out.println("1.Account balance");
        System.out.println(">");
        System.out.println("2.Credit account ");
        System.out.println(">");
        System.out.println("3.Send money");
        System.out.println(">");
        System.out.println("4.Disconnect");

    }


}