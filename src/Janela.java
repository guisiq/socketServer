
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent; 

public class Janela extends JFrame {
    JTextArea   chat            = new JTextArea("");
    JButton     btEnviar        = new JButton("enviar"); // Cria um botão
    JButton     btRemetente     = new JButton("trocar Remetente"); // Cria um botão
    JButton     btLimpar        = new JButton("limpar"); // Cria um botão
    JTextField  campoChat       = new JTextField(10);
    JTextField  campoRemetente  = new JTextField(10);
    String      mensagem        = "";
    

    public Janela() {
        super("Chat"); // Título da janela
        setSize(1200, 3000); // Tamanho da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ação ao fechar a janela
         // Cria um rótulo de texto
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints(); // Cria um objeto GridBagConstraints
        gbc.gridx = 0; // Define a coluna inicial do componente
        gbc.gridy = 0; // Define a linha inicial do componente
        gbc.weightx =  3; // Define o número de colunas que o componente ocupa
        gbc.weighty =   0.1; // Define o número de linhas que o componente ocupa
        gbc.fill = GridBagConstraints.BOTH;
        add(campoRemetente,gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 0; 
        gbc.gridy = 1; 
        gbc.weightx =   3; 
        gbc.weighty =  8;
        gbc.fill = GridBagConstraints.BOTH;
        chat.setLineWrap(true);
        chat.setSize(3, 8);
        add(chat,gbc);
        
        campoChat.setEditable(true);
        campoChat.setText(".....");
        gbc = new GridBagConstraints();
        gbc.gridx = 0; 
        gbc.gridy = 10; 
        gbc.weightx =  3;
        gbc.weighty =   0.15;
        gbc.fill = GridBagConstraints.BOTH;
        add(campoChat,gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 3; 
        gbc.gridy = 10; 
        gbc.weightx =  2; 
        gbc.weighty =  1; 
        gbc.fill = GridBagConstraints.BOTH;
        add(btEnviar,gbc); 
        setVisible(true); 

      
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
