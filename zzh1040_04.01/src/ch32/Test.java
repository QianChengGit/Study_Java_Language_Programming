package ch32;
import java.util.Scanner;
public class Test {
		public static void main(String[] args) {

			Student[] stuArr = {new Student("����",13,"201701081041"),new Student("����",14,"201701081042"),new Student("����",15,"201701081043")};

			

			System.out.print("������Ҫ���ҵ�ѧ��������\n");

			Scanner sc = new Scanner(System.in);

			String name = sc.nextLine();

			

			for(Student temp:stuArr){

				if(temp.getName().equals(name)){

					System.out.println("����ѯ��ѧ����Ϣ���£�\n"+temp);

					return;

				}

			}

			System.out.println(name+"����ѧ����Ϣ�����ڣ�");

		}

	}

