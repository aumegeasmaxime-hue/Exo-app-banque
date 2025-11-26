package services;

import helper.Shellhelper;
import model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class BankServices {
    private static final Logger LOGGER = Logger.getLogger(BankServices.class.getName());
    private static Map<String, User> users = new HashMap<>();

    public void createAccount() {
        System.out.println("Pease enter your first name: ");
        String firstname = Shellhelper.readEntry();
        System.out.println("Pease enter your last name: ");
        String lastname = Shellhelper.readEntry();

        String email = getEntryEmail();
        System.out.println("Pease enter your password: ");
        String password = Shellhelper.readEntry();

        User user = new User(firstname,lastname,email,password);
        registerUser(user);
    }

    private String getEntryEmail() {
        String email;
        while(true){
            System.out.println("Pease enter your email adress : ");
            email = Shellhelper.readEntry();
            if (isEmailValid(email)){
                email = formatEmail(email);
                break;
            }
            System.out.println("Invalid email adresse. \n Email must contain '@' and '.' . ex: exemple@email.com");
        }
        return email;
    }

    private String formatEmail(String email) {
        return email.trim().toLowerCase();
    }

    private boolean isEmailValid(String email) {
        return email.contains("@")&& email.contains(".");
    }

    private void registerUser(User user) {
        if (isUserRegistered(user.getEmail())){
            LOGGER.warning("this email adress "+user.getEmail()+"is already in use");
        }
        users.put(user.getEmail(), user);
        LOGGER.info("User with email"+user.getEmail()+"has been registered successfully");
    }

    private boolean isUserRegistered(String email) {
        return  users.containsKey(email);
    }

    public void connectToAccount() {
    }
}