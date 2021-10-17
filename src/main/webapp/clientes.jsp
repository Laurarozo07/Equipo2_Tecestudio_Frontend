<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>clientes</title>

<link rel="icon" type="image/png" href="image/favicon-196x196.png" sizes="196x196" />
<link rel="icon" type="image/png" href="image/favicon-96x96.png" sizes="96x96" />
<link rel="icon" type="image/png" href="image/favicon-16x16.png" sizes="16x16" />
<link rel="icon" type="image/png" href="image/favicon-128.png" sizes="128x128" />

<link href="css/styleform.css" rel="stylesheet" type="text/css">
<link href="css/menu.css" rel="stylesheet" type="text/css">
<script
src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script type="text/javascript" src="js/clientes.js"></script>
</head>
<body>
<header>
	<%@ include file="fragments/navbar.jsp"%>
</header>
<section class="container">
<form >
	<div class="input_section">
		<div class="row">
	<label for="inp_documento" class="label">Cedula</label>
        <input id="inp_documento" class="input" type="text" name="cedula_cliente" placeholder="Ingrese su cedula"> 
	</div>
	<br/>
	<div class="row">
		<label for="inp_nombre" class="label">Nombre</label>
        <input id="inp_nombre" class="input" type="text" name="nombre_cliente" placeholder="Ingrese su nombre completo">
	</div>
	<br/>
    <div class="row">
    	<label for="inp_apellido" class="label">apellido</label>
        <input id="inp_apellido" class="input" type="text" name="apellido_cliente" placeholder="Ingrese su apellido completo">
	</div>
	<br/>
	<div class="row">
		<label for="inp_direccion" class="label">Direccion</label>
        <input id="inp_direccion" class="input" type="text" name="direccion_cliente" placeholder="Ingrese su direccion">
	</div>
	<br/>
	<div class="row">
		<label for="inp_telefono" class="label">Telefono</label>
        <input id="inp_telefono" class="input" type="tel" name="tel_cliente" placeholder="Ingrese su telefono">
	</div>
	<br/>
	<div class="row">
		<label for="inp_email" class="label">Correo</label>
        <input id="inp_email" class="input" type="text" name="email_cliente" placeholder="Ingrese su correo electronico">
	</div>
	<br/>
	</div>
	
      <section class="action_buttons" >
      	<input id="buscarC" type="button" value="Consultar">
        <input id="agregarC" type="button" value="Crear">
        <input id="actualizarC" type="button" value="Actualizar">
        <input id="eliminarU" type="button" value="Borrar">
        <input id="listarC" type="button" value="Todos" >
        <button type="reset" >Limpiar</button>
      </section>
        
    </form>
    <div id="mensaje"></div>
 </section>
 
 <footer></footer>   
    

</body>
</html>