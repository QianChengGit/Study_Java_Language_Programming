package gui1;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculators implements ActionListener{
private double data1=0.0,data2=0.0;
private String t_content;
boolean number=false;

//key������ʾ�û������µİ�ť���Ӽ��˳�
//keyΪ0��ʾ+��Ϊ1��ʾ-��Ϊ2��ʾ*��Ϊ3��ʾ/
short key=-1;

//pkey��ȡֵΪ-1~5
//pkeyΪ-1��ʾ��һ�ΰ���=��ť��Ϊ5˵�����ǵ�һ�ΰ���=��ť
//pkeyΪ����ֵ0,1,2,3ʱ�ֱ����+��-,*��/
short pkey=-1;


Frame frame=new Frame("Calculator");//�������ΪCalculator�Ĵ���
TextField textfield=new TextField(30);//��������

//����backspace,ce,c0��ť
Button backspace=new Button("Backspace");
Button ce=new Button("CE");
Button c0=new Button("C");



//������壬����backspace,ce,c0��ť�ͼ������textfeild�������p1��
//���ఴť�������p2��
Panel p1=new Panel();
Panel p2=new Panel();


//��������ϵİ�ť���飬����ȥbackspace,ce,c0��ť�����а�ť
String names[]={"7","8","9","/","sqrt","4","5","6","*","%","1","2","3","-","1/x","0","+/-",".","+","="};
Button bb[]=new Button[names.length];

public static void main(String[] args){
Calculators cal=new Calculators();
cal.go();
}


public void go(){
frame.setSize(300,200);
frame.setLayout(new BorderLayout());
Font fonts=new Font("����_GB2312",Font.PLAIN,12); // ��һҳ


//�������p1������Ͳ��ֹ������ͣ���textfeild������ӵ������
p1.setFont(fonts);
p1.setLayout(new GridLayout(2,1,5,10));
textfield.setFont(fonts);
p1.add(textfield,null);

//backspace,ce,c0��ťע��addActionListener����
backspace.addActionListener(this);
ce.addActionListener(this);
c0.addActionListener(this);


//��backspace,ce,c0��ť��ӵ�p1�����
p1.add(backspace,null);
p1.add(ce,null);
p1.add(c0,null);

//�������p2�Ĳ��ֹ���������ΪGridLayout
p2.setLayout(new GridLayout(4,5,5,5));


//Ϊ��ť���еİ�ťע��addActionListener����
for(int i=0;i<names.length;i++){
bb[i]=new Button(names[i]);
p2.add(bb[i]);
bb[i].addActionListener(this);
}


//�������p1�����p2�ڴ����е�λ��
//���p1�ڴ����North�������p2�ڴ����South����
frame.add(p1,BorderLayout.NORTH);
frame.add(p2,BorderLayout.SOUTH);
frame.setVisible(true);

//�������رհ�ťʱ�˳�ϵͳ
frame.addWindowListener(new WindowAdapter(){
public void windowClosing(WindowEvent e){
System.exit(0);
}
});
}
public void actionPerformed(ActionEvent ae){
String s; 
//ͨ��ActionEvent���getActionCommand()�������ó����������ĸ���ť�����ġ� //�ڶ�ҳ
s=ae.getActionCommand();

//�û�����һ�Σ����������ȥ��һ���ַ�
//�Ƚ�����������ַ���գ�����ӳ����һ���ַ����ַ���
if(s.equals("Backspace")&&number){
t_content=textfield.getText();
textfield.setText("");


for(int i=0;i<t_content.length()-1;i++){
char c=t_content.charAt(i);
textfield.setText(textfield.getText()+c);
}
}


//�û���������CE��ť�����������
if(s.equals("CE")){
textfield.setText("");
number=false;
}


//�û���������C��ť
if(s.equals("C")){
textfield.setText("");
data1=data2=0.0;
number=false;
}


//�û���������sqrt��ť�����и������ܱ�����
if(s.equals("sqrt")&&number){
t_content=textfield.getText();
if(t_content.charAt(0)=='-'){
textfield.setText("�������ܱ�����");
number=false;
}else{
textfield.setText(Double.toString(java.lang.Math.sqrt(Double.parseDouble(t_content))));
}
}



//�û���������1/x������ť������ʱ��ĸ����Ϊ0
if(s.equals("1/x") && number){
t_content=textfield.getText();
if(t_content.equals("0")){ //����ҳ 
textfield.setText("�㲻������");
number=false;
}else{
textfield.setText(Double.toString(1/Double.parseDouble(t_content)));
}
}


//�û���������%��ť
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

//�����Double ������100
if(g=true){
double dtemp=Double.parseDouble(textfield.getText());
dtemp=dtemp/100.0;
textfield.setText(Double.toString(dtemp));
}
//�����int�����ܱ�100��������ȥ��ĩβ����0
else{
if(Integer.parseInt(textfield.getText())%100==0){
int itemp=Integer.parseInt(textfield.getText());
itemp/=100;
textfield.setText(Integer.toString(itemp));
}

//�����int���������ܱ�100��������Double������
else{
double dtemp=Double.parseDouble(textfield.getText());
dtemp=dtemp/100.0;
textfield.setText(Double.toString(dtemp));
}
}
} //����ҳ

}

//���������ֵĴ���
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

//�����µİ�ťΪ+��ť
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
textfield.setText("��������Ϊ��");
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
//����ҳ

//�����µİ�ťΪ-��ť

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
textfield.setText("��������Ϊ��");
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

//�����µİ�ťΪ*��ť
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
if(textfield.getText().equals("0")){ // ����ҳ
textfield.setText("��������Ϊ��");
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

//�����µİ�ťΪ/��ť 
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
textfield.setText("��������Ϊ��");
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
} //����ҳ
//�����µİ�ťΪ=������ 
if(s.equals("=")&&number){

//������ǵ�һ�ΰ���=��ť
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
textfield.setText("��������Ϊ��");
number=false;
}else{

data2/=data1;
textfield.setText(Double.toString(data2));
break;
}
}
}

//����ǵ�һ�ΰ���=��ť
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
textfield.setText(Double.toString(data2)); //�ڰ�ҳ
break;
case 2:
key=-1;
data2*=Double.parseDouble(textfield.getText());
textfield.setText(Double.toString(data2)); 
break;
case 3:
if(textfield.getText().equals("0")){ 
textfield.setText("��������Ϊ��");
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

//���µİ�ťʱ���ְ�ť
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
//��.�Ĵ���
case'.':
t_content=textfield.getText();
boolean g=false; //�ھ�ҳ
//�Լ�������е����ݽ��м���
//���������С���㣬���û������ð�ťʱ�������С����
for(int i=0;i<t_content.length();i++){
if(t_content.charAt(i)=='.'){
g=true;
break;
}
}

//�������Ѿ���С����
if(g==true)
break;
//������û��С���㣬���û�����С����ʱ���С����
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
