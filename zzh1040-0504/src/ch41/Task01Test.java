package ch41;

interface USB {
	void turnOn();//����
	void turnOff();//�ر�
}
//���
class Mouse implements USB{
	public void turnOn(){
		System.out.println("���������");
	}
	public void turnOff(){
		System.out.println("���ر���");
	}
}

class KeyBoard implements USB{
	public void turnOn(){
		System.out.println("����������");
	}
	public void turnOff(){
		System.out.println("���̹ر���");
	}
}

class Mic implements USB{
	public void turnOn(){
		System.out.println("��˷�������");
	}
	public void turnOff(){
		System.out.println("��˷�ر���");
	}
}

class Computer{
	private USB[] usbArr=new USB[4];
	public void add(USB usb){
		for(int i=0;i<usbArr.length;i++){
			if(usbArr[i]==null){
				usbArr[i]=usb;
				break;
			}
		}
	}
	public void powerOn(){
		for(int i=0;i<usbArr.length;i++){
			if(usbArr[i]!=null){
				usbArr[i].turnOn();
			}
		}
		System.out.println("����������ɹ�");
	}
	public void powerOff(){
		for(int i=0;i<usbArr.length;i++){
			if(usbArr[i]!=null){
				usbArr[i].turnOff();
			}
		}
		System.out.println("������رճɹ�");
	}
}

public class Task01Test{
	public static void main(String[] args) {
		Computer c=new Computer();
		c.add(new Mouse());
		c.add(new Mic());
		c.add(new KeyBoard());
		c.powerOn();
		System.out.println();
		c.powerOff();
	}
}
