package ch26;
import java.util.Random;
import java.util.Scanner;
public class File32 {

	public static void main(String[] args) {
		int i;
		System.out.println("���ɵ������Ϊ��");
		int [] arr=random();
		System.out.println("��ѡ������ʽ��");
		System.out.println("a������      d������");
		//char [] a={'a','d'};
		Scanner reader=new Scanner(System.in);
		String  s=reader.next();//����һ���ַ�������ֵ
		char [] n=s.toCharArray();//���ַ�������ת��Ϊ�ַ�������
		char ch=n[0];//���ַ��������͵ĵ�һ���ַ���ֵ���ַ���ch����
		System.out.println("�����Ϊ��");
		int [] x=sort(arr,ch);
		for(i=0;i<10;i++){
			System.out.print(x[i]+" ");
		}	
	}
	
	
//���������
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

//����
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
