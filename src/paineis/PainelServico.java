package paineis;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import classes.Coleta;
import classes.ColetaServico;

public class PainelServico extends JPanel {
	private JLabel jlServico, jlData, jlCEP, jlContratante;
	private JTextField jtfData, jtfCEP, jtfContratante;
	private JButton jbCadastrar;
	private List<Coleta> coleta;
	
	public PainelServico(List<Coleta> coleta) {
		super();
		this.coleta = coleta;
		setSize(400, 400);
		setLayout(null);
		setBackground(Color.magenta);
		iniciarComponentes();
		criarEventos();
	}

	private void iniciarComponentes() {
		jlServico = new JLabel("À serviço");
		jlContratante = new JLabel("Contratante:");
		jlData = new JLabel("Data de coleta:");
		jlCEP = new JLabel("CEP:");
		jtfContratante = new JTextField();
		jtfData = new JTextField();
		jtfCEP = new JTextField();
		jbCadastrar = new JButton("Cadastrar");
		
		add(jlCEP);
		add(jlData);
		add(jlServico);
		add(jlContratante);
		add(jtfCEP);
		add(jtfData);
		add(jbCadastrar);
		add(jtfContratante);
		
		jlServico.setBounds(165, 10, 100, 20);
		jlContratante.setBounds(100, 70, 100, 20);	
		jlData.setBounds(100, 100, 100, 20);
		jlCEP.setBounds(125, 130, 100, 20);
		jtfContratante.setBounds(175, 70, 100, 20);
		jtfData.setBounds(190, 100, 100, 20);
		jtfCEP.setBounds(155, 130, 100, 20);
		jbCadastrar.setBounds(120, 200, 150, 40);	
	}

	private void criarEventos() {
		jbCadastrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String tipo, data, cep, contratante;
			if(!jtfContratante.getText().isEmpty() && !jtfData.getText().isEmpty() && !jtfCEP.getText().isEmpty()) {
				tipo = jlServico.getText();
				data = jtfData.getText();
				cep = jtfCEP.getText();
				contratante = jtfContratante.getText();
				coleta.add(new ColetaServico(tipo, data, cep, contratante));
			} else {
				JOptionPane.showMessageDialog(null, "Preencha todos os campos", "UpWard Reciclagem",
						JOptionPane.ERROR_MESSAGE);
			}
			//apagar as caixas
			jtfData.setText("");
			jtfCEP.setText("");
			jtfContratante.setText("");
			}
		});
		
	}
}
