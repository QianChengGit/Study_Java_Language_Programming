package leaner;

import java.util.Scanner;

public class Main20 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] h =new int[n];
		for(int i = 0;i<n;i++){
			h[i] = sc.nextInt();
		}
		int tem;
		int[] w = new int[n];
		for(int i = 0;i<n;i++){
			w[i] = 0;
		}
		for(int i= 0;i<n-1;i++){
			for(int j=i+1;j<n;j++){
				if(h[i]>h[j]){
//					tem = h[i];
//					h[i] = h[j];
//					h[j] = tem;
					//记录位置经过移动的次数
					w[i]++;
					w[j]++;
					//交换位置
					tem = w[i];
					w[i] = w[j];
					w[j] = tem;
					
				}
			}
		}
		int sum,min = 0;
		for(int i = 0;i<n;i++){
			sum=0;
			for(int j=1;j<w[i]+1;j++){
				sum = sum+j;
			}
			min = min+sum;
			
		}
		System.out.println(min);

	}

}
