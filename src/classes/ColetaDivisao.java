package classes;

public class ColetaDivisao extends Coleta{
	private String notaFiscal;

	public ColetaDivisao(String tipoColeta, String dataColeta, String cep, String notaFiscal) {
		super(tipoColeta, dataColeta, cep);
		this.notaFiscal = notaFiscal;
	}

	
}
