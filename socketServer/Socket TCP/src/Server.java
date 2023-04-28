//Classe Server.java
import java.net.*;
import java.util.Scanner;
import java.util.*;
import java.io.*;
public class Server {
    static Vector<ClientHandler> ar = new Vector<>();
    static int i = 0;

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(1234);
        Socket s;

        while (true) {
            s = ss.accept();

            System.out.println("Novo cliente conectado : " + s);

            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());

            System.out.println("Criando uma nova thread para esse cliente...");

            ClientHandler mtch = new ClientHandler(s,"cliente " + i, dis, dos);

            Thread t = new Thread(mtch);

            System.out.println("Adicionando esse cliente à lista ativa...");

            ar.add(mtch);

            t.start();

            i++;

        }
    }
}
