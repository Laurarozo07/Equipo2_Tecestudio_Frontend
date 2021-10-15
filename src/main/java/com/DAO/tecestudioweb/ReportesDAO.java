package com.DAO.tecestudioweb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.DTO.tecestudioweb.ReportesVO;

public class ReportesDAO {

	public List< ReportesVO > buscarVentas(long DOC_CLIENTE){
		List<ReportesVO> listaReportes = new ArrayList<ReportesVO>();
		ReportesVO reporteTemp ;
		Conexion conexion = new Conexion();
		String query ="select v.CODIGO_VENTA, c.NOM_CLIENTE, c.APE_CLIENTE, \r\n"
				+ "dv.CODIGO_PRODUCTO,dv.CANTIDAD_PRODCUTO, p.NOMBRE_PRODUCTO ,pv.NOM_PROVEEDOR, dv.VALOR_TOTAL,\r\n"
				+ "dv.VALOR_VENTA, dv.VALOR_IVA from\r\n"
				+ "	(select CODIGO_VENTA, ID_CLIENTE from VENTAS ) v,\r\n"
				+ "    (select * from DETALLE_VENTA) dv ,\r\n"
				+ "    (select ID_CLIENTE, NOM_CLIENTE, APE_CLIENTE from CLIENTE where DOC_CLIENTE=?) c,\r\n"
				+ "    (select CODIGO_PRODUCTO, NOMBRE_PRODUCTO, NIT_PROVEEDOR from PRODUCTO) p,\r\n"
				+ "    (select NIT_PROVEEDOR, NOM_PROVEEDOR from PROVEEDOR) pv\r\n"
				+ "WHERE v.ID_CLIENTE = c.ID_CLIENTE and v.CODIGO_VENTA = dv.CODIGO_VENTA \r\n"
				+ "and p.CODIGO_PRODUCTO = dv.CODIGO_PRODUCTO and pv.NIT_PROVEEDOR = p.NIT_PROVEEDOR;";
		try {
			Connection conn = conexion.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setLong(1, DOC_CLIENTE);
			ResultSet result = pstmt.executeQuery();
			if(result == null) {
				listaReportes = null;	
			}else {
				while (result.next()) {
					reporteTemp = new ReportesVO();
					reporteTemp.setCodigo_venta(result.getLong("CODIGO_VENTA"));
					reporteTemp.setNom_cliente(result.getString("NOM_CLIENTE"));
					reporteTemp.setApe_cilente(result.getString("APE_CLIENTE"));
					reporteTemp.setCodigo_producto(result.getLong("CODIGO_PRODUCTO"));
					reporteTemp.setCantidad_producto(result.getInt("CANTIDAD_PRODCUTO"));
					reporteTemp.setNombre_Producto(result.getString("NOMBRE_PRODUCTO"));
					reporteTemp.setNom_proveedor(result.getString("NOM_PROVEEDOR"));
					reporteTemp.setValor_total(result.getDouble("VALOR_TOTAL"));
					reporteTemp.setValor_venta(result.getDouble("VALOR_VENTA"));
					reporteTemp.setValor_iva(result.getDouble("VALOR_IVA"));
					
					listaReportes.add(reporteTemp);
				}
			}
			
		} catch (Exception e) {
			System.out.println("no se ha podido realizar la busqueda de las ventas "+e);
		}finally {
			try {
				conexion.desconectar();
			} catch (Exception e2) {
				System.out.println("no se ha podido cerrar la conexion");
			}
		}	
		return listaReportes;
	}
	
}
