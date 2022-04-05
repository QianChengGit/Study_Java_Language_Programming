package ch51zuoye;
import java.util.Arrays;
public class WrapperTest {
	private static final String SPACE_SEPARATOR=" ";
	public static void main(String[] args) {
		String numStr="20 78 9 -7 88 36 29";
		System.out.println(numStr);
		numStr=sortStringNumber(numStr);
		System.out.println(numStr.toString());
	}
	
	public static String sortStringNumber(String numStr){
		String [] str_arr=stringToArray(numStr);
		int[] num_arr=toIntArray(str_arr);
		mySortArray(num_arr);
		String temp=arrayToString(num_arr);
		return temp;
	}
	
	
	public static String arrayToString(int [] num_arr){
		StringBuffer sb=new StringBuffer();
		for(int x=0;x<num_arr.length;x++){
			if(x!=num_arr.length-1){
				sb.append(num_arr[x]+SPACE_SEPARATOR);
			}
			else{
				sb.append(num_arr[x]);
			}
		}
		return sb.toString();
	}
	
	
	public static void mySortArray(int [] num_arr){
		Arrays.sort(num_arr);
	}
	
	
	
	public static int [] toIntArray(String [] str_arr){
		int[] arr=new int[str_arr.length];
		for(int i=0;i<arr.length;i++){
			arr[i]=Integer.parseInt(str_arr[i]);
		}
		return arr;
	}
	
	
	public static String[] stringToArray(String numStr){
		String [] str_arr=numStr.split(SPACE_SEPARATOR);
		return str_arr;
	}
}
