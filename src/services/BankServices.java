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
        System.out.println("Pease enter your email adress : ");
        String email = Shellhelper.readEntry();
        System.out.println("Pease enter your password: ");
        String password = Shellhelper.readEntry();

        User user = new User(firstname,lastname,email,password);
        registerUser(user);


    }

    private void registerUser(User user) {
        if (isUserRegistered(user.getEmail()))
        {
            LOGGER.warning("this email adress "+user.getEmail()+"is already in use");
        }
        users.put(user.getEmail(), user);
        LOGGER.info("User with email"+user.getEmail()+"has been registered successfully");
    }

    private boolean isUserRegistered(String email) {
        return  users.containsKey(email);
    }
}