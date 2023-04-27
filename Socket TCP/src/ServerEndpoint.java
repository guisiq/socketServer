import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/chat")
public class ServerEndpoint {

    @OnOpen
    public void onOpen(Session session) {
        System.out.println("Conectado ao cliente: " + session.getId());
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("Recebido do cliente " + session.getId() + ": " + message);
        // Envia a resposta ao cliente
        session.getBasicRemote().sendText("Olá, cliente!");
    }

    @OnClose
    public void onClose(Session session) {
        System.out.println("Conexão encerrada com o cliente: " + session.getId());
    }

    @OnError
    public void onError(Throwable error) {
        System.out.println("Ocorreu um erro: " + error.getMessage());
    }
}