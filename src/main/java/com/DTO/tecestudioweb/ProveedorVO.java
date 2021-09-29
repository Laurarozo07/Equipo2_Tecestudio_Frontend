package com.DTO.tecestudioweb;

public class ProveedorVO {
	
	private long nit_Proveedor;
	private String nom_proveedor;
	private String email_proveedor;
	private String ciudad_proveedor;
	private String direc_proveedor;
	private String tel_proveedor;
	
	public ProveedorVO(){};
	
	public ProveedorVO(long nit_Proveedor, String nom_proveedor, String email_proveedor, String ciudad_proveedor,
			String direc_proveedor, String tel_proveedor) {
		super();
		this.nit_Proveedor = nit_Proveedor;
		this.nom_proveedor = nom_proveedor;
		this.email_proveedor = email_proveedor;
		this.ciudad_proveedor = ciudad_proveedor;
		this.direc_proveedor = direc_proveedor;
		this.tel_proveedor = tel_proveedor;
	}

	public long getNit_Proveedor() {
		return nit_Proveedor;
	}

	public void setNit_Proveedor(long nit_Proveedor) {
		this.nit_Proveedor = nit_Proveedor;
	}

	public String getNom_proveedor() {
		return nom_proveedor;
	}

	public void setNom_proveedor(String nom_proveedor) {
		this.nom_proveedor = nom_proveedor;
	}

	public String getEmail_proveedor() {
		return email_proveedor;
	}

	public void setEmail_proveedor(String email_proveedor) {
		this.email_proveedor = email_proveedor;
	}

	public String getCiudad_proveedor() {
		return ciudad_proveedor;
	}

	public void setCiudad_proveedor(String ciudad_proveedor) {
		this.ciudad_proveedor = ciudad_proveedor;
	}

	public String getDirec_proveedor() {
		return direc_proveedor;
	}

	public void setDirec_proveedor(String direc_proveedor) {
		this.direc_proveedor = direc_proveedor;
	}

	public String getTel_proveedor() {
		return tel_proveedor;
	}

	public void setTel_proveedor(String tel_proveedor) {
		this.tel_proveedor = tel_proveedor;
	}

	@Override
	public String toString() {
		return "ProveedorVO [nit_Proveedor=" + nit_Proveedor + ", nom_proveedor=" + nom_proveedor + ", email_proveedor="
				+ email_proveedor + ", ciudad_proveedor=" + ciudad_proveedor + ", direc_proveedor=" + direc_proveedor
				+ ", tel_proveedor=" + tel_proveedor + "]";
	}
	
	
	

}
