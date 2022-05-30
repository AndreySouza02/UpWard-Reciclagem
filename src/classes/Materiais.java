package classes;

import java.io.Serializable;

public class Materiais implements Serializable {
	protected String material;
	protected String quantidade;
	
	public Materiais(String material, String quantidade) {
		super();
		this.material = material;
		this.quantidade = quantidade;
	}
	
	public String mostrarMaterial() {
		return "\nMaterial: " + this.material +
				"\nQuantidade: " + this.quantidade + "\n";
	}
	
}
