package leaner;

public class Main14 {

	public static void main(String[] args) {
		int t=0,y=0;
		for(int i = 0;i<32;i++){
			String n =Integer.toBinaryString(Integer.valueOf(String.valueOf(i),10));
			for(int j = 0;j<(5-n.length());j++){
				System.out.print(0);
			}
			System.out.print(n);
			System.out.print("\n");
		}
	}
}
