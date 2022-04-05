package studentManagement_Tool;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class Media extends Object implements Runnable{
	String name="Richard Clayderman - ���еĻ���.wav";//��������ѡ������Ҫ���ŵ�����
    File f = new File("lib\\"+name); //�������ļ���·����ע��һ��Ҫ��WAV��ʽ�����ֲ�Ȼ�����Բ���
    URL url; 
    URI uri;
    AudioClip clip; 
   void setMusic(String name)//�޸Ĳ��ŵ������ļ�
   {
       this.name=name;
   }
  public Media(){     
    try
    {  
       uri=f.toURI();
       url = uri.toURL();
       clip = Applet.newAudioClip(url); 
       clip.loop();//ѭ������
       //clip.play();//����
       //clip.stop();//ֹͣ����
       System.out.println("�����ļ��Ѿ���");
   }
    catch (MalformedURLException e) { 
           e.printStackTrace(); 
           System.out.println("���Ŵ���");
       }
   }
  public void stopMusic()//ֹͣ����
  {
      clip.stop();
  }
  public void playMusic()//����
  {
      clip.play();
  }
  public void loopMusic()//ѭ������
  {
      clip.loop();
  }
	
	@Override
	public void run() {
		// TODO �Զ����ɵķ������
		try {
			Thread.sleep(20);
			loopMusic();
		} catch (InterruptedException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Media media = new Media();
	}
}
