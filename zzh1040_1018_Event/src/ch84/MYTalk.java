package ch84;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MYTalk extends JFrame{
	JButton sendBt;
	JTextField inputField;
	JTextArea chatContent;
	public MYTalk(){
		this.setLayout(new BorderLayout());
		chatContent=new JTextArea(12, 34);
		JScrollPane showPanel=new JScrollPane(chatContent);
		chatContent.setEditable(false);
		JPanel inputPanel=new JPanel();
		inputField=new JTextField(20);
		sendBt =new JButton("发送");
		sendBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String content=inputField.getText();
				if(content != null && !content.trim().equals("")){
					chatContent.append("本人："+content+"\n");
				}else{
					chatContent.append("聊天信息不能为空！"+"\n");
				}
				inputField.setText("");
			}
		});
		Label label=new Label("聊天信息");
		inputPanel.add(label);
		inputPanel.add(inputField);
		inputPanel.add(sendBt);
		this.add(showPanel, BorderLayout.CENTER);
		this.add(inputPanel, BorderLayout.SOUTH);
		this.setTitle("聊天窗口");
	//	this.setSize(400, 300);
		this.setBounds(500, 500, 400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new MYTalk();
	}
}
