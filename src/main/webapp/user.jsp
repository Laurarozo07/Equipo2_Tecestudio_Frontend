<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>usuarios</title>
<script
src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script src="user.js"></script>
</head>
<body>
	<header>
		<%@ include file="fragments/navbar.jsp"%>
	</header>
	<section>
	<form>
	        <label for="inp_documento">Cedula</label>
	        <input id="inp_documento" type="text" placeholder="Ingrese su cedula">
	        <br/>
	        <label for="inp_nombre">Nombre</label>
	        <input id="inp_nombre" type="text" placeholder="Ingrese su nombre completo">
	        <br/>
	        <label for="inp_email">Correo</label>
	       <input id="inp_email" type="text" placeholder="Ingrese su correo">
	        <br/>
	        <label for="inp_usuario">Usuario</label>
	        <input id="inp_usuario" type="text" placeholder="Ingrese el ususario">
	        <br/>
	        <label for="inp_password">Contraseña</label>
	        <input id="inp_password" type="password" placeholder="Ingrese la contraseña">
	        <br/>
	        
	        <input id="buscarU" type="button" value="Consultar">
	        <input id="agregarU" type="button" value="Crear">
	        <input id="actualizarU" type="button" value="Actualizar">
	        <input id="eliminarU" type="button" value="Borrar">
	        <input id="listarU" type="button" value="todos">
	        <button type="reset" >limpiar</button> 
     
    	</form>
    </section>
    <div id="mensaje">
    </div>

	<footer></footer>
</body>
</html>