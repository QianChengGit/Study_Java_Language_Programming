package task11_2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServer {

	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(10001);
		while(true){
			Socket s = serverSocket.accept();
			new Thread(new ServerThread(s)).start();
		}
	}

}
class ServerThread implements Runnable{
	
	private Socket socket;
	public ServerThread(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		String ip = socket.getInetAddress().getHostAddress();
		int count = 1;
		try{
			InputStream in = socket.getInputStream();
			File parentFile = new File("F:\\upload\\");
			if(parentFile.exists()){
				parentFile.mkdir();
			}
			File file = new File(parentFile,ip+"("+count+").jpg");
			while(file.exists()){
				file = new File(parentFile,ip+"("+(count++)+").jpg");
			}
			FileOutputStream fos = new FileOutputStream(file);
			byte[] buf = new byte[1024];
			int len = 0;
			while((len = in.read(buf)) != -1){
				fos.write(buf, 0, len);
			}
			OutputStream out = socket.getOutputStream();
			out.write("�ϴ��ɹ���".getBytes());
			fos.close();
			socket.close();
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
}