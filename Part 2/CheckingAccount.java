public class CheckingAccount extends Account{
	public boolean VIP;
	private double savingsInt;
	private double checkingsInt;
	private double checkingsCharge;
	private double overPenalty;
	private int accountType;
	public CheckingAccount(String fName, String lName, int inage, int customerType, boolean VIP){
		super(fName,lName,inage,customerType);
	  if (customerType == 0){
			if(VIP == false){
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
			else if(VIP == true){
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
		else if(customerType == 1){
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
		else if(customerType == 2){
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
    amount+= this.checkingsCharge;
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
      else if(this.getCustomer() instanceof Senior && this.overPenalty == 10){
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
	double interestAccrued = this.getBalance() * (this.checkingsInt + 1);
	double newbal = this.getBalance() + interestAccrued;
	this.setBalance(newbal);
	Transaction newTrans = new Transaction(type,interestAccrued,0,"Interest Accrued");
	this.getTransactions()[this.getIndex()] = newTrans.processTransaction();
	this.setIndex(this.getIndex()+1);
  }
}
