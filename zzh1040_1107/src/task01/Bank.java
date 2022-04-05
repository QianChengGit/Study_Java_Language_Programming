package task01;

public class Bank {
	private int sum;
	public void add(int num){
		synchronized(this){
			sum = sum + num;
			System.out.println("ÕË»§µÄÓà¶îÎª£º"+ sum);
		}
	}
}
