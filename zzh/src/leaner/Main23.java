package leaner;

import java.util.Scanner;
/*
 * �߶θ���
 * 
 * СA�������£�����һ��ܳ���ľ����Ϳɫ��ÿ�Σ�����ѡȡľ���ϵ�һ�Σ�Ȼ�����Ϳ����ɫ��Ϳ�����µ���ɫ���ǻḲ�Ǿ���ɫ�ġ�

����Ϳ��������Ϊֹ��������Ҳ�����Ϳ100�Ρ�

���ʣ���ľ���ϵ�xλ����ʲô��ɫ��


��һ������������n��m����ʾľ�峤�ȣ�n<=100000��������Ϳɫ�Ĵ�����m<=100��

������n�У�ÿ������������l��r��c��ʾ��Ϳ��λ�õ���˺��Ҷˣ��Լ���ɫ����1<=l<=r<=n,1<=c<=20��

������һ��������x����ʾѯ�ʵ�λ�á�


���һ�У�����һ��������ʾ��ɫ�����ûͿɫ�����0��
 */
public class Main23 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n,m,s=0;
		n=sc.nextInt();
		m=sc.nextInt();
		int[][] a = new int[m][3];
		for(int i=0;i<m;i++){
			for(int j=0;j<3;j++){
				a[i][j] = sc.nextInt();
			}
		}
		int x=sc.nextInt();
		
		for(int i=0;i<m;i++){
			for(int j=0;j<3;j++){
				if(a[i][0]<=x && a[i][1]>=x){
					s=a[i][2];
				}
			}
		}
		System.out.println(s);

	}

}
