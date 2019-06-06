public abstract class Customer{
  private String firstName;
  private String lastName;
  private int age;
  private int customerNumber;
  private int lastCustomerNumber = 9999;

  public Customer(String fName, String lName, int inage){
    this.firstName = fName;
    this.lastName = lName;
    this.age = inage;
    this.customerNumber = lastCustomerNumber;
    lastCustomerNumber ++;
  }

  public Customer(String fName, String lName, int inage, int newNum){
    this.firstName = fName;
    this.lastName = lName;
    this.age = inage;
    this.customerNumber = newNum;
  }

  public Customer(){
    this.customerNumber = lastCustomerNumber;
    lastCustomerNumber ++;
  }

  public void setFirstName(String name){
    this.firstName = name;
  }

  public String getFirstName(){
    return this.firstName;
  }

  public void setLastName(String lastnom){
    this.lastName = lastnom;
  }

  public String getLastName(){
    return this.lastName;
  }

  public void setAge(int newage){
    this.age = newage;
  }

  public int getAge(){
    return this.age;
  }

  public void setCustomerNumber(int newNumber){
    this.customerNumber = newNumber;
  }

  public int getCustomerNumber(){
    return this.customerNumber;
  }

  public String toString(){
    String canon;
    canon = "Client: "+this.getFirstName()+" "+this.getLastName()+" | Customer Number: "+this.getCustomerNumber()+" | Age: "+this.getAge();
  }

  public abstract double getSavingsInterest();
  public abstract double getCheckInterest();
  public abstract double getCheckCharge();

}
