package money;
import java.util.Scanner;
public class Test {
 static RecordGoodsOrder dsm =new RecordGoodsOrder();
 public static void main(String[] args) {
  Scanner scanner = new Scanner(System.in);
  int failCount = 0;
  String userName = "";
  String pwd = "";
  while(true){
   while(true){
    System.out.print("�������û�����");
    scanner = new Scanner(System.in);
    userName = scanner.nextLine();
    if(!"".equals(userName)){
     break;
    }
   }
   while(true){
    System.out.print("���������룺");
    scanner = new Scanner(System.in);
    pwd = scanner.nextLine();
    if(!"".equals(pwd)){
     break;
    }
   }
   if("boss".endsWith(userName) && "12345".endsWith(pwd)){
    System.out.println("��¼�ɹ���");
    dsm.main(args);
  break;
   }else{
    System.out.println("�û������������");
    failCount++;
   }
   if(failCount >= 3){
    System.out.println("���Ѿ�����3���������ϵͳ�˳���");
    break;
   }
  }
 }
}