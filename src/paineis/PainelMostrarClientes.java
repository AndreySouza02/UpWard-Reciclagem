package paineis;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import classes.Clientes;
import classes.Empresas;
import classes.Estabelecimentos;
import classes.Pessoas;

public class PainelMostrarClientes extends JPanel{
	private JCheckBox jckEmpresas, jckPessoas, jckEstabelecimentos;
	private JLabel jlMostrar;
	private JButton jbMostrar;
	private JTextArea jtaMostrar;
	private JScrollPane jspMostrar;
	private List<Clientes> clientes;
	
	public PainelMostrarClientes(List<Clientes> clientes) {
		super();
		this.clientes = clientes;
		setSize(400,400);
		setLayout(null);
		setBackground(Color.gray);
		iniciarComponentes();
		criarEventos();
	}

	private void iniciarComponentes() {
		jckEmpresas = new JCheckBox("Empresas");
		jckEmpresas.setOpaque(false);
		jckEstabelecimentos = new JCheckBox("Estabelecimentos");
		jckEstabelecimentos.setOpaque(false);
		jckPessoas = new JCheckBox("Pessoas");
		jckPessoas.setOpaque(false);		
		jlMostrar = new JLabel("Mostrar Clientes");
		jtaMostrar = new JTextArea();
		jtaMostrar.setEditable(false);
		jspMostrar = new JScrollPane(jtaMostrar);
		jbMostrar = new JButton("Mostrar");
		
		//adicionar
		add(jckEmpresas);
		add(jckEstabelecimentos);
		add(jckPessoas);
		add(jlMostrar);
		add(jspMostrar);
		add(jbMostrar);
		
		//dimensionar
		jlMostrar.setBounds(140,1,120,20);
		jckEmpresas.setBounds(50,30,85,20);
		jckPessoas.setBounds(140,30,75,20);
		jckEstabelecimentos.setBounds(220,30,130,20);
		jbMostrar.setBounds(120,60,135,20);
		jspMostrar.setBounds(20,90,345,230);
		
	}

	private void criarEventos() {
		jbMostrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jtaMostrar.setText("=====================Clientes=====================");
				for (Clientes cliente : clientes) {
					if (jckPessoas.isSelected()) {
						if (cliente instanceof Pessoas) jtaMostrar.append(cliente.mostrarDados());
					}
					if (jckEmpresas.isSelected()) {
						if (cliente instanceof Empresas) jtaMostrar.append(cliente.mostrarDados());	
					}
					if (jckEstabelecimentos.isSelected()) {
						if (cliente instanceof Estabelecimentos) jtaMostrar.append(cliente.mostrarDados());	
					}		
				}
				
			}
		});
		
	}
}
