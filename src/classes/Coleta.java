package classes;

import java.io.Serializable;

public abstract class Coleta implements Serializable {
	protected String tipoColeta;
	protected String dataColeta;
	protected String cep;

	public Coleta(String tipoColeta, String dataColeta, String cep) {
		super();
		this.tipoColeta = tipoColeta;
		this.dataColeta = dataColeta;
		this.cep = cep;
	}
	
	public String mostrarDados() {
		return "\n\nColeta: " + this.tipoColeta +
				"\nData da coleta: " + this.dataColeta +
				"\nCEP: " + this.cep;
	}
	
}
