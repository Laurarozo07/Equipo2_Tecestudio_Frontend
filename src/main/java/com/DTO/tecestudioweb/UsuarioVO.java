package com.DTO.tecestudioweb;

public class UsuarioVO {
	
	private long id_usuario;
	private String doc_usuario;
	private String nom_usuario;
	private String email_usuario;
	private String usuario;
	private String password;
	
	public long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(long id_usuario) {
		this.id_usuario = id_usuario;
	}

	//--------------- contructor---------------------------------------------
	public UsuarioVO(){}
	
	public UsuarioVO(long id_usuario, String doc_usuario, String nom_usuario, String email_usuario, String usuario,
			String password) {
		super();
		this.id_usuario = id_usuario;
		this.doc_usuario = doc_usuario;
		this.nom_usuario = nom_usuario;
		this.email_usuario = email_usuario;
		this.usuario = usuario;
		this.password = password;
	}



	//------------------getter and setter-----------------------------------

	public String getDoc_usuario() {
		return doc_usuario;
	}

	public void setDoc_usuario(String doc_usuario) {
		this.doc_usuario = doc_usuario;
	}

	public String getNom_usuario() {
		return nom_usuario;
	}

	public void setNom_usuario(String nom_usuario) {
		this.nom_usuario = nom_usuario;
	}

	public String getEmail_usuario() {
		return email_usuario;
	}

	public void setEmail_usuario(String email_usuario) {
		this.email_usuario = email_usuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
