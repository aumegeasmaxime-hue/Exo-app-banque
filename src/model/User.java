package model;

public class User {

    private final String firstname;
    private final String lastname;
    private final String email;
    private final String password;
    private final Account account;

    public User(String firstname, String lastname, String password, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.account = new Account();
        this.email = email;
    }

    public String getFirstname() {return firstname;}

    public String getLastname() { return lastname;}

    public String getEmail() { return email;}

    public String getPassword() {return password;}

    public Account getAccount() {return account;}


    @Override
    public String toString() {
        return "User{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", account=" + account +
                '}';
    }
}