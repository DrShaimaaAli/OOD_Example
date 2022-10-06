import java.util.Scanner;
public class ATMSystem {
    final static String[] ACCOUNT_TYPES = {"Debit", "Credit", "Saving"};
   private long accountNumber;
   private String accountUserName;
   private String accountPassword;
   private double accountBalance;
   private String accountType;
   
    final static String[] ATM_OPTIONS = {"login","choose acct type","deposit","withdraw","exit"};
   
    /**
     * @return the accountNumber
     */
    public long getAccountNumber() {
        return accountNumber;
    }

    /**
     * @param accountNumber the accountNumber to set
     */
    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * @return the accountUserName
     */
    public String getAccountUserName() {
        return accountUserName;
    }

    /**
     * @param accountUserName the accountUserName to set
     */
    public void setAccountUserName(String accountUserName) {
        this.accountUserName = accountUserName;
    }

    /**
     * @return the accountPassword
     */
    public String getAccountPassword() {
        return accountPassword;
    }

    /**
     * @param accountPassword the accountPassword to set
     */
    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }

    /**
     * @return the accountBalance
     */
    public double getAccountBalance() {
        return accountBalance;
    }

    /**
     * @param accountBalance the accountBalance to set
     */
    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    /**
     * @return the accountType
     */
    public String getAccountType() {
        return accountType;
    }

    /**
     * @param accountType the accountType to set
     */
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    
    public static void main(String[] args) {
        
        ATMSystem atm = new ATMSystem();
        
        //Display available options
        boolean runFlag = true;
        while (runFlag)
        {
	         System.out.println("Please choose the option number:");
	         for (int i=0; i<ATMSystem.ATM_OPTIONS.length; i++)
	         {
	             System.out.println(i +" - " + ATMSystem.ATM_OPTIONS[i]);
	         }
	         
	         Scanner sc = new Scanner (System.in);
	         int option = sc.nextInt();
	         switch (option)
	         {
	         	case 0:
	         		 System.out.println("Please enter user name:\n");
		             String userName = sc.next();  
		             atm.setAccountUserName(userName);
		             
		             System.out.println("Please enter password:\n");
		             String password = sc.next();
		             atm.setAccountPassword(password);
	         		break;
	         	case 1:
	         		 System.out.println("Please choose an account type:");
		   	         for (int i=0; i<ATMSystem.ACCOUNT_TYPES.length; i++)
		   	         {
		   	             System.out.println(i +" - " + ATMSystem.ACCOUNT_TYPES[i]);
		   	         }
			         int acct_option = sc.nextInt();
			         atm.setAccountType(ATMSystem.ACCOUNT_TYPES[acct_option]);
			         System.out.println("Account type is set to:" + atm.getAccountType());
	         		break;
	         	case 2:
	         		 System.out.println("Please enter amount to deposit");
	                 double newAmount = sc.nextDouble();
	                 System.out.println("Please enter cash or check in the deposit box");
	                 /*logic to count cash or scan check*/
	                 atm.setAccountBalance(atm.getAccountBalance() + newAmount);
	                 System.out.println("New balance is:" + atm.getAccountBalance());
	         		
	                 break;
	         	case 3:
	         	    System.out.println("Please enter amount to withdraw:");
                    double amount = sc.nextDouble();
                 
                    // make sure there's enough balance before withdrawal
                    double currentBalance = atm.getAccountBalance();
                    double balanceAfterWithdraw = currentBalance - amount;
                    if ( balanceAfterWithdraw > 0 )
                    {
                      /*Logic to instruct the machine to dispense the money*/
                      System.out.println("Please take the money from the cash dispenser");
                      atm.setAccountBalance(balanceAfterWithdraw);
                      System.out.println("New balance is:" + atm.getAccountBalance());
                    }
                    else
                        System.out.println("Balance is not sufficient");
                    
	         		break;
	         	default:
	         		System.out.println("Goodbye");
	         		runFlag = false;
	         }
	         
        }
    }
    
}