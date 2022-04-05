package cn.itcast.fruitstore.test;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import cn.itcast.fruitstore.view.AbstractAdminDialog;

public class AbstractAdminDialogTest extends AbstractAdminDialog{
	//���幹�캯����ʼ������
	public AbstractAdminDialogTest(){
		super();
		queryFruitItem();//��������
	}
	//�������table����
	@Override
	public void queryFruitItem() {
		// TODO Auto-generated method stub
		String[] thead=new String[]{"ˮ�����","ˮ������","ˮ�����ۣ�/Ԫ��","�Ƽ۵�λ"};
		String[][] tbody=new String[][]{
			{"1","ƻ��","5.0","kg"},
			{"2","����","3.2","��"},
			{"3","ѩ��","3.8","��"},
			{"4","̩��������","120","��"}
		};
		TableModel data=new DefaultTableModel(tbody, thead);
		table.setModel(data);
	}

	@Override
	public void addFruitItem() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateFruitItem() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delFruitItem() {
		// TODO Auto-generated method stub
		
	}
	
	//�������������г���
	public static void main(String[] args) {
		//�������沢��ʾ
		new AbstractAdminDialogTest().setVisible(true);
	}
}
