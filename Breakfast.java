public class Breakfast extends Meal
{
	public final double ALLOWANCE = 11.55

	public Breakfast(String description, int numberOfMeals){
		super(description,numberOfMeals);
	}
	public double getAmount(){
		return numberOfMeals*ALLOWANCE;
	}
}
