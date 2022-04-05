package cn.ArrayList.com;
import java.util.*;
public class Example01 {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add("stu1");
		list.add("stu2");
		list.add("stu3");
		list.add("stu4");
		System.out.println("集合的长度："+list.size());
		System.out.println("第三个元素是："+list.get(2));
		System.out.println("集合中是否包含stu2:"+list.contains("stu2"));
		System.out.println(list.iterator());
		list.add(2, "stu");
		System.out.println("集合的长度："+list.size());
		System.out.println("第三个元素是："+list.get(2));
		//利用下标遍历集合
		for(int i=0;i<list.size();i++){
			System.out.println("第"+(i+1)+"个元素为："+list.get(i));
		}
		//foreach遍历集合
		for(Object s: list){
			System.out.println(s);
		}
	}
}
