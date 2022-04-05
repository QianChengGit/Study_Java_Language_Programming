package task02;

class Info01{
	private String title;
	private String content;
	public synchronized void set(String title,String content){
		this.title = title;
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.content = content;
	}
	public synchronized void get(){
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(this.title+"-"+this.content);
	}
}

class productor01 implements Runnable{
	private Info01 info;
	
	public productor01(Info01 info) {
		this.info = info;
	}
	@Override
	public void run() {
		for(int i = 0;i<100;i++){
			if(i%2 == 0){
				this.info.set("王惊雷","好学生一枚");
			}else{
				this.info.set("可爱的动物","草泥马");
			}
		}
	}
}

class Customer01 implements Runnable{
	private Info01 info;
	public Customer01(Info01 info) {
		this.info = info;
	}
	@Override
	public void run() {
		for(int i = 0;i<100;i++){
			this.info.get();
		}
	}
}

public class TestDemo01 {
	public static void main(String[] args) throws Exception {
		Info01 info = new Info01();
		new Thread(new productor01(info)).start();
		new Thread(new Customer01(info)).start();
	}
}

