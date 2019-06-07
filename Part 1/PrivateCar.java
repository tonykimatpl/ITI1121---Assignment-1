class PrivateCar extends Transportation
{
	private int distance;
	public final double RATE = 0.427;

	public PrivateCar(String description, String destination,int dist)
	{
		super(description,destination);
		this.distance = dist;
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
