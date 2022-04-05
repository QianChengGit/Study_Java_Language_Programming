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
						System.out.println("��ʼ��ͻ��˽�������");
						os.write("���ǲ��ͻ�ӭ����".getBytes());
						Thread.sleep(5000);
						System.out.println("������ͻ��˽�������");
						while(true){
							InputStream is = client.getInputStream();
							byte [] buf = new byte[1024];
							int len = is.read(buf);
							String st = new String(buf,0,len+1);
							if(st.equals("�˳�")){
								is.close();
								break;
							}else{
								System.out.println("���յ���Ϣ��");
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