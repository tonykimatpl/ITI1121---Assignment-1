public class Adult extends Customer{
	private static final double SAVINGS_INTEREST = 0.03;
	private static final double CHECK_INTEREST = 0.01;
	private static final double CHECK_CHARGE = 0.03;
	private static final double OVERDRAFT_PENALTY = 25;
	private double savingsInt;
	private double checkingsInt;
	private double checkingsCharge;
	private double overPenalty;
	
	public Adult(String fName, String lName,int inage){
		super(fName, lName, inage);
		this.savingsInt = SAVINGS_INTEREST;
		this.checkingsInt = CHECK_INTEREST;
		this.checkingsCharge = CHECK_CHARGE;
		this.overPenalty = OVERDRAFT_PENALTY;
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
}