package classes;

import java.io.Serializable;

public abstract class Clientes implements Serializable {
	protected String nome, local, contrato, telefone, cep;

	public Clientes(String nome, String local, String contrato, String telefone, String cep) {
		super();
		this.nome = nome;
		this.local = local;
		this.contrato = contrato;
		this.telefone = telefone;
		this.cep = cep;
	}

	public String mostrarDados() {
		return "\n\nNome: " + this.nome +
				"\nEnderešo: " + this.local +
				"\nTipo de contrato: " + this.contrato +
				"\nTelefone: " + this.telefone +
				"\nCEP: " + this.cep;
	}
}
