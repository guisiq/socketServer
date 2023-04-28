import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.StringTokenizer;

class ClientHandler implements Runnable {
    Scanner scn = new Scanner(System.in);
    private String name;
    final DataInputStream dis;
    final DataOutputStream dos;
    Socket s;
    boolean isloggedin;

    public ClientHandler(Socket s, String name,
                         DataInputStream dis, DataOutputStream dos) {
        this.dis = dis;
        this.dos = dos;
        this.name = name;
        this.s = s;
        this.isloggedin=true;
    }

    @Override
    public void run() {

        String received;
        while (true)
        {
            try
            {
                received = dis.readUTF();

                System.out.println(received);

                if(received.equals("logout")){
                    for (ClientHandler mc : Server.ar)
                    {
                        mc.dos.writeUTF(this.name+" : logout ");
                    }
                    this.isloggedin=false;
                    this.s.close();
                    break;
                }

                StringTokenizer st = new StringTokenizer(received, "#");
                String MsgToSend = st.nextToken();
                String recipient = st.nextToken();
                if (recipient.equals("I")) {
                    this.name = MsgToSend;
                    for (ClientHandler mc : Server.ar)
                    {
                        mc.dos.writeUTF("Cliente:"+this.name);
                    }
                    
                }else if(recipient.equals("ALL")){
                    for (ClientHandler mc : Server.ar)
                    {
                        mc.dos.writeUTF(this.name+" : "+MsgToSend);
                    }
                }else if(recipient.equals("LIST")){
                    for (ClientHandler mc : Server.ar)
                    {
                        if (mc.name.equals(recipient) && mc.isloggedin==true)
                        {
                            mc.dos.writeUTF("clientes :");
                            for (ClientHandler mc2 : Server.ar)
                            {
                                mc.dos.writeUTF("\t"+mc2.name);
                            }
                            break;
                        }
                    }
                }else {
                    for (ClientHandler mc : Server.ar)
                    {
                        if (mc.name.equals(recipient) && mc.isloggedin==true)
                        {
                            mc.dos.writeUTF(this.name+" : "+MsgToSend);
                            break;
                        }
                    }
                }
            } catch (IOException e) {

                e.printStackTrace();
            }

        }
        try
        {
            
            this.dis.close();
            this.dos.close();

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

