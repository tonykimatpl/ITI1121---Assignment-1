public class ExpenseTracker {
	private Expense[] expenses;
	private int size;
	public ExpenseTracker(int capacity) {
		expenses = new Expense[capacity];
		size = 0;
	}
  public void add(Expense e){
		expenses[size] = e;
		size++;
  }
  public double getTotal(){
    double total = 0;
    for(int i=0; i < size; i++){
      total += expenses[i].getAmount();
    }
    return total;
  }
}
