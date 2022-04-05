package gui1;
import java.awt.*;
public class ImgPanel extends Panel{
	Image img;
	public ImgPanel(Image img){
		this.img=img;
	}
	public void paint(Graphics g){
		super.paint(g);
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(),this);
	}
}
