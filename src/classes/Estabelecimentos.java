package classes;

public class Estabelecimentos extends Clientes {
	private String cnpj;

	public Estabelecimentos(String nome, String local, String contrato, String telefone, String cep, String cnpj) {
		super(nome, local, contrato, telefone, cep);
		this.cnpj = cnpj;
	}

	@Override
	public String mostrarDados() {
		// TODO Auto-generated method stub
		return super.mostrarDados() + "\nCNPJ: " + this.cnpj;
	}
	
	
}
