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
import classes.ColetaDiscarte;

public class PainelDiscarte extends JPanel{
	private JLabel jlDiscarte, jlData, jlCEP;
	private JTextField jtfData, jtfCEP;
	private JButton jbCadastrar;
	private List<Coleta> coleta;
	
	public PainelDiscarte(List<Coleta> coleta) {
		super();
		this.coleta = coleta;
		setSize(400, 400);
		setLayout(null);
		setBackground(Color.orange.darker());
		iniciarComponentes();
		criarEventos();
	}

	private void iniciarComponentes() {
		jlDiscarte = new JLabel("Discarte");
		jlData = new JLabel("Data de coleta:");
		jlCEP = new JLabel("CEP:");
		jtfData = new JTextField();
		jtfCEP = new JTextField();
		jbCadastrar = new JButton("Cadastrar");
		
		add(jlCEP);
		add(jlData);
		add(jlDiscarte);
		add(jtfCEP);
		add(jtfData);
		add(jbCadastrar);
		
		jlDiscarte.setBounds(165, 10, 100, 20);
		jlData.setBounds(100, 70, 100, 20);
		jtfData.setBounds(190, 70, 100, 20);
		jlCEP.setBounds(125, 100, 100, 20);
		jtfCEP.setBounds(155, 100, 100, 20);
		jbCadastrar.setBounds(120, 200, 150, 40);
		
	}

	private void criarEventos() {
		jbCadastrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String tipo, data, cep;
				if(!jtfData.getText().isEmpty() && !jtfCEP.getText().isEmpty()) {
					tipo = jlDiscarte.getText();
					data = jtfData.getText();
					cep = jtfCEP.getText();	
					coleta.add(new ColetaDiscarte(tipo, data, cep));
				} else {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos", "UpWard Reciclagem",
							JOptionPane.ERROR_MESSAGE);
				}
				//apagar as caixas
				jtfData.setText("");
				jtfCEP.setText("");
			}
		});
		
	}
}