public class Expense
{
	private String description;

	public Expense(String desc)
	{
		this.description = desc;
	}
	public String getDescription()
	{
		return description;
	}
	public abstract double getAmount();
}
