package ch32;
import java.util.Scanner;
public class Test {
		public static void main(String[] args) {

			Student[] stuArr = {new Student("张三",13,"201701081041"),new Student("李四",14,"201701081042"),new Student("王五",15,"201701081043")};

			

			System.out.print("请输入要查找的学生姓名：\n");

			Scanner sc = new Scanner(System.in);

			String name = sc.nextLine();

			

			for(Student temp:stuArr){

				if(temp.getName().equals(name)){

					System.out.println("待查询的学生信息如下：\n"+temp);

					return;

				}

			}

			System.out.println(name+"，该学生信息不存在！");

		}

	}

