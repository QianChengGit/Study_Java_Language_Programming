package ch44;

public class Example26 {
	public static void main(String[] args) {
		try{
			Porson n=new Porson("张三","dew","12岁");
			String result=divide(n.getSex());
			System.out.println(result);
		}catch(Porson e){
			System.out.println(e.getMessage());
		}
	}
	public static String divide(String t) throws Porson
	{
		if(t!="男"&&t!="女"){
			throw new Porson("警告：性别异常！");
		}
		String result=t;
		return result;
	}
}
