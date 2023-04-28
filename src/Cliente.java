//Classe Client.java
import java.net.*;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.*;

public class Cliente {

	public static void main(String args[]) throws UnknownHostException, IOException 
	{
		
		var janela = new Janela();
		Scanner scn = new Scanner(System.in);
		
		InetAddress ip = InetAddress.getByName("localhost");
		
		Socket s = new Socket(ip, 1234);
	
		DataInputStream dis = new DataInputStream(s.getInputStream());
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());

		Thread sendMessageThread= new Thread(new Runnable(){
			@Override
			public void run() {
				
				var destinatario = "";
				while (true) {

					String msg = janela.campoRemetente.getText() + "#" +  janela.mensagem;
					if (!janela.mensagem.equals("")) {

							msg = janela.mensagem;
							janela.mensagem ="";
							destinatario = janela.campoRemetente.getText();
							if (destinatario.equals("I")) {
								msg.toLowerCase().trim();
							} else {
								destinatario.toLowerCase().trim();
							}
						

						try {

							if (msg.toLowerCase().trim().equals("logout")) {
								dos.writeUTF(msg);
								scn.close();
								s.close();
								System.exit(1);
							} else {
								dos.writeUTF(msg + "#" + destinatario);
							}
						} catch (IOException e) {
							e.printStackTrace();
						}

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
						janela.escreverMensagens(msg);
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

