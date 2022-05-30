package paineis;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PainelSobre extends JPanel {
	private JLabel jlSobre, jlImagem;
	private ImageIcon imagem;
	
	public PainelSobre() {
		super();
		setSize(400, 400);
		setLayout(null);
		setBackground(Color.green.darker());
		iniciarComponentes();
	}

	private void iniciarComponentes() {
		jlSobre = new JLabel("Feito pelo Squad KLAM em parceria com a UpWard Reciclagem");
		imagem = new ImageIcon(getClass().getResource("/imagens/Logosquad.png"));
		jlImagem = new JLabel(imagem);
		
		add(jlSobre);
		add(jlImagem);
		
		jlSobre.setBounds(15,20,400,20);
		jlImagem.setBounds(20,60,330,240);
		
	}

	
}
