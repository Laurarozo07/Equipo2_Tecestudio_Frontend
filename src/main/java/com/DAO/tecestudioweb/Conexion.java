package com.DAO.tecestudioweb;

import java.sql.*;

public class Conexion {
	
	/**Parametros de conexion*/

	static String bd = "grupo16_equipo2";
	 static String login = "admin";
	 //static String password = "admin";
	 static String password = "tiendagenericamaoe2";
	 static String url = "jdbc:mysql://tiendagenericamaoe2.czo3ixoe3xoe.us-east-1.rds.amazonaws.com/"+bd;
	 Connection connection = null;
	 /** Constructor de DbConnection */
	 public Conexion() {
	 try{
	 //obtenemos el driver de para mysql
	 Class.forName("com.mysql.cj.jdbc.Driver");


	 //obtenemos la conexión
	 connection = DriverManager.getConnection(url,login,password);
	 if (connection!=null){
		 
	 }
	 }
	 catch(SQLException e){
	 System.out.println(e);
	 }catch(ClassNotFoundException e){
	 System.out.println(e);
	 }catch(Exception e){
	 System.out.println(e);
	 }
	 }
	 /**Permite retornar la conexión*/
	 public Connection getConnection(){
	 return connection;
	 }
	 public void desconectar(){
	 connection = null;
	 }


}
