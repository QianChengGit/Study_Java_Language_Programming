package cn.itcast.fruitstore.controller;
import cn.itcast.fruitstore.view.AbstractMainFrame;
public class MainFrameController extends AbstractMainFrame{

	@Override
	public void showAdminDialog() {
		// TODO Auto-generated method stub
		new AdminDialogController(this, true).setVisible(true);
	}

}
