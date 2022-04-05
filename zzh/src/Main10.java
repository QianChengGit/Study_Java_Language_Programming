import java.util.Scanner;


public class Main10 {
 private static int[][] a;
private static int[][] b;
private static int [][] foot=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
private static int[][] v=new int[3][3];
private static int mun=Integer.MAX_VALUE;
public static void main(String[] args) {
	 Scanner input=new Scanner(System.in);
	 while(input.hasNext()){
	 String stra=input.next();
	 String strb=input.next();
	 int sx=0,sy=0,dx=0,dy=0;
	  a=new int[3][3];
	 b=new int[3][3];
	 int k=0;
	for (int i = 0; i < 3; i++) {
		for (int j = 0; j < 3; j++) {
			char ch=stra.charAt(k++);
			if(ch=='.'){
				sx=i;sy=j;
			}
			else{
				a[i][j]=Integer.parseInt(ch+"");
			}
		}
	}
	k=0;
	for (int i = 0; i < 3; i++) {
		for (int j = 0; j < 3; j++) {
			char ch=strb.charAt(k++);
			if(ch=='.'){
				dx=i;dy=j;
			}
			else{
				b[i][j]=Integer.parseInt(ch+"");
			}
		}
	}
	dfs(sx,sy,dx,dy,0);
	if(mun==Integer.MAX_VALUE)System.out.println(-1);
	else
	System.out.println(mun);
	 }
}
private static void dfs(int sx, int sy, int dx, int dy, int count) {
	 if(sx==dx&&sy==dy){
		 if(chexk()){
			if(count<mun)mun=count;
		 }
		 return;
	 }else{
		 for (int i = 0; i < 4; i++) {
			int tx=sx+foot[i][0];
			int ty=sy+foot[i][1];
			if(tx>=0&&ty>=0&&tx<3&&ty<3&&v[tx][ty]==0){
				v[tx][ty]=1;
				int m=a[sx][sy];
				a[sx][sy]=a[tx][ty];
				a[tx][ty]=m;
				dfs(tx,ty,dx,dy,count+1);
				v[tx][ty]=0;
				m=a[sx][sy];
				a[sx][sy]=a[tx][ty];
				a[tx][ty]=m;
			}
		}
	 }
}
private static boolean chexk() {
	for (int i = 0; i < 3; i++) {
		for (int j = 0; j <3; j++) {
			if(a[i][j]!=b[i][j])return false;
		}
	}
	return true;
}
}
