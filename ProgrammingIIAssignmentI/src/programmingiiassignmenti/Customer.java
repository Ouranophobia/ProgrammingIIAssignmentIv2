
package programmingiiassignmenti;

public class Customer {
   
    
    private final Name n;
    private final Address a;
    private String accountNum;
    
    public Customer(Name n, Address a, String accountNum){
        
        this.n = n;
        this.a = a;
        this.accountNum = accountNum;
    }
    
    public String getName(){
        return n.getName();
    }
    
    public String getAddress(){
        return a.getAddress();
    }
    
    public void setAccountNum(String accountNum){
        this.accountNum = accountNum;
    }
    
    public String getAccountNum(){
        return accountNum;
    }
    
    public String getStreet(){
        return a.getStreet();
    }
    
    public String getCity(){
        return a.getCity();
    }
    
    public String getState(){
        return a.getState();
    }
    
    public String getZip(){
        return a.getZip();
    }
    
}
