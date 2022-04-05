package task02;

class Info03{
	private String title;
	private String content;
	private boolean flag = true;
	//flag = true;表示可以生产，但是不可以取走
	//flag = false;表示可以取走，但是不可以生产
	public synchronized void set(String title,String content){
		//重复进入到set()方法里面，发现不能够生产，所以等待
		if(this.flag == false){
			try {
				super.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.title = title;
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.content = content;
		this.flag = false;//修改生产标记
		this.notify(); //唤醒其他等待线程
	}
	public synchronized void get(){
		if(this.flag == true){//还没生产呢
			try {
				super.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(this.title+"-"+this.content);
		this.flag = true;
		super.notify();
	}
}

class productor03 implements Runnable{
	private Info03 info;
	
	public productor03(Info03 info) {
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

class Customer03 implements Runnable{
	private Info03 info;
	public Customer03(Info03 info) {
		this.info = info;
	}
	@Override
	public void run() {
		for(int i = 0;i<100;i++){
			this.info.get();
		}
	}
}

public class TestDemo03 {
	public static void main(String[] args) throws Exception {
		Info03 info = new Info03();
		new Thread(new productor03(info)).start();
		new Thread(new Customer03(info)).start();
	}
}
