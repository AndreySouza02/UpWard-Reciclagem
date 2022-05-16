package classes;

public class ColetaServico extends Coleta{
	private String contratante;

	public ColetaServico(String tipoColeta, String dataColeta, String cep, String contratante) {
		super(tipoColeta, dataColeta, cep);
		this.contratante = contratante;
	}

	
}
