public abstract class Transportation extends Expense
{
	private String destination;
	
	public Transportation(String description,String destination)
	{
		super(description);
		this.destination = destination;
	}
	public getDestination()
	{
		return destination;
	}
	public abstract double getAmount();
}