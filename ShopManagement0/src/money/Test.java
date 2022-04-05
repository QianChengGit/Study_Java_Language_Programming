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
    System.out.print("请输入用户名：");
    scanner = new Scanner(System.in);
    userName = scanner.nextLine();
    if(!"".equals(userName)){
     break;
    }
   }
   while(true){
    System.out.print("请输入密码：");
    scanner = new Scanner(System.in);
    pwd = scanner.nextLine();
    if(!"".equals(pwd)){
     break;
    }
   }
   if("boss".endsWith(userName) && "12345".endsWith(pwd)){
    System.out.println("登录成功！");
    dsm.main(args);
  break;
   }else{
    System.out.println("用户名或密码错误！");
    failCount++;
   }
   if(failCount >= 3){
    System.out.println("您已经连续3次输入错误。系统退出。");
    break;
   }
  }
 }
}