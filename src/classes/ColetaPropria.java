package classes;

public class ColetaPropria extends Coleta{
	private String local;
	
	public ColetaPropria(String tipoColeta, String dataColeta, String cep, String local) {
		super(tipoColeta, dataColeta, cep);
		this.local = local;
	}
}
