package ch11_2_3;
import java.net.InetAddress;
import java.net.UnknownHostException;
public class Example01 {
	public static void main(String[] args) throws Exception {
		//获取IP地址对象
		InetAddress localAddress = InetAddress.getLocalHost();
		InetAddress remoteAddress = InetAddress.getByName("www.baidu.cn");
		System.out.println("本机的IP地址："+localAddress.getHostAddress());
		System.out.println("itcast的IP地址："+remoteAddress.getHostAddress());
		System.out.println("3秒是否可达："+remoteAddress.isReachable(3000));
		System.out.println("itcast的主机名："+remoteAddress.getHostName());
		
	}
}
