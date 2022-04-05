package youxi2;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
public class ImagePanel01 extends Panel{
	Image img;
	public ImagePanel01(Image img){
		this.img=img;
	}
	public void paint(Graphics g){
		super.paint(g);
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(),this);
	}
}
