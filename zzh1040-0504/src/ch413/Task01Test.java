package ch413;

interface USB {
	//void turnOn();//����
	//void turnOff();//�ر�
	//public static final String name="�����";
	void turnOn(String name);
	void turnOff(String name);
}
//���
class Mouse implements USB{
	public void turnOn(String name){
		System.out.println("���������");
	}
	public void turnOff(String name){
		System.out.println("���ر���");
	}
}

class KeyBoard implements USB{
	public void turnOn(String name){
		System.out.println("����������");
	}
	public void turnOff(String name){
		System.out.println("���̹ر���");
	}
}

class Mic implements USB{
	public void turnOn(String name){
		System.out.println("��˷�������");
	}
	public void turnOff(String name){
		System.out.println("��˷�ر���");
	}
}

class USB1 implements USB{
	public void turnOn(String name){
		System.out.println(name+"��USB������");
	}
	public void turnOff(String name){
		System.out.println(name+"��USB�ر���");
	}
}


class Computer{
	private USB[] usbArr=new USB[3];
	int j=0,t=0,i;
	public void add(USB usb){
		for(int i=0;i<usbArr.length;i++){
			if(usbArr[i]==null){
				usbArr[i]=usb;
				t++;
				break;
			}
		}

		for(int i=0;;i++){
			if(usbArr[i] instanceof USB){
				j++;
				break;
			}
		}
		
		if(j>t){
			usbArr[t-1]=usb;	
		}
		
	}
	
/*	public void add1(USB usb){
		for(int i=0;i<usbArr.length;i++){
			if(usbArr[i]==null){
				usbArr[i]=usb;
				break;
			}
		}
	}*/
	public void powerOn(){
		for(int i=0;i<usbArr.length;i++){
			if(usbArr[i]!=null){
				usbArr[i].turnOn("�����");
				}
		}
		System.out.println("����������ɹ�");
		System.out.println("USB�ӿ���Ϊ��"+usbArr.length);
	}
	public void powerOff(){
		for(int i=0;i<usbArr.length;i++){
			if(usbArr[i]!=null){
				usbArr[i].turnOff("�����");
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
		c.add(new USB1());
		USB1 n=new USB1();
		System.out.println(n instanceof USB);
		c.powerOn();
		System.out.println();
		c.powerOff();
	}
}
