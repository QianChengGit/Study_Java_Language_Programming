package ch11_2_3;
import java.net.InetAddress;
import java.net.UnknownHostException;
public class Example01 {
	public static void main(String[] args) throws Exception {
		//��ȡIP��ַ����
		InetAddress localAddress = InetAddress.getLocalHost();
		InetAddress remoteAddress = InetAddress.getByName("www.baidu.cn");
		System.out.println("������IP��ַ��"+localAddress.getHostAddress());
		System.out.println("itcast��IP��ַ��"+remoteAddress.getHostAddress());
		System.out.println("3���Ƿ�ɴ"+remoteAddress.isReachable(3000));
		System.out.println("itcast����������"+remoteAddress.getHostName());
		
	}
}
