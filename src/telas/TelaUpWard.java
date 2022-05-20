package telas;

import java.awt.Color;
import java.awt.Container;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import arquivo.EscreverLerArquivos;
import classes.Clientes;
import classes.Coleta;
import classes.Materiais;
import paineis.PainelDiscarte;
import paineis.PainelDivisao;
import paineis.PainelEmpresas;
import paineis.PainelEstabelecimento;
import paineis.PainelMateriais;
import paineis.PainelMostrarClientes;
import paineis.PainelMostrarColetas;
import paineis.PainelMostrarMateriais;
import paineis.PainelPessoas;
import paineis.PainelPropria;
import paineis.PainelServico;

public class TelaUpWard extends JFrame{
	private JMenuBar jmbBarraMenu;
	private JMenu jmArquivo, jmCadastro, jmColeta, jmExibir;
	private JMenuItem jmiSair, jmiPessoas, jmiEmpresas, jmiEstabelecimentos,
	jmiPropria, jmiDivisao, jmiServico, jmiDiscarte, jmiMateriais, jmiMostrarClientes,
	jmiMostrarColetas, jmiMostrarMateriais;
	private JLabel jlImagem;
	private ImageIcon imagem;
	private Container contentPane;
	private List<Clientes> clientes = new ArrayList<>();//matriz din�mica
	private List<Coleta> coleta = new ArrayList<>();
	private List<Materiais> materiais = new ArrayList<>();
	private EscreverLerArquivos arquivos = new EscreverLerArquivos();
	
	public TelaUpWard(String title) throws HeadlessException {
		super(title);
		setSize(400,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.green.darker());
		iniciarComponentes();
		criarEventos();
		lerArquivo();
	}

	private void lerArquivo() {
		if (arquivos.lerArquivo() != null) {
			clientes = arquivos.lerArquivo();
		}	
		if (arquivos.lerArquivo2() != null) {
			coleta = arquivos.lerArquivo2();
		}
		//if (arquivos.lerArquivo3() != null) {
		//	materiais = arquivos.lerArquivo3();
		}
	//}

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
		jmiDivisao = new JMenuItem("Divis�o de ganhos");
		jmiPropria = new JMenuItem("Pr�pria");
		jmiServico = new JMenuItem("� servi�o");
		jmiMateriais = new JMenuItem("Materiais");
		jmiMostrarClientes = new JMenuItem("Mostrar Clientes");
		jmiMostrarColetas = new JMenuItem("Mostrar Coletas");
		jmiMostrarMateriais = new JMenuItem("Mostrar Materiais");
		
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
		jmColeta.add(jmiMateriais);
		jmExibir.add(jmiMostrarClientes);
		jmExibir.add(jmiMostrarColetas);
		jmExibir.add(jmiMostrarMateriais);
		
		//adicionando e dimensionando imagem
		add(jlImagem);
		jlImagem.setBounds(1,1,400,400);
		
	}

	private void criarEventos() {
		jmiSair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int resposta = JOptionPane.showConfirmDialog(null, "Deseja sair e salvar o programa", "UpWard Reciclagem",
				JOptionPane.YES_NO_OPTION);
				if(resposta == 0) {
					arquivos.escreverArquivos(clientes, coleta);
				}
				System.exit(0);
				
			}
		});
		//menu Pessoa
		jmiPessoas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PainelPessoas pessoa = new PainelPessoas(clientes);
				contentPane.removeAll();
				contentPane.add(pessoa);
				contentPane.validate();
			}
		});
		jmiEmpresas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PainelEmpresas empresa = new PainelEmpresas(clientes);
				contentPane.removeAll();
				contentPane.add(empresa);
				contentPane.validate();
			}
		});
		jmiEstabelecimentos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PainelEstabelecimento estab = new PainelEstabelecimento(clientes);
				contentPane.removeAll();
				contentPane.add(estab);
				contentPane.validate();			
			}
		});
		jmiMostrarClientes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PainelMostrarClientes mostra1 = new PainelMostrarClientes(clientes);
				contentPane.removeAll();
				contentPane.add(mostra1);
				contentPane.validate();		
			}
		});
		jmiPropria.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PainelPropria propria = new PainelPropria(coleta);
				contentPane.removeAll();
				contentPane.add(propria);
				contentPane.validate();			
			}
		});
		jmiServico.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PainelServico serv = new PainelServico(coleta);
				contentPane.removeAll();
				contentPane.add(serv);
				contentPane.validate();			
			}
		});
		jmiDivisao.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PainelDivisao div = new PainelDivisao(coleta);
				contentPane.removeAll();
				contentPane.add(div);
				contentPane.validate();				
			}
		});
		jmiDiscarte.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PainelDiscarte discarte = new PainelDiscarte(coleta);
				contentPane.removeAll();
				contentPane.add(discarte);
				contentPane.validate();
			}
		});
		jmiMostrarColetas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PainelMostrarColetas mostra2 = new PainelMostrarColetas(coleta);
				contentPane.removeAll();
				contentPane.add(mostra2);
				contentPane.validate();			
			}
		});
		jmiMateriais.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PainelMateriais material = new PainelMateriais(materiais);
				contentPane.removeAll();
				contentPane.add(material);
				contentPane.validate();				
			}
		});
		jmiMostrarMateriais.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PainelMostrarMateriais mostra3 = new PainelMostrarMateriais(materiais);
				contentPane.removeAll();
				contentPane.add(mostra3);
				contentPane.validate();				
			}
		});
	}

}
