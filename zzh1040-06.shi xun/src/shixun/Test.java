package shixun;
import java.io.IOException;
import java.util.Scanner;
public class Test {
	public static void main(String[] args) throws Exception {
		
		Student student=new Student("嫖眉","槻","20170108","18");
		Teacher teacher=new Teacher("川析弗","溺","2001452","25");
		Scanner sc=new Scanner(System.in);
		
		System.out.println("                                                   "
		+ "                                                        散哭序秘僥伏砿尖狼由??\n");
		
		while(true){
		System.out.println();
		System.out.println("                                             "
	    + "                                                              僥伏砿尖狼由暇汽(麼順中)\n");
		System.out.println("                                      |！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！|");
		System.out.println("                                      |僉??       |          坪否                           |");
		System.out.println("                                      |！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！|");
		System.out.println("                                      |1、         |         廣過                             |");
		System.out.println("                                      |！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！|");
		System.out.println("                                      |2、         |         僥伏鞠村                     |");
		System.out.println("                                      |！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！|");
		System.out.println("                                      |3、         |         縮弗鞠村                     |");
		System.out.println("                                      |！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！|");
		System.out.println("                                      |4、         |         曜竃狼由                     |");
		System.out.println("                                      |！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！|");
		
		System.out.println("萩補秘僉夲??");
		String a=sc.next();
		System.out.println();
		//僉夲鞠村
		switch(a){
			case "1":
				System.out.println("艇議僉夲葎廣過??");
				System.out.println("(1、僥伏廣過      2、縮弗廣過)");
				int registered=sc.nextInt();
				ok:switch(registered){
					case 1:
						student.StudentRegistered();
						break ok;
					case 2:
						teacher.TeacherRegistered();
						break ok;
					default:
						System.out.println("僉夲補秘危列??");
				}
				System.out.println("孝浪艇??廣過撹孔??");
				break;
			case "2":
				System.out.println("艇議僉夲葎僥伏鞠村??");
				student.login();
				break;
			case "3":
				System.out.println("艇議僉夲葎縮弗鞠村??");
				teacher.login();
				break;
			case "4":
				System.out.println("艇議僉夲葎曜竃狼由??");
				exit();
				break;
			default:
				System.out.println("艇補秘議峺綜危列??");
				break;
		}
	}
}
	//協吶阻匯倖曜竃狼由圭隈
	private static void exit(){
			System.out.println("艇厮曜竃狼由??");
			System.exit(0);
		}
}
