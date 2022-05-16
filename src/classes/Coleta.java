package classes;

public abstract class Coleta {
	protected String tipoColeta;
	protected String dataColeta;
	protected String cep;

	public Coleta(String tipoColeta, String dataColeta, String cep) {
		super();
		this.tipoColeta = tipoColeta;
		this.dataColeta = dataColeta;
		this.cep = cep;
	}
	
}
