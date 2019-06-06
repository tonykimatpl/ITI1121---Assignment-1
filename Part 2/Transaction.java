import java.util.Date;
public class Transaction{
  private byte type;
  private double amount;
  private Date date;
  private double fees;
  private String description;

  public Transaction(byte operation, double amt, Date datum, double fee, String desc){
    this.type = operation;
    this.amount = amt;
    this.date = datum;
    this.fees = fee;
    this.description = desc;
  }

  public Transaction(byte operation, double amt, double fee, String desc){
    java.util.Date currentdate = new java.util.Date();
    this.date = currentdate;
    this.type = operation;
    this.amount = amt;
    this.fees = fee;
    this.description = desc;
  }

  public String processTransaction(){
    String transactionInfo;
    if(this.type) == 0){
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
