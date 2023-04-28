
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 

public class Janela extends JFrame {
    JLabel      chat            = new JLabel("");
    JButton     btEnviar        = new JButton("enviar"); // Cria um botão
    JButton     btRemetente     = new JButton("trocar Remetente"); // Cria um botão
    JButton     btLimpar        = new JButton("limpar"); // Cria um botão
    JTextField  campoChat       = new JTextField(10);
    JTextField  campoRemetente  = new JTextField(10);
    String      mensagem        = "";
    

    public Janela() {
        super("Chat"); // Título da janela
        //setSize(300, 200); // Tamanho da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ação ao fechar a janela
         // Cria um rótulo de texto
        setLayout(new GridLayout(3, 2));
        campoChat.setEditable(true);
        campoChat.setText(".....");
        add(campoRemetente);
        add(btRemetente); 
        add(chat);
        add(btLimpar); 
        add(campoChat); 
        add(btEnviar); 
        setVisible(true); // Torna a janela visível

        btEnviar.addActionListener(new ActionListener() { // Adiciona um ActionListener ao botão
            public void actionPerformed(ActionEvent e) { // Define o método actionPerformed
                mensagem  = campoChat.getText();
                campoChat.setText("");
            }
          });
    }
    public void  escreverMensagens(String texto){
        this.chat.setText(this.chat.getText() + texto);
    }

  
}
