package money;
import java.util.ArrayList;
import java.util.Scanner;

public class RecordGoodsOrder {
	static ArrayList<Goods>goodsList=new ArrayList<Goods>();
	static void init(){
		Goods goods1=new Goods(101,"С���				",19,17.5,"�ȷ���ɳ����ҵ�����������ι�˾     		",1200);
		goodsList.add(goods1);
		Goods goods2=new Goods(102,"����				",56,50.6,"����ʡ��ũ������ѧ���������������ι�˾	",2000);
		goodsList.add(goods2);
		Goods goods3=new Goods(103,"����				",40,35,"�ӱ���ɳ����ҵ�����������ι�˾		",4000);
		goodsList.add(goods3);
		Goods goods4=new Goods(104,"ʳ��ֲ����				",109,101,"����ʡ�γ�����Ƽ����޹�˾		",3100);
		goodsList.add(goods4);
		Goods goods5=new Goods(105,"����				",44,41,"��̨������ҵʳƷ���޹�˾			",5800);
		goodsList.add(goods5);
		Goods goods6=new Goods(106,"����				",188,170,"�㽭ʡ�𻪻������޹�˾�����ֹ�˾		",1199);
		goodsList.add(goods6);
		Goods goods7=new Goods(107,"��ţ��ţ��				",46,40,"���ɹ���ţ�����������ι�˾		",23578);
		goodsList.add(goods7);
		Goods goods8=new Goods(108,"��լ����ˮ				",39,30,"�����ɿڿ�������(����)���޹�˾		",74);
		goodsList.add(goods8);
		Goods goods9=new Goods(109,"��ʦ������ţ�ⷽ����		",5,3,"���ݶ���ʳƷ���޹�˾			",35665);
		goodsList.add(goods9);
		Goods goods10=new Goods(110,"����				",168,150,"���������ڼ�ʳƷ���޹�˾			",3545);
		goodsList.add(goods10);
		Goods goods11=new Goods(111,"������Ƭ				",5,3,"����ʳƷ(�й�)���޹�˾			",2800);
		goodsList.add(goods11);
		Goods goods12=new Goods(112,"�ſ˼����ǹ�			",50,45,"����ʡ���������﹤ҵ԰��			",1250);
		goodsList.add(goods12);
		Goods goods13=new Goods(113,"ħ�Ǹ߶˺��ɿ���			",170,150,"����Ʒ����ʳƷ���޹�˾			",979);
		goodsList.add(goods13);
		Goods goods14=new Goods(114,"������������Ҷ������ǰ����������	",108,98,"���ݲ賧���޹�˾				",23722);
		goodsList.add(goods14);
				
	}//��������
	public void main(String[] args){
		init();
		for(int i=0;i < goodsList.size();i++){
			System.out.println(goodsList.get(i));
		}
		while(true){
			
		Scanner scan =new Scanner(System.in);
				System.out.println("����-1��������");
				System.out.println("����������ţ�");
				
				int goodsId=scan.nextInt();
				Goods stockGoods=getGoodsById(goodsId);
				if(goodsId<0){
					exit();
				}
				if (stockGoods !=null) {
					System.out.println("��ǰ��Ʒ��Ϣ: "+stockGoods);
					System.out.println("���������������");
					int sellNumber=scan.nextInt();
					
					if(sellNumber <=stockGoods.number){
						
						Goods goods=new Goods(stockGoods.id,stockGoods.name,stockGoods.price,stockGoods.money,
								stockGoods.Manufacturer,stockGoods.number-sellNumber);
						stockGoods.setNumber(stockGoods.number-sellNumber);
						FileUtil.saveGoods(goods);
					}else{
						System.out.println("��治�㣡");
					}
					System.out.println("��������Ϊ��"+(stockGoods.price-stockGoods.money)*sellNumber+"Ԫ");
					System.out.println("�����빺��������");
					int buyNumber=scan.nextInt();
								Goods goods=new Goods(stockGoods.id,stockGoods.name,stockGoods.price,stockGoods.money,
								stockGoods.Manufacturer,stockGoods.number+buyNumber);
						
						stockGoods.setNumber(stockGoods.number+buyNumber);
						FileUtil.saveGoods(goods);
						System.out.println("����֧��Ϊ��"+stockGoods.money*buyNumber+"Ԫ");
					}else{
						System.out.println("��������ȷ����Ʒ��ţ�");
					}
	}
}

private static void exit() {
	System.out.println("�����˳�ϵͳ��ллʹ�ã�");
	System.exit(0);
		
	}
private static Goods getGoodsById(int goodId){
	for(int i=0;i<goodsList.size();i++){
		Goods thisGoods=goodsList.get(i);
		if(goodId==thisGoods.id){
			return thisGoods;
		}}
		return null;
	}
}