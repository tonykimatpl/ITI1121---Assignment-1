public class Transaction{
  private byte type;
  private double amount;

  public String processTransaction(byte operation, double amt){
    String transactionInfo;
    if(this.type == 0){
      transactionInfo = "Deposit of amount: "+amt;
    }
    else if(this.type == 1){
      transactionInfo = "Withdrawal of amount: "+amt;
    }
    else if(this.type == 2){
      transactionInfo = "Added Interest of amount: "+amt;
    }
    return transactionInfo;
  }
}
