package ch44;

public class Example26 {
	public static void main(String[] args) {
		try{
			Porson n=new Porson("����","dew","12��");
			String result=divide(n.getSex());
			System.out.println(result);
		}catch(Porson e){
			System.out.println(e.getMessage());
		}
	}
	public static String divide(String t) throws Porson
	{
		if(t!="��"&&t!="Ů"){
			throw new Porson("���棺�Ա��쳣��");
		}
		String result=t;
		return result;
	}
}
