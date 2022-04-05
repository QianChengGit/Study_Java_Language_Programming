package gui1;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Calculator extends WindowAdapter implements MouseListener {

private String first;
private String second;
private String operator;
private Button zero = new Button("0");
private Button one = new Button("1");
private Button two = new Button("2");
private Button three = new Button("3");
private Button four = new Button("4");
private Button five = new Button("5");
private Button six = new Button("6");
private Button seven = new Button("7");
private Button eight = new Button("8");
private Button nine = new Button("9");

private Button decimal = new Button(".");
private Button equal = new Button("=");

private Button add = new Button("+");
private Button sub = new Button("-");
private Button mul = new Button("*");
private Button div = new Button("/");

private TextField input = null;

private Button CE = new Button("CE");
private Button DEL = new Button("Del");
private Button save = new Button("Save");
private Button clear = new Button("Clear");
private TextArea resultArea;
private Frame f;

public static void main(String[] args) {
new Calculator();
}

public Calculator(){
f = new Frame("Calculator");

input = new TextField();
f.add("North", input);

Panel keys = new Panel();

f.add(keys, BorderLayout.CENTER);
keys.setLayout(new GridLayout(4, 4));
keys.add(seven);
keys.add(eight);
keys.add(nine);
keys.add(add);

keys.add(four);
keys.add(five);
keys.add(six);
keys.add(sub);

keys.add(one);
keys.add(two);
keys.add(three);
keys.add(mul);

keys.add(zero);
keys.add(decimal);
keys.add(equal);
keys.add(div);

zero.addMouseListener(this);
one.addMouseListener(this);
two.addMouseListener(this);
three.addMouseListener(this);
four.addMouseListener(this);
five.addMouseListener(this);
six.addMouseListener(this);
seven.addMouseListener(this);
eight.addMouseListener(this);
nine.addMouseListener(this);

add.addMouseListener(this);
sub.addMouseListener(this);
div.addMouseListener(this);
mul.addMouseListener(this);
equal.addMouseListener(this);
decimal.addMouseListener(this);

Panel addtionalPanel = new Panel();
addtionalPanel.setLayout(new GridLayout(2, 2));
addtionalPanel.setSize(100, 50);
addtionalPanel.add(CE);
addtionalPanel.add(DEL);
addtionalPanel.add(save);
addtionalPanel.add(clear);

save.addMouseListener(this);
clear.addMouseListener(this);
CE.setBackground(Color.green);
DEL.setBackground(Color.cyan);
CE.addMouseListener(this);
DEL.addMouseListener(this);

resultArea = new TextArea();
resultArea.setColumns(10);
resultArea.setEditable(false);

f.add(resultArea, BorderLayout.EAST);

f.add(BorderLayout.SOUTH, addtionalPanel);
f.addWindowListener(this);
f.pack();
f.setVisible(true);
}

public void windowClosing(WindowEvent e) {
System.exit(0);
}
public void mouseClicked(MouseEvent e) {
Button btn = (Button) e.getSource();
String key = btn.getActionCommand().trim();

if(btn == one || btn == two || btn == three || btn == zero
|| btn == four || btn == five || btn == six
|| btn == seven || btn == eight || btn == nine){
if(isBlank(operator)){
if(isBlank(first)){
first = key;
}else{
first += key;
}

input.setText(first);
}else{
if(isBlank(second)){
second = key;
}else{
second += key;
}

input.setText(second);
}
}else if(btn == decimal){
if(isBlank(operator)){
if(isBlank(first)){
first = "0.";
input.setText(first);
}else{
if(first.indexOf(".") == -1){
first += ".";
input.setText(first);
}
}
}else{
if(isBlank(second)){
second = "0.";
input.setText(second);
}else{
if(second.indexOf(".") == -1){
second += ".";
input.setText(second);
}
}
}
}else if(btn == equal){
if(!isBlank(second) && !isBlank(first) && !isBlank(operator)){

double result = 0.0D;
if(operator.equals("+")){
result = Double.parseDouble(first) + Double.parseDouble(second);
}else if(operator.equals("-")){
result = Double.parseDouble(first) - Double.parseDouble(second);
}else if(operator.equals("*")){
result = Double.parseDouble(first) * Double.parseDouble(second);
}else if(operator.equals("/")){
result = Double.parseDouble(first) / Double.parseDouble(second);
}

int value = (int)Math.round(result);

if(value == result){
input.setText(String.valueOf(value));
}else{
input.setText(String.valueOf(result));
}

String lableText = first + operator + second + "=" + input.getText();
resultArea.setText(resultArea.getText() + "\r\n" + lableText);

first = String.valueOf(result);
second = null;
operator = null;
}
}else if(btn == add || btn == sub || btn == div || btn == mul){
if(!isBlank(first)){
if(!isBlank(operator) && !isBlank(second)){
if(operator.equals("+")){
first = String.valueOf(Double.parseDouble(first) + Double.parseDouble(second));
}else if(operator.equals("-")){
first = String.valueOf(Double.parseDouble(first) - Double.parseDouble(second));
}else if(operator.equals("*")){
first = String.valueOf(Double.parseDouble(first) * Double.parseDouble(second));
}else if(operator.equals("/")){
first = String.valueOf(Double.parseDouble(first) / Double.parseDouble(second));
}

second = null;
}

operator = key;
}
}else if(btn == CE){
first = null;
second = null;
operator = null;
input.setText(null);
}else if(btn == DEL){
if(isBlank(operator)){
if(!isBlank(first)){
first = first.substring(0, first.length() -1);
input.setText(first);
}
}else{
if(!isBlank(second)){
second = second.substring(0, second.length() -1);
input.setText(second);
}
}
}else if(btn == save){
FileDialog fd = new FileDialog(f, "Please choose the file to save:");
fd.setVisible(true);

String fileChosen = fd.getDirectory() + fd.getFile();

try {
File file = new File(fileChosen);;
BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));

bw.write(resultArea.getText());
bw.newLine();
bw.write("Last Update time: " + new Date().toLocaleString());

bw.close();
} catch (IOException e1) {
//Impossible for this Exception normally as the file is chosen
}

}else if(btn == clear){
resultArea.setText("");
}

}
private boolean isBlank(String str){
return str == null || str.trim().equals("");
}

public void mousePressed(MouseEvent e) {}
public void mouseReleased(MouseEvent e) {}
public void mouseEntered(MouseEvent e) {}
public void mouseExited(MouseEvent e) {}

}
