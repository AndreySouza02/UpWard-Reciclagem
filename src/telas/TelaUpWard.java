package telas;

import java.awt.Color;
import java.awt.Container;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import paineis.PainelDiscarte;
import paineis.PainelDivisao;
import paineis.PainelEmpresas;
import paineis.PainelEstabelecimento;
import paineis.PainelPessoas;
import paineis.PainelPropria;
import paineis.PainelServico;

public class TelaUpWard extends JFrame{
	private JMenuBar jmbBarraMenu;
	private JMenu jmArquivo, jmCadastro, jmColeta, jmExibir;
	private JMenuItem jmiSair, jmiPessoas, jmiEmpresas, jmiEstabelecimentos,
	jmiPropria, jmiDivisao, jmiServico, jmiDiscarte, jmiMostrarClientes, jmiMostrarColetas;
	private JLabel jlImagem;
	private ImageIcon imagem;
	private Container contentPane;
	
	public TelaUpWard(String title) throws HeadlessException {
		super(title);
		setSize(400,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.green.darker());
		iniciarComponentes();
		criarEventos();
	}

	private void iniciarComponentes() {
		contentPane = getContentPane();
		jmbBarraMenu = new JMenuBar();
		setJMenuBar(jmbBarraMenu);
		//menus
		jmArquivo = new JMenu("Arquivo");
		jmArquivo.setMnemonic('A');
		jmCadastro = new JMenu("Cadastro");
		jmCadastro.setMnemonic('C');
		jmColeta = new JMenu("Coleta");
		jmColeta.setMnemonic('E');
		jmExibir = new JMenu("Exibir");
		jmExibir.setMnemonic('X');
		
		//itens
		jmiSair = new JMenuItem("Sair");
		jmiEmpresas = new JMenuItem("Empresas");
		jmiEstabelecimentos = new JMenuItem("Estabelecimentos");
		jmiPessoas = new JMenuItem("Pessoas");
		jmiDiscarte = new JMenuItem("Discarte");
		jmiDivisao = new JMenuItem("Divisão de ganhos");
		jmiPropria = new JMenuItem("Própria");
		jmiServico = new JMenuItem("À serviço");
		jmiMostrarClientes = new JMenuItem("Mostrar Clientes");
		jmiMostrarColetas = new JMenuItem("Mostrar Coletas");
			
		//imagem
		imagem = new ImageIcon(getClass().getResource("/imagens/Logo.png"));
		jlImagem = new JLabel(imagem);
		
		//adicionar os menus
		jmbBarraMenu.add(jmArquivo);		
		jmbBarraMenu.add(jmCadastro);		
		jmbBarraMenu.add(jmColeta);		
		jmbBarraMenu.add(jmExibir);
		
		//adicionando os itens
		jmArquivo.add(jmiSair);
		jmCadastro.add(jmiPessoas);
		jmCadastro.add(jmiEmpresas);
		jmCadastro.add(jmiEstabelecimentos);
		jmColeta.add(jmiPropria);
		jmColeta.add(jmiServico);
		jmColeta.add(jmiDivisao);
		jmColeta.add(jmiDiscarte);
		jmExibir.add(jmiMostrarClientes);
		jmExibir.add(jmiMostrarColetas);
		
		//adicionando e dimensionando imagem
		add(jlImagem);
		jlImagem.setBounds(1,1,400,400);
		
	}

	private void criarEventos() {
		jmiSair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		//menu Pessoa
		jmiPessoas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PainelPessoas pessoa = new PainelPessoas();
				contentPane.removeAll();
				contentPane.add(pessoa);
				contentPane.validate();
			}
		});
		jmiEmpresas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PainelEmpresas empresa = new PainelEmpresas();
				contentPane.removeAll();
				contentPane.add(empresa);
				contentPane.validate();
			}
		});
		jmiEstabelecimentos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PainelEstabelecimento estab = new PainelEstabelecimento();
				contentPane.removeAll();
				contentPane.add(estab);
				contentPane.validate();			
			}
		});
		jmiPropria.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PainelPropria propria = new PainelPropria();
				contentPane.removeAll();
				contentPane.add(propria);
				contentPane.validate();			
			}
		});
		jmiServico.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PainelServico serv = new PainelServico();
				contentPane.removeAll();
				contentPane.add(serv);
				contentPane.validate();			
			}
		});
		jmiDivisao.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PainelDivisao div = new PainelDivisao();
				contentPane.removeAll();
				contentPane.add(div);
				contentPane.validate();				
			}
		});
		jmiDiscarte.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PainelDiscarte discarte = new PainelDiscarte();
				contentPane.removeAll();
				contentPane.add(discarte);
				contentPane.validate();
			}
		});
	}

	
	
	
	
	
}
