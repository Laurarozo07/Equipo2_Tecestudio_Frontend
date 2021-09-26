package com.DAO.tecestudioweb;

import java.beans.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.DAO.tecestudioweb.*;
import com.DTO.tecestudioweb.*;

import java.sql.*;

public class UsuarioDAO {

	private Conexion conn = new Conexion();

	// ---------------- metodo buscar todos ---------------------------
	public List<UsuarioVO> traerTodos() {
		String query = "select * from usuario";
		List<UsuarioVO> listaUsuarios = new ArrayList<UsuarioVO>();
		Conexion conn = new Conexion();
		UsuarioVO usuarioTemp;

		try {
			PreparedStatement consulta = conn.getConnection().prepareStatement(query);
			ResultSet result = consulta.executeQuery();

			if (result == null) {

				return null;
			} else {

				while (result.next()) {
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

	// --------------- metodo guardar -----------------------------------------

	public boolean guardar(String documento, String nombre, String email, String usuario, String password) {

		String query = "insert into usuario(doc_usuario, nom_usuario, email_usuario, usuario, password ) value (?,?,?,?,?)";
		boolean guardado = false;
		int respuestadb = 0;

		try {
			Conexion conexion = new Conexion();
			Connection conn = conexion.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, documento);
			pstmt.setString(2, nombre);
			pstmt.setString(3, email);
			pstmt.setString(4, usuario);
			pstmt.setString(5, password);

			respuestadb = pstmt.executeUpdate();

			conexion.desconectar();
			if (respuestadb > 0) {
				guardado = true;
			}

		} catch (Exception e) {
			System.out.println("no se pudo proceder " + e);
		}

		return guardado;
	}

	// -----------------metodo buscar--------------------------------------------
	public List<UsuarioVO> buscar(String doc_usuario) {
		String query = "select * from usuario where doc_usuario = '" + doc_usuario + "'";
		List<UsuarioVO> listaUsuarios = new ArrayList<UsuarioVO>();
		Conexion conexion = new Conexion();
		UsuarioVO usuarioTemp;

		try {
			PreparedStatement consulta = conn.getConnection().prepareStatement(query);
			ResultSet result = consulta.executeQuery();

			if (result == null) {

				return null;
			} else {

				while (result.next()) {
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
				System.out.print("no se pudo procesar el query " + e);

				conn.desconectar();

			} catch (Exception e2) {
				System.out.print("no se pudo conectar con la base de datos " + e);
			}
		}

		return listaUsuarios;
	}

	// ------------ metodo eliminar --------------------------------

	public boolean eliminar(String documento) {

		String query = "delete from usuario where DOC_USUARIO = ?";
		boolean eliminado = false;
		int resultado = 0;

		try {
			Conexion conexion = new Conexion();
			Connection conn = conexion.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, documento);
			resultado = pstmt.executeUpdate();
			if (resultado > 0) {
				eliminado = true;
			}
			conexion.desconectar();

		} catch (Exception e) {
			System.out.println("no se pudo eliminar " + e);
		}

		return eliminado;
	}

	// ------------------------ metodo actualizar -------------------------

	public boolean actualizar(String documento, String nombre, String correo, String usuario, String password) {

		String query = "UPDATE  usuario SET nom_usuario = '"+nombre+"', email_usuario = '"+correo+"',\r\n"
				+ " usuario = '"+usuario+"', password = '"+password+"' WHERE doc_usuario = '"+documento+"';";

		boolean actualizado = false;
		int resultado = 0;

		try {
			Conexion conexion = new Conexion();
			Connection conn = conexion.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			//pstmt.setString(1, nombre);
			// pstmt.setString(2, correo);
			// pstmt.setString(3, usuario);
			// pstmt.setString(4, password);
			// pstmt.setString(5, documento);

			resultado = pstmt.executeUpdate();

			conexion.desconectar();
			if (resultado > 0) {
				actualizado = true;
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return actualizado;
	}

}
