public class Adult extends Customer{
	private static final double SAVINGS_doubleEREST = 0.03;
	private static final double CHECK_doubleEREST = 0.01;
	private static final double CHECK_CHARGE = 0.03;
	private static final double OVERDRAFT_PENALTY = 25;
	private double savingsdouble;
	private double checkingsdouble;
	private double checkingsCharge;
	private double overPenalty;
	
	public Adult(){
		super(fName, lName, inage);
		this.savingsdouble = SAVINGS_doubleEREST;
		this.checkingsdouble = CHECK_doubleEREST;
		this.checkingsCharge = CHECK_CHARGE;
		this.overPenalty = OVERDRAFT_PENALTY;
	}
	public double getSavingsdoubleerest(){
		return this.savingsdouble;
	}
	public double getCheckdoubleerest(){
		return this.checkingsdouble;
	}
	public double getCheckCharge(){
		return this.checkingsCharge;
	}
	public double getOverPenalty(){
		return this.overPenalty;
	}
}