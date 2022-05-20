package classes;

public class ColetaServico extends Coleta{
	private String contratante;

	public ColetaServico(String tipoColeta, String dataColeta, String cep, String contratante) {
		super(tipoColeta, dataColeta, cep);
		this.contratante = contratante;
	}

	@Override
	public String mostrarDados() {
		// TODO Auto-generated method stub
		return super.mostrarDados() + "\nContratante: " + this.contratante;
	}
	
	

	
}
