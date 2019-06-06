public class Lunch extends Meal
{
	public final double ALLOWANCE = 11.30;
	public Lunch(String description, int numberOfMeals)
	{
		super(description, numberOfMeals);
	}
	public double getAmount(){
		return numberOfMeals*ALLOWANCE;
	}
}
