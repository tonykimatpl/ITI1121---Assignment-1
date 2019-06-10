/*Transaction.java
Tony Kim, Noël Khalaf
300087407, 300079144
ITI1121
*/
import java.util.Date;	//imports Date utility
/*Class Transaction has two constructor and a processTransaction method with transaction information*/
public class Transaction{
  private byte type;
  private double amount;
  private Date date;
  private double fees;
  private String description;
	//Constructor for Transaction with arity 5
  public Transaction(byte operation, double amt, Date datum, double fee, String desc){
    this.type = operation;
    this.amount = amt;
    this.date = datum;
    this.fees = fee;
    this.description = desc;
  }
	//Constructor for Transaction with arity 4
  public Transaction(byte operation, double amt, double fee, String desc){
    java.util.Date currentdate = new java.util.Date();		//creates date
    this.date = currentdate;
    this.type = operation;
    this.amount = amt;
    this.fees = fee;
    this.description = desc;
  }
	//Returns transaction information including amount, fees, date, and description
  public String processTransaction(){
    String transactionInfo = "";
    if(this.type == 0){					//for deposit information
      transactionInfo = "Deposit of amount: " +this.amount + " | Fees incurred: "+this.fees+" | Date: "+this.date+" | Description: "+this.description;
    }
    else if(this.type == 1){			//for withdrawal information
      transactionInfo = "Withdrawal of amount: " +this.amount + " | Fees incurred: "+this.fees+" | Date: "+this.date+" | Description: "+this.description;
    }
    else if(this.type == 2){			//for added interest information
      transactionInfo = "Added Interest of amount: " +this.amount + " | Fees incurred: "+this.fees+" | Date: "+this.date+" | Description: "+this.description;
    }
    return transactionInfo;
  }
}
