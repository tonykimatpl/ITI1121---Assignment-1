/*CheckingAccount.java
Tony Kim, Noël Khalaf
300087407, 300079144
ITI1121
*/
/*Class CheckingAccount has a constructor, a deposit method, a withdraw method, an addInterest method, and extends Account*/
public class CheckingAccount extends Account{
	public boolean VIP;
	private double savingsInt;
	private double checkingsInt;
	private double checkingsCharge;
	private double overPenalty;
	private int accountType;
	//Constructor for SavingsAccount with arity 5
	public CheckingAccount(String fName, String lName, int inage, int customerType, boolean VIP){
		super(fName,lName,inage,customerType);			//Calls Account constructor
	  if (customerType == 0){							//Checking Account for Senior
			if(VIP == false){							//Specifically Checking Account for regular Senior
				new Senior(fName,lName,inage,false,1);
				final double SAVINGS_INTEREST = 0.08;
				final double CHECK_INTEREST = 0.04;
				final double CHECK_CHARGE = 0.01;
				final double OVERDRAFT_PENALTY = 10;
				this.savingsInt = SAVINGS_INTEREST;
				this.checkingsInt = CHECK_INTEREST;
				this.checkingsCharge = CHECK_CHARGE;
				this.overPenalty = OVERDRAFT_PENALTY;
				this.accountType = 1;
		}
			else if(VIP == true){						//Specifically Checking Account for VIP Senior
				new Senior(fName,lName,inage,true,1);
				final double SAVINGS_INTEREST = 0.1;
				final double CHECK_INTEREST = 0.04;
				final double CHECK_CHARGE = 0;
				final double OVERDRAFT_PENALTY = 5;
				this.savingsInt = SAVINGS_INTEREST;
				this.checkingsInt = CHECK_INTEREST;
				this.checkingsCharge = CHECK_CHARGE;
				this.overPenalty = OVERDRAFT_PENALTY;
				this.accountType = 1;
		}
	}
		else if(customerType == 1){							//Checking Account for Adult
			new Adult(fName,lName,inage,1);
			final double SAVINGS_INTEREST = 0.03;
			final double CHECK_INTEREST = 0.01;
			final double CHECK_CHARGE = 0.03;
			final double OVERDRAFT_PENALTY = 25;
			this.savingsInt = SAVINGS_INTEREST;
			this.checkingsInt = CHECK_INTEREST;
			this.checkingsCharge = CHECK_CHARGE;
			this.overPenalty = OVERDRAFT_PENALTY;
			this.accountType = 1;


		}
		else if(customerType == 2){							//Checking Account for Student
			new Student(fName, lName,inage,1);
			final double SAVINGS_INTEREST = 0.07;
			final double CHECK_INTEREST = 0.03;
			final double CHECK_CHARGE = 0.02;
			final double OVERDRAFT_PENALTY = 0;
			this.savingsInt = SAVINGS_INTEREST;
			this.checkingsInt = CHECK_INTEREST;
			this.checkingsCharge = CHECK_CHARGE;
			this.overPenalty = OVERDRAFT_PENALTY;
			this.accountType = 1;

		}
	}
	//Takes amount and deposits it into the account and records it in transaction array
	public void deposit(double amount){
	byte type;
    if(this.getIndex() == this.getTransactions().length){	//Doubles array size if transactions array is full
      this.reallocate();
    }
    double currentBal = this.getBalance() + amount;
    this.setBalance(currentBal);											//Increases account balance by amount
	type = 0;
    Transaction newTrans = new Transaction(type, amount, 0, "Deposit");			//creates new transaction with transaction information
    this.getTransactions()[this.getIndex()] = newTrans.processTransaction();	//processes transaction
	this.setIndex(this.getIndex()+1);											//uptades index
  }
  //Takes amount and withdraws from the account and records it in transaction array
  public void withdraw(double amount){
	byte type;
    amount+= this.checkingsCharge;
	if(this.getIndex() == this.getTransactions().length){		//Doubles array size if transactions array is full
      this.reallocate();
    }

    if(amount <= this.getBalance()){					//Withdraws from balance if amount is less than or equal to balance
      double newBal = this.getBalance() - amount;
      this.setBalance(newBal);
      this.setIndex(this.getIndex()+1);
    }
    else if(amount > this.getBalance()){				//withdrawal conditions for types when amount is greater than balance
      if(this.getCustomer() instanceof Student){		//condition for Student type
        System.out.println("Amount to be withdrawn is greater than your balance. Your student account cannot be overdrafted. Please upgrade to an adult or senior account for overdraft privileges");
      }
      else if(this.getCustomer() instanceof Adult){			//condition for Adult type
        if((this.getBalance() - amount) >= -500){			//condition for overdraft greater than or equal to -500
          double currentBal = this.getBalance() - amount;
          this.setBalance(currentBal);
		  type = 1;
          Transaction newTrans = new Transaction(type,amount,25,"Withdrawal");
          this.getTransactions()[this.getIndex()] = newTrans.processTransaction();
          this.setIndex(this.getIndex()+1);
        }
        else if((this.getBalance() - amount) < -500){				//condition for overdraft less than -500
          System.out.println("This transaction could not be processed as you have reached your overdraft limit. Consider making a payment.");
        }
      }
      else if(this.getCustomer() instanceof Senior && this.overPenalty == 10){		//condition for Senior type
        if((this.getBalance() - amount) >= -500){									//condition for overdraft greater than or equal to -500
          double currentBal = this.getBalance() - amount;
          this.setBalance(currentBal);
		  type = 1;
          Transaction newTrans = new Transaction(type,amount,10,"Withdrawal");
          this.getTransactions()[this.getIndex()] = newTrans.processTransaction();
          this.setIndex(this.getIndex()+1);
        }
        else if((this.getBalance() - amount) < -500){									//condition for overdraft less than -500
          System.out.println("This transaction could not be processed as you have reached your overdraft limit. Consider making a payment.");
        }
      }
      else{																					//condition for VIP Senior type
        if((this.getBalance() - amount) < -100 && (this.getBalance() - amount) > -500){		//condition for overdraft below -100 and above -500
          double currentBal = this.getBalance() - amount;
          this.setBalance(currentBal);
		  type = 1;
          Transaction newTrans = new Transaction(type,amount,5,"Withdrawal");
          this.getTransactions()[this.getIndex()] = newTrans.processTransaction();
          this.setIndex(this.getIndex()+1);
        }
        else if((this.getBalance() - amount) < -500){											//condition for overdraft below -500
          System.out.println("This transaction could not be processed as you have reached your overdraft limit. Consider making a payment.");
      }
        else if((this.getBalance() - amount) > -100){											//condition for overdraft above -100
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
  //Adds interest to the balance of an account
  public void addInterest(){
	byte type = 2;
    if(this.getIndex() == this.getTransactions().length){		//Doubles array size if transactions array is full
		this.reallocate();
	}
	double interestAccrued = this.getBalance() * (this.checkingsInt + 1);
	double newbal = this.getBalance() + interestAccrued;									//calculates new balance
	this.setBalance(newbal);
	Transaction newTrans = new Transaction(type,interestAccrued,0,"Interest Accrued");		//creates new transaction
	this.getTransactions()[this.getIndex()] = newTrans.processTransaction();				//processes transaction information
	this.setIndex(this.getIndex()+1);														//updates array index
  }
}
