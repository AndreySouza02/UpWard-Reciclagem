package telas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import arquivo.EscreverLerArquivos;
import classes.Cadastro;

public class TelaCadastrar extends JFrame {
	private JLabel jlLogin, jlSenha;
	private JTextField jtfLogin;
	private JPasswordField jpfSenha;
	private JButton jbCadastrar, jbCancelar;
	private List<Cadastro> cadastros;
	
	public TelaCadastrar(List<Cadastro> cadastros) {
		super();
		this.cadastros = cadastros;
		setTitle("Cadastro");
		setSize(250, 200);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.LIGHT_GRAY);
		iniciarCompontentes();
		criarEventos();	
	}

	private void iniciarCompontentes() {
		jlSenha = new JLabel("Senha: ");
		jlLogin = new JLabel("Login: ");
		jtfLogin = new JTextField();
		jpfSenha = new JPasswordField();
		jbCadastrar = new JButton("Cadastrar");
		jbCancelar = new JButton("Cancelar");
		
		add(jlSenha);
		add(jlLogin);
		add(jtfLogin);
		add(jpfSenha);
		add(jbCadastrar);
		add(jbCancelar);
		
		jtfLogin.setBounds(100, 30, 120, 25);
		jlLogin.setBounds(30, 30, 80, 25);
		jlSenha.setBounds(30, 75, 80, 25);
		jpfSenha.setBounds(100, 75, 120, 25);
		jbCadastrar.setBounds(20, 120, 100, 25);
		jbCancelar.setBounds(125, 120, 100, 25);
	}

	private void criarEventos() {
		jbCadastrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String login, senha;
				login = jtfLogin.getText();
				senha = String.valueOf(jpfSenha.getPassword());
				cadastros.add(new Cadastro(senha, login));
				EscreverLerArquivos arquivos = new EscreverLerArquivos();
				arquivos.escreverArquivosCadastro(cadastros);
			}
		});
		jbCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		
	}
	
	
	
	
}
