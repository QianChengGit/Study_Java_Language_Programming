package ch31;

public class Shopping {

	public static void main(String[] args) {
		Product p1=new Product();
		Product p2=new Product();
		Product p3=new Product();
		Product p4=new Product();
		Product p5=new Product();
		p1.setproName("���ӻ�");
		p2.setproName("ϴ�»�");
		p3.setproName("������");
		p4.setproName("�յ���");
		p5.setproName("�����");
		Market m=new Market();
		m.setMarketName("���ָ�");
		m.setproductArr(new Product[]{p1,p2,p3,p4,p5});
		Person p=new Person();
		p.setName("С��");
		Product result=p.shopping(m, "�����");
		if(result!=null){
			System.out.println(p.getName()+"��"+m.getMarketName()+"����"+result.getproName());
		}
		else{
			System.out.println(p.getName()+"������һ�ˣ���"+m.getMarketName()+"ʲô��û��");
		}
	}

}
