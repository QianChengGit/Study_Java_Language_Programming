package ch26;

public class YearMonthDay {
	private int year;
	private int month;
	private int day;
	//使用一个静态数组变量
	public static int[] months={31,28,31,30,31,30,31,31,30,31,30,31};
	public int getYear() {
	return year;
	}
	public void setYear(int year) {
	this.year = year;
	}
	public int getMonth() {
	return month;
	}
	public void setMonth(int month) {
	this.month = month;
	}
	public int getDay() {
	return day;
	}
	public void setDay(int day) {
	this.day = day;
	}
	public YearMonthDay(){
	}
	public YearMonthDay(int year, int month, int day) {
	super();
	this.year = year;
	this.month = month;
	this.day = day;
	}
	/*
	* 判断是否是闰年
	* 4年一闰，百年不闰，400年又闰
	*/
	private void isRunYear(){
	if((this.year%4==0&&this.year%100!=0)||this.year%400==0){
	//闰年
	months[1]=29;
	}else{
	//平年
	months[1]=28;
	}
	}
	/*
	* 天数计算
	*/
	public int totleDays(){
	isRunYear();
	int totle = 0;
	for(int i=0;i<month-1;i++){
	totle = totle+months[i];
	}
	totle =totle+this.day;
	return totle;
	}
	/*
	* 判断用户输入是否存在
	*/
	public void isExits(){
	if(month<0||month>12){
	System.out.println("月份错误");
	System.exit(0);
	}
	if(day<0||day>31){
	System.out.println("日期错误");
	System.exit(0);
	}
}
}
