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
		String message="商品编号："+id+"商品名称："+name+"单价："+price+"元	"+"进价："+money+"元	"+"生产商："+Manufacturer+"库存："+number;
		return message;
		
	}
	public void setNumber(int number){
		this.number=number;
		
	}
}
