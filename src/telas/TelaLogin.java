package telas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import arquivo.EscreverLerArquivos;
import classes.Cadastro;

public class TelaLogin extends JFrame {
	private JTextField jtfLoguin;
	private JLabel jlSenha, jlLoguin;
	private JButton jbLogar, jbCancelar, jbCadastrar;
	private JPasswordField jpfSenha;
	private List<Cadastro> cadastros = new ArrayList<>();
	private static TelaLogin frame; 
	
	public TelaLogin() {
		super();
		iniciarComponentes(); // metodos q serao utilizados para def carac visuais e os eventos neles.
		criarEventos();
		abrirArquivo();
	}

	private void abrirArquivo() {
		EscreverLerArquivos arquivos = new EscreverLerArquivos();
		if (arquivos.lerArquivosCadastrados() != null) {
			cadastros = arquivos.lerArquivosCadastrados();
		}
		
	}

	private void iniciarComponentes() {
		setTitle("Login"); // define titulo
		setSize(250, 230); // define dimençoes do frame (comprimento e largura )
		setLayout(null); // define como nulo o gerenciador de layout com o metodo setLayout
		jtfLoguin = new JTextField(5); // criação de objetos e o num define o comprim das caixas de texto
		jpfSenha = new JPasswordField(5);// determina o numero de caracter que deverá ter a senha
		jlSenha = new JLabel("Senha: "); // cria objetos de labels e botoes c/ seus titulos
		jlLoguin = new JLabel("Login: ");
		jbLogar = new JButton("Logar");
		jbCancelar = new JButton("Cancelar");
		jbCadastrar = new JButton("Cadastrar");
		jbCadastrar.setForeground(Color.blue);

		add(jtfLoguin); // os componentes graficos são adicionados ao frame como um quebra cabeças
		add(jlSenha); // estes são adicionados ao que foi definido anteriormente
		add(jlLoguin);
		add(jbLogar);
		add(jbCancelar);
		add(jbCadastrar);
		add(jpfSenha);

		jtfLoguin.setBounds(100, 30, 120, 25);
		jlLoguin.setBounds(30, 30, 80, 25);
		jlSenha.setBounds(30, 75, 80, 25);
		jpfSenha.setBounds(100, 75, 120, 25);
		jbLogar.setBounds(20, 120, 100, 25);
		jbCancelar.setBounds(125, 120, 100, 25);
		jbCadastrar.setBounds(70, 150, 100, 25);
		
	}

	private void criarEventos() {
		jbLogar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String senha = String.valueOf(jpfSenha.getPassword()); // o método getPassword retorna uma matriz de caracter eo o metodo valueOf convert em uma String
				boolean achou = false;
				for (Cadastro cadastro : cadastros) {
					if (jtfLoguin.getText().equals(cadastro.getLogin()) && senha.equals(cadastro.getSenha())) { // testa se a senha esta correta e o loguin
						 frame.setVisible(false); 
						TelaUpWard transportadora = new TelaUpWard("UpWard Reciclagem"); // Este método cria a tela(frame)do menu principal
						transportadora.setVisible(true);
						achou = true;
						break;
					} 
				}
				if (!achou) {
					JOptionPane.showMessageDialog(null, "Loguin ou senha incorretos");
				}
			}
		
		});

		jbCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0); // sai do programa

			}
		});
		
		jbCadastrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				TelaCadastrar cadastrar = new TelaCadastrar(cadastros);
				cadastrar.setVisible(true);
				
			}
		});
	}

	// metodo principal

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // encerra aplicação qd a janela é fechada
				Dimension tela = Toolkit.getDefaultToolkit().getScreenSize(); // metodos que manipulam dimensão da tela
																				// do ambiente gráfico
				frame.setLocation((tela.width - (frame).getSize().width) / 2,
						(tela.height - frame.getSize().height) / 2); // centraliza janela coluna e a janela linha
				frame.setVisible(true);
			}

		});
	}
}
