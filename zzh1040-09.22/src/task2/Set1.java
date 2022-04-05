package task2;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

class Book implements Comparable<Book>{
	private String title;
	private double price;
	public Book(String title,double price) {
		this.title = title;
		this.price = price;
	}
	public String toString(){
		return "书名："+ this.title +",价格"+ this.price +"\n";
	}
	public int compareTo(Book o){
		if(this.price > o.price){
			return 1;
		}else if(this.price < o.price){
			return -1;
		}else{
			return this.title.compareTo(o.title);
		}
	}
}

class Book1 {
	private String title;
	private double price;
	public Book1(String title,double price) {
		this.title = title;
		this.price = price;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book1 other = (Book1) obj;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	public String toString(){
		return "书名："+ this.title +",价格"+ this.price +"\n";
	}
	
}



public class Set1 {
	public static void main(String[] args) throws Exception{
		//HashSet无重复数据，且无序排列
		Set<String> all = new HashSet<String>();
		all.add("NIHAO");
		all.add("Hello");
		all.add("Hello");
		all.add("World");
		System.out.println(all);
		//TrrSet无重复数据，且自动排序
		Set<String> all1 = new TreeSet<String>();
		all1.add("X");
		all1.add("B");
		all1.add("A");
		all1.add("B");
		System.out.println(all1);
		
		Set<Book> all2 = new TreeSet<Book>();
		all2.add(new Book("Java开发",79.8));
		all2.add(new Book("Java开发",79.8));
		all2.add(new Book("JSP开发",79.8));
		all2.add(new Book("Android开发",89.8));
		System.out.println(all2);
		
		Set<Book> all3 = new HashSet<Book>();
		all3.add(new Book("Java开发",79.8));
		all3.add(new Book("Java开发",79.8));
		all3.add(new Book("JSP开发",79.8));
		all3.add(new Book("Android开发",89.8));
		System.out.println(all3);
		
		Set<Book1> all4 = new HashSet<Book1>();
		all4.add(new Book1("Java开发",79.8));
		all4.add(new Book1("Java开发",79.8));
		all4.add(new Book1("JSP开发",79.8));
		all4.add(new Book1("Android开发",89.8));
		System.out.println(all4);
	}
}
