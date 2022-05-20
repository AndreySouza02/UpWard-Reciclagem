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
import classes.Empresas;
import classes.Pessoas;

public class PainelPessoas extends JPanel {
	private JLabel jlPessoa, jlNome, jlLocal, jlTelefone, jlCEP;
	private JTextField jtfNome, jtfLocal, jtfTelefone, jtfCEP;
	private JButton jbCadastrar;
	private List<Clientes> clientes;

	public PainelPessoas(List<Clientes> clientes) {
		super();
		this.clientes = clientes;
		setSize(400, 400);
		setLayout(null);
		setBackground(Color.cyan.darker());
		iniciarComponentes();
		criarEventos();
	}

	private void iniciarComponentes() {
		jlPessoa = new JLabel("Pessoa");
		jlNome = new JLabel("Nome completo");
		jlLocal = new JLabel("Endereço");
		jlTelefone = new JLabel("Telefone");
		jlCEP = new JLabel("CEP");
		jtfNome = new JTextField();
		jtfLocal = new JTextField();
		jtfTelefone = new JTextField();
		jtfCEP = new JTextField();
		jbCadastrar = new JButton("Cadastrar");

		// adicionar
		add(jlPessoa);
		add(jlNome);
		add(jlLocal);
		add(jlTelefone);
		add(jlCEP);
		add(jtfNome);
		add(jtfLocal);
		add(jtfTelefone);
		add(jtfCEP);
		add(jbCadastrar);

		// dimensionar
		jlPessoa.setBounds(165, 10, 100, 20);
		jlNome.setBounds(30, 70, 100, 20);
		jlLocal.setBounds(30, 100, 100, 20);
		jlTelefone.setBounds(30, 130, 100, 20);
		jlCEP.setBounds(30, 160, 100, 20);
		jtfNome.setBounds(125, 70, 200, 20);
		jtfLocal.setBounds(90, 100, 200, 20);
		jtfTelefone.setBounds(90, 130, 150, 20);
		jtfCEP.setBounds(60, 160, 100, 20);
		jbCadastrar.setBounds(120, 200, 150, 40);

	}

	private void criarEventos() {
		jbCadastrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String pessoa, nome, local, telefone, cep;
				if (!jtfNome.getText().isEmpty() && !jtfLocal.getText().isEmpty() && !jtfTelefone.getText().isEmpty()
						&& !jtfCEP.getText().isEmpty()) {
					// entrada
					pessoa = jlPessoa.getText();
					nome = jtfNome.getText();
					local = jtfLocal.getText();
					telefone = jtfTelefone.getText();
					cep = jtfCEP.getText();
					clientes.add(new Pessoas(nome, local, pessoa, telefone, cep));
				} else {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos", "UpWard Reciclagem",
							JOptionPane.ERROR_MESSAGE);
				}
				//apagar as caixas
				jtfNome.setText("");
				jtfLocal.setText("");
				jtfTelefone.setText("");
				jtfCEP.setText("");
			}
		});

	}

}
