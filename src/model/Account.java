package model;

public class Account {
    private double balance= 0;

    public void deposit(double amount)
    {
        balance +=amount;
    }

    public boolean withdraw(double amount)
    {
        if(amount >= balance)
        {
            balance -=amount;
            return true;
        }
        return false;
    }


}