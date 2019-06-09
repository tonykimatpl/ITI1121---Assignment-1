public abstract class Customer extends Account{
  private String firstName;
  private String lastName;
  private int age;
  private int customerNumber;
  private static int lastCustomerNumber = 9999;

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
    return "Client: "+this.getFirstName()+" "+this.getLastName()+" | Customer Number: "+this.getCustomerNumber()+" | Age: "+this.getAge();
  }

  public boolean equals(Customer other){
    if((this.getFirstName() == other.getFirstName()) && (this.getLastName() == other.getLastName()) && (this.getAge() == other.getAge()) && (this.getCustomerNumber() == other.getCustomerNumber())){
      return true;
    }
    else{
      return false;
    }
  }

  public abstract double getSavingsInterest();
  public abstract double getCheckInterest();
  public abstract double getCheckCharge();
  public abstract double getOverPenalty();
  public abstract int getType();
}
