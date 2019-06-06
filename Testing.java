public class Testing
{
	public static void main(String[] args)
	{
		PrivateCar car = new PrivateCar(20,"Uber","Airport");
		System.out.println("Amount for car: "+car.getAmount()); //should return 8.54
		System.out.println("Distance for car: "+car.getDistance());
    System.out.println("Description for car: "+car.getDescription());
    Airfare plane = new Airfare(200,"Jet","Paris");
		System.out.println("Amount for plane: "+plane.getAmount()); //should returb 200
    System.out.println("Distance for plane: "+plane.getDistance());
    System.out.println("Description for plane: "+plane.Description());
    Meal brekkie = new Breakfast('IHOP',5);
    System.out.println("Number of meals at IHOP: "+brekkie.numberOfMeals());
    System.out.println("Amount spent at IHOP: "+brekkie.getAmount()); //should return 57.5
    Meal lunch1 = new Lunch("Dons",2);
    System.out.println("Number of meals at Dons: "+lunch1.numberOfMeals());
    System.out.println("Amount spent at Dons: "+lunch1.getAmount()); //should return 22.6
    Meal din1 = new Dinner("Fancy Shit",4);
    System.out.println("Number of meals at Fancy Shit: "+din1.numberOfMeals());
    System.out.println("Amount spent at Fancy Shit: "+ din1.getAmount());
	}
}
