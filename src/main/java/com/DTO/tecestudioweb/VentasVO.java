package com.DTO.tecestudioweb;

public class VentasVO {
	
	long id_cliente;
	long id_usuario;
	double iva_venta;
	double total_venta;
	double valor_venta;
	
	public VentasVO(){}
	
	public VentasVO(long id_cliente, long id_usuario, double iva_venta, double total_venta, double valor_venta) {
		super();
		this.id_cliente = id_cliente;
		this.id_usuario = id_usuario;
		this.iva_venta = iva_venta;
		this.total_venta = total_venta;
		this.valor_venta = valor_venta;
	}

	public long getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(long id_cliente) {
		this.id_cliente = id_cliente;
	}

	public long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public double getIva_venta() {
		return iva_venta;
	}

	public void setIva_venta(double iva_venta) {
		this.iva_venta = iva_venta;
	}

	public double getTotal_venta() {
		return total_venta;
	}

	public void setTotal_venta(double total_venta) {
		this.total_venta = total_venta;
	}

	public double getValor_venta() {
		return valor_venta;
	}

	public void setValor_venta(double valor_venta) {
		this.valor_venta = valor_venta;
	}
	

}
