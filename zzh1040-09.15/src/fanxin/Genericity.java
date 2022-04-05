package fanxin;
/**
 * ����
 * @author Administrator
 *
 * @param <T>
 */
class GenericityDamo<T>{
	private T name;
	private T number;
	public void setName(T name) {
		this.name = name;
	}
	public void setNumber(T number) {
		this.number = number;
	}
	public T getName() {
		return name;
	}
	public T getNumber() {
		return number;
	}
}
/**
 * ���ͽӿ�
 * @author Administrator
 *
 */
interface IMessage<T>{
	public void print(T t);
}

class MessageImpl<T> implements IMessage<T>{
	
	public void print(T t) {
		System.out.println(t);
		
	}
}

class MessageImpl01 implements IMessage<String>{
	
	public void print(String t) {
		System.out.println(t);
		
	}
}

public class Genericity {
	public static void main(String[] args) {
		GenericityDamo<Integer> st1 = new GenericityDamo<Integer>();
		st1.setName(1);
		st1.setNumber(2);
		int p1 = st1.getName();
		int p2 = st1.getNumber();
		System.out.println("����Ϊ��"+p1);
		System.out.println("���Ϊ��"+p2);
		
		GenericityDamo<Double> st2 = new GenericityDamo<Double>();
		st2.setName(1.20);
		st2.setNumber(2.30);
		Double p3 = st2.getName();
		Double p4 = st2.getNumber();
		System.out.println("����Ϊ��"+p3);
		System.out.println("���Ϊ��"+p4);
		
		GenericityDamo<String> st3 = new GenericityDamo<String>();
		st3.setName("С��");
		st3.setNumber("10��");
		String p5 = st3.getName();
		String p6 = st3.getNumber();
		System.out.println("����Ϊ��"+p5);
		System.out.println("���Ϊ��"+p6);
		
		//���ͽӿ�
		IMessage<String> msg = new MessageImpl<String>();
		msg.print("hello word!");
		
		IMessage<String> msg01 = new MessageImpl01();
		msg01.print("hello!");
		
		//���÷��ͷ���
		String st = fun("���ͷ���");
		System.out.println(st);
	}
	//T�������ɴ���Ĳ�������
	public static <T> T fun(T t){
		
		return t;
	}
	
}
