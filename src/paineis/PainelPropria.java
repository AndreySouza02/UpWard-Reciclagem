package paineis;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PainelPropria extends JPanel {
	private JLabel jlPropria, jlData, jlCEP, jlLocal;
	private JTextField jtfData, jtfCEP, jtfLocal;
	private JButton jbCadastrar;
	
	public PainelPropria() {
		super();
		setSize(400, 400);
		setLayout(null);
		setBackground(Color.red.brighter());
		iniciarComponentes();
		criarEventos();
	}

	private void iniciarComponentes() {
		jlPropria = new JLabel("Própria");
		jlLocal = new JLabel("Endereço:");
		jlData = new JLabel("Data de coleta:");
		jlCEP = new JLabel("CEP:");
		jtfLocal = new JTextField();
		jtfData = new JTextField();
		jtfCEP = new JTextField();
		jbCadastrar = new JButton("Cadastrar");
		
		add(jlCEP);
		add(jlData);
		add(jlPropria);
		add(jlLocal);
		add(jtfCEP);
		add(jtfData);
		add(jbCadastrar);
		add(jtfLocal);
		
		jlPropria.setBounds(165, 10, 100, 20);
		jlLocal.setBounds(110, 70, 100, 20);	
		jlData.setBounds(100, 100, 100, 20);
		jlCEP.setBounds(125, 130, 100, 20);
		jtfLocal.setBounds(175, 70, 100, 20);
		jtfData.setBounds(190, 100, 100, 20);
		jtfCEP.setBounds(155, 130, 100, 20);
		jbCadastrar.setBounds(120, 200, 150, 40);	
		
	}

	private void criarEventos() {
		jbCadastrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String tipo, data, cep, local;
			if(!jtfLocal.getText().isEmpty() && !jtfData.getText().isEmpty() && !jtfCEP.getText().isEmpty()) {
				tipo = jlPropria.getText();
				data = jtfData.getText();
				cep = jtfCEP.getText();
				local = jtfLocal.getText();
			} else {
				JOptionPane.showMessageDialog(null, "Preencha todos os campos", "UpWard Reciclagem",
						JOptionPane.ERROR_MESSAGE);
			}
			//apagar as caixas
			jtfData.setText("");
			jtfCEP.setText("");
			jtfLocal.setText("");
			}
		});
		
	}
	
	
}
