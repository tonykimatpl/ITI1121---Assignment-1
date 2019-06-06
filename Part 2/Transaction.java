public class Transaction{
  private byte type;
  private double amount;

  public String processTransaction{
    String transactionInfo;
    if(this.type == 0){
      transactionInfo = "Deposit of amount: "+this.amount;
    }
    else if(this.type == 1){
      transactionInfo = "Withdrawal of amount: "+this.amount;
    }
    else if(this.type == 2){
      transactionInfo = "Added Interest of amount: "+this.amount;
    }
    return transactionInfo;
  }
}
