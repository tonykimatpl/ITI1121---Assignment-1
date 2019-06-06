public abstract class Expense
{
	private String description;

	public Expense(String description)
	{
		this.description = description;
	}
	public String getDescription()
	{
		return description;
	}
	public abstract double getAmount();
}
