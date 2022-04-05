package money;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.MalformedInputException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.text.SimpleDateFormat;

public class FileUtil {
public static final String SEPARATE_FIELD=",";
public static final String SEPARATE_LINE="\r\n";
public static void saveGoods(Goods goods){
	Date date=new Date();
	DateFormat format=new SimpleDateFormat("yyyyMMdd");
	String name="���ۼ�¼"+format.format(date)+".csv";
	InputStream in=null;
	try{
		in=new FileInputStream(name);
		if (in!=null) {
			in.close();
			createFile(name,true,goods);
			
		}
	}catch(FileNotFoundException e){
		createFile(name,false,goods);}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	public static void createFile(String name,boolean label,Goods goods){
		BufferedOutputStream out=null;
		StringBuffer sbf=new StringBuffer();
		try{
			if(label){
				out=new BufferedOutputStream(new FileOutputStream(name,true));
			}else{
				out =new BufferedOutputStream(new FileOutputStream(name));
				String[] fieldSort=new String[]{"","��Ʒ���  ","��Ʒ����  ","����","�������","������ "};
				for (String fieldKye:fieldSort){
					sbf.append(fieldKye).append(SEPARATE_FIELD);
					}
		}
			sbf.append(SEPARATE_LINE);
			sbf.append(SEPARATE_FIELD);
			sbf.append(goods.id).append(SEPARATE_FIELD);//���
			sbf.append(goods.name).append(SEPARATE_FIELD);//����
			sbf.append((double) goods.price).append(SEPARATE_FIELD);//����
			sbf.append(goods.number).append(SEPARATE_FIELD);//���
		
			sbf.append(goods.Manufacturer).append(SEPARATE_FIELD);//������
			
			String str=sbf.toString();
			byte[] b=str.getBytes();
			for(int i=0;i<b.length;i++){
				out.write(b[i]);
			}
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				try{
					if(out!=null)
						out.close();
				}catch(Exception e2){
					e2.printStackTrace();
				}
			}
	}
}
