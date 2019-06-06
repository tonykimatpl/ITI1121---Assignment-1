public class Senior extends Customer{
	private double savingsInt;
	private double checkingsInt;
	private double checkingsCharge;
	private double overPenalty;
	public boolean VIP;

	public Senior(boolean VIP){
		if(VIP == false){
			private static final double SAVINGS_INTEREST = 0.08;
			private static final double CHECK_INTEREST = 0.04;
			private static final double CHECK_CHARGE = 1;
			private static final double OVERDRAFT_PENALTY = 10;
		}
		else{
			private static final double SAVINGS_INTEREST = 0.1;
			private static final double CHECK_INTEREST = 0.04;
			private static final double CHECK_CHARGE = 0;
			private static final double OVERDRAFT_PENALTY = 5;
		}
		super(fName, lName, inage);
		this.savingsInt = SAVINGS_INTEREST;
		this.checkingsInt = CHECK_INTEREST;
		this.checkingsCharge = CHECK_CHARGE;
		this.overPenalty = OVERDRAFT_PENALTY;
		this.VIP = VIP;
	}
	public double getSavingsInterest(){
		return this.savingsInt;
	}
	public double getCheckInterest(){
		return this.checkingsInt;
	}
	public double getCheckCharge(){
		return this.checkingsCharge;
	}
	public boolean getVip(){
		return this.VIP;
	}
}
