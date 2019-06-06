public class CheckingAccount extends Account{
	public void deposit(double amount){
    if(this.index == this.transaction.length){
      this.reallocate();
    }
    currentBal = this.getBalance() + amount;
    this.setBalance(currentBal);
    Transaction newTrans = new Transaction
    elem = newTrans.processTransaction(0,amount);
    this.transactions[this.index] = elem
  }
  public void withdraw(double amount){

    if(amount <= this.getBalance()){
      newBal = this.getBalance() - amount;
      this.setBalance(newBal);
    }
  }
}