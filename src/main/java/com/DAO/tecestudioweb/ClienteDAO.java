package com.DAO.tecestudioweb;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import java.beans.Statement;
import com.DTO.tecestudioweb.ClienteVO;

public class ClienteDAO {

	public List<ClienteVO> traerTodos() {
		Conexion conexion = new Conexion();
		String query = "select * from Cliente;";
		ClienteVO clienteTemporal = new ClienteVO();
		List<ClienteVO> listaClientes = new ArrayList<ClienteVO>();

		try {
			Connection conn = conexion.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			if (result == null) {
				listaClientes = null;
			} else {
				while (result.next()) {
					clienteTemporal = new ClienteVO();
					clienteTemporal.setDoc_cliente(result.getInt("doc_cliente"));
					clienteTemporal.setApe_cliente(result.getString("ape_cliente"));
					clienteTemporal.setDirec_cliente(result.getString("direc_cliente"));
					clienteTemporal.setEmail_cliente(result.getString("email_cliente"));
					clienteTemporal.setNom_cliente(result.getString("nom_cliente"));
					clienteTemporal.setTel_cliente(result.getString("tel_cliente"));
					listaClientes.add(clienteTemporal);
				}
				conexion.desconectar();
			}

		} catch (Exception e) {
			System.out.println("no se pudo procesar la consulta de clientes " + e);
		}
		return listaClientes;
	}

	public List<ClienteVO> buscar(String doc_cliente) {
		String query = "select * from usuario where doc_cliente = '" + doc_cliente + "'";
		List<ClienteVO> listaClientes = new ArrayList<ClienteVO>();
		Conexion conexion = new Conexion();
		ClienteVO usuarioTemp;

		try {
			PreparedStatement consulta = conexion.getConnection().prepareStatement(query);
			ResultSet result = consulta.executeQuery();

			if (result == null) {

				return null;
			} else {

				while (result.next()) {
					usuarioTemp = new ClienteVO();
					usuarioTemp.setDoc_cliente(result.getInt("doc_cliente"));
					usuarioTemp.setNom_cliente(result.getString("nom_cliente"));
					usuarioTemp.setEmail_cliente(result.getString("email_cliente"));
					usuarioTemp.setApe_cliente(result.getString("ape_cliente"));
					usuarioTemp.setDirec_cliente(result.getString("direc_cliente"));
					usuarioTemp.setTel_cliente(result.getString("tel_cliente"));

					listaClientes.add(usuarioTemp);
				}
				conexion.desconectar();
			}
		} catch (Exception e) {
			try {
				JOptionPane.showMessageDialog(null, "no se pudo proceder");

				conexion.desconectar();

			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "no se pudo desconectar la db");
			}
		}

		return listaClientes;
	}

	public boolean eliminar(String doc_cliente) {

		String query = "delete from cliente where DOC_CLIENTE = ?";
		boolean eliminado = false;
		int resultado = 0;

		try {
			Conexion conexion = new Conexion();
			Connection conn = conexion.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, doc_cliente);
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

	public boolean guardar(String nom_cliente, String ape_cliente, String direc_cliente, String email_cliente,
			String tel_cliente, String doc_cliente) {

		String query = "insert into cliente (nom_cliente, ape_cliente, direc_cliente, email_cliente, tel_cliente, doc_cliente) value (?, ?, ?, ?, ?, ?)";
		boolean guardado = false;
		int respuestadb = 0;

		try {
			Conexion conexion = new Conexion();
			Connection conn = conexion.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, doc_cliente);
			pstmt.setString(2, nom_cliente);
			pstmt.setString(3, email_cliente);
			pstmt.setString(4, ape_cliente);
			pstmt.setString(5, direc_cliente);
			pstmt.setString(6, tel_cliente);

			respuestadb = pstmt.executeUpdate();

			conexion.desconectar();
			if (respuestadb > 0) {
				guardado = true;
			}
		} catch (Exception e) {
			System.out.println("no se pudo proceder" + e);
		}

		return guardado;
	}

	public boolean actualizar(String documento, String nombre, String correo, String usuario, String password) {

		String query = "UPDATE cliente SET nom_cliente = '" + nombre + "', email_cliente = '" + correo + "', \r\n"
				+ "usuario = '" + usuario + "', password = '" + password + "' WHERE doc_cliente = '" + documento + "';";

		boolean actualizado = false;
		int resultado = 0;

		try {
			Conexion conexion = new Conexion();
			Connection conn = conexion.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			// pstmt.setString(1, nombre);
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
