<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Proveedores</title>

<link rel="icon" type="image/png" href="image/favicon-196x196.png" sizes="196x196" />
<link rel="icon" type="image/png" href="image/favicon-96x96.png" sizes="96x96" />
<link rel="icon" type="image/png" href="image/favicon-16x16.png" sizes="16x16" />
<link rel="icon" type="image/png" href="image/favicon-128.png" sizes="128x128" />
<link href="css/menu.css" rel="stylesheet" type="text/css">
<link href="css/styleform.css" rel="stylesheet" type="text/css">

<script
src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script type="text/javascript" src="js/proveedores.js"></script>




</head>
<body>
<header>
	<%@ include file="fragments/navbar.jsp"%>
</header>
<section class="container">
	<form>
		<div id="row">
			<label for="inp_nit" class="label">Nit</label>
        	<input id="inp_nit" class="input" type="text"  name="nit_prov" placeholder="Ingrese su Nit"> 
		</div>
		<br/>
		<br/>
		<div id="row">
			
			<label for="inp_nom" class="label">Nombre</label>
        	<input id="inp_nom" class="input" type="text"  name="nombre_prov" placeholder="Ingrese su nombre completo">
		</div>
		<br/>
		<br/>
		<div id="row">
			<label for="inp_email" class="label">email</label>
        	<input id="inp_email" class="input" type="email" name="email_prov" placeholder="Ingrese su correo">
		</div>
		<br/>
		<br/>
		<div id="row">
			 <label for="inp_dir" class="label">Direccion</label>
        	<input id="inp_dir" class="input" type="text" name="direccion_prov" placeholder="Ingrese su direccion">
		</div>
		<br/>
		<br/>
		<div id="row">
			 <label for="inp_tel" class="label">Telefono</label>
        	<input id="inp_tel" class="input" type="tel" name="tel_prov" placeholder="Ingrese su telefono">
		</div>
		<br/>
		<br/>
		<div id="row">
			<label for="inp_ciud" class="label">Ciudad</label>
       		<input id="inp_ciud" class="input" type="text" name="ciudad_prov" placeholder="Ingrese su ciudad">
		</div>
		<br/>
		<br/>
		<section class="action_buttons" >
	        <input id="btn_buscar" type="button" value="Consultar">
	        <input id="btn_guardar" type="button" value="Crear">
	        <input id="btn_actualizar" type="button" value="Actualizar">
	        <input id="btn_eliminar" type="button" value="Borrar">
	        <input id="btn_listar" type="button" value="Todos">
	        <button type="reset">Limpiar</button>
	   	</section>
    </form>
    <section class="result">
    	<div id="mensaje"></div>

    </section>
</section>
	

</body>
</html>