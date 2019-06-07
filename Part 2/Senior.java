public class Senior extends Customer{
	private double savingsInt;
	private double checkingsInt;
	private double checkingsCharge;
	private double overPenalty;
	public boolean VIP;

	public Senior(String fName, String lName,int inage,boolean VIP){
		super(fName,lName,inage);
		if(VIP == false){
			final double SAVINGS_INTEREST = 0.08;
			final double CHECK_INTEREST = 0.04;
			final double CHECK_CHARGE = 0.01;
			final double OVERDRAFT_PENALTY = 10;
			this.savingsInt = SAVINGS_INTEREST;
			this.checkingsInt = CHECK_INTEREST;
			this.checkingsCharge = CHECK_CHARGE;
			this.overPenalty = OVERDRAFT_PENALTY;
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
		}
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
	public double getOverPenalty(){
		return this.overPenalty;
	}
	public boolean getVip(){
		return this.VIP;
	}
}
