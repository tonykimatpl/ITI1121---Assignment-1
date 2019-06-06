public class Senior extends Customer{
	private double savingsInt;
	private double checkingsInt;
	private int checkingsCharge;
	private int overPenalty;
	private boolean vip;
	
	public void Senior(boolean VIP){
		if(VIP == false){
			private static final double SAVINGS_INTEREST = 0.08;
			private static final double CHECK_INTEREST = 0.04;
			private static final int CHECK_CHARGE = 1;
			private static final int OVERDRAFT_PENALTY = 10;
		}
		else{
			private static final double SAVINGS_INTEREST = 0.1;
			private static final double CHECK_INTEREST = 0.04;
			private static final int CHECK_CHARGE = 0;
			private static final int OVERDRAFT_PENALTY = 5;
		}
		this.savingsInt = SAVINGS_INTEREST;
		this.checkingsInt = CHECK_INTEREST;
		this.checkingsCharge = CHECK_CHARGE;
		this.overPenalty = OVERDRAFT_PENALTY;
		this.vip = VIP;
	}
}