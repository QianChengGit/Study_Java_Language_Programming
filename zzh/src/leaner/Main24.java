package leaner;
import java.util.Scanner;
public class Main24
{
     private int maxSubArray(int n,int a[])
      {
            int b=0,sum=-10000000;
            for(int i=0;i<n;i++)
            {
                  if(b>0) b+=a[i];
                  else b=a[i];
                  if(b>sum) sum=b;
            }
            return sum;  
      }
      private int maxSubMatrix(int n,int[][] array)
      {
            int i,j,k,max=0,sum=-100000000;
            int b[]=new int[101];
            for(i=0;i<n;i++)
            {
                  for(k=0;k<n;k++)//��ʼ��b[]
                  {
                        b[k]=0;
                  }
                  for(j=i;j<n;j++)//�ѵ�i�е���j�����,��ÿһ�����������ֵ
                  {
                        for(k=0;k<n;k++)
                        {
                              b[k]+=array[j][k];
                        }
                        max=maxSubArray(k,b);  
                        if(max>sum)
                        {
                                sum=max;
                        }
                  }
            }
            return sum;
      }
      public static void main(String args[])
      {
    	  Main24 p=new Main24();
            Scanner cin=new Scanner(System.in);
            int n=0;
            int[][] array=new int[101][101];
            while(cin.hasNext())
            {
                       n=cin.nextInt();   
                       for(int i=0;i<n;i++)
                       {
                                  for(int j=0;j<n;j++)
                                  {
                                             array[i][j]=cin.nextInt();
                                  }
                       }
                       System.out.println(p.maxSubMatrix(n,array));
            }
      }
}

