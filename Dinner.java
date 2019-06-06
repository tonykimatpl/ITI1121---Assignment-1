public class Dinner extends Meal
{
	public final double ALLOWANCE = 31.80;
	public Dinner(String description, int numberOfMeals)
	{
		super(description, numberOfMeals);
	}
	public double getAmount(){
		return this.getNumberOfMeals()*ALLOWANCE;
	}
}
