package ch26;
import java.util.Random;
import java.util.Scanner;
public class File32 {

	public static void main(String[] args) {
		int i;
		System.out.println("生成的随机数为：");
		int [] arr=random();
		System.out.println("请选择排序方式：");
		System.out.println("a、升序      d、降序");
		//char [] a={'a','d'};
		Scanner reader=new Scanner(System.in);
		String  s=reader.next();//输入一个字符串类型值
		char [] n=s.toCharArray();//将字符串类型转换为字符数组型
		char ch=n[0];//将字符数组类型的第一个字符赋值给字符型ch变量
		System.out.println("排序后为：");
		int [] x=sort(arr,ch);
		for(i=0;i<10;i++){
			System.out.print(x[i]+" ");
		}	
	}
	
	
//生成随机数
public static int [] random(){
	int [] arr=new int[10];
	int i,sum,a=10;
	for(i=0;i<10;i++)
	{
		int randomNumber=new Random().nextInt(90);
		sum=randomNumber+a;
		arr[i]=sum;
		System.out.print(arr[i]+" ");
	}
	System.out.println(" ");
	return arr;
}

//排序
public static int [] sort(int arr[],char n){
	int i,j,t;
	if(n=='a'){
	for(j=0;j<9;j++){
		for(i=0;i<9-j;i++)
		{
			if(arr[i]>arr[i+1])
			{
				t=arr[i];
				arr[i]=arr[i+1];
				arr[i+1]=t;
			}
		}
	}
	}
	if(n=='d')
	{
		for(j=0;j<9;j++){
			for(i=0;i<9-j;i++)
			{
				if(arr[i]<arr[i+1])
				{
					t=arr[i];
					arr[i]=arr[i+1];
					arr[i+1]=t;
				}
			}
		}
	}
	return arr;
}

}
