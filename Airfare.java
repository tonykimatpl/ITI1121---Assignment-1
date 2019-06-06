class Airfare extends Transportation
{
	private double amount;

	public Airfare(double amount,String description,String destination)
	{
		super(description,destination);
		this.amount = amount;
	}
	public double getAmount()
	{
		return amount;
	}
}
