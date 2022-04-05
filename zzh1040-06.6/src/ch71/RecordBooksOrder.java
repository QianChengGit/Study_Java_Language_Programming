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
	static ArrayList<Books> booksList=new ArrayList<Books>();//创建书架
	public static void main(String[] args) {
		init();
		for(int i=0;i<booksList.size();i++){
			System.out.println(booksList.get(i));
		}
		while(true){
			Scanner scan=new Scanner(System.in);
			System.out.println("请输入图书编号：");
			int bookId=scan.nextInt();
			Books stockBooks=getBooksById(bookId);
			if(stockBooks!=null){
				System.out.println("当前图书信息："+stockBooks);
				System.out.println("请输入购买数量：");
				int bookNumber=scan.nextInt();
				if(bookNumber<=stockBooks.number){
					Books books=new Books(stockBooks.id,stockBooks.name,stockBooks.price
							,bookNumber,stockBooks.price*bookNumber,stockBooks.publish);
					FileUtil.saveBooks(books);
					stockBooks.setNumber(stockBooks.number-bookNumber);
				}else{
					System.out.println("库存不足！");
				}
			}else{
				System.out.println("图书编号输入错误！");
			}
		}
	}
	
	private static void init(){
		Books goods1=new Books(101,"Java基础入门",44.50,100,4450.00,"清华大学出版社");
		Books goods2=new Books(102,"Java编程思想",108.00,50,5400.00,"机械工业出版社");
		Books goods3=new Books(103,"疯狂Java讲义",99.00,100,9900.00,"电子工业出版社");
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
		String message="图书编号："+id+"  图书名称："+name+
				"  出版社："+publish+"  单价："+price+"  库存数量："+number;
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
		 String name="销售记录"+format.format(date)+".cav";
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
				 String [] fieldSort=new String[]{"图书馆编号", "图书名称", "购买数量",
						  "单价", "总价", "出版社"};
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
