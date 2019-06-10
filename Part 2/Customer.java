/*Customer.java
Tony Kim, Noël Khalaf
300087407, 300079144
ITI1121
*/
/*Abstract Class Customer has three constructors, accessor and modifier methods for class variables, and equals and toString methods*/
public abstract class Customer{
  private String firstName;
  private String lastName;
  private int age;
  private int customerNumber;
  private static int lastCustomerNumber = 9999;
  //Constructor for Customer with arity 3
  public Customer(String fName, String lName, int inage){
    this.firstName = fName;
    this.lastName = lName;
    this.age = inage;
    this.customerNumber = lastCustomerNumber;
    lastCustomerNumber ++;					//Increments CustomerNumber to change once a new Customer is made
  }
  //Constructor for Customer with arity 4
  public Customer(String fName, String lName, int inage, int newNum){
    this.firstName = fName;
    this.lastName = lName;
    this.age = inage;
    this.customerNumber = newNum;
  }
	//Constructor for Customer with arity 0
  public Customer(){
    this.customerNumber = lastCustomerNumber;
    lastCustomerNumber ++;					//Increments CustomerNumber to change once a new Customer is made
  }
	//Modifier method for firstName
  public void setFirstName(String name){
    this.firstName = name;
  }
	//Accessor method for firstName
  public String getFirstName(){
    return this.firstName;
  }
	//Modifier method for lastName
  public void setLastName(String lastnom){
    this.lastName = lastnom;
  }
	//Accessor method for lastName
  public String getLastName(){
    return this.lastName;
  }
	//Modifier method for age
  public void setAge(int newage){
    this.age = newage;
  }
	//Accessor method for age
  public int getAge(){
    return this.age;
  }
	//Modifier method for customerNumber
  public void setCustomerNumber(int newNumber){
    this.customerNumber = newNumber;
  }
	//Accessor method for customerNumber
  public int getCustomerNumber(){
    return this.customerNumber;
  }
	//Displays Customer information including firstName, lastName, customerNumber, and age
  public String toString(){
    return "Client: "+this.getFirstName()+" "+this.getLastName()+" | Customer Number: "+this.getCustomerNumber()+" | Age: "+this.getAge();
  }
	//Compares two customers to see if they are the same, returns true is so, false if not
  public boolean equals(Customer other){
    if((this.getFirstName() == other.getFirstName()) && (this.getLastName() == other.getLastName()) && (this.getAge() == other.getAge()) && (this.getCustomerNumber() == other.getCustomerNumber())){
      return true;
    }
    else{
      return false;
    }
  }
}
