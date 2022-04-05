package ch31;

public class Shopping {

	public static void main(String[] args) {
		Product p1=new Product();
		Product p2=new Product();
		Product p3=new Product();
		Product p4=new Product();
		Product p5=new Product();
		p1.setproName("电视机");
		p2.setproName("洗衣机");
		p3.setproName("豆浆机");
		p4.setproName("空调机");
		p5.setproName("吹风机");
		Market m=new Market();
		m.setMarketName("家乐福");
		m.setproductArr(new Product[]{p1,p2,p3,p4,p5});
		Person p=new Person();
		p.setName("小韩");
		Product result=p.shopping(m, "吹风机");
		if(result!=null){
			System.out.println(p.getName()+"在"+m.getMarketName()+"买到了"+result.getproName());
		}
		else{
			System.out.println(p.getName()+"白跑了一趟，在"+m.getMarketName()+"什么都没买到");
		}
	}

}
