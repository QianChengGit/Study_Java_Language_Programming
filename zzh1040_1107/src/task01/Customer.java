package task01;

public class Customer implements Runnable{
	private Bank b = new Bank();
	@Override
	public void run() {
		try {
			for(int i=0;i<3;i++){
				Thread.sleep(2000);
				b.add(100);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
