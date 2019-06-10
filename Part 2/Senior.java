/*Senior.java
Tony Kim, Noël Khalaf
300087407, 300079144
ITI1121
*/
/*Class Senior has a constructor, accessor and modifier methods for class variables, and extends Account*/
public class Senior extends Account{
	private double savingsInt;
	private double checkingsInt;
	private double checkingsCharge;
	private double overPenalty;
	public boolean VIP;
	private int accountType;
	//Constructor for Senior with arity 5, calls Account constructor
	public Senior(String fName, String lName,int inage,boolean VIP,int typeacc){
		super(fName,lName,inage,typeacc);			//Calls account constructor
		if(VIP == false){							//Differentiates between Senior VIP and regular Senior
			final double SAVINGS_INTEREST = 0.08;
			final double CHECK_INTEREST = 0.04;
			final double CHECK_CHARGE = 0.01;
			final double OVERDRAFT_PENALTY = 10;
			this.savingsInt = SAVINGS_INTEREST;
			this.checkingsInt = CHECK_INTEREST;
			this.checkingsCharge = CHECK_CHARGE;
			this.overPenalty = OVERDRAFT_PENALTY;
			this.accountType = typeacc;
		}
		else{
			final double SAVINGS_INTEREST = 0.1;
			final double CHECK_INTEREST = 0.04;
			final double CHECK_CHARGE = 0;
			final double OVERDRAFT_PENALTY = 5;
			this.savingsInt = SAVINGS_INTEREST;
			this.checkingsInt = CHECK_INTEREST;
			this.checkingsCharge = CHECK_CHARGE;
			this.overPenalty = OVERDRAFT_PENALTY;
			this.accountType = typeacc;
		}
		this.VIP = VIP;
	}
	//Accessor method for savingsInt
	public double getSavingsInterest(){
		return this.savingsInt;
	}
	//Accessor method for checkingsInt
	public double getCheckInterest(){
		return this.checkingsInt;
	}
	//Accessor method for checkingsCharge
	public double getCheckCharge(){
		return this.checkingsCharge;
	}
	//Accessor method for overPenalty
	public double getOverPenalty(){
		return this.overPenalty;
	}
	//Accessor method for VIP
	public boolean getVip(){
		return this.VIP;
	}
	//Modifier method for VIP
	public void setVIP(boolean vipStatus){
		this.VIP = vipStatus;
	}
	//Accessor method for accountType
	public int getType(){
		return this.accountType;
	}
}
