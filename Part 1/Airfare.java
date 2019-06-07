class Airfare extends Transportation
{
	private double amount;

	public Airfare(String description,String destination,double amount)
	{
		super(description,destination);
		this.amount = amount;
	}
	public double getAmount()
	{
		return amount;
	}
}
