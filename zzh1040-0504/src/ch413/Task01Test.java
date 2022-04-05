package ch413;

interface USB {
	//void turnOn();//启动
	//void turnOff();//关闭
	//public static final String name="张泽宏";
	void turnOn(String name);
	void turnOff(String name);
}
//鼠标
class Mouse implements USB{
	public void turnOn(String name){
		System.out.println("鼠标启动了");
	}
	public void turnOff(String name){
		System.out.println("鼠标关闭了");
	}
}

class KeyBoard implements USB{
	public void turnOn(String name){
		System.out.println("键盘启动了");
	}
	public void turnOff(String name){
		System.out.println("键盘关闭了");
	}
}

class Mic implements USB{
	public void turnOn(String name){
		System.out.println("麦克风启动了");
	}
	public void turnOff(String name){
		System.out.println("麦克风关闭了");
	}
}

class USB1 implements USB{
	public void turnOn(String name){
		System.out.println(name+"的USB启动了");
	}
	public void turnOff(String name){
		System.out.println(name+"的USB关闭了");
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
				usbArr[i].turnOn("张泽宏");
				}
		}
		System.out.println("计算机开机成功");
		System.out.println("USB接口数为："+usbArr.length);
	}
	public void powerOff(){
		for(int i=0;i<usbArr.length;i++){
			if(usbArr[i]!=null){
				usbArr[i].turnOff("张泽宏");
			}
		}
		System.out.println("计算机关闭成功");
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
