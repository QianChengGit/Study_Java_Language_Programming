package task02;

class Info03{
	private String title;
	private String content;
	private boolean flag = true;
	//flag = true;��ʾ�������������ǲ�����ȡ��
	//flag = false;��ʾ����ȡ�ߣ����ǲ���������
	public synchronized void set(String title,String content){
		//�ظ����뵽set()�������棬���ֲ��ܹ����������Եȴ�
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
		this.flag = false;//�޸��������
		this.notify(); //���������ȴ��߳�
	}
	public synchronized void get(){
		if(this.flag == true){//��û������
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
				this.info.set("������","��ѧ��һö");
			}else{
				this.info.set("�ɰ��Ķ���","������");
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
