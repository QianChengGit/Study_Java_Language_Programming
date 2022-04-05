package ch71;
import java.io.*;
public class FileCopyDemo {
	public static void main(String[] args) throws Exception{
		FileOutputStream fos=new FileOutputStream("object.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		Person p1=new Person("123456789","张三"),p2=null;
		oos.writeObject(p1);
		Person p3=new Person("000","李四");
		oos.writeObject(p3);
//		oos.writeObject(null);
		oos.close();
		File f=new File("object.txt");
		FileInputStream fis=new FileInputStream(f);
		ObjectInputStream ois=new ObjectInputStream(fis);
		p2=(Person)ois.readObject();
		p2.showInfo();
		p2=(Person)ois.readObject();
		p2.showInfo();
	}
}

class Person
implements Serializable{
	private String ID;
	private String name;
	public Person(){}
	public Person(String id,String n){
		this.ID=id;
		this.name=n;
	}
	public void showInfo(){
		System.out.println(this.ID+"   "+this.name);
	}
}

