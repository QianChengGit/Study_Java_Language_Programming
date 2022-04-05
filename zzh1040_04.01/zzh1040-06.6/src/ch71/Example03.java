package ch71;
import java.io.*;
public class Example03 {
	public static void main(String[] args) throws Exception{
		
		OutputStream out=new FileOutputStream("example.txt",true);
		String str="»¶Ó­Äã£¡";
		byte [] b=str.getBytes();
		for(int i=0;i<b.length;i++){
			out.write(b[i]);
		}
		//out.close();
		
		//finally{
			/*try{
				if(in!=null)
					in.close();
			}catch(Exception e){
				e.printStackTrace();
			}*/
			try{
				if(out!=null)
					out.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		//}
	}
}

