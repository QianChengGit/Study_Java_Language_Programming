package task1;
import java.util.ArrayList;
import java.util.Scanner;
public class KTVByArrayList {
	public static void main(String[] args) {
		System.out.println("------欢迎来到点歌系统------");
		System.out.println("0.添加歌曲至列表");
		System.out.println("1.将歌曲置顶");
		System.out.println("2.将歌曲前移一位");
		System.out.println("3.查看歌单");
		System.out.println("4.退出");
		ArrayList lineUpList = new ArrayList();
		addMusicList(lineUpList);
		while(true){
			System.out.println("请输入要执行的操作序号：");
			Scanner scan = new Scanner(System.in);
			int command = scan.nextInt();
			//执行序号对应的功能
			switch(command){
			case 0:
				addMusic(lineUpList);
				break;
			case 1:
				setTop(lineUpList);
				break;
			case 2:
				setBefore(lineUpList);
				break;
			case 3:
				System.out.println(lineUpList);
				break;
			case 4:
				exit();
				break;
			default:
				System.out.println("-------------------------");
				System.out.println("功能选择有误，请输入正确的功能序号！");
				break;
			}
		}
	}
	
	//初始时添加歌曲名称
	private static void addMusicList(ArrayList lineUpList){
		lineUpList.add("稻香");
		lineUpList.add("夜曲");
		lineUpList.add("夜的第七章");
		lineUpList.add("听妈妈的话");
		lineUpList.add("龙卷风");
		System.out.println("初始歌曲列表："+lineUpList);
	}
	
	//执行添加歌曲
	private static void addMusic(ArrayList lineUpList) {
		System.out.println("请输入要添加的歌曲名称：");
		String musicName = new Scanner(System.in).nextLine();
		lineUpList.add(musicName);
		System.out.println("已添加歌曲："+musicName);
		System.out.println("添加歌曲后的歌曲列表："+lineUpList);
	}
	
	//执行将歌曲置顶
	private static void setTop(ArrayList lineUpList){
		System.out.println("请输入要置顶的歌曲名称：");
		String musicName = new Scanner(System.in).nextLine();
		int position = lineUpList.indexOf(musicName);
		if(position < 0){
			System.out.println("当前列表中没有输入的歌曲！");
		} else{
			lineUpList.remove(musicName);
			lineUpList.add(0,musicName);
		}
		System.out.println("已将歌曲"+ musicName +"置顶");
		System.out.println("置顶后的歌曲列表："+lineUpList);
	}
	
	//执行将歌曲置前一位
	private static void setBefore(ArrayList lineUpList){
		System.out.println("请输入要置前的歌曲名称：");
		String musicName = new Scanner(System.in).nextLine();
		int position = lineUpList.indexOf(musicName);
		if(position < 0){
			System.out.println("当前列表中没有输入的歌曲！");
		} else if(position == 0){
			System.out.println("当前歌曲已在最顶部！");
		} else{
			lineUpList.remove(musicName);
			lineUpList.add(position-1,musicName);
		}
		System.out.println("已将歌曲"+ musicName +"置前一位");
		System.out.println("置前一位后歌曲列表："+lineUpList);
	}
	
	//退出
	private static void exit(){
		System.out.println("-----------退出--------");
		System.out.println("您已退出系统！");
		System.exit(0);
	}
}
