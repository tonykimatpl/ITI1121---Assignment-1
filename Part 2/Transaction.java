public class Transaction{
  private byte type;
  private double amount;

  public String processTransaction(byte operation, double amt){
    String transactionInfo;
    if(operation == 0){
      transactionInfo = "Deposit of amount: "+amt;
    }
    else if(operation == 1){
      transactionInfo = "Withdrawal of amount: "+amt;
    }
    else if(operation == 2){
      transactionInfo = "Added Interest of amount: "+amt;
    }
    return transactionInfo;
  }
}
