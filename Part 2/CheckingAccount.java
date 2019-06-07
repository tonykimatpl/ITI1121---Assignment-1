public class CheckingAccount extends Account{
	public void deposit(double amount){
	byte type;
    if(this.getIndex() == this.getTransactions().length){
      this.reallocate();
    }
    double currentBal = this.getBalance() + amount;
    this.setBalance(currentBal);
	type = 0;
    Transaction newTrans = new Transaction(type, amount, 0, "Deposit");
    this.getTransactions()[this.getIndex()] = newTrans.processTransaction();
    this.setIndex(this.getIndex()+1);
  }
  public void withdraw(double amount){
	byte type;
    amount+= this.getCheckCharge();
	if(this.getIndex() == this.getTransactions().length){
      this.reallocate();
    }

    if(amount <= this.getBalance()){
      double newBal = this.getBalance() - amount;
      this.setBalance(newBal);
      this.setIndex(this.getIndex()+1);
    }
    else if(amount > this.getBalance()){
      if(this.getCustomer() instanceof Student){
        System.out.println("Amount to be withdrawn is greater than your balance. Your student account cannot be overdrafted. Please upgrade to an adult or senior account for overdraft privileges");    
      }
      else if(this.getCustomer() instanceof Adult){
        if((this.getBalance() - amount) >= -500){
          double currentBal = this.getBalance() - amount;
          this.setBalance(currentBal);
		  type = 1;
          Transaction newTrans = new Transaction(type,amount,25,"Withdrawal");
          this.getTransactions()[this.getIndex()] = newTrans.processTransaction();
          this.setIndex(this.getIndex()+1);
        }
        else if((this.getBalance() - amount) < -500){
          System.out.println("This transaction could not be processed as you have reached your overdraft limit. Consider making a payment.");
        }
      }
      else if(this.getCustomer() instanceof Senior && this.getOverPenalty == 10){
        if((this.getBalance() - amount) >= -500){
          double currentBal = this.getBalance() - amount;
          this.setBalance(currentBal);
		  type = 1;
          Transaction newTrans = new Transaction(type,amount,10,"Withdrawal");
          this.getTransactions()[this.getIndex()] = newTrans.processTransaction();
          this.setIndex(this.getIndex()+1);
        }
        else if((this.getBalance() - amount) < -500){
          System.out.println("This transaction could not be processed as you have reached your overdraft limit. Consider making a payment.");
        }
      }
      else{
        if((this.getBalance() - amount) < -100 && (this.getBalance() - amount) > -500){
          double currentBal = this.getBalance() - amount;
          this.setBalance(currentBal);
		  type = 1;
          Transaction newTrans = new Transaction(type,amount,5,"Withdrawal");
          this.getTransactions()[this.getIndex()] = newTrans.processTransaction();
          this.setIndex(this.getIndex()+1);
        }
        else if((this.getBalance() - amount) < -500){
          System.out.println("This transaction could not be processed as you have reached your overdraft limit. Consider making a payment.");
      }
        else if((this.getBalance() - amount) > -100){
		  double currentBal = this.getBalance() - amount;
          this.setBalance(currentBal);
		  type = 1;
          Transaction newTrans = new Transaction(type,amount,5,"Withdrawal");
          this.getTransactions()[this.getIndex()] = newTrans.processTransaction();
          this.setIndex(this.getIndex()+1);
		}
	  }
    }
  }
  public void addInterest(){
	byte type = 2;
    if(this.getIndex() == this.getTransactions().length){
		this.reallocate();
	}
	double interestAccrued = this.getBalance() * (this.getCheckInterest() + 1);
	double newbal = this.getBalance() + interestAccrued;
	this.setBalance(newbal);
	Transaction newTrans = new Transaction(type,interestAccrued,0,"Interest Accrued");
	this.getTransactions()[this.getIndex()] = newTrans.processTransaction();
	this.setIndex(this.getIndex()+1);
  }
}
