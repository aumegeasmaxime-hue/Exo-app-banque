package services;

import helper.InteractionShell;
import helper.Shellhelper;
import model.User;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class BankServices {
    private static final Logger LOGGER = Logger.getLogger(BankServices.class.getName());
    private static Map<String, User> users = new HashMap<>(); //celui qui chercher la clé à qui appartient à cet user
    private User loggerUser = null; //l utilisateur qui vient de se connecter


    public void createAccount() {
        System.out.println("Pease enter your first name: ");
        String firstname = Shellhelper.readEntry();
        System.out.println("Pease enter your last name: ");
        String lastname = Shellhelper.readEntry();
        String email = getEntryEmail();
        System.out.println("Please enter your password: ");
        String password = Shellhelper.readEntry();

        User user = new User(firstname,lastname,email,password);
        registerUser(user);

    }

    private String getEntryEmail() {
        String email;
        while (true)
        {
            System.out.println("please enter your email adress : ");
            email = Shellhelper.readEntry();
            if(isEmailValid(email))
            {
                email = formedEmail(email);
                break;
            }
            System.out.println("Invalid email adres.\n Email must containt '@' and '.' . EX: exemple@exemple.com");
        }
        return email;
    }

    private boolean isEmailValid(String email) {
        return email.contains("@")&&email.contains(".");
    }

    private String formedEmail(String email) {
        return  email.trim().toLowerCase(); //trim est chaine de caractere sans l espace//et que l email est en miniscule
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

    public void connectToAccount() {
        System.out.println("Please enter your email address: ");
        String email = Shellhelper.readEntry();
        System.out.println("Please enter your password: ");
        String password= Shellhelper.readEntry();
        loggerUser = loginUser(email,password);
        if(loggerUser!= null)
        {
            LOGGER.info("user connected successfully.");
            System.out.println("welcome back "+loggerUser.getFirstname()+" "+loggerUser.getLastname());
            System.out.println("------------------------------------------");
            InteractionShell.loadAccountInterface();
        }

    }

    private User loginUser(String email, String password) {
        if (!isUserRegistered(email))
        {
            LOGGER.warning("this adress "+email+"is not registred");
        }
        User user = findUserByEmail(email);
        if ((!user.getPassword().equals(password))){
            LOGGER.warning("Invalid or not existent email or password");
            return null;
        }
        return user;
    }

    private User findUserByEmail(String email) {

        return users.get(email); //find the user in the Map users by the email
    }
    public static void initializeUsers(){
        users.put ("admin@ex.com", new User("admin","admin","password",
                "admin@ex.com"));
        users.put ("test@ex.com", new User("test","test","password",
                "test@ex.com"));
    }

    public void showBalance() {
        BigDecimal balance = loggerUser.getAccount().getBalance();
        System.out.printf("your actual balance is: [%.2f]",balance);
    }
}