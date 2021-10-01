package com.DAO.tecestudioweb;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class VentasDAO {
	
	public boolean guardarVenta(long Id_cliente,long id_usuario, double iva_venta,
			double total_venta, double valor_venta ) {
		Conexion conexion = new Conexion();
		boolean guardado = false;
			
		
	String query = "insert into ventas("
			+ "id_cliente, "
			+ "id_usuario, "
			+ "iva_venta, "
			+ "total_venta, "
			+ "valor_venta) "
			+ "value(?, ?,  ?, ?, ? )";
		
		try {
			Connection conn = conexion.getConnection();	
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setLong(1, Id_cliente);
			pstmt.setLong(2, id_usuario);
			pstmt.setDouble(3, iva_venta);
			pstmt.setDouble(4, total_venta);
			pstmt.setDouble(5, valor_venta);
			guardado = true;
			
		} catch (Exception e) {
			System.out.println("no se ha logrado guardar la venta "+e);
		}
		return guardado;
	}

}
