package task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
public class PokerShuffleCards {
	public static void main(String[] args){
		//准备花色
		ArrayList<String> color = new ArrayList<String>();
		color.add("♠");
		color.add("♥");
		color.add("♣");
		color.add("♦");
		//准备数字，用ArrayList将纸牌由小到大排序
		ArrayList<String> number = new ArrayList<String>();
		for(int i=3;i<=10;i++){
			number.add(i+"");
		}
		number.add("J");
		number.add("Q");
		number.add("K");
		number.add("A");
		number.add("2");
		//定义一个Map集合：用来将数字和每一张牌进行对应
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		int index = 0;
		for(String thisNumber : number){
			for(String thisColor : color){
				map.put(index++, thisColor + thisNumber);
			}
		}
		
		//加大小王
		map.put(index++, "(o^.^o)");
		map.put(index++, "(o@.@o)");
		//创建内容为0~53的数字集合，代替着54张牌
		ArrayList<Integer> cards = new ArrayList<Integer>();
		for(int i=0;i<=53;i++){
			cards.add(i);
		}
		//洗牌
		Collections.shuffle(cards);
		//创建三个玩家和低牌
		ArrayList<Integer> iPlayer = new ArrayList<Integer>();
		ArrayList<Integer> iPlayer2 = new ArrayList<Integer>();
		ArrayList<Integer> iPlayer3 = new ArrayList<Integer>();
		ArrayList<Integer> iSecretCards = new ArrayList<Integer>();
		//遍历这幅洗好的牌，遍历过程中，将牌发到3个玩家和底牌中
		for(int i=0;i<cards.size();i++){
			if(i>=51){
				iSecretCards.add(cards.get(i));
			}else{
				if(i%3==0){
					iPlayer.add(cards.get(i));
				}else if(i%3==1){
					iPlayer2.add(cards.get(i));
				}else{
					iPlayer3.add(cards.get(i));
				}
			}
		}
		//对每个人手中的牌排序，使用Collections工具类中的sort()方法
		Collections.sort(iPlayer);
		Collections.sort(iPlayer2);
		Collections.sort(iPlayer3);
		//对应数字形式的每个人手中的牌，定义字符串形式的牌
		ArrayList<String> sPlayer = new ArrayList<String>();
		ArrayList<String> sPlayer2 = new ArrayList<String>();
		ArrayList<String> sPlayer3 = new ArrayList<String>();
		ArrayList<String> sSecretCards = new ArrayList<String>();
		//循环主键，从map中获取纸牌
		for(Integer key : iPlayer){
			sPlayer.add(map.get(key));
		}
		for(Integer key : iPlayer2){
			sPlayer2.add(map.get(key));
		}
		for(Integer key : iPlayer3){
			sPlayer3.add(map.get(key));
		}
		for(Integer key : iSecretCards){
			sSecretCards.add(map.get(key));
		}
		//看牌
		System.out.println("玩家1："+sPlayer);
		System.out.println("玩家2："+sPlayer2);
		System.out.println("玩家3："+sPlayer3);
		System.out.println("底牌："+sSecretCards);
	}
}
