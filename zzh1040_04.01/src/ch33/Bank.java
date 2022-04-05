package ch33;

public class Bank {
	static String bankName;
	private String name;
	private String password;
	private double balance;
	private double turnover;
	
	static void welcome(){
		System.out.println("欢迎来到"+bankName+"----------");
		
	}
	
	public Bank(String name,String password,double turnover){
		this.name=name;
		this.password=password;
		this.turnover=turnover;
		this.balance=turnover-10;
		System.out.println(name+"开户成功，账户余额"+balance);
	}
	public void deposit(double turnover){
		balance=balance+turnover;
		System.out.println(name+"您好，您的账户 已存入"+turnover+"元， "+"当前余额 "+balance+" 元");
	}
	public void withdrawal(String password,double turnover){
		if(this.password!=password){
			System.out.println("您输入的密码错误！");
			return;
		}
		if(balance-turnover>0){
			balance=balance-turnover;
			System.out.println(name+"您好，您的账户 已取出"+turnover+"元，"+"当前余额 "+balance+" 元");
		}
		else{
			System.out.println("对不起，账户余额不足！");
		}
	}
	static void welcomeNext(){
		System.out.println("请携带好随身财物，欢迎下次光临！"+bankName+"---------");
	}
}
