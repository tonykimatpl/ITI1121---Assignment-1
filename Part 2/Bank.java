/*
 * Bank.java
 *
 * Created on July 21, 2004, 1:23 AM
 */
import java.util.HashMap;
import java.util.Map;
public abstract class Bank extends Account {
    private Account[] accounts;
    private int size = 0;
    private int capacity;
    private Map<String,String> accountBalances = new HashMap<String, String>();
    private Map<String, Account> accountFinder = new HashMap<String, Account>();
    private static final int SAVINGS = 0;
    private static final int CHECKING = 1;
    private static final int SENIOR = 0;
    private static final int ADULT = 1;
    private static final int STUDENT = 2;
    private static final int INIT_CAPACITY = 100;




    /** Creates a new instance of Bank */
    public Bank(){
    	accounts = new Account[INIT_CAPACITY];
      capacity = INIT_CAPACITY;
      accountBalances = new HashMap<String,String>();
      accountFinder = new HashMap<String,Account>();
    }

    /********************************************************************
     * Creates a new account.
     * pre: customer information must be not null and types must be valid
     * post: New account added to bank
     * @param customerName String Account owner's name
     * @param customerAddress String Owner's address
     * @param customerAge int Owner's age (in years)
     * @param customerPhoneNumber String Owner's phone number
     * @param customerType int Owner's type of customer within bank
     * @param typeAccount int Account type (savings or checking)
     * @return String New account number
     */
    public int addAccount(String customerFirstName, String customerLastName, int customerAge, int customerType, int typeAccount, boolean isVIP){
    if(size == (capacity - 1)){
    	this.allocate();
    }
    if(customerType == SENIOR){
      	if(typeAccount==CHECKING){
        	Account newCustomer = new Senior(customerFirstName, customerLastName, customerAge, isVIP, typeAccount);
          accounts[size] = newCustomer;
          size ++;
          int acctype = 1;
          accountBalances.put(Integer.toString(newCustomer.getAccountNumber()), Integer.toString(0));
          accountFinder.put(Integer.toString(newCustomer.getAccountNumber()), newCustomer);
        }
      	else{
        	Account newCustomer = new Senior(customerFirstName, customerLastName, customerAge, isVIP, typeAccount);
          accounts[size] = newCustomer;
          size++;
          int acctype = 0;
          accountBalances.put(Integer.toString(newCustomer.getAccountNumber()),Integer.toString(0));
          accountFinder.put(Integer.toString(newCustomer.getAccountNumber()), newCustomer);
        }
      }
      else if(customerType == ADULT){
      if(typeAccount==CHECKING){
      	Account newCustomer = new Adult(customerFirstName, customerLastName, customerAge, typeAccount);
        accounts[size] = newCustomer;
        size++;
        int acctype = 1;
        accountBalances.put(Integer.toString(newCustomer.getAccountNumber()),Integer.toString(0));
        accountFinder.put(Integer.toString(newCustomer.getAccountNumber()), newCustomer);
      }
      else{
      	Account newCustomer = new Adult(customerFirstName, customerLastName, customerAge, typeAccount);
        accounts[size] = newCustomer;
        size++;
        int acctype = 0;
        accountBalances.put(Integer.toString(newCustomer.getAccountNumber()),Integer.toString(0));
        accountFinder.put(Integer.toString(newCustomer.getAccountNumber()), newCustomer);
      }
    }
    else if(customerType == STUDENT){
    if(typeAccount==CHECKING){
      Account newCustomer = new Student(customerFirstName, customerLastName, customerAge, typeAccount);
      accounts[size] = newCustomer;
      size++;
      int acctype = 1;
      accountBalances.put(Integer.toString(newCustomer.getAccountNumber()),Integer.toString(0));
      accountFinder.put(Integer.toString(newCustomer.getAccountNumber()), newCustomer);
    }
    else{
      Account newCustomer = new Student(customerFirstName, customerLastName, customerAge, typeAccount);
      accounts[size] = newCustomer;
      size++;
      int acctype = 0;
      accountBalances.put(Integer.toString(newCustomer.getAccountNumber()),Integer.toString(0));
      accountFinder.put(Integer.toString(newCustomer.getAccountNumber()), newCustomer);
    }
  }
      return accounts[size].getAccountNumber();
    }

