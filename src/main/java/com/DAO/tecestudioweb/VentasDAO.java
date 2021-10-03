package com.DAO.tecestudioweb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.DTO.tecestudioweb.VentasVO;

public class VentasDAO {
	
	public boolean guardarVenta(VentasVO venta) {
		Conexion conexion = new Conexion();
		int resultado = -1;
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
			pstmt.setLong(1, venta.getId_cliente());
			pstmt.setLong(2, venta.getId_usuario());
			pstmt.setDouble(3, venta.getIva_venta());
			pstmt.setDouble(4, venta.getTotal_venta());
			pstmt.setDouble(5, venta.getValor_venta());
			resultado = pstmt.executeUpdate();
			if(resultado > 0) {
				guardado = true;
			}
			conexion.desconectar();
		} catch (Exception e) {
			System.out.println("no se ha logrado guardar la venta "+e);
		}
		return guardado;
	}
	
	/**
	 * trae el numero del ultimon numero consucutivo registrado en la base de datos 
	 * @return {@link Integer} 
	 */
	public long traerConsecutivo() {
		Conexion conexion = new Conexion();
		long consec = -1;
		String query = "select max(codigo_venta) conse from ventas";
		
		
		try {
			Connection conn = conexion.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(query);
			
			while(result.next()) {
				consec = result.getLong("conse");
			}
			
			conexion.desconectar();
			
		} catch (Exception e) {
			System.out.println("no su pudo traer el consecutivo "+e);
		}
		
		
		return consec;
	}

}
