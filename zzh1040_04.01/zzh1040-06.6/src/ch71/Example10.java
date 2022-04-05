package ch71;
import java.io.*;
public class Example10 {
	public static void main(String[] args) throws Exception{
		FileInputStream in=new FileInputStream("src.txt");
		InputStreamReader isr=new InputStreamReader(in);
		BufferedReader br=new BufferedReader(isr);
		FileOutputStream out=new FileOutputStream("des.txt");
		OutputStreamWriter osw=new OutputStreamWriter(out);
		BufferedWriter bw=new BufferedWriter(osw);
		String line;
		while((line=br.readLine())!=null){
			bw.write(line);
		}
		br.close();
		bw.close();
	}
}
