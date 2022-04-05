package baidu;
import java.io.*;
public class Baidu1{
public static void main(String[] args) throws IOException {
	BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter buff = new BufferedWriter(new FileWriter("D:/学生信息系统.txt"));
	BufferedReader buf1 = new BufferedReader(new FileReader("D:/学生信息系统.txt"));
	FileReader fr=new FileReader("D:/学生信息系统.txt");
	System.out.println("===========================");
	System.out.println(" 学生信息系统");
	System.out.println("===========================");
	System.out.println("===========================");
	System.out.println(" 请输入姓名、学号和成绩:");
	System.out.println("===========================");
	System.out.println();
	String str = buf.readLine();//读取一行
	while (!str.equals("")) {
		buff.write(str);//将str写入到缓冲区
		buff.newLine();//写入换行符
		buff.flush();//将缓冲区内的数据写入到文件
		str = buf.readLine();
	}
	System.out.println("===========================");
		buf.close();//关闭
		buff.close();//关闭
		System.out.println(" 学生信息已从键盘写入文件!");
		System.out.println("===========================");
//创建可容纳128个字符的数组
		char data[]=new char[128];
//将数据读入字符串行数组中
		int num=fr.read(data);
//将字符串行转化成字符串
		String str2=new String(data,0,num);
		System.out.println("===========================");
		System.out.println(" 文件中的学生信息:");
		System.out.println("===========================");
		System.out.println();
		System.out.println(str2);
		fr.close();//关闭
		System.out.println("==========================="); System.out.println("学生信息已从文件读出到窗体!");
		System.out.println("==========================="); System.out.println();
//创建可容纳100个字符串的数组
		String[]s=new String[100];
//创建可容纳100个双精度行的数组
		Double[]score=new Double[100];
//异常处理程序
		try{
//将字符串分行读入
			for(int i=0;s[i]!="";i++)
			{
				s[i]=buf1.readLine();
				int num1=s[i].length();
//截取最后三位字符串即为分数,以满分一百位最大限
				s[i]=s[i].substring(num1-3,num1);
//将字符串转换成Double型存入score数组
				score[i]=Double.parseDouble(s[i]);
//打印每位学生的成绩
				System.out.println(" 第"+(i+1)+"个学生的成绩:"+score[i]);
			}
		}
//捕获NullPointerException异常
		catch(NullPointerException e)
		{
		}
		int k=0;//计数标志位
		Double max=score[0];//最高分
		Double min=score[0];//最低分
		Double total=0.0;//总分
		Double average=0.0;//平均分
		System.out.println();
		System.out.println("==========================="); System.out.println(" 处理结果");
		System.out.println("==========================="); System.out.println();
//计算程序
		for(int j=0;score[j]!=null;j++)
		{
			if(score[j]>max)
				max=score[j];
			if(score[j]<min)
				min=score[j];
			total=total+score[j];
			k=j+1;
		}
		average=total/k;
		System.out.println(" 最高分为:"+max);
		System.out.println(" 最低分为:"+min);
		System.out.println(" 平均分为:"+average);
		System.out.println(" 总分为:"+total);
		System.out.println();
		System.out.println("===========================");
		System.out.println(" 工作已经完成!");
		System.out.println("===========================");
	}
}