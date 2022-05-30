package arquivo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import javax.swing.JOptionPane;
import classes.Clientes;
import classes.Coleta;
import classes.Materiais;

public class EscreverLerArquivos {

	public void escreverArquivos(List<Clientes> clientes, List<Coleta> coleta, List<Materiais> materiais) {
		FileOutputStream saida, saida2, saida3;
		try {
			saida = new FileOutputStream("Clientes.bin");
			saida2 = new FileOutputStream("Coleta.bin");
			saida3 = new FileOutputStream("Materiais.bin");
			ObjectOutputStream objeto = new ObjectOutputStream(saida);
			ObjectOutputStream objeto2 = new ObjectOutputStream(saida2);
			ObjectOutputStream objeto3 = new ObjectOutputStream(saida3);
			objeto.writeObject(clientes);
			objeto2.writeObject(coleta);
			objeto3.writeObject(materiais);;
			objeto.close();
			objeto2.close();
			objeto3.close();
			JOptionPane.showMessageDialog(null, "Arquivo gravado com sucesso");
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Arquivo n�o Encontrado", "UpWard Reciclagem", JOptionPane.ERROR_MESSAGE);
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
		}catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Arquivo n�o Encontrado", "UpWard Reciclagem", JOptionPane.ERROR_MESSAGE);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Arquivo Corrompido", "UpWard Reciclagem", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Classe n�o Encontrada", "UpWard Reciclagem", JOptionPane.ERROR_MESSAGE);
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
			JOptionPane.showMessageDialog(null, "Arquivo n�o Encontrado", "UpWard Reciclagem", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Arquivo Corrompido", "UpWard Reciclagem", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Classe n�o Encontrada", "UpWard Reciclagem", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		return coleta;
	}
	public List<Materiais> lerArquivo3() {
	    List<Materiais> material = null;
		try {
			FileInputStream entrada = new FileInputStream("Materiais.bin");
			ObjectInputStream objeto = new ObjectInputStream(entrada);
			material = (List<Materiais>) objeto.readObject();
			objeto.close();
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Arquivo n�o Encontrado", "UpWard Reciclagem", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Arquivo Corrompido", "UpWard Reciclagem", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Classe n�o Encontrada", "UpWard Reciclagem", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		return material;
	}
	
}
