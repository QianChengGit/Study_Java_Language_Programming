package cn.ArrayList.com;
import java.util.*;
public class Example01 {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add("stu1");
		list.add("stu2");
		list.add("stu3");
		list.add("stu4");
		System.out.println("���ϵĳ��ȣ�"+list.size());
		System.out.println("������Ԫ���ǣ�"+list.get(2));
		System.out.println("�������Ƿ����stu2:"+list.contains("stu2"));
		System.out.println(list.iterator());
		list.add(2, "stu");
		System.out.println("���ϵĳ��ȣ�"+list.size());
		System.out.println("������Ԫ���ǣ�"+list.get(2));
		//�����±��������
		for(int i=0;i<list.size();i++){
			System.out.println("��"+(i+1)+"��Ԫ��Ϊ��"+list.get(i));
		}
		//foreach��������
		for(Object s: list){
			System.out.println(s);
		}
	}
}
