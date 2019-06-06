public class CheckingAccount extends Account{
	public void deposit(double amount){
		if(this.index == this.transactions.length){
			
		}
		else{
			this.balance += amount;
			processTransaction(0,amount);
		}
	}
	public void withdraw(double amount){
		if(this.index = this.transactions.length){
		
		}
		else{
			this.balance -= amount;
			processTransaction(1,amount);
		}
	}
	public void addInterest(){
		
	}
}