package com.DTO.tecestudioweb;

public class DetalleVentaVO {
	int cantidad_producto;
	long codigo_producto;
	long codigo_venta;
	double valor_total;
	double valor_venta;
	double valor_iva;
	
	public DetalleVentaVO(){}
	
	public DetalleVentaVO(int cantidad_producto, long codigo_producto, long codigo_venta, double valor_total,
			double valor_venta, double valor_iva) {
		super();
		this.cantidad_producto = cantidad_producto;
		this.codigo_producto = codigo_producto;
		this.codigo_venta = codigo_venta;
		this.valor_total = valor_total;
		this.valor_venta = valor_venta;
		this.valor_iva = valor_iva;
	}

	public int getCantidad_producto() {
		return cantidad_producto;
	}

	public void setCantidad_producto(int cantidad_producto) {
		this.cantidad_producto = cantidad_producto;
	}

	public long getCodigo_producto() {
		return codigo_producto;
	}

	public void setCodigo_producto(long codigo_producto) {
		this.codigo_producto = codigo_producto;
	}

	public long getCodigo_venta() {
		return codigo_venta;
	}

	public void setCodigo_venta(long codigo_venta) {
		this.codigo_venta = codigo_venta;
	}

	public double getValor_total() {
		return valor_total;
	}

	public void setValor_total(double valor_total) {
		this.valor_total = valor_total;
	}

	public double getValor_venta() {
		return valor_venta;
	}

	public void setValor_venta(double valor_venta) {
		this.valor_venta = valor_venta;
	}

	public double getValor_iva() {
		return valor_iva;
	}

	public void setValor_iva(double valor_iva) {
		this.valor_iva = valor_iva;
	}
	
	
	

}
