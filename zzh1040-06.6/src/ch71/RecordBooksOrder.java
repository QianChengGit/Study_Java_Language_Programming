package ch71;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
public class RecordBooksOrder {
	static ArrayList<Books> booksList=new ArrayList<Books>();//�������
	public static void main(String[] args) {
		init();
		for(int i=0;i<booksList.size();i++){
			System.out.println(booksList.get(i));
		}
		while(true){
			Scanner scan=new Scanner(System.in);
			System.out.println("������ͼ���ţ�");
			int bookId=scan.nextInt();
			Books stockBooks=getBooksById(bookId);
			if(stockBooks!=null){
				System.out.println("��ǰͼ����Ϣ��"+stockBooks);
				System.out.println("�����빺��������");
				int bookNumber=scan.nextInt();
				if(bookNumber<=stockBooks.number){
					Books books=new Books(stockBooks.id,stockBooks.name,stockBooks.price
							,bookNumber,stockBooks.price*bookNumber,stockBooks.publish);
					FileUtil.saveBooks(books);
					stockBooks.setNumber(stockBooks.number-bookNumber);
				}else{
					System.out.println("��治�㣡");
				}
			}else{
				System.out.println("ͼ�����������");
			}
		}
	}
	
	private static void init(){
		Books goods1=new Books(101,"Java��������",44.50,100,4450.00,"�廪��ѧ������");
		Books goods2=new Books(102,"Java���˼��",108.00,50,5400.00,"��е��ҵ������");
		Books goods3=new Books(103,"���Java����",99.00,100,9900.00,"���ӹ�ҵ������");
		booksList.add(goods1);
		booksList.add(goods2);
		booksList.add(goods3);
	}
	
	private static Books getBooksById(int bookId){
		for(int i=0;i<booksList.size();i++){
			Books thisBooks=booksList.get(i);
			if(bookId==thisBooks.id){
				return thisBooks;
			}
		}
		return null;
	}
}


class Books{
	int id;
	String name;
	double price;
	int number;
	double money;
	String publish;
	public Books(int id,String name,double price,
			int number,double money,String publish)
	{
		this.id=id;
		this.name=name;
		this.price=price;
		this.number=number;
		this.money=money;
		this.publish=publish;
	}
	
	public String toString(){
		String message="ͼ���ţ�"+id+"  ͼ�����ƣ�"+name+
				"  �����磺"+publish+"  ���ۣ�"+price+"  ���������"+number;
		return message;
	}
	
	public void setNumber(int number){
		this.number=number;
	}
}


class FileUtil{
	 public static final String SEPARATE_FIELD=",";
	 public static final String SEPARATE_LINE="\r\n";
	 
	 
	 public static void saveBooks(Books books){
		 Date date=new Date();
		 DateFormat format=new SimpleDateFormat("yyyyMMdd");
		 String name="���ۼ�¼"+format.format(date)+".cav";
		 InputStream in=null;
		 try{
			 in=new FileInputStream(name);
			 if(in!=null){
				 in.close();
				 createFile(name,true,books);
			 }
		 }catch(FileNotFoundException e){
			 createFile(name,false,books);
		 }catch(IOException e){
			 e.printStackTrace();
		 }
	 }
	
	 public static void createFile(String name,boolean label,Books books){
		 BufferedOutputStream out=null;
		 StringBuffer sbf=new StringBuffer();
		 try{
			 if(label){
				 out=new BufferedOutputStream(new FileOutputStream(name,true));
			 }else{
				 out=new BufferedOutputStream(new FileOutputStream(name));
				 String [] fieldSort=new String[]{"ͼ��ݱ��", "ͼ������", "��������",
						  "����", "�ܼ�", "������"};
				 for(String fieldKye:fieldSort){
					 sbf.append(fieldKye).append(SEPARATE_FIELD);
				 }
			 }
			 sbf.append(SEPARATE_LINE);
			 sbf.append(books.id).append(SEPARATE_FIELD);
			 sbf.append(books.name).append(SEPARATE_FIELD);
			 sbf.append(books.number).append(SEPARATE_FIELD);
			 sbf.append((double)books.price).append(SEPARATE_FIELD);
			 sbf.append((double)books.money).append(SEPARATE_FIELD);
			 sbf.append(books.publish).append(SEPARATE_FIELD);
			 String str=sbf.toString();
			 byte [] b=str.getBytes();
			 for(int i=0;i<b.length;i++){
				 out.write(b[i]);
			 }
		 }catch(Exception e){
			 e.printStackTrace();
		 }finally{
			 try{
				 if(out!=null){
					 out.close();
				 }
			 }catch(Exception e2){
				 e2.printStackTrace();
			 }
		 }
	 }	 
}
