package com.DAO.tecestudioweb;

import java.util.ArrayList;
import java.util.List;
import com.DTO.tecestudioweb.ProveedorVO;
import com.sun.net.httpserver.Authenticator.Result;

import java.sql.*;


public class ProveedorDAO {
	
	
	
	//---------------- buscar todos ---------------------------------------
	
	public List< ProveedorVO > traerTodos(){
		Conexion conexion = new Conexion();
		String query = "select * from PROVEEDOR";
		 
		ProveedorVO proveedorTemp ;
		List<ProveedorVO> listaProveedores = new ArrayList<ProveedorVO>();
		
		try {
			Connection conn = conexion.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(query);
			if(result == null){
				listaProveedores = null;
			}else {
				
				while(result.next()){
					proveedorTemp = new ProveedorVO();
					
					proveedorTemp.setNit_Proveedor(result.getLong("nit_proveedor"));
					proveedorTemp.setNom_proveedor(result.getString("nom_proveedor"));
					proveedorTemp.setEmail_proveedor(result.getString("email_proveedor"));
					proveedorTemp.setCiudad_proveedor(result.getString("ciudad_proveedor"));
					proveedorTemp.setDirec_proveedor(result.getString("direc_proveedor"));
					proveedorTemp.setTel_proveedor(result.getString("tel_proveedor"));
					
					listaProveedores.add(proveedorTemp);
					
				}
				conexion.desconectar();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listaProveedores;
	}
	
	//-------------------- metodo guardar -----------------------------------
		public boolean guardar(ProveedorVO proveedor ){
			Conexion conexion = new Conexion();
			String query = "insert into PROVEEDOR(nit_proveedor, nom_proveedor, email_proveedor, ciudad_proveedor, direc_proveedor, tel_proveedor\r\n"
					+ ") value(?, ?, ?, ?, ?, ?)" ;
			boolean guardado = false ;
			// recibe la cantidad de lineas afectadas en la base de datos
			int resultado; 
			
			try {
				Connection conn = conexion.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);	
				pstmt.setLong(1, proveedor.getNit_Proveedor());
				pstmt.setString(2, proveedor.getNom_proveedor());
				pstmt.setString(3, proveedor.getEmail_proveedor());
				pstmt.setString(4, proveedor.getCiudad_proveedor());
				pstmt.setString(5, proveedor.getDirec_proveedor());
				pstmt.setString(6, proveedor.getTel_proveedor());
				
				resultado = pstmt.executeUpdate();
				
				conn.close();
				if(resultado > 0) {
					guardado = true;
				}
				
			} catch (Exception e) {
				System.out.println("no fue posible procesar el guardado del proveedor "+e);
				conexion.desconectar();
			}
			
			
			return guardado;
		}
	
	//-------------------- metodo buscar ------------------------------------
		public List<ProveedorVO> buscar (Long nit_Proveedor){
			ProveedorVO proveedorTemp = null;
			List<ProveedorVO> proveedores = new ArrayList<ProveedorVO>();
			String query = "select * from PROVEEDOR where NIT_PROVEEDOR = ?";
			Conexion conexion = new Conexion();
			try {
				Connection conn = conexion.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				pstmt.setLong(1, nit_Proveedor);
				ResultSet result = pstmt.executeQuery();
				
				if(result != null) {
					
					while(result.next()){
						
						proveedorTemp = new ProveedorVO();
						proveedorTemp.setNit_Proveedor(result.getLong("nit_proveedor"));
						proveedorTemp.setNom_proveedor(result.getString("nom_proveedor"));
						proveedorTemp.setEmail_proveedor(result.getString("email_proveedor"));
						proveedorTemp.setCiudad_proveedor(result.getString("ciudad_proveedor"));
						proveedorTemp.setDirec_proveedor(result.getString("direc_proveedor"));
						proveedorTemp.setTel_proveedor(result.getString("tel_proveedor"));
						proveedores.add(proveedorTemp);
					}
					conexion.desconectar();
				}
				
			} catch (Exception e) {
				System.out.println("no fue posible buscar al proveedor " +e);
			}
			return proveedores ;
		}
		
		
	//-------------------- motodo eliminar ----------------------------------
		public boolean eliminar(long nit) {
			String query = "delete from PROVEEDOR where NIT_PROVEEDOR = ?";
			int respuesta = 0;
			boolean eliminado = false;
			Conexion conexion = new Conexion();
			
			try {
				Connection conn = conexion.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				pstmt.setLong(1, nit);
				respuesta = pstmt.executeUpdate();
				if(respuesta > 0) {
					eliminado = true;
				}
				
			} catch (Exception e) {
				System.out.println("no se logro eliminar el proveedor "+e);
			}finally {
				
				try {
					conexion.desconectar();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
			
			
			
			return eliminado;
		}
		
	//-------------------- motodo actualizar --------------------------------
	public boolean actualizar(ProveedorVO proveedor ){
		String query = "update PROVEEDOR "
				+ "set NOM_PROVEEDOR = ?, "
				+ "EMAIL_PROVEEDOR = ?, "
				+ "CIUDAD_PROVEEDOR = ?, "
				+ "DIREC_PROVEEDOR = ?, "
				+ "TEL_PROVEEDOR = ? "
				+ "where NIT_PROVEEDOR = ?";
		int resultado = 0;
		Conexion conexion = new Conexion();
		boolean actualizado = false;
		try {
			Connection conn = conexion.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, proveedor.getNom_proveedor());
			pstmt.setString(2, proveedor.getEmail_proveedor());
			pstmt.setString(3, proveedor.getCiudad_proveedor());
			pstmt.setString(4, proveedor.getDirec_proveedor());
			pstmt.setString(5, proveedor.getTel_proveedor());
			pstmt.setLong(6, proveedor.getNit_Proveedor());
			resultado = pstmt.executeUpdate();
			if(resultado>0){
				actualizado = true;
			}
		} catch (Exception e) {
			System.out.println("no se pudo actualizar "+e);
		}finally {
			try {
				conexion.desconectar();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		return actualizado;
	}

}
