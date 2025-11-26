

import helper.InteractionShell;
import services.BankServices;

public class App {
        public static void main(String[] args) {
            BankServices.initializeUsers();
            InteractionShell.loadAuthInterface();

        }
    }



