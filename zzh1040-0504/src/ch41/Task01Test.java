package ch41;

interface USB {
	void turnOn();//启动
	void turnOff();//关闭
}
//鼠标
class Mouse implements USB{
	public void turnOn(){
		System.out.println("鼠标启动了");
	}
	public void turnOff(){
		System.out.println("鼠标关闭了");
	}
}

class KeyBoard implements USB{
	public void turnOn(){
		System.out.println("键盘启动了");
	}
	public void turnOff(){
		System.out.println("键盘关闭了");
	}
}

class Mic implements USB{
	public void turnOn(){
		System.out.println("麦克风启动了");
	}
	public void turnOff(){
		System.out.println("麦克风关闭了");
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
		System.out.println("计算机开机成功");
	}
	public void powerOff(){
		for(int i=0;i<usbArr.length;i++){
			if(usbArr[i]!=null){
				usbArr[i].turnOff();
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
		c.powerOn();
		System.out.println();
		c.powerOff();
	}
}
