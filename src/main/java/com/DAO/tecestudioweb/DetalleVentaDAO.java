package com.DAO.tecestudioweb;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.DTO.tecestudioweb.DetalleVentaVO;

public class DetalleVentaDAO {

	public boolean guardarDetalle(DetalleVentaVO detalleV) {
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
			pstmt.setInt(1, detalleV.getCantidad_producto());
			pstmt.setLong(2, detalleV.getCodigo_producto());
			pstmt.setLong(3, detalleV.getCodigo_venta());
			pstmt.setDouble(4, detalleV.getValor_total());
			pstmt.setDouble(5, detalleV.getValor_venta());
			pstmt.setDouble(6, detalleV.getValor_iva());
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
