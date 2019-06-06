public abstract class Transportation extends Expense
{
	private String destination;
	
	public Transportation(String destination)
	{
		super();
		this.destination = destination;
	}
	public getDestination()
	{
		return destination;
	}
	abstract public double getAmount();
}