package gui1;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculators implements ActionListener{
private double data1=0.0,data2=0.0;
private String t_content;
boolean number=false;

//key用来标示用户所按下的按钮即加减乘除
//key为0标示+，为1表示-，为2表示*，为3表示/
short key=-1;

//pkey的取值为-1~5
//pkey为-1表示第一次按下=按钮，为5说明不是第一次按下=按钮
//pkey为其他值0,1,2,3时分别代表+，-,*，/
short pkey=-1;


Frame frame=new Frame("Calculator");//定义标题为Calculator的窗体
TextField textfield=new TextField(30);//定义计算机

//定义backspace,ce,c0按钮
Button backspace=new Button("Backspace");
Button ce=new Button("CE");
Button c0=new Button("C");



//定义面板，其中backspace,ce,c0按钮和计算机兰textfeild放在面板p1中
//其余按钮放在面板p2中
Panel p1=new Panel();
Panel p2=new Panel();


//定义界面上的按钮数组，即除去backspace,ce,c0按钮的所有按钮
String names[]={"7","8","9","/","sqrt","4","5","6","*","%","1","2","3","-","1/x","0","+/-",".","+","="};
Button bb[]=new Button[names.length];

public static void main(String[] args){
Calculators cal=new Calculators();
cal.go();
}


public void go(){
frame.setSize(300,200);
frame.setLayout(new BorderLayout());
Font fonts=new Font("楷体_GB2312",Font.PLAIN,12); // 第一页


//设置面板p1的字体和布局管理类型，将textfeild对象添加到面板中
p1.setFont(fonts);
p1.setLayout(new GridLayout(2,1,5,10));
textfield.setFont(fonts);
p1.add(textfield,null);

//backspace,ce,c0按钮注册addActionListener方法
backspace.addActionListener(this);
ce.addActionListener(this);
c0.addActionListener(this);


//将backspace,ce,c0按钮添加到p1面板中
p1.add(backspace,null);
p1.add(ce,null);
p1.add(c0,null);

//设置面板p2的布局管理器类型为GridLayout
p2.setLayout(new GridLayout(4,5,5,5));


//为按钮组中的按钮注册addActionListener方法
for(int i=0;i<names.length;i++){
bb[i]=new Button(names[i]);
p2.add(bb[i]);
bb[i].addActionListener(this);
}


//设置面板p1和面板p2在窗体中的位置
//面板p1在窗体的North方向，面板p2在窗体的South方向
frame.add(p1,BorderLayout.NORTH);
frame.add(p2,BorderLayout.SOUTH);
frame.setVisible(true);

//当单击关闭按钮时退出系统
frame.addWindowListener(new WindowAdapter(){
public void windowClosing(WindowEvent e){
System.exit(0);
}
});
}
public void actionPerformed(ActionEvent ae){
String s; 
//通过ActionEvent类的getActionCommand()方法，得出动作是由哪个按钮触发的。 //第二页
s=ae.getActionCommand();

//用户单击一次，计算栏里便去掉一个字符
//先将计算栏里的字符清空，再添加除最好一个字符的字符串
if(s.equals("Backspace")&&number){
t_content=textfield.getText();
textfield.setText("");


for(int i=0;i<t_content.length()-1;i++){
char c=t_content.charAt(i);
textfield.setText(textfield.getText()+c);
}
}


//用户单击的是CE按钮，计算栏清空
if(s.equals("CE")){
textfield.setText("");
number=false;
}


//用户单击的是C按钮
if(s.equals("C")){
textfield.setText("");
data1=data2=0.0;
number=false;
}


//用户单击的是sqrt按钮，其中负数不能被开方
if(s.equals("sqrt")&&number){
t_content=textfield.getText();
if(t_content.charAt(0)=='-'){
textfield.setText("负数不能被开方");
number=false;
}else{
textfield.setText(Double.toString(java.lang.Math.sqrt(Double.parseDouble(t_content))));
}
}



//用户单击的是1/x求倒数按钮，求倒数时分母不能为0
if(s.equals("1/x") && number){
t_content=textfield.getText();
if(t_content.equals("0")){ //第三页 
textfield.setText("零不能求倒数");
number=false;
}else{
textfield.setText(Double.toString(1/Double.parseDouble(t_content)));
}
}


//用户单击的是%按钮
if(s.equals("%")&&number){
if(data2==0){
t_content=textfield.getText();
textfield.setText(t_content);
}else{
boolean g=false;
for(int i=0;i<textfield.getText().length();i++)
if('.'==textfield.getText().charAt(i)){
g=true;
break;
}

//如果是Double 数，除100
if(g=true){
double dtemp=Double.parseDouble(textfield.getText());
dtemp=dtemp/100.0;
textfield.setText(Double.toString(dtemp));
}
//如果是int数但能被100整除，则去掉末尾两个0
else{
if(Integer.parseInt(textfield.getText())%100==0){
int itemp=Integer.parseInt(textfield.getText());
itemp/=100;
textfield.setText(Integer.toString(itemp));
}

//如果是int数，但不能被100整除，则按Double数处理
else{
double dtemp=Double.parseDouble(textfield.getText());
dtemp=dtemp/100.0;
textfield.setText(Double.toString(dtemp));
}
}
} //第四页

}

//对正负数字的处理
if(s.equals("+/-")){
t_content=textfield.getText();
if(t_content.charAt(0)=='-'){
textfield.setText("");
String content;
for(int i=1;i<t_content.length();i++){
textfield.setText(textfield.getText()+t_content.charAt(i));
}
}else{
textfield.setText("-"+t_content);
}
}

//所按下的按钮为+按钮
if(s.equals("+")){
switch(pkey){
case 0:
data2+=Double.parseDouble(textfield.getText());
break;
case 1:
data2+=Double.parseDouble(textfield.getText());
break;
case 2:
data2+=Double.parseDouble(textfield.getText());
break;
case 3:
if(textfield.getText().equals("0")){
textfield.setText("除数不能为零");
number=false;
}else{
key=-1;
data2/=data1;
textfield.setText(Double.toString(data2));
break;
}
default:
data2=Double.parseDouble(textfield.getText());
}
pkey=key=0;
textfield.setText("");
} 
//第五页

//所按下的按钮为-按钮

if(s.equals("-")){
switch(pkey){
case 0:
data2+=Double.parseDouble(textfield.getText());
break;
case 1:
data2+=Double.parseDouble(textfield.getText());
break;
case 2:
data2+=Double.parseDouble(textfield.getText());
break;

case 3:
if(textfield.getText().equals("0")){
textfield.setText("除数不能为零");
number=false;
}else{
key=-1;
data2/=data1;
textfield.setText(Double.toString(data2));
break;
}
default:
data2=Double.parseDouble(textfield.getText());
}
pkey=key=1;
textfield.setText("");
} 

//所按下的按钮为*按钮
if(s.equals("*")){
switch(pkey){
case 0:
data2+=Double.parseDouble(textfield.getText());
break;
case 1:
data2+=Double.parseDouble(textfield.getText());
break;
case 2:
data2+=Double.parseDouble(textfield.getText());
break;

case 3:
if(textfield.getText().equals("0")){ // 第六页
textfield.setText("除数不能为零");
number=false;
}else{
key=-1;
data2/=data1;
textfield.setText(Double.toString(data2));
break;
}
default:
data2=Double.parseDouble(textfield.getText());
}
pkey=key=2;
textfield.setText("");
} 

//所按下的按钮为/按钮 
if(s.equals("/")){
switch(pkey){
case 0:
data2+=Double.parseDouble(textfield.getText());
break;
case 1:
data2+=Double.parseDouble(textfield.getText());
break;
case 2:
data2+=Double.parseDouble(textfield.getText());
break;

case 3:
if(textfield.getText().equals("0")){ 
textfield.setText("除数不能为零");
number=false;
}else{
key=-1;
data2/=data1;
textfield.setText(Double.toString(data2));
break;
}
default:
data2=Double.parseDouble(textfield.getText());
}
pkey=key=3;
textfield.setText("");
} //第七页
//所按下的按钮为=，求结果 
if(s.equals("=")&&number){

//如果不是第一次按下=按钮
if(pkey==5){
switch(pkey){
case 0:
data2+=data1;
textfield.setText(Double.toString(data2));
break;
case 1:
data2-=data1;
textfield.setText(Double.toString(data2));
break;
case 2:
data2*=data1;
textfield.setText(Double.toString(data2));
break;
case 3:
if(textfield.getText().equals("0")){ 
textfield.setText("除数不能为零");
number=false;
}else{

data2/=data1;
textfield.setText(Double.toString(data2));
break;
}
}
}

//如果是第一次按下=按钮
else{
data1=Double.parseDouble(textfield.getText());
switch(key){
case 0:
key=-1;
data2+=Double.parseDouble(textfield.getText());
textfield.setText(Double.toString(data2));
break;

case 1:
key=-1;
data2-=Double.parseDouble(textfield.getText());
textfield.setText(Double.toString(data2)); //第八页
break;
case 2:
key=-1;
data2*=Double.parseDouble(textfield.getText());
textfield.setText(Double.toString(data2)); 
break;
case 3:
if(textfield.getText().equals("0")){ 
textfield.setText("除数不能为零");
number=false;
}else{
key=-1;
data2/=Double.parseDouble(textfield.getText());
textfield.setText(Double.toString(data2));
break;
}
}
}
pkey=5;
}

//按下的按钮时数字按钮
else{
switch(s.charAt(0)){
case'0':
case'1':
case'2':
case'3':
case'4':
case'5':
case'6':
case'7':
case'8':
case'9':
number=true;
textfield.setText(textfield.getText()+s);
break;
//对.的处理
case'.':
t_content=textfield.getText();
boolean g=false; //第九页
//对计算机栏中的数据进行检验
//如果其中有小数点，则用户单击该按钮时不在添加小数点
for(int i=0;i<t_content.length();i++){
if(t_content.charAt(i)=='.'){
g=true;
break;
}
}

//数据中已经有小数点
if(g==true)
break;
//数据中没有小数点，当用户单击小数点时添加小数点
if(g==false)
textfield.setText(t_content+".");
}
}
}


private String Integer(String string) {
//TODO Auto-generated method stub
return null;
}
}
