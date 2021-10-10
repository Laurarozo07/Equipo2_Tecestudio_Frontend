package com.DTO.tecestudioweb;
/**
 * obejeto Value Object encargado de almacenar los resultados de reportes de venta
 * @author sergiohh
 *
 */
public class ReportesVO {
	
	private long codigo_venta;
	private String nom_cliente;
	private String ape_cilente;
	private long codigo_producto;
	private int cantidad_producto;
	private String nombre_Producto;
	private String nom_proveedor;
	private double valor_total;
	private double valor_venta;
	private double valor_iva;
	
	public ReportesVO(){}

	public ReportesVO(long codigo_venta, String nom_cliente, String ape_cilente, long codigo_producto,
			int cantidad_producto, String nombre_Producto, String nom_proveedor, double valor_total, double valor_venta,
			double valor_iva) {
		super();
		this.codigo_venta = codigo_venta;
		this.nom_cliente = nom_cliente;
		this.ape_cilente = ape_cilente;
		this.codigo_producto = codigo_producto;
		this.cantidad_producto = cantidad_producto;
		this.nombre_Producto = nombre_Producto;
		this.nom_proveedor = nom_proveedor;
		this.valor_total = valor_total;
		this.valor_venta = valor_venta;
		this.valor_iva = valor_iva;
	}



	public long getCodigo_venta() {
		return codigo_venta;
	}

	public void setCodigo_venta(long codigo_venta) {
		this.codigo_venta = codigo_venta;
	}

	public String getNom_cliente() {
		return nom_cliente;
	}

	public void setNom_cliente(String nom_cliente) {
		this.nom_cliente = nom_cliente;
	}

	public String getApe_cilente() {
		return ape_cilente;
	}

	public void setApe_cilente(String ape_cilente) {
		this.ape_cilente = ape_cilente;
	}

	public long getCodigo_producto() {
		return codigo_producto;
	}

	public void setCodigo_producto(long codigo_producto) {
		this.codigo_producto = codigo_producto;
	}
	

	public int getCantidad_producto() {
		return cantidad_producto;
	}

	public void setCantidad_producto(int cantidad_producto) {
		this.cantidad_producto = cantidad_producto;
	}

	public String getNombre_Producto() {
		return nombre_Producto;
	}

	public void setNombre_Producto(String nombre_Producto) {
		this.nombre_Producto = nombre_Producto;
	}

	public String getNom_proveedor() {
		return nom_proveedor;
	}

	public void setNom_proveedor(String nom_proveedor) {
		this.nom_proveedor = nom_proveedor;
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

	@Override
	public String toString() {
		return "ReportesVO [codigo_venta=" + codigo_venta + ", nom_cliente=" + nom_cliente + ", ape_cilente="
				+ ape_cilente + ", codigo_producto=" + codigo_producto + ", nombre_Producto=" + nombre_Producto
				+ ", nom_proveedor=" + nom_proveedor + ", valor_total=" + valor_total + ", valor_venta=" + valor_venta
				+ ", valor_iva=" + valor_iva + "]";
	}
	

}
