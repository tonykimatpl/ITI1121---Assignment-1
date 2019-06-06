public abstract class Meal extends Expense
{
	private int numberOfMeals;

	public Meal(String description, int numberMeal)
	{
		super(description);
		this.numberOfMeals = numberMeal;
	}
	public int getNumberOfMeals()
	{
		return numberOfMeals;
	}
}
