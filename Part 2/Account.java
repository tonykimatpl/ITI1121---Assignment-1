public abstract class Account{
	private static lastAccountNumber = 9999;
  private Customer customer;
	private double balance;
  private Transaction[] transactions;
	private Transaction newTransArray;
  private static final int INITSIZE = 25;
	private int index = 0;


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
        var = this.transactions.length;
        Transaction[] newTransArray = new Transactions[var*2];
        for(int i=0; i < var;i++){
          newTransArray[i] = this.transactions[i];
        }
				this.transactions = newTransArray;
      }
		else{
			break;
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
    String a = "Account balance is: "+ this.balance+". Account Number is: "+ this.accountNumber+". ";
    String b = this.getCustomer();
    return a,b;

  }
}
