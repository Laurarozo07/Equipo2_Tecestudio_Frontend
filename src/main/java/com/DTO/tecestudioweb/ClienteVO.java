package com.DTO.tecestudioweb;

public class ClienteVO {

private String nom_cliente;
private String ape_cliente;
private String direc_cliente;
private String email_cliente;
private String tel_cliente;
private int doc_cliente;
public ClienteVO(String nom_cliente, String ape_cliente, String direc_cliente, String email_cliente, String tel_cliente,
		int doc_cliente) {
	super();
	this.nom_cliente = nom_cliente;
	this.ape_cliente = ape_cliente;
	this.direc_cliente = direc_cliente;
	this.email_cliente = email_cliente;
	this.tel_cliente = tel_cliente;
	this.doc_cliente = doc_cliente;
}

public ClienteVO() {}

public String getNom_cliente() {
	return nom_cliente;
}

public void setNom_cliente(String nom_cliente) {
	this.nom_cliente = nom_cliente;
}

public String getApe_cliente() {
	return ape_cliente;
}

public void setApe_cliente(String ape_cliente) {
	this.ape_cliente = ape_cliente;
}

public String getDirec_cliente() {
	return direc_cliente;
}

public void setDirec_cliente(String direc_cliente) {
	this.direc_cliente = direc_cliente;
}

public String getEmail_cliente() {
	return email_cliente;
}

public void setEmail_cliente(String email_cliente) {
	this.email_cliente = email_cliente;
}

public String getTel_cliente() {
	return tel_cliente;
}

public void setTel_cliente(String tel_cliente) {
	this.tel_cliente = tel_cliente;
}

public int getDoc_cliente() {
	return doc_cliente;
}

public void setDoc_cliente(int doc_cliente) {
	this.doc_cliente = doc_cliente;
}

}
