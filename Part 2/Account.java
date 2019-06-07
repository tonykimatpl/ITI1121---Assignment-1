public abstract class Account{
	private static int lastAccountNumber = 9999;
	private int accountNumber;
  private Customer customer;
	private double balance;
  private Transaction[] transactions;
	private Transaction newTransArray;
  private static final int INITSIZE = 25;
	private int index = 0;

	public Account(){
		this.accountNumber = lastAccountNumber;
		lastAccountNumber ++;
		this.customer = new Customer();
		this.balance = 0;
		this.index = 0;
		Transaction[] transactions = new Transaction[INITSIZE];
	}

	public Account(Customer person, double bal){
    this.balance = bal;
    this.customer = person;
		this.accountNumber = lastAccountNumber;
		lastAccountNumber ++;
		this.index = 0;
    Transaction[] transactions = new Transaction[INITSIZE];
	}

	public void reallocate(){
    if(this.index == this.transactions.length){
        int var = this.transactions.length;
        Transaction[] newTransArray = new Transaction[var*2];
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
}
