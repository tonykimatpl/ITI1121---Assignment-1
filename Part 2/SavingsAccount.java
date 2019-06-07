public abstract class SavingsAccount extends Account{
  public void deposit(double amount){
    if(this.getIndex() == this.getTransactions().length){
      this.reallocate();
    }
    double currentBal = this.getBalance() + amount;
    this.setBalance(currentBal);
    Transaction newTrans = new Transaction((byte)0, amount, 0, "Deposit");
    String transInput = newTrans.processTransaction();
    this.addTransaction(transInput);
    this.setIndex(this.getIndex()+1);
  }
  public void withdraw(double amount){
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
          Transaction newTrans = new Transaction((byte)1,amount,25,"Withdrawal");
          String transInput = newTrans.processTransaction();
          this.addTransaction(transInput);
          this.setIndex(this.getIndex()+1);
        }
        else if((this.getBalance() - amount) < -500){
          System.out.println("This transaction could not be processed as you have reached your overdraft limit. Consider making a payment.");
        }
      }
      else if(this.getCustomer() instanceof Senior && this.getOverPenalty() == 10){
        if((this.getBalance() - amount) >= -500){
          double currentBal = this.getBalance() - amount;
          this.setBalance(currentBal);
          Transaction newTrans = new Transaction((byte)1,amount,10,"Withdrawal");
          String transInput = newTrans.processTransaction();
          this.addTransaction(transInput);
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
          Transaction newTrans = new Transaction((byte)1,amount,5,"Withdrawal");
          String transInput = newTrans.processTransaction();
          this.addTransaction(transInput);
          this.setIndex(this.getIndex()+1);
        }
        else if((this.getBalance() - amount) < -500){
          System.out.println("This transaction could not be processed as you have reached your overdraft limit. Consider making a payment.");
      }
        else if((this.getBalance() - amount) > -100){
          double currentBal = this.getBalance() - amount;
          this.setBalance(currentBal);
          Transaction newTrans = new Transaction((byte)1,amount,0,"Withdrawal");
          String transInput = newTrans.processTransaction();
          this.addTransaction(transInput);
          this.setIndex(this.getIndex()+1);
        }
    }
  }
}
  public void addInterest(){
    if(this.getIndex() == this.getTransactions().length){
      this.reallocate();
    }
    double interestAccrued = this.getBalance() * (this.getSavingsInterest());
    double newbal = this.getBalance() + interestAccrued;
    this.setBalance(newbal);
    Transaction newTrans = new Transaction((byte)2,interestAccrued,0,"Interest Accrued");
    String transInput = newTrans.processTransaction();
    this.addTransaction(transInput);
    this.setIndex(this.getIndex()+1);
  }
  public abstract double getSavingsInterest();
  public abstract double getCheckInterest();
  public abstract double getCheckCharge();
  public abstract double getOverPenalty();
}
