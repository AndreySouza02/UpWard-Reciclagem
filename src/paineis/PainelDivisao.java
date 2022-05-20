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
import classes.ColetaDivisao;

public class PainelDivisao extends JPanel {
	private JLabel jlDivisao, jlData, jlCEP, jlNota;
	private JTextField jtfData, jtfCEP, jtfNotaFiscal;
	private JButton jbCadastrar;
	private List<Coleta> coleta;
	
	public PainelDivisao(List<Coleta> coleta) {
		super();
		this.coleta = coleta;
		setSize(400, 400);
		setLayout(null);
		setBackground(Color.pink.darker());
		iniciarComponentes();
		criarEventos();
	}

	private void iniciarComponentes() {
		jlDivisao = new JLabel("Divisão de ganhos");
		jlNota = new JLabel("Nota Fiscal:");
		jlData = new JLabel("Data de coleta:");
		jlCEP = new JLabel("CEP:");
		jtfNotaFiscal = new JTextField();
		jtfData = new JTextField();
		jtfCEP = new JTextField();
		jbCadastrar = new JButton("Cadastrar");
		
		add(jlCEP);
		add(jlData);
		add(jlDivisao);
		add(jlNota);
		add(jtfCEP);
		add(jtfData);
		add(jbCadastrar);
		add(jtfNotaFiscal);
		
		jlDivisao.setBounds(145, 10, 120, 20);
		jlNota.setBounds(100, 70, 100, 20);	
		jlData.setBounds(100, 100, 100, 20);
		jlCEP.setBounds(125, 130, 100, 20);
		jtfNotaFiscal.setBounds(170, 70, 100, 20);
		jtfData.setBounds(190, 100, 100, 20);
		jtfCEP.setBounds(155, 130, 100, 20);
		jbCadastrar.setBounds(120, 200, 150, 40);	
		
	}

	private void criarEventos() {
		jbCadastrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String tipo, data, cep, notafiscal;
			if(!jtfNotaFiscal.getText().isEmpty() && !jtfData.getText().isEmpty() && !jtfCEP.getText().isEmpty()) {	
				tipo = jlDivisao.getText();
				data = jtfData.getText();
				cep = jtfCEP.getText();
				notafiscal = jtfNotaFiscal.getText();
				coleta.add(new ColetaDivisao(tipo, data, cep, notafiscal));
			} else {
				JOptionPane.showMessageDialog(null, "Preencha todos os campos", "UpWard Reciclagem",
						JOptionPane.ERROR_MESSAGE);
			}
			//apagar as caixas
			jtfData.setText("");
			jtfCEP.setText("");
			jtfNotaFiscal.setText("");		
			}
		});
		
	}
}
