package arquivo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import javax.swing.JOptionPane;

import classes.Cadastro;
import classes.Clientes;
import classes.Coleta;
import classes.Materiais;

public class EscreverLerArquivos {

	public void escreverArquivos(List<Clientes> clientes, List<Coleta> coleta) {
		FileOutputStream saida, saida2, saida3;
		try {
			saida = new FileOutputStream("Clientes.bin");
			saida2 = new FileOutputStream("Coleta.bin");
		//	saida3 = new FileOutputStream("Materiais.bin");
			ObjectOutputStream objeto = new ObjectOutputStream(saida);
			ObjectOutputStream objeto2 = new ObjectOutputStream(saida2);
		//	ObjectOutputStream objeto3 = new ObjectOutputStream(saida3);
			objeto.writeObject(clientes);
			objeto2.writeObject(coleta);
		//	objeto3.writeObject(objeto3);;
			objeto.close();
			objeto2.close();
		//	objeto3.close();
			JOptionPane.showMessageDialog(null, "Arquivo gravado com sucesso");
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Arquivo não Encontrado", "UpWard Reciclagem", JOptionPane.ERROR_MESSAGE);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Arquivo Corrompido", "UpWard Reciclagem", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	public List<Clientes> lerArquivo() {
		List<Clientes> clientes = null;
		try {
			FileInputStream entrada = new FileInputStream("Clientes.bin");
			ObjectInputStream objeto = new ObjectInputStream(entrada);
			clientes = (List<Clientes>) objeto.readObject();
			objeto.close();
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Arquivo não Encontrado", "UpWard Reciclagem", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Arquivo Corrompido", "UpWard Reciclagem", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Classe não Encontrada", "UpWard Reciclagem", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		return clientes;
	}
	public List<Coleta> lerArquivo2() {
		List<Coleta> coleta = null;
		try {
			FileInputStream entrada = new FileInputStream("Coleta.bin");
			ObjectInputStream objeto = new ObjectInputStream(entrada);
			coleta = (List<Coleta>) objeto.readObject();
			objeto.close();
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Arquivo não Encontrado", "UpWard Reciclagem", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Arquivo Corrompido", "UpWard Reciclagem", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Classe não Encontrada", "UpWard Reciclagem", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		return coleta;
	}
	//public List<Materiais> lerArquivo3() {
	//<Materiais> material = null;
	//	try {
	//		FileInputStream entrada = new FileInputStream("Materiais.bin");
	//		ObjectInputStream objeto = new ObjectInputStream(entrada);
	//		material = (List<Materiais>) objeto.readObject();
	//		objeto.close();
	//	} catch (FileNotFoundException e) {
	//		JOptionPane.showMessageDialog(null, "Arquivo não Encontrado", "UpWard Reciclagem", JOptionPane.ERROR_MESSAGE);
	//		e.printStackTrace();
	//	} catch (IOException e) {
	//		JOptionPane.showMessageDialog(null, "Arquivo Corrompido", "UpWard Reciclagem", JOptionPane.ERROR_MESSAGE);
	//		e.printStackTrace();
	//	} catch (ClassNotFoundException e) {
	//		JOptionPane.showMessageDialog(null, "Classe não Encontrada", "UpWard Reciclagem", JOptionPane.ERROR_MESSAGE);
	//		e.printStackTrace();
	//	}
	//	return material;
	//}
	
	
	//criar e ler arquivos de cadastro
	public void escreverArquivosCadastro(List<Cadastro> cadastros) {
		FileOutputStream saida;
		try {
			saida = new FileOutputStream("Cadastros.bin");
			ObjectOutputStream objeto = new ObjectOutputStream(saida);
			objeto.writeObject(cadastros);
			objeto.close();
			JOptionPane.showMessageDialog(null, "Arquivo gravado com sucesso");
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Arquivo não Encontrado", "UpWard Reciclagem", JOptionPane.ERROR_MESSAGE);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Arquivo Corrompido", "UpWard Reciclagem", JOptionPane.ERROR_MESSAGE);
		}
	}
	//ler arquivos
	public List<Cadastro> lerArquivosCadastrados() {
		List<Cadastro> cadastro = null;
		try {
			FileInputStream entrada = new FileInputStream("Cadastros.bin");
			ObjectInputStream objeto = new ObjectInputStream(entrada);
			cadastro = (List<Cadastro>) objeto.readObject();
			objeto.close();
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Arquivo não Encontrado", "Transportadora", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Arquivo Corrompido", "Transportadora", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Classe não Encontrada", "Transportadora", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		return cadastro;
	}
	
}
