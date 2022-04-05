package ch11_3;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1 {
	public static void main(String[] args) throws Exception {
		new TCPServer1().listen();
	}

}
class TCPServer1{
	private static final int PORT = 7788;
	public void listen() throws Exception{
		//
		ServerSocket serverSocket = new ServerSocket(PORT);
		while(true){
			final Socket client = serverSocket.accept();
			new Thread(){
				public void run(){
					OutputStream os;
					try{
						os = client.getOutputStream();
						System.out.println("开始与客户端交互数据");
						os.write("传智播客欢迎您！".getBytes());
						Thread.sleep(5000);
						System.out.println("结束与客户端交互数据");
						while(true){
							InputStream is = client.getInputStream();
							byte [] buf = new byte[1024];
							int len = is.read(buf);
							String st = new String(buf,0,len+1);
							if(st.equals("退出")){
								is.close();
								break;
							}else{
								System.out.println("接收的信息：");
								System.out.println(st);
							}
						}
						os.close();
						client.close();
					}catch(Exception e){
						e.printStackTrace();
					}
				};
			}.start();
		}
	}
}