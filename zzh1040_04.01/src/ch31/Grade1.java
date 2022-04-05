package ch31;
import java.util.Scanner;
public class Grade1 {
	private String gName;
	private Student1[] stuArr;

	public Grade1(){}
	public Grade1(String n){
		this.gName=n;
	}
	public void setStuArr(Student1[] ss){
		this.stuArr=ss;
	}
	public Student1[] getStuArr(){
		return this.stuArr;
	}
	public void printStuArr(){
		int i;
		for(i=0;i<this.stuArr.length;i++){
			stuArr[i].showStu();
		}
	}
	public void findStuArr(){
		int i;
		Scanner in = new Scanner(System.in);
		for(Student1 temp:stuArr){ 
			String name=in.nextLine();
		//	String student=//stuArr[i].get(name);student!=nulli=0;i<this.stuArr.length;i++
			if(temp.getName().equals(name)){
				System.out.println("查找到的信息为："+temp);
			//	stuArr[].showStu();
				return;
			}
			else{
				System.out.println("没有找到该学生信息！");
			}
		}
	}
}
