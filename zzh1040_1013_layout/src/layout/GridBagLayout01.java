package layout;
import java.awt.*;

class Layout extends Frame{
	public Layout(String title){
		GridBagLayout01 layout = new GridBagLayout01();
		GridBagConstraints c = new GridBagConstraints();
		this.setLayout(layout);
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.weighty = 1;
		this.addComponent("btn1",layout,c);
		this.addComponent("btn2",layout,c);
		this.addComponent("btn3",layout,c);
		c.gridwidth = GridBagConstraints.REMAINDER;
		this.addComponent("btn4", layout, c);
		c.weightx = 0;
		c.weighty = 0;
		addComponent("btn5", layout, c);
		c.gridwidth = 1;
		this.addComponent("btn6", layout, c);
		c.gridwidth = GridBagConstraints.REMAINDER;
		this.addComponent("btn7", layout, c);
		c.gridheight = 2;
		c.gridwidth = 1;
		c.weightx = 2;
		c.weighty = 2;
		this.addComponent("btn8", layout, c);
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.gridheight = 1;
		this.addComponent("btn9", layout, c);
		this.addComponent("btn10", layout, c);
		this.setTitle(title);
		this.pack();
		this.setVisible(true);
	}

	private void setLayout(GridBagLayout01 layout) {
		// TODO 自动生成的方法存根
		
	}

	private void addComponent(String name, GridBagLayout01 layout, GridBagConstraints c) {
		Button bt = new Button(name);
		layout.setConstraints(bt,c);
		this.add(bt);
		
	}
}
public class GridBagLayout01{
	public static void main(String[] args) {
		new Layout("GridBagLayout");
	}

	public void setConstraints(Button bt, GridBagConstraints c) {
		// TODO 自动生成的方法存根
		
	}
}