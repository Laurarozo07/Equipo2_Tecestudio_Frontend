package com.DAO.tecestudioweb;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DetalleVentaDAO {

	public boolean guardarDetalle(int cantidad_producto, long codigo_producto, long codigo_venta, double valor_total,
			double valor_venta, double valor_iva) {
		int resultado = -1;
		boolean guardado = false;
		Conexion conexion = new Conexion();
		String query = "insert into detalle_venta(CANTIDAD_PRODCUTO, " + 
						"CODIGO_PRODUCTO, " + 
						"CODIGO_VENTA, " + 
						"VALOR_TOTAL, " + 
						"VALOR_VENTA, " + 
						"VALOR_IVA  )" + 
						"value(?, ?, ?, ?, ?, ? )";
		try {
			Connection conn = conexion.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, cantidad_producto);
			pstmt.setLong(2, codigo_producto);
			pstmt.setLong(3, codigo_venta);
			pstmt.setDouble(4, valor_total);
			pstmt.setDouble(5, valor_venta);
			pstmt.setDouble(6, valor_iva);
			resultado = pstmt.executeUpdate();

			if (resultado > 0) {
				guardado = true;
			}
			conexion.desconectar();
		} catch (Exception e) {
			System.out.println(" no se logro guardar el detalle de la venta " + e);
		}

		return guardado;
	}

}
