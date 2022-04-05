package ch84;
import java.awt.*;
import java.util.Random;
public class Paint extends Panel{
	public void paint(Graphics g){
		char[] zheng=new char[4];
		int width=100;
		int height=46;
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, width, height);
		g.setColor(Color.black);
		g.drawRect(0, 0, width-1, height-1);
		
		Random r= new Random();
		for(int i=0;i<100;i++){
			int x=r.nextInt(width)-2;
			int y=r.nextInt(height)-2;
			g.drawOval(x, y, 2, 2);
		}
		g.setFont(new Font("ºÚÌå",Font.BOLD,20));
		g.setColor(Color.RED);
		char [] chars= ("0123456789abcdefghijkmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();
		StringBuilder sb= new StringBuilder();
		for(int i=0;i<4;i++){
			int pos=r.nextInt(chars.length);
			char c=chars[pos];
			zheng[i]=chars[pos];
		//	yan[i]=Character.toString(c);
		//	yan[i]=String.valueOf(c);
			sb.append(c+" ");
		}
		String str=new String(zheng);
		System.out.println(str);
		g.drawString(sb.toString(), 10, 30);
	//	return str;
	}
}
