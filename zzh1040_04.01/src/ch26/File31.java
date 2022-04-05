package ch26;
import java.util.Random;

public class File31 {

	public static void main(String[] args) {
		int [] arr = new int[10];
		int i,sum,a=10,t,j;
		System.out.println("生成的10个随机数为：");
		for(i=0;i<10;i++)
		{
			int randomNumber=new Random().nextInt(90);
			sum=randomNumber+a;
			arr[i]=sum;
			System.out.println(arr[i]);
		}
		System.out.println(" ");
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
		System.out.println("排序后的数字为：");
		for(i=0;i<10;i++)
		{
			System.out.println(arr[i]);
		}
	}	
}
