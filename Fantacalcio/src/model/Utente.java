package model;

public class Utente  {
	
	private String username;
	private String nome;
	private String cognome;
	private String email;
	private String password;
	private Boolean invito = false;
	private int facebook_id;

	// riferimenti
	
	
	public Utente(String username, String nome, String cognome, String email, String password) {
		super();
		this.username = username;
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.password=password;
	}
	
	public Utente(String username, String nome, String cognome, String email, int facebook_id) {
		super();
		this.username = username;
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.facebook_id = facebook_id;
	}

	public Utente() {
		super();
	}

	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getInvito() {
		return invito;
	}

	public void setInvito(Boolean invito) {
		this.invito = invito;
	}

	public int getFacebook_id() {
		return facebook_id;
	}

	public void setFacebook_id(int facebook_id) {
		this.facebook_id = facebook_id;
	}
}
