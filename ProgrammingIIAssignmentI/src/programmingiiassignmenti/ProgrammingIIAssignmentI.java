
package programmingiiassignmenti;

import java.awt.Dimension;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ProgrammingIIAssignmentI {

    public static void main(String[] args) {
        
        ArrayList<BankAccount> bankAccounts = new ArrayList<>();
        ArrayList<BankAccount> closedBankAccounts = new ArrayList<>();
        
        boolean done = false;
        
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date();
        
        while(!done){
            int menu = GetData.getInt("\tUnited Bank of Java\n"
                    + "\nPlease Choose From the Following"
                    + "\n1. Create New Account"
                    + "\n2. Update Existing Account"
                    + "\n3. Close an Account"
                    + "\n4. View Account Information"
                    + "\n5. Exit");
            
            switch(menu)
            {
                case 1://Create bank account obj and store in database
                   String first = JOptionPane.showInputDialog(null, "What is your first name?");
                   String last = JOptionPane.showInputDialog(null, "What is your last name?");
                   Name customerName = new Name(first, last);
                   JOptionPane.showMessageDialog(null, "Customer name is " + customerName.getName());
                   String street = JOptionPane.showInputDialog(null, "What's your street address?");
                   String city = JOptionPane.showInputDialog(null, "What city do you live in?");
                   String state = JOptionPane.showInputDialog(null, "What state do you live in?");
                   String zip = JOptionPane.showInputDialog(null, "What is your ZIP code?");
                   Address customerAddress = new Address(street, city, state, zip);
                   JOptionPane.showMessageDialog(null, "Customer's address is: \n" + customerAddress.getAddress());
                   String accountNum = JOptionPane.showInputDialog(null, "What do you want your account number to be?");
                   Customer c = new Customer(customerName, customerAddress, accountNum);
                   JOptionPane.showMessageDialog(null, "Welcome!\nHere's your info.\nName: " + c.getName()
                   + "\nAddress: " + c.getAddress() + "\nAccount #: " + c.getAccountNum());
                   String balance = JOptionPane.showInputDialog(null, "What will be your initial balance?");
                   double bal = Double.parseDouble(balance);
                   BankAccount bankacc = new BankAccount(c, bal);
                   JOptionPane.showMessageDialog(null, "Your balance is: \n" + bankacc.getBalance());
                   bankAccounts.add(bankacc);
                   System.out.print(bankAccounts.indexOf(bankacc) + " " + bankAccounts.size());
                 
                   
                break;
                
                case 2://Update Account
                    int money = GetData.getInt("What would you like to do?"
                            + "\n1. Make a deposit."
                            + "\n2. Make a withdrawal."
                            + "\n");
                    
                    switch(money)
                    {
                        case 1://Make a deposit
                            String accNum = JOptionPane.showInputDialog(null, "What is your account number?");
                             if (BankAccount.findAccNum(bankAccounts, accNum)){
                                 JOptionPane.showMessageDialog(null, "Account found!");
                                 int i = BankAccount.findIndex(bankAccounts, accNum);
                                 JOptionPane.showMessageDialog(null, "Account balance is currently: $" + bankAccounts.get(i).getBalance());
                                 String x = JOptionPane.showInputDialog(null, "How much would you like to deposit?");
                                 double y = Double.parseDouble(x);
                                 bankAccounts.get(i).deposit(y);
                                 JOptionPane.showMessageDialog(null, "Your new balance is: $" + bankAccounts.get(i).getBalance());
                             }
                             else{
                                 JOptionPane.showMessageDialog(null, "Account not in database.");
                             }
                            break;
                        
                        case 2://Make a withdrawal
                            String accNum1 = JOptionPane.showInputDialog(null, "What is your account number?");
                            if(BankAccount.findAccNum(bankAccounts, accNum1)){
                                JOptionPane.showMessageDialog(null, "Account found!");
                                 int i = BankAccount.findIndex(bankAccounts, accNum1);
                                 JOptionPane.showMessageDialog(null, "Account balance is currently: $" + bankAccounts.get(i).getBalance());
                                 String x = JOptionPane.showInputDialog(null, "How much would you like to withdraw?");
                                 double y = Double.parseDouble(x);
                                 
                                 if(y < bankAccounts.get(i).getBalance()){
                                 bankAccounts.get(i).withdraw(y);
                                 JOptionPane.showMessageDialog(null, "Your new balance is: $" + bankAccounts.get(i).getBalance());
                                 }
                                 else{
                                     JOptionPane.showMessageDialog(null, "Insufficient funds.");
                                 }
                            }
                            else{
                                 JOptionPane.showMessageDialog(null, "Account not in database.");
                             }
                            break;
                            
                        default: JOptionPane.showMessageDialog(null, "Invalid option.");
                            break;
                    }

                    break;
                
                case 3://close account
                    
                     String accNum = JOptionPane.showInputDialog(null, "What is the account number?");
                   if (BankAccount.findAccNum(bankAccounts, accNum)){
                       JOptionPane.showMessageDialog(null, "Account found!");
                       int i = BankAccount.findIndex(bankAccounts, accNum);
                       BankAccount clone = bankAccounts.get(i);
                       bankAccounts.get(i).deactivate();
                       JOptionPane.showMessageDialog(null, "Account is located in the ArrayList at index: " + i);
                       closedBankAccounts.add(clone);
                       bankAccounts.remove(i);
                   }
                   else{
                       JOptionPane.showMessageDialog(null, "Account not found!");
                   }
                    
                break;
                    
                case 4://view account info
                    int view = GetData.getInt("What information would you like to view?"
                            + "\n1. Single Account"
                            + "\n2. All active accounts"
                            + "\n3. All inactive accounts"
                            + "\n");
                    
                    switch(view)
                    {
                        case 1: //view single account
                            String accNum2 = JOptionPane.showInputDialog(null, "Please enter account number to view information on it.");
                            
                            if (BankAccount.findAccNum(bankAccounts, accNum2)){
                                JOptionPane.showMessageDialog(null, "Account found!");
                            
                                int i = BankAccount.findIndex(bankAccounts, accNum2);
                                JOptionPane.showMessageDialog(null, "Name: " + bankAccounts.get(i).getName() +
                                "\nAccount Number: " + bankAccounts.get(i).getAccountNum() + 
                                "\nBalance: $" + bankAccounts.get(i).getBalance());
                            }
                            
                            else{
                                JOptionPane.showMessageDialog(null, "Account not in database.");
                            }
                            
                        break;
                            
                        case 2://view all account
                            
                                
                            
                            
                                /*JTextArea textArea = new JTextArea("Date: " + dateFormat.format(date) + 
                                        BankAccount.printAllCustomers(bankAccounts));
                                JScrollPane scrollPane = new JScrollPane(textArea);  
                                textArea.setLineWrap(true);  
                                textArea.setWrapStyleWord(true); 
                                scrollPane.setPreferredSize( new Dimension( 300, 400 ) );
                                JOptionPane.showMessageDialog(null, scrollPane, "Current Customers",  
                                       JOptionPane.YES_NO_OPTION);
                            
                            */
                        break;
                            
                        case 3://view all closed accounts
                        break;
                            
                        default: JOptionPane.showMessageDialog(null, "Invalid Option.");
                            break;
                    }//end view
                break;
                
                case 5://exit
                    done = true;
                break;
                    
                default:
                    JOptionPane.showMessageDialog(null, "Account not found.");
                    break;
              
                
            }
        
            
        }
        
        
        
    }
    
}

