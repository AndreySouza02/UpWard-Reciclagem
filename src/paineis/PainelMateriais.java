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

import classes.Materiais;

public class PainelMateriais extends JPanel {
	private JLabel jlMateriais, jlMaterial, jlQuantidade;
	private JTextField jtfMaterial, jtfQuantidade;
	private JButton jbCadastrar;
	private List<Materiais> materiais;
	
	public PainelMateriais(List<Materiais> materiais) {
		super();
		this.materiais = materiais;
		setSize(400, 400);
		setLayout(null);
		setBackground(Color.cyan.brighter());
		iniciarComponentes();
		criarEventos();
	}

	private void iniciarComponentes() {
		jlMateriais = new JLabel("Materiais");
		jlMaterial = new JLabel("Material: ");
		jlQuantidade = new JLabel("Quantidade: ");
		jtfMaterial = new JTextField();
		jtfQuantidade = new JTextField();
		jbCadastrar = new JButton("Cadastrar");
		
		add(jbCadastrar);
		add(jlMateriais);
		add(jlMaterial);
		add(jlQuantidade);
		add(jtfMaterial);
		add(jtfQuantidade);
		
		jlMateriais.setBounds(175,20,80,20);
		jlMaterial.setBounds(100,60,80,20);
		jtfMaterial.setBounds(155,60,120,20);
		jlQuantidade.setBounds(100,90,100,20);
		jtfQuantidade.setBounds(175,90,120,20);
		jbCadastrar.setBounds(140,160,120,40);
		
	}

	private void criarEventos() {
		jbCadastrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String material, quantidade;
				if(!jtfMaterial.getText().isEmpty() && !jtfQuantidade.getText().isEmpty()) {
					material = jtfMaterial.getText();
					quantidade = jtfQuantidade.getText();
					materiais.add(new Materiais(material, quantidade));
				} else {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos", "UpWard Reciclagem",
							JOptionPane.ERROR_MESSAGE);
				}	
				//apagar caixas
				jtfMaterial.setText("");
				jtfQuantidade.setText("");
			}
		});
		
	}
	
	
}
