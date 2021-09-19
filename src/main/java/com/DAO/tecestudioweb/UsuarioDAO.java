package com.DAO.tecestudioweb;

import java.beans.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.DAO.tecestudioweb.*;
import com.DTO.tecestudioweb.*;

import java.sql.*;

public class UsuarioDAO {
	
Conexion conn = new Conexion();
	
	public List<UsuarioVO> traerTodos(){
		String query = "select * from usuario";
		List<UsuarioVO> listaUsuarios = new ArrayList<UsuarioVO>();
		Conexion conn = new Conexion();
		UsuarioVO usuarioTemp;
		
		try {
			 PreparedStatement consulta =
			conn.getConnection().prepareStatement(query);
			 ResultSet result = consulta.executeQuery();
			
			 if(result == null){
				 
				 return null;
			 }
			 else {
				 
				 while(result.next()){
					 usuarioTemp = new UsuarioVO();
					 usuarioTemp.setDoc_usuario(result.getString("doc_usuario"));
					 usuarioTemp.setNom_usuario(result.getString("nom_usuario"));
					 usuarioTemp.setEmail_usuario(result.getString("email_usuario"));
					 usuarioTemp.setUsuario(result.getString("usuario"));
					 usuarioTemp.setPassword(result.getString("password"));
					 
					 listaUsuarios.add(usuarioTemp);
				 }
				 conn.desconectar();
			 }
			
		} catch (Exception e) {
			try {
				JOptionPane.showMessageDialog(null, "no se pudo proceder ");
				
				conn.desconectar();
				
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "no se pudo desconectar la db");
			}
		}
		
		return listaUsuarios;
	}
	
	//--------------- metodo guardar -----------------------------------------
	
	public boolean guardar(String documento , String nombre,String email, String usuario,
			String password  ){
		
		String query = "insert into usuario(doc_usuario, nom_usuario, email_usuario, usuario, password ) value (?,?,?,?,?)";
		boolean guardado = false;
		
		try {
			Conexion conexion = new Conexion();
			Connection conn = conexion.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, documento);
			pstmt.setString(2, nombre);
			pstmt.setString(3, email);
			pstmt.setString(4, usuario);
			pstmt.setString(5, password);
			
			pstmt.executeUpdate();
			
			guardado = true;
			
		} catch (Exception e) {
			System.out.println("no se pudo proceder "+e);
		}
		
	return guardado;
	}
	
	//-----------------metodo buscar--------------------------------------------
	public List<UsuarioVO> buscar(String cedula){
		String query = "select * from usuario where doc_usuario = '"+cedula+"'";
		List<UsuarioVO> listaUsuarios = new ArrayList<UsuarioVO>();
		Conexion conexion = new Conexion();
		UsuarioVO usuarioTemp;
		
		try {
			 PreparedStatement consulta =
			conn.getConnection().prepareStatement(query);
			 ResultSet result = consulta.executeQuery();
			
			 if(result == null){
				 
				 return null;
			 }
			 else {
				 
				 while(result.next()){
					 usuarioTemp = new UsuarioVO();
					 usuarioTemp.setDoc_usuario(result.getString("doc_usuario"));
					 usuarioTemp.setNom_usuario(result.getString("nom_usuario"));
					 usuarioTemp.setEmail_usuario(result.getString("email_usuario"));
					 usuarioTemp.setUsuario(result.getString("usuario"));
					 usuarioTemp.setPassword(result.getString("password"));
					 
					 listaUsuarios.add(usuarioTemp);
				 }
				 conn.desconectar();
			 }
			
		} catch (Exception e) {
			try {
				System.out.print("no se pudo procesar el query "+e);
				
				conn.desconectar();
				
			} catch (Exception e2) {
				System.out.print("no se pudo conectar con la base de datos "+e);
			}
		}
		
		return listaUsuarios;
	}

	
	//------------ metodo eliminar --------------------------------

	public boolean eliminar(String cedula){
		String query = "delete from usuario where DOC_USUARIO = ?";
		Conexion conn = new Conexion();
		boolean eliminado = false;
		
		
		try {
			PreparedStatement pstmt =
			conn.getConnection().prepareStatement(query);
			pstmt.setString(1, cedula);
			pstmt.executeQuery();
			eliminado = true;
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "no fue posible eliminar al usuario");
			
		}
		
		return eliminado;
	}
	
	public boolean eliminarUsuario(String usuario, String password) {
		 ArrayList<LoginVO> miusuario = new ArrayList<LoginVO>();//Crea el objeto arryList
		 Conexion conn= new Conexion();
		 boolean eliminado = false;
		 try {
		 String cadenaSQL="delete from usuario where DOC_USUARIO = ?";
		 PreparedStatement consulta =
		conn.getConnection().prepareStatement(cadenaSQL);

		 consulta.setString(1, "103");//el orden de los ?
		 ResultSet res = consulta.executeQuery();
		 eliminado = true;
		 
		 } catch (Exception e) {
		 JOptionPane.showMessageDialog(null, "no se pudo eliminar El usuario\n"+e);
		 }
		 return eliminado;
		}
	
}
