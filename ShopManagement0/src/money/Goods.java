package money;

public class Goods {
	int id;
	String name;
	double price;
	int number;
	
	
	double money;
	String Manufacturer;
	public Goods(int id,String name,double price,double money,String Manufacturer,int number){
		this.id=id;
		this.name=name; 
		this.price=price;
		this.money=money;
		this.number=number;
		
		this.Manufacturer=Manufacturer;
		
	}
	
	

	public String toString(){
		String message="��Ʒ��ţ�"+id+"��Ʒ���ƣ�"+name+"���ۣ�"+price+"Ԫ	"+"���ۣ�"+money+"Ԫ	"+"�����̣�"+Manufacturer+"��棺"+number;
		return message;
		
	}
	public void setNumber(int number){
		this.number=number;
		
	}
}
