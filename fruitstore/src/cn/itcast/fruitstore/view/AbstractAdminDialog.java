package cn.itcast.fruitstore.view;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import cn.itcast.fruitstore.tools.GUITools;
public abstract class AbstractAdminDialog extends JDialog{
	//定义界面使用到的组件作为成员变量
	private JLabel tableLabel=new JLabel("水果列表");//水果列表标题
	private JScrollPane tablePane=new JScrollPane();//滚动视口
	protected JTable table=new JTable();//水果列表
	private JLabel numberLabel=new JLabel("水果编号");//编号标题
	private JLabel nameLabel=new JLabel("水果名称");//名称标题
	private JLabel priceLabel=new JLabel("水果单价");//单价标题
	private JLabel unitLabel=new JLabel("计价单位");//计价单位标题
	
	//添加功能组件
	protected JTextField addNumberText=new JTextField(6);//添加编号文本框
	protected JTextField addNameText=new JTextField(6);//添加名称文本框
	protected JTextField addPriceText=new JTextField(6);//添加单价文本框
	protected JTextField addUnitText=new JTextField(6);//添加计价单位文本框
	private JButton addBtn=new JButton("添加水果");//添加水果按钮
	
	//修改功能组件
	protected JTextField updateNumberText=new JTextField(6);//修改编号文本框
	protected JTextField updateNameText=new JTextField(6);//修改名称文本框
	protected JTextField updatePriceText=new JTextField(6);//修改单价文本框
	protected JTextField updateUnitText=new JTextField(6);//修改计价单位文本框
	private JButton updateBtn=new JButton("修改水果");//修改水果按钮
	
	//删除功能组件
	protected JTextField delNumberText=new JTextField(6);//添加编号文本框
	private JButton delBtn=new JButton("删除水果");//删除水果按钮
	
	//构造方法
	public AbstractAdminDialog(){
		this(null,true);
	}
	public AbstractAdminDialog(Frame owner,boolean modal){
		super(owner,modal);
		this.init();//初始化操作
		this.addComponent();//添加组件
		this.addListener();//添加监听器
	}
	
	//初始化操作
	private void init(){
		this.setTitle("超市货物管理");//窗口标题
		this.setSize(1050,790);//窗体大小与位置
		GUITools.center(this);//设置窗口在屏幕上的位置
		this.setResizable(false);//窗体大小位置
	}
	
	//添加组件
	private void addComponent(){
		//取消布局
		this.setLayout(null);
		//表格标题
		tableLabel.setFont(new Font("黑体",Font.BOLD,20));
		tableLabel.setBounds(500, 10, 100, 50);
		this.add(tableLabel);
		//表格
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		table.setEnabled(false);
		tablePane.setBounds(50, 50, 950, 500);
		tablePane.setViewportView(table);
		this.add(tablePane);
		//字段标题
		numberLabel.setBounds(70,570,70,25);
		nameLabel.setBounds(270,570,70,25);
		priceLabel.setBounds(470,570,70,25);
		unitLabel.setBounds(670,570,70,25);
		this.add(numberLabel);
		this.add(nameLabel);
		this.add(priceLabel);
		this.add(unitLabel);
		
		//增加组件
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
		
		//修改组件
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
		
		//删除组件
		delNumberText.setBounds(50, 700, 100, 25);
		this.add(delNumberText);
		delBtn.setBounds(850, 700, 90, 25);
		this.add(delBtn);
	}
	
	//添加监听器
	private void addListener(){
		//添加按钮
		addBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//调用添加方法
				addFruitItem();
				}
			});
		//修改按钮
		updateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				//调用修改方法
				updateFruitItem();
			}
		});
		//删除按钮
		delBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				//调用删除方法
				delFruitItem();
			}
		});
	}
	
	//查询方法
	public abstract void queryFruitItem();
	//添加方法
	public abstract void addFruitItem();
	//修改方法
	public abstract void updateFruitItem();
	//删除方法
	public abstract void delFruitItem();
}
