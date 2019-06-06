class PrivateCar extends Transportation
{
	private int distance;
	public final double RATE = 0.427;
	
	public PrivateCar()
	{
		this.distance;
	}
	public int getDistance()
	{
		return distance;
	}
	public double getAmount()
	{
		return RATE*distance;
	}
}