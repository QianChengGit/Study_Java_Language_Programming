package cn.itcast.fruitstore.test;
import cn.itcast.fruitstore.view.AbstractMainFrame;
public class AbstractMainFrameTest extends AbstractMainFrame{
	public static void main(String[] args) {
		new AbstractMainFrameTest().setVisible(true);
	}
	public void showAdminDialog(){
		System.out.println("����������");
	}

}
