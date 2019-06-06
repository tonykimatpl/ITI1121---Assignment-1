public abstract class Account{
	private static lastAccountNumber = 9999;
  private Customer customer;
	private double balance;
  private Transaction[] transactions;
	private Transaction newTransArray;
  private static final int INITSIZE = 25;


	public Account(Customer person, double bal){
    this.balance = bal;
    this.customer = person;
		this.accountNumber = lastAccountNumber;
		lastAccountNumber ++;
    Transaction[] transactions = new Transaction[INITSIZE];
	}

	public void reallocate(){
    for(int i = 0; i < this.transactions.length;i++){
      if(this.transactions[i] == null){
        break;
      }
      else{
        var = this.transactions.length;
        Transaction[] newTransArray = new Transactions[var*2];
        for(int i=0; i < var;i++){
          newTransArray[i] = this.transactions[i];
        }
        this.transactions = newTransArray;
      }
    }
	}
  public double getBalance(){
    return this.balance;
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