    /***********************************************************************
     * Make a deposit into account.
     * pre: amount must be a positive integer
     * post: Account's balance increases
     * @param accountNumber String Account's number
     * @param amount double Amount to deposit
     * @return double New balance
     */
    public double makeDeposit(String accountNumber, double amount){
    	if(this.find(accountNumber) == 1){
  		if(accountFinder.get(accountNumber).getType() == CHECKING){
      	CheckingAccount tempcheck = accountFinder.get(accountNumber);
      	tempcheck.deposit(amount);
        accountBalances.put(accountNumber, String.valueOf(accountFinder.get(accountNumber).getBalance()));
        return accountFinder.get(accountNumber).getBalance();


      }
      else if(accountFinder.get(accountNumber).getType() == SAVINGS){
      	SavingsAccount tempsave = accountFinder.get(accountNumber);
        tempsave.deposit(amount);
        accountBalances.put(accountNumber, String.valueOf(accountFinder.get(accountNumber).getBalance()));
        return accountFinder.get(accountNumber).getBalance();
      }
      }
      else{
      	System.out.println("This account does not exist in the system. Please enter a valid account number.");
      }
    }

    /***********************************************************************
     * Make a withdrawal from account.
     * pre: amount must be a positive integer
     * post: Account's balance decreases
     * @param accountNumber String Account's number
     * @param amount double Amount to withdraw
     * @return double New balance
     */
    public double makeWithdrawal(String accountNumber, double amount){
      if(this.find(accountNumber) == 1){
     if(accountFinder.get(accountNumber).getType() == CHECKING){
       CheckingAccount tempcheck = accountFinder.get(accountNumber);
       tempcheck.withdraw(amount);
       accountBalances.put(accountNumber, String.valueOf(accountFinder.get(accountNumber).getBalance()));
       return accountFinder.get(accountNumber).getBalance();


      }
      else if(accountFinder.get(accountNumber).getType() == SAVINGS){
       SavingsAccount tempsave = accountFinder.get(accountNumber);
        tempsave.withdraw(amount);
        accountBalances.put(accountNumber, String.valueOf(accountFinder.get(accountNumber).getBalance()));
        return accountFinder.get(accountNumber).getBalance();
      }
      }
      else{
       System.out.println("This account does not exist in the system. Please enter a valid account number.");
      }
    }

    /***********************************************************************
     * Returns account information as a string so it can be displayed
     * @param accountNumber String Account's number
     * @return String Account information as a String object
     */
    public String getAccount(String accountNumber){
    	return accountFinder.get(accountNumber).toString();
    }

    /***********************************************************************
     * Given an account number tells if the account exists or not
     * @param accountNumber String Account's number
     * @return int 1 if accountNumber exists in accounts[]. Otherwise, -1.
     */
    private int find(String accountNumber){
       if(accountFinder.get(accountNumber) != null){
             return 1;
          }

       return -1;
    }

 /***********************************************************************


    /** You need to create private method : Allocate to allocate a new array to hold the transactions. */
    private void allocate(){
    	if(size == accounts.length){
      	Account[] newAccounts = new Account[size*2];
        for(int i=0;i < size;i++){
        	newAccounts[i] = accounts[i];
        }
        accounts = newAccounts;
      }
    }
    public Account[] getAccounts(){
    	return this.accounts;
    }

    public abstract double getSavingsInterest();
  	public abstract double getCheckInterest();
  	public abstract double getCheckCharge();
  	public abstract double getOverPenalty();
    public abstract int getType();
}
