//Classe Client.java
import java.net.*;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.*;

public class Cliente {

	public static void main(String args[]) throws UnknownHostException, IOException 
	{
		Scanner scn = new Scanner(System.in);
		
		InetAddress ip = InetAddress.getByName("localhost");
		
		Socket s = new Socket(ip, 1234);
	
		DataInputStream dis = new DataInputStream(s.getInputStream());
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());

		Thread sendMessageThread= new Thread(new Runnable(){
			@Override
			public void run() {
				var janela = new Janela();
				var destinatario = "";
				while (true) {

					String msg= scn.nextLine();
					
					if (msg.contains("#")) {
						StringTokenizer st = new StringTokenizer(msg, "#");
						msg = st.nextToken();
						destinatario = st.nextToken();
						if(destinatario.equals("I")){
							msg.toLowerCase().trim();
						}else{
							destinatario.toLowerCase().trim();
						}
					}
					
					try {
						
						if (msg.toLowerCase().trim().equals("logout")) {
							dos.writeUTF(msg);
							scn.close();
							s.close();
							System.exit(1);
						}else{
							dos.writeUTF(msg+"#"+destinatario);
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
			
		
		Thread readMessageThread= new Thread(new Runnable() {
			 @Override
			public void run() {

				while (true) {
					try {							
						String msg=dis.readUTF();
						System.out.println(msg);
					} catch (IOException e) {

						e.printStackTrace();
					}
				}
			}
		 });

		
		 sendMessageThread.start();		 
		 readMessageThread.start();

	  }
}

