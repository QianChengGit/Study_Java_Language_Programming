package gui1;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.*;
public class ImgJpanel extends JPanel{
	Image img;
	public ImgJpanel(Image img){
		this.img=img;
	}
	public void paint(Graphics g){
		super.paint(g);
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(),this);
	}
}
