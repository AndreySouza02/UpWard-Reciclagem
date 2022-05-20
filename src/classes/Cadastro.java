package classes;

import java.io.Serializable;

public class Cadastro implements Serializable{
	private String senha, login;

	public Cadastro(String senha, String login) {
		super();
		this.senha = senha;
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public String getLogin() {
		return login;
	}
	
	
}
