
package programmingiiassignmenti;

import java.util.ArrayList;

public class BankAccount {
  
    private final String street;
    private final String city;
    private final String state;
    private final String zip;
    
    
    
    private final Address address;
    private final Customer c;
    private double balance;
    private boolean active = true;
    
    public BankAccount(Customer c, double balance){
        
        
        
        this.address = new Address(c.getStreet(), c.getCity(), c.getState(), c.getZip());
        this.c = c;
        this.balance = balance;
        this.street = address.getStreet();
        this.city = address.getCity();
        this.state = address.getState();
        this.zip = address.getZip();
        
    }
    
    public void setBalance(double balance){
        this.balance = balance;
    }
    
    public void deposit(double balance){
        this.balance += balance;
    }
    
    public void withdraw(double balance){
        this.balance -= balance;
    }
    
    public double getBalance(){
        return balance;
    }
    
    public String getName(){
        return c.getName();
    }
    
    public String getAddress(){
        return c.getAddress();
    }
    
    public String getAccountNum(){
        return c.getAccountNum();
    }
    
    public void deactivate(){
        active =false;
    }
    
    public static boolean findAccNum(ArrayList<BankAccount> bankAccounts, String s){
        
        for(BankAccount ba: bankAccounts){
            if(ba.getAccountNum().equals(s))
                return true;
        }
        return false;
    }
    
    public static int findIndex(ArrayList<BankAccount> bankAccounts, String s){
        
        for(BankAccount ba: bankAccounts){
            if(ba.getAccountNum().equals(s))
                return bankAccounts.indexOf(ba);
        }
        return 0;
        
    }
    
    /*public static String printAllCustomers(ArrayList<BankAccount> bankAccounts){
        
        ArrayList<String> a = null;
        String b = null;
        String c = null;
        String d = null;
        String e = null;
        String f = null;
        
        for(BankAccount ba : bankAccounts)
                 a.add("Account Number: " + ba.getAccountNum() + " Name: " + ba.getName()); 
        for(BankAccount ba : bankAccounts)
                 b = ("\nStreet: " + ba.street + "\t\t");
        for(BankAccount ba : bankAccounts)                    
                 c = ("\nCity: " + ba.city + "\t\t");
        for(BankAccount ba : bankAccounts)
                 d = ("\nState: " + ba.state + "\t\t");
        for(BankAccount ba : bankAccounts)
                 e = ("\nZip: " + ba.zip + "\t\t");
        for(BankAccount ba : bankAccounts)                    
                 f =   (ba.getBalance() + "\t\t");
        
        return (a + "\n" + b + "\n" + c + "\n" + d + "\n" + e + "\n" + f);
        
        
        
    }*/
    
}
