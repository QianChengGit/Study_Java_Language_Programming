package money;
import java.util.ArrayList;
import java.util.Scanner;

public class RecordGoodsOrder {
	static ArrayList<Goods>goodsList=new ArrayList<Goods>();
	static void init(){
		Goods goods1=new Goods(101,"小麦粉				",19,17.5,"廊坊金沙河面业集团有限责任公司     		",1200);
		goodsList.add(goods1);
		Goods goods2=new Goods(102,"大米				",56,50.6,"吉林省辉农粳稻科学技术开发有限责任公司	",2000);
		goodsList.add(goods2);
		Goods goods3=new Goods(103,"挂面				",40,35,"河北金沙河面业集团有限责任公司		",4000);
		goodsList.add(goods3);
		Goods goods4=new Goods(104,"食用植物油				",109,101,"福建省嘉成生物科技有限公司		",3100);
		goodsList.add(goods4);
		Goods goods5=new Goods(105,"酱油				",44,41,"烟台欣和企业食品有限公司			",5800);
		goodsList.add(goods5);
		Goods goods6=new Goods(106,"火腿				",188,170,"浙江省金华火腿有限公司东阳分公司		",1199);
		goodsList.add(goods6);
		Goods goods7=new Goods(107,"蒙牛纯牛奶				",46,40,"内蒙古蒙牛集团有限责任公司		",23578);
		goodsList.add(goods7);
		Goods goods8=new Goods(108,"肥宅快乐水				",39,30,"中粮可口可乐饮料(济南)有限公司		",74);
		goodsList.add(goods8);
		Goods goods9=new Goods(109,"康师傅麻辣牛肉方便面		",5,3,"杭州顶益食品有限公司			",35665);
		goodsList.add(goods9);
		Goods goods10=new Goods(110,"冰棍				",168,150,"广州市美口佳食品有限公司			",3545);
		goodsList.add(goods10);
		Goods goods11=new Goods(111,"乐事薯片				",5,3,"百事食品(中国)有限公司			",2800);
		goodsList.add(goods11);
		Goods goods12=new Goods(112,"雅克夹心糖果			",50,45,"福建省晋江市五里工业园区			",1250);
		goodsList.add(goods12);
		Goods goods13=new Goods(113,"魔吻高端黑巧克力			",170,150,"天津恒品逸美食品有限公司			",979);
		goodsList.add(goods13);
		Goods goods14=new Goods(114,"西湖牌龙井茶叶正宗雨前西湖龙井茶	",108,98,"杭州茶厂有限公司				",23722);
		goodsList.add(goods14);
				
	}//创建货架
	public void main(String[] args){
		init();
		for(int i=0;i < goodsList.size();i++){
			System.out.println(goodsList.get(i));
		}
		while(true){
			
		Scanner scan =new Scanner(System.in);
				System.out.println("输入-1结束程序！");
				System.out.println("请输入货物编号：");
				
				int goodsId=scan.nextInt();
				Goods stockGoods=getGoodsById(goodsId);
				if(goodsId<0){
					exit();
				}
				if (stockGoods !=null) {
					System.out.println("当前商品信息: "+stockGoods);
					System.out.println("请输入出售数量：");
					int sellNumber=scan.nextInt();
					
					if(sellNumber <=stockGoods.number){
						
						Goods goods=new Goods(stockGoods.id,stockGoods.name,stockGoods.price,stockGoods.money,
								stockGoods.Manufacturer,stockGoods.number-sellNumber);
						stockGoods.setNumber(stockGoods.number-sellNumber);
						FileUtil.saveGoods(goods);
					}else{
						System.out.println("库存不足！");
					}
					System.out.println("本次收益为："+(stockGoods.price-stockGoods.money)*sellNumber+"元");
					System.out.println("请输入购买数量：");
					int buyNumber=scan.nextInt();
								Goods goods=new Goods(stockGoods.id,stockGoods.name,stockGoods.price,stockGoods.money,
								stockGoods.Manufacturer,stockGoods.number+buyNumber);
						
						stockGoods.setNumber(stockGoods.number+buyNumber);
						FileUtil.saveGoods(goods);
						System.out.println("本次支出为："+stockGoods.money*buyNumber+"元");
					}else{
						System.out.println("请输入正确的商品编号！");
					}
	}
}

private static void exit() {
	System.out.println("您已退出系统，谢谢使用！");
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