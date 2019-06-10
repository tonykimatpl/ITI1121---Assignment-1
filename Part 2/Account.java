/*Account.java
Tony Kim, Noël Khalaf
300087407, 300079144
ITI1121
*/
/*Class Account stores an array of transactions and has accessors, modifiers for instance variables, and extends Customer*/
public class Account extends Customer{
	private int lastAccountNumber = 9999;
	private int accountNumber;
  private Customer customer;
	private double balance;
  private String[] transactions;
	private Transaction newTransArray;
  private static final int INITSIZE = 25;
	private int index = 0;
	private int acctype;
	//Constructor for Account instance with arity 0
	public Account(){
		this.accountNumber = lastAccountNumber;
		lastAccountNumber ++;
		this.balance = 0;
		this.index = 0;
		String[] transactions = new String[INITSIZE];
	}
	//Constructor for Account instance with arity 4
	public Account(String fName, String lName, int inage, int accountType){
		super(fName,lName,inage);
		this.accountNumber = lastAccountNumber;
		lastAccountNumber ++;
		this.balance = 0;
		this.index = 0;
		this.acctype = accountType;
		String[] transactions = new String[INITSIZE];
	}
	//Doubles the length of an array of transactions to hold more transactions
	public void reallocate(){
    if(this.getIndex() == this.transactions.length){
        int var = this.transactions.length;
        String[] newTransArray = new String[var*2];		//temporary array of transactions with twice the length of other array
        for(int i=0; i < var;i++){
          newTransArray[i] = this.transactions[i];		//transfers transactions to new array
        }
			this.transactions = newTransArray;
      }
    }
  //Accessor method for balance
  public double getBalance(){
    return this.balance;
  }
	//Modifier method for balance
	public void setBalance(double newBal){
		this.balance = newBal;
	}
	//Accessor method for customer
  public Customer getCustomer(){
    return this.customer;
  }
  //Modifier method for customer
  public void setCustomer(Customer other){
    this.customer = other;
  }
  //toString method for Account instance
  public String toString(){
    String a = "Account balance is: "+ this.balance+". Account Number is: "+ this.accountNumber+". "+"Customer Number is: "+this.getCustomer()+".";
    return a;
  }
  //Accessor method for index
	public int getIndex(){
		return this.index;
	}
	//Modifier method for index
	public void setIndex(int newIndex){
		this.index = newIndex;
	}
	//Accessor method for transactions
	public String[] getTransactions(){
		return this.transactions;
	}
	//Takes a transaction as parameter and adds it to the list of transactions
	public void addTransaction(String newTranAr){
		this.transactions[this.getIndex()] = newTranAr;
	}
	//Accessor method for accountNumber
	public int getAccountNumber(){
		return this.accountNumber;
	}
	//Accessor method for acctype
	public int getType(){
		return this.acctype;
	}
}
