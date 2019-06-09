public abstract class Account{
	private static int lastAccountNumber = 9999;
	private int accountNumber;
  private Customer customer;
	private double balance;
  private String[] transactions;
	private Transaction newTransArray;
  private static final int INITSIZE = 25;
	private int index = 0;

	public Account(){
		this.accountNumber = lastAccountNumber;
		lastAccountNumber ++;
		this.balance = 0;
		this.index = 0;
		String[] transactions = new String[INITSIZE];
	}

	public Account(Customer person, double bal){
    this.balance = bal;
    this.customer = person;
		this.accountNumber = lastAccountNumber;
		lastAccountNumber ++;
		this.index = 0;
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
	public abstract double getSavingsInterest();
  public abstract double getCheckInterest();
  public abstract double getCheckCharge();
  public abstract double getOverPenalty();
  public abstract int getType();
}
