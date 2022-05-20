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

import classes.Clientes;
import classes.Estabelecimentos;

public class PainelEstabelecimento extends JPanel{
	private JLabel jlEstabelecimento, jlNome, jlLocal, jlTelefone, jlCEP, jlCNPJ;
	private JTextField jtfNome, jtfLocal, jtfTelefone, jtfCEP, jtfCNPJ;
	private JButton jbCadastrar;
	private List<Clientes> clientes;

	public PainelEstabelecimento(List<Clientes> clientes) {
		super();
		this.clientes = clientes;
		setSize(400,400);
		setLayout(null);
		setBackground(Color.pink);
		iniciarComponentes();
		criarEventos();
	}

	private void iniciarComponentes() {
		jlEstabelecimento = new JLabel("Estabelecimento");
		jlNome = new JLabel("Nome completo");
		jlLocal = new JLabel("Endere�o");
		jlTelefone = new JLabel("Telefone");
		jlCEP = new JLabel("CEP");
		jlCNPJ = new JLabel("CNPJ");
		jtfNome = new JTextField();
		jtfLocal = new JTextField();
		jtfTelefone = new JTextField();
		jtfCEP = new JTextField();
		jtfCNPJ = new JTextField();
		jbCadastrar = new JButton("Cadastrar");

		// adicionar
		add(jlEstabelecimento);
		add(jlNome);
		add(jlLocal);
		add(jlTelefone);
		add(jlCEP);
		add(jlCNPJ);
		add(jtfNome);
		add(jtfLocal);
		add(jtfTelefone);
		add(jtfCEP);
		add(jtfCNPJ);
		add(jbCadastrar);

		// dimensionar
		jlEstabelecimento.setBounds(150, 10, 100, 20);
		jlNome.setBounds(30, 70, 100, 20);
		jlLocal.setBounds(30, 100, 100, 20);
		jlTelefone.setBounds(30, 130, 100, 20);
		jlCEP.setBounds(30, 160, 100, 20);
		jlCNPJ.setBounds(30,190,100,20);
		jtfNome.setBounds(125, 70, 200, 20);
		jtfLocal.setBounds(90, 100, 200, 20);
		jtfTelefone.setBounds(90, 130, 150, 20);
		jtfCEP.setBounds(60, 160, 100, 20);
		jtfCNPJ.setBounds(70,190,150,20);
		jbCadastrar.setBounds(120, 230, 150, 40);

	}

	private void criarEventos() {
		jbCadastrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String estabelecimento, nome, local, telefone, cep, cnpj;
				if (!jtfNome.getText().isEmpty() && !jtfLocal.getText().isEmpty() && !jtfTelefone.getText().isEmpty()
						&& !jtfCEP.getText().isEmpty() && !jtfCNPJ.getText().isEmpty()) {
					// entrada
					estabelecimento = jlEstabelecimento.getText();
					nome = jtfNome.getText();
					local = jtfLocal.getText();
					telefone = jtfTelefone.getText();
					cep = jtfCEP.getText();
					cnpj = jtfCNPJ.getText();
					clientes.add(new Estabelecimentos(nome, local, estabelecimento, telefone, cep, cnpj));
				} else {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos", "UpWard Reciclagem",
							JOptionPane.ERROR_MESSAGE);
				}
				//apagar as caixas
				jtfNome.setText("");
				jtfLocal.setText("");
				jtfTelefone.setText("");
				jtfCEP.setText("");
				jtfCNPJ.setText("");
			}
		});

	}

}
