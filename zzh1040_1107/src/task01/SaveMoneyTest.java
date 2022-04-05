package task01;

public class SaveMoneyTest {
	public static void main(String[] args) {
		Customer c = new Customer();
		Thread th1 = new Thread(c);
		Thread th2 = new Thread(c);
		try {
			th1.start();
			Thread.sleep(3000);
			th2.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
