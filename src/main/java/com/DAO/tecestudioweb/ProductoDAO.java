package com.DAO.tecestudioweb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
		return guardado;
		
	}
	
	public List< ProductoVO > traerTodos(){
		Conexion conexion = new Conexion();
		String query = "select * from producto ";
		
		ProductoVO productoTemp ;
		List<ProductoVO> listaProductos = new ArrayList<ProductoVO>();
		
		try {
			Connection conn = conexion.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(query);
			if (result == null) {
				listaProductos = null;
			}else {
				
				while(result.next()) {
					productoTemp = new ProductoVO();
					productoTemp.setNombre_producto(result.getString("nombre_producto"));
					productoTemp.setPrecio_compra(result.getLong("precio_compra"));
					productoTemp.setIva_compra(result.getLong("iva_compra"));
					productoTemp.setPrecio_venta(result.getLong("precio_venta"));
					productoTemp.setNit_proveedor(result.getLong("nit_proveedor"));
					
					listaProductos.add(productoTemp);
				}
				conexion.desconectar();
			}
		}catch (Exception e) {
	
		}
		return listaProductos;
	}
	
	public List<ProductoVO> buscar (Long nit_proveedor){
		ProductoVO productoTemp = null;
		List<ProductoVO> productos = new ArrayList<ProductoVO>();
		String query = "select * from proveedor where nit_proveedor = ?";
		Conexion conexion = new Conexion();
		try {
			Connection conn = conexion.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setLong(1, nit_proveedor);
			ResultSet result = pstmt.executeQuery();
			
			if(result != null) {
				
				while(result.next()) {
					
					productoTemp = new ProductoVO();
					productoTemp.setNit_proveedor(result.getLong("nit_proveedor"));
					productoTemp.setNombre_producto(result.getString("nombre_producto"));
					productoTemp.setPrecio_compra(result.getLong("precio_compra"));
					productoTemp.setIva_compra(result.getLong("iva_compra"));
					productoTemp.setPrecio_venta(result.getLong("precio_venta"));
					productos.add(productoTemp);
				}
				conexion.desconectar();
			}
			
		}catch (Exception e) {
			System.out.println("no fue posible buscar al proveedor" +e);
		}
		return productos;
	}
	
	
	public boolean eliminar(long nit) {
		String query = "delete from proveedor where nit_proveedor = ?";
		int respuesta = 0;
		boolean eliminado = false;
		Conexion conexion = new Conexion();
		
		try {
			Connection conn = conexion.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setLong(1, nit);
			respuesta = pstmt.executeUpdate();
			if (respuesta > 0) {
				eliminado = true;
			}
		}catch (Exception e) {
			System.out.println("no se logro eliminar al proveedor"+e);
		}finally {
			
			try {
				conexion.desconectar();
			}catch (Exception e2) {
			}
		}
		return eliminado;
	}
	
	
	public boolean actualizar (ProductoVO producto) {
		String query = "update proveedor"
				+ "set nombre_producto = ?, "
				+"precio_compra = ?, "
				+"iva_compra = ?, "
				+"precio_venta = ?, "
				+"where nit_proveedor = ?, ";
		int resultado = 0;
		Conexion conexion = new Conexion();
		boolean actualizado = false;
		try {
			Connection conn = conexion.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, producto.getNombre_producto());
			pstmt.setDouble(2, producto.getPrecio_compra());
			pstmt.setDouble(3, producto.getIva_compra());
			pstmt.setDouble(3, producto.getPrecio_venta());
			pstmt.setLong(5, producto.getNit_proveedor());
			resultado = pstmt.executeUpdate();
			if (resultado > 0) {
				actualizado = true;
			}
			
		}catch (Exception e) {
			System.out.println("no se pudo actualizar"+e);
		}finally {
			try {
				conexion.desconectar();
			}catch (Exception e2) {
				
			}
		}
		return actualizado;				
	}
}
