package telas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class TelaLogin extends JFrame {
	private JTextField jtfLogin; 
	private JLabel jlSenha, jlLogin, jlImagem; 
	private JButton jbLogar, jbCancelar;
	private JPasswordField jpfSenha;
	private ImageIcon imagem;
	private static TelaLogin frame;

	public TelaLogin(){   
		
		inicializarComponentes(); 
		definirEventos(); 
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setIcon(this);
}

	private void setIcon(JFrame JFrame) {
		JFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagens/Login.png")));	
	}

	private void inicializarComponentes() {
		setTitle("UpWard Login"); // define titulo
		setSize(500, 300); 
		setLayout(null); 
		jtfLogin = new JTextField(5);
		jpfSenha = new JPasswordField(5);
		jlSenha = new JLabel("Senha: "); 
		jlLogin = new JLabel("Login: ");
		jbLogar = new JButton("LOGAR");
		jbCancelar = new JButton("CANCELAR");
		imagem = new ImageIcon(getClass().getResource("/imagens/Logo.png"));
		jlImagem = new JLabel(imagem);

		jtfLogin.setBounds(100, 60, 120, 25);
		jlLogin.setBounds(30, 60, 80, 25);
		jlSenha.setBounds(30, 105, 80, 25);
		jpfSenha.setBounds(100, 105, 120, 25);
		jbLogar.setBounds(20, 150, 100, 25);
		jbCancelar.setBounds(125, 150, 100, 25);
		jlImagem.setBounds(200, -20, 300, 300);

		add(jtfLogin); 
		add(jlSenha); 
		add(jlLogin);
		add(jbLogar);
		add(jbCancelar);
		add(jpfSenha);
		add(jlImagem);
		
	}

	private void definirEventos() {
		jbLogar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String senha = String.valueOf(jpfSenha.getPassword()); 
				if (jtfLogin.getText().equals("EliasNeves") && senha.equals("68722")) { 																					
					frame.setVisible(false);
					TelaUpWard tela2 = new TelaUpWard("UpWard Reciclagem");
					tela2.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Login ou senha incorretos");
				}
			}
		});
		
		jbCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
	}

//metodo principal  
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				frame = new TelaLogin();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				Dimension tela = Toolkit.getDefaultToolkit().getScreenSize(); 
				frame.setLocation((tela.width - (frame).getSize().width) / 2,
						(tela.height - frame.getSize().height) / 2); // centraliza janela coluna e a janela linha
				frame.setVisible(true);
			}
		});
	}

}