package ch51zuoye;

public class Example01 {

	public static void main(String[] args) throws Exception{
		Runtime rt2=Runtime.getRuntime();
		 Process process=rt2.exec("notepad.exe");
		 Thread.sleep(3000);
		 process.destroy();
	}

}
