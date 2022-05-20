package paineis;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import classes.Materiais;

public class PainelMostrarMateriais extends JPanel {
	private JLabel jlMostra;
	private JButton jbMostrar;
	private JTextArea jtaMostrar;
	private JScrollPane jspMostrar;
	private List<Materiais> materiais;
	
	public PainelMostrarMateriais(List<Materiais> materiais) {
		super();
		this.materiais = materiais;
		setSize(400,400);
		setLayout(null);
		setBackground(Color.gray);
		iniciarComponentes();
		criarEventos();
	}

	private void iniciarComponentes() {
		jlMostra = new JLabel("Mostrar materiais cadastrados");
		jbMostrar = new JButton("Mostrar");
		jtaMostrar = new JTextArea();
		jtaMostrar.setEditable(false);
		jspMostrar = new JScrollPane(jtaMostrar);
		
		add(jbMostrar);
		add(jlMostra);
		add(jspMostrar);
		
		jlMostra.setBounds(110,20,200,20);
		jbMostrar.setBounds(130,50,120,20);
		jspMostrar.setBounds(20,80,340,235);
		
	}

	private void criarEventos() {
		jbMostrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jtaMostrar.setText("====================Materiais====================");
				for (Materiais materiais2 : materiais) {
					if (materiais2 instanceof Materiais) jtaMostrar.append(materiais2.mostrarMaterial());
				}
			}
		});
		
	}
	
	
}
