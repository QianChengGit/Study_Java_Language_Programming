package ch84;
import java.awt.event.*;
import javax.swing.*;
public class MYJPopupMenu extends JFrame{
	private JPopupMenu popupMenu;
	
	public MYJPopupMenu() {
		popupMenu = new JPopupMenu();;
		JMenuItem refreshItem = new JMenuItem("refreshItem");
		JMenuItem createItem = new JMenuItem("createItem");
		JMenuItem exitItem = new JMenuItem("exitItem");
		
		exitItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		
		popupMenu.add(refreshItem);
		popupMenu.add(createItem);
		popupMenu.addSeparator();
		popupMenu.add(exitItem);
		
		this.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getButton() == e.BUTTON3){
					popupMenu.show(e.getComponent(), e.getX(), e.getY());
				}
				
			}
		});
		
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new MYJPopupMenu();
	}

}
