package com.DAO.tecestudioweb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.DTO.tecestudioweb.VentasVO;

public class VentasDAO {
	
	/**
	 * guarda en la base de datos los datos de la venta 
	 * @param venta
	 * @return {@code boolean} true si logra guardarlo
	 */
	
	public boolean guardarVenta(VentasVO venta) {
		Conexion conexion = new Conexion();
		int resultado = -1;
		boolean guardado = false;
			
	String query = "insert into VENTAS("
			+ "ID_CLIENTE, "
			+ "ID_USUARIO, "
			+ "IVA_VENTA, "
			+ "TOTAL_VENTA, "
			+ "VALOR_VENTA) "
			+ "value(?, ?,  ?, ?, ? )";
		
		try {
			//----prueba ----
			System.out.println(venta.toString());
			//--------------
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
	
	public VentasVO traerVenta() {
		VentasVO venta = new VentasVO();
		String query = "";
		Conexion conexion = new Conexion();
		try {
			Connection conn = conexion.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	} 
	/**
	 * trae el numero del ultimo numero consucutivo registrado en la base de datos 
	 * @return {@link Integer} 
	 */
	public long traerConsecutivo() {
		Conexion conexion = new Conexion();
		long consec = -1;
		String query = "select max(CODIGO_VENTA) conse from VENTAS";
		
		
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
