package task02;

class Info{
	private String title;
	private String content;
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitle() {
		return title;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getContent() {
		return content;
	}
}

class productor implements Runnable{
	private Info info;
	
	public productor(Info info) {
		this.info = info;
	}
	@Override
	public void run() {
		for(int i = 0;i<100;i++){
			if(i%2 == 0){
				this.info.setTitle("王惊雷");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				this.info.setContent("好学生一枚");
			}else{
				this.info.setTitle("可爱的动物");
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				this.info.setContent("草泥马");
			}
		}
	}
}

class Customer implements Runnable{
	private Info info;
	public Customer(Info info) {
		this.info = info;
	}
	@Override
	public void run() {
		for(int i = 0;i<100;i++){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(this.info.getTitle()+"-"+this.info.getContent());
		}
	}
}

public class TestDemo {
	public static void main(String[] args) throws Exception {
		Info info = new Info();
		new Thread(new productor(info)).start();
		new Thread(new Customer(info)).start();
	}
}
