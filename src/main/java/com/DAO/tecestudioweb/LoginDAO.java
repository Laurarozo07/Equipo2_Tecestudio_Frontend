package com.DAO.tecestudioweb;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import com.DAO.tecestudioweb.*;
import com.DTO.tecestudioweb.*;

public class LoginDAO {
	
	private static long userId = 1;
	
	public LoginDAO(){}

	
	public ArrayList<LoginVO> consultarUsuario(String usuario, String password) {
		 ArrayList<LoginVO> miusuario = new ArrayList<LoginVO>();//Crea el objeto arryList
		 Conexion conex= new Conexion();
		 try {
		 String cadenaSQL="SELECT * FROM usuario where usuario =? and password=?";
		 PreparedStatement consulta =
		conex.getConnection().prepareStatement(cadenaSQL);

		 consulta.setString(1, usuario);//el orden de los ?
		 consulta.setString(2, password);
		 ResultSet res = consulta.executeQuery();

		 if(res.next()){
		 LoginVO usuario1= new LoginVO();
		 userId = res.getLong("ID_USUARIO");
		 usuario1.setUsuario(res.getString("usuario"));//lee la BD
		 usuario1.setClave(res.getString("password"));
		 miusuario.add(usuario1);//agregar a la lista el usuario encontrado en la BD
		 }
		 res.close();
		 consulta.close();
		 conex.desconectar();
		 } catch (Exception e) {
		 JOptionPane.showMessageDialog(null, "no se pudo consultar El usuario\n"+e);
		 }
		 return miusuario;
		}
	
	public long traerId(){
		return userId;
	}
}
