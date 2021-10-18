<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>usuarios</title>

<link rel="icon" type="image/png" href="image/favicon-196x196.png" sizes="196x196" />
<link rel="icon" type="image/png" href="image/favicon-96x96.png" sizes="96x96" />
<link rel="icon" type="image/png" href="image/favicon-16x16.png" sizes="16x16" />
<link rel="icon" type="image/png" href="image/favicon-128.png" sizes="128x128" />

<script
src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script type="text/javascript" src="js/user.js"></script>

<link href="css/styleform.css" rel="stylesheet" type="text/css">
<link href="css/menu.css" rel="stylesheet" type="text/css">
</head>
<body>
	<header>
		<%@ include file="fragments/navbar.jsp"%>
	</header>
	<section class="container">
	<form>
		<div class="row">
	        <label for="inp_documento" class="label">Cedula</label>
	        <input id="inp_documento" class="input" type="text" placeholder="Ingrese su cedula">
	    </div>
		<br/>
		<div class="row">
	        <label for="inp_nombre" class="label">Nombre</label>
	        <input id="inp_nombre" class="input" type="text" placeholder="Ingrese su nombre completo">
	    </div>    
		<br/>
		<div class="row">
	        <label for="inp_email" class="label">Correo</label>
	       <input id="inp_email" class="input" type="text" placeholder="Ingrese su correo">
	    </div>
		<br/>
		<div class="row">
	        <label for="inp_usuario" class="label">Usuario</label>
	        <input id="inp_usuario" class="input" type="text" placeholder="Ingrese el ususario">
	    </div>
		<br/>
		<div class="row">
	        <label for="inp_password" class="label">Contraseña</label>
	        <input id="inp_password" class="input" type="password" placeholder="Ingrese la contraseña">
	    </div>   
	    <br/>
	      <section class="action_buttons" >
	        <input id="buscarU" type="button" value="Consultar">
	        <input id="agregarU" type="button" value="Crear">
	        <input id="actualizarU" type="button" value="Actualizar">
	        <input id="eliminarU" type="button" value="Borrar">
	        <input id="listarU" type="button" value="Todos">
	        <button type="reset" >Limpiar</button> 
     	  </section>
    	</form>
    	<section class="result">
    		<div id="mensaje"></div>
    	</section>
    
    </section>
    
   

	<footer></footer>
</body>
</html>