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
import classes.Coleta;
import classes.ColetaDiscarte;
import classes.ColetaDivisao;
import classes.ColetaPropria;
import classes.ColetaServico;
import classes.Empresas;
import classes.Estabelecimentos;
import classes.Pessoas;

public class PainelMostrarColetas extends JPanel {
	private JCheckBox jckPropria, jckDivisao, jckServico, jckDiscarte;
	private JLabel jlMostrar;
	private JButton jbMostrar;
	private JTextArea jtaMostrar;
	private JScrollPane jspMostrar;
	private List<Coleta> coleta;
	
	public PainelMostrarColetas(List<Coleta> coleta) {
		super();
		this.coleta = coleta;
		setSize(400,400);
		setLayout(null);
		setBackground(Color.yellow.darker());
		iniciarComponentes();
		criarEventos();
	}

	private void iniciarComponentes() {
		jckPropria = new JCheckBox("Própria");
		jckPropria.setOpaque(false);
		jckDivisao = new JCheckBox("Divisão");
		jckDivisao.setOpaque(false);
		jckServico = new JCheckBox("À serviço");
		jckServico.setOpaque(false);
		jckDiscarte = new JCheckBox("Discarte");
		jckDiscarte.setOpaque(false);
		jlMostrar = new JLabel("Mostrar Coletas");
		jtaMostrar = new JTextArea();
		jtaMostrar.setEditable(false);
		jspMostrar = new JScrollPane(jtaMostrar);
		jbMostrar = new JButton("Mostrar");
		
		//adicionar
		add(jckPropria);
		add(jckDiscarte);
		add(jckDivisao);
		add(jckServico);
		add(jlMostrar);
		add(jspMostrar);
		add(jbMostrar);
		
		//dimensionar
		jlMostrar.setBounds(150,1,120,20);
		jckPropria.setBounds(30,30,85,20);
		jckDivisao.setBounds(110,30,75,20);
		jckServico.setBounds(185,30,120,20);
		jckDiscarte.setBounds(275,30,80,20);
		jbMostrar.setBounds(120,60,135,20);
		jspMostrar.setBounds(20,90,345,230);
	}

	private void criarEventos() {
		jbMostrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jtaMostrar.setText("=====================Coletas=====================");
				for (Coleta coleta2 : coleta) {
					if (jckPropria.isSelected()) {
						if (coleta2 instanceof ColetaPropria) jtaMostrar.append(coleta2.mostrarDados());
					}
					if (jckDivisao.isSelected()) {
						if (coleta2 instanceof ColetaDivisao) jtaMostrar.append(coleta2.mostrarDados());	
					}
					if (jckServico.isSelected()) {
						if (coleta2 instanceof ColetaServico) jtaMostrar.append(coleta2.mostrarDados());	
					}
					if (jckDiscarte.isSelected()) {
						if (coleta2 instanceof ColetaDiscarte) jtaMostrar.append(coleta2.mostrarDados());	
					}
				}
		
			}
		});
		
	}
}
