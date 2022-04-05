package ch51zuoye;
import java.util.*;
import java.io.IOException;
public class Example {
	public static void main(String[] args) throws IOException {
		Properties properties=System.getProperties();
		System.out.println(properties);
		 Set<String>propertyNames=properties.stringPropertyNames();
		 for(String key : propertyNames){
			 String value=System.getProperty(key);
			 System.out.println(key+"---->"+value);
		 }
		 
		 System.out.println();
		 
		 long startTime=System.currentTimeMillis();
		 int sum=0;
		 for(int i=0;i<100000000;i++){
			 sum+=i;
		 }
		 long endTime=System.currentTimeMillis();
		 System.out.println("�������е�ʱ��Ϊ��"+(endTime - startTime)+"����");
		 
		 
		 System.out.println();
		 
		 
		 
		 int[] fromArray={101,102,103,104,105,106};
		 int[] toArray={201,202,203,204,205,206,207};
		 System.arraycopy(fromArray,2,toArray,3,4);
		 for(int i=0;i<toArray.length;i++){
			 System.out.println(i+":"+toArray[i]);
		 }
		 
		 
		 System.out.println();
		 
		 
		 
		 Runtime rt=Runtime.getRuntime();
		 System.out.println("�������ĸ�����"+rt.availableProcessors()+"��");
		 System.out.println("�����ڴ�������"+rt.freeMemory()/1024/1024+"M");
		 System.out.println("�������ڴ�����"+rt.maxMemory()/1024/1024+"M");
		 
		 
		 System.out.println();
		 
		 
		 
		 Runtime rt1=Runtime.getRuntime();
		 rt1.exec("calc.exe");//notepad.exe
		 
		 
		 System.out.println();
		 
		 
		 
		 
		 
	}
	
	
}
