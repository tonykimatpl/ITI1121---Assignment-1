/*Student.java
Tony Kim, Noël Khalaf
300087407, 300079144
ITI1121
*/
/*Class Student has a constructor, accessor and modifier methods for class variables, and extends Account*/
public class Student extends Account{
	private static final double SAVINGS_INTEREST = 0.07;
	private static final double CHECK_INTEREST = 0.03;
	private static final double CHECK_CHARGE = 0.02;
	private static final double OVERDRAFT_PENALTY = 0;
	private double savingsInt;
	private double checkingsInt;
	private double checkingsCharge;
	private double overPenalty;
	private int accountType;
	//Constructor for Student with arity 4, calls Account constructor
	public Student(String fName, String lName,int inage, int typeacc){
		super(fName, lName, inage,typeacc);
		this.savingsInt = SAVINGS_INTEREST;
		this.checkingsInt = CHECK_INTEREST;
		this.checkingsCharge = CHECK_CHARGE;
		this.overPenalty = OVERDRAFT_PENALTY;
		this.accountType = typeacc;
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
	//Accessor method for accountType
	public int getType(){
		return this.accountType;
	}
}
