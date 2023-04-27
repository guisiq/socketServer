import org.glassfish.tyrus.server.Server;

public class Server {

    public static void main(String[] args) {
        // Cria um objeto server
        Server server = new Server("localhost", 8080, "/ws", ServerEndpoint.class);

        try {
            // Inicia o servidor
            server.start();
            System.out.println("Servidor WebSocket ouvindo na porta 8080");
            // Aguarda o usuário digitar algo para parar
            System.in.read();
        } catch (Exception e) {
            System.out.println("Ocorreu um erro: " + e.getMessage());
        } finally {
            // Para o servidor
            server.stop();
        }
    }
}