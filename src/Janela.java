
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout; 

public class Janela extends JFrame {
    JLabel label = new JLabel("Olá, mundo!");
    JButton botao = new JButton("Clique aqui"); // Cria um botão
  
    public Janela() {
        super("Chat"); // Título da janela
        //setSize(300, 200); // Tamanho da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ação ao fechar a janela
         // Cria um rótulo de texto
         setLayout(new FlowLayout());
         JTextField campo = new JTextField(10); // Cria um campo de texto
        campo.setEditable(true);
        campo.setText("digite a mensagem aqui ");
        add(campo);
        add(botao); // Adiciona o botão à janela
        add(label); // Adiciona o rótulo à janela
        setVisible(true); // Torna a janela visível
    }
  
}
