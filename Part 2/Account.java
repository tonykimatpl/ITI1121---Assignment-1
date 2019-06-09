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

	public Account(){
		this.accountNumber = lastAccountNumber;
		lastAccountNumber ++;
		this.balance = 0;
		this.index = 0;
		String[] transactions = new String[INITSIZE];
	}
	public Account(String fName, String lName, int inage, int accountType){
		super(fName,lName,inage);
		this.accountNumber = lastAccountNumber;
		lastAccountNumber ++;
		this.balance = 0;
		this.index = 0;
		this.acctype = accountType;
		String[] transactions = new String[INITSIZE];
	}

	public void reallocate(){
    if(this.getIndex() == this.transactions.length){
        int var = this.transactions.length;
        String[] newTransArray = new String[var*2];
        for(int i=0; i < var;i++){
          newTransArray[i] = this.transactions[i];
        }
				this.transactions = newTransArray;
      }
		else{
			;
		}
    }

  public double getBalance(){
    return this.balance;
  }
	public void setBalance(double newBal){
		this.balance = newBal;
	}
  public Customer getCustomer(){
    return this.customer;
  }
  public void setCustomer(Customer other){
    this.customer = other;
  }
  public String toString(){
    String a = "Account balance is: "+ this.balance+". Account Number is: "+ this.accountNumber+". "+"Customer Number is: "+this.getCustomer()+".";
    return a;
  }
	public int getIndex(){
		return this.index;
	}
	public void setIndex(int newIndex){
		this.index = newIndex;
	}
	public String[] getTransactions(){
		return this.transactions;
	}
	public void addTransaction(String newTranAr){
		this.transactions[this.getIndex()] = newTranAr;
	}
	public int getAccountNumber(){
		return this.accountNumber;
	}
	public int getType(){
		return this.acctype;
	}
}
