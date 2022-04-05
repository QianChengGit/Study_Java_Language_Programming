package cn.itcast.fruitstore.view;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import cn.itcast.fruitstore.tools.GUITools;
public abstract class AbstractAdminDialog extends JDialog{
	//�������ʹ�õ��������Ϊ��Ա����
	private JLabel tableLabel=new JLabel("ˮ���б�");//ˮ���б����
	private JScrollPane tablePane=new JScrollPane();//�����ӿ�
	protected JTable table=new JTable();//ˮ���б�
	private JLabel numberLabel=new JLabel("ˮ�����");//��ű���
	private JLabel nameLabel=new JLabel("ˮ������");//���Ʊ���
	private JLabel priceLabel=new JLabel("ˮ������");//���۱���
	private JLabel unitLabel=new JLabel("�Ƽ۵�λ");//�Ƽ۵�λ����
	
	//��ӹ������
	protected JTextField addNumberText=new JTextField(6);//��ӱ���ı���
	protected JTextField addNameText=new JTextField(6);//��������ı���
	protected JTextField addPriceText=new JTextField(6);//��ӵ����ı���
	protected JTextField addUnitText=new JTextField(6);//��ӼƼ۵�λ�ı���
	private JButton addBtn=new JButton("���ˮ��");//���ˮ����ť
	
	//�޸Ĺ������
	protected JTextField updateNumberText=new JTextField(6);//�޸ı���ı���
	protected JTextField updateNameText=new JTextField(6);//�޸������ı���
	protected JTextField updatePriceText=new JTextField(6);//�޸ĵ����ı���
	protected JTextField updateUnitText=new JTextField(6);//�޸ļƼ۵�λ�ı���
	private JButton updateBtn=new JButton("�޸�ˮ��");//�޸�ˮ����ť
	
	//ɾ���������
	protected JTextField delNumberText=new JTextField(6);//��ӱ���ı���
	private JButton delBtn=new JButton("ɾ��ˮ��");//ɾ��ˮ����ť
	
	//���췽��
	public AbstractAdminDialog(){
		this(null,true);
	}
	public AbstractAdminDialog(Frame owner,boolean modal){
		super(owner,modal);
		this.init();//��ʼ������
		this.addComponent();//������
		this.addListener();//��Ӽ�����
	}
	
	//��ʼ������
	private void init(){
		this.setTitle("���л������");//���ڱ���
		this.setSize(1050,790);//�����С��λ��
		GUITools.center(this);//���ô�������Ļ�ϵ�λ��
		this.setResizable(false);//�����Сλ��
	}
	
	//������
	private void addComponent(){
		//ȡ������
		this.setLayout(null);
		//������
		tableLabel.setFont(new Font("����",Font.BOLD,20));
		tableLabel.setBounds(500, 10, 100, 50);
		this.add(tableLabel);
		//���
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		table.setEnabled(false);
		tablePane.setBounds(50, 50, 950, 500);
		tablePane.setViewportView(table);
		this.add(tablePane);
		//�ֶα���
		numberLabel.setBounds(70,570,70,25);
		nameLabel.setBounds(270,570,70,25);
		priceLabel.setBounds(470,570,70,25);
		unitLabel.setBounds(670,570,70,25);
		this.add(numberLabel);
		this.add(nameLabel);
		this.add(priceLabel);
		this.add(unitLabel);
		
		//�������
		addNumberText.setBounds(50,600,100,25);
		addNameText.setBounds(250,600,100,25);
		addPriceText.setBounds(450,600,100,25);
		addUnitText.setBounds(650,600,100,25);
		this.add(addNumberText);
		this.add(addNameText);
		this.add(addPriceText);
		this.add(addUnitText);
		addBtn.setBounds(850, 600, 90, 25);
		this.add(addBtn);
		
		//�޸����
		updateNumberText.setBounds(50,650,100,25);
		updateNameText.setBounds(250,650,100,25);
		updatePriceText.setBounds(450,650,100,25);
		updateUnitText.setBounds(650,650,100,25);
		this.add(updateNumberText);
		this.add(updateNameText);
		this.add(updatePriceText);
		this.add(updateUnitText);
		updateBtn.setBounds(850,650, 90, 25);
		this.add(updateBtn);
		
		//ɾ�����
		delNumberText.setBounds(50, 700, 100, 25);
		this.add(delNumberText);
		delBtn.setBounds(850, 700, 90, 25);
		this.add(delBtn);
	}
	
	//��Ӽ�����
	private void addListener(){
		//��Ӱ�ť
		addBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//������ӷ���
				addFruitItem();
				}
			});
		//�޸İ�ť
		updateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				//�����޸ķ���
				updateFruitItem();
			}
		});
		//ɾ����ť
		delBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				//����ɾ������
				delFruitItem();
			}
		});
	}
	
	//��ѯ����
	public abstract void queryFruitItem();
	//��ӷ���
	public abstract void addFruitItem();
	//�޸ķ���
	public abstract void updateFruitItem();
	//ɾ������
	public abstract void delFruitItem();
}
