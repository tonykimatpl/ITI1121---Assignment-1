public class SavingsAccount extends Account{
  public void deposit(double amount){
    if(this.index == this.transaction.length){
      this.reallocate();
    }
    double currentBal = this.getBalance() + amount;
    this.setBalance(currentBal);
    Transaction newTrans = new Transaction(0, amount, 0, "Deposit");
    this.transactions[this.index] = newTrans.processTransaction();
    this.index++;
  }
  public void withdraw(double amount){
    if(this.index == this.transaction.length){
      this.reallocate();
    }

    if(amount <= this.getBalance()){
      double newBal = this.getBalance() - amount;
      this.setBalance(newBal);
      this.index++;
    }
    else if(amount > this.getBalance()){
      if(this.getCustomer() instanceof Student){
        System.out.println("Amount to be withdrawn is greater than your balance. Your student account cannot be overdrafted. Please upgrade to an adult or senior account for overdraft privileges")
      }
      else if(this.getCustomer() instanceof Adult){
        if((this.getBalance() - amount) >= -500){
          double currentBal = this.getBalance() - amount;
          this.setBalance(currentBal);
          Transaction newTrans = new Transaction(1,amount,25,"Withdrawal");
          this.transactions[this.index] = newTrans.processTransaction();
          this.index++;
        }
        else if((this.getBalance() - amount) < -500){
          System.out.println("This transaction could not be processed as you have reached your overdraft limit. Consider making a payment.");
        }
      }
      else if(this.getCustomer() instanceof Senior && this.getOverPenalty == 10){
        if((this.getBalance() - amount) >= -500){
          double currentBal = this.getBalance() - amount;
          this.setBalance(currentBal);
          Transaction newTrans = new Transaction(1,amount,10,"Withdrawal");
          this.transactions[this.index] = newTrans.processTransaction();
          this.index++;
        }
        else if((this.getBalance() - amount) < -500){
          System.out.println("This transaction could not be processed as you have reached your overdraft limit. Consider making a payment.");
        }
      }
      else{
        if((this.getBalance() - amount) < -100 && (this.getBalance() - amount) > -500){
          double currentBal = this.getBalance() - amount;
          this.setBalance(currentBal);
          Transaction newTrans = new Transaction(1,amount,5,"Withdrawal");
          this.transactions[this.index] = newTrans.processTransaction();
          this.index++;
        }
        else if((this.getBalance() - amount) < -500){
          System.out.println("This transaction could not be processed as you have reached your overdraft limit. Consider making a payment.");
      }
        else if((this.getBalance() - amount) > -100){
          double currentBal = this.getBalance() - amount;
          this.setBalance(currentBal);
          Transaction newTrans = new Transaction(1,amount,0,"Withdrawal");
          this.transactions[this.index] = newTrans.processTransaction();
          this.index++;
        }
    }
  }
}
  public void addInterest(){
    if(this.index == this.transaction.length){
      this.reallocate();
    }
    double interestAccrued = this.getBalance() * (this.getSavingsInterest());
    double newbal = this.getBalance() + interestAccrued;
    this.setBalance(newbal);
    Transaction newTrans = new Transaction(2,interestAccrued,0,"Interest Accrued");
    this.transactions[this.index] = newTrans.processTransaction();
    this.index++;
  }
}
