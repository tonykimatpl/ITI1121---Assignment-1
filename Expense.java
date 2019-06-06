public class Expense
{
	private String description;
	private final String DEFAULT_DESCRIPTION = "New Expense";

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
