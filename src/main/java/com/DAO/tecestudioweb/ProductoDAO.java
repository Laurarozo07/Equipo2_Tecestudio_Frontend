package com.DAO.tecestudioweb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.DTO.tecestudioweb.ProductoVO;

public class ProductoDAO {

	public boolean productoGuardar(ProductoVO producto) {
		
		Conexion conexion = new Conexion();
		Connection conn = conexion.getConnection();
		String query = "insert into producto (NOMBRE_PRODUCTO, IVA_COMPRA, PRECIO_COMPRA, PRECIO_VENTA, NIT_PROVEEDOR)"
				+ "value (?, ?, ?, ?, ?)";
		int resultado = -1;
		boolean guardado = false;
		
		
		try {
			PreparedStatement pstp = conn.prepareStatement(query);
			pstp.setString(1, producto.getNombre_producto());
			pstp.setDouble(2, producto.getIva_compra());
			pstp.setDouble(3, producto.getPrecio_compra());
			pstp.setDouble(4, producto.getPrecio_venta());
			pstp.setLong(5, producto.getNit_proveedor());
			
			resultado = pstp.executeUpdate();
			
			if (resultado >0 ) {
				guardado = true;
			}
			
			conexion.desconectar();
			
		} catch (Exception e) {
		System.out.println("no se pudo guardar el producto "+ e); 
		}
		return false;
		
	}
}
