<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reportes</title>

<link rel="icon" type="image/png" href="image/favicon-196x196.png" sizes="196x196" />
<link rel="icon" type="image/png" href="image/favicon-96x96.png" sizes="96x96" />
<link rel="icon" type="image/png" href="image/favicon-16x16.png" sizes="16x16" />
<link rel="icon" type="image/png" href="image/favicon-128.png" sizes="128x128" />

<script
src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script type="text/javascript" src="js/reportes.js"></script>
<link href="css/main.css" rel="stylesheet" type="text/css">
</head>
<body>
<header>
	<%@ include file="fragments/navbar.jsp"%>
</header>
<section>
    <form id="form_botones">
    	<button id="btn_listarU" type="button" value="usuarios" >Listado De Usuarios</button>
	    <br>
	    <button id="btn_listac" type="button" value="clientes" >Listado De Clientes</button>
	    <br>
	    <button id="btn_ventasc" type="button" value="ventas" >Ventas Por Cliente</button>
    </form>    
</section>
<section id="moduloVentas" >
	<label>cedula del cliente</label>
	<input id="inp_cedulaC" name="cedulaC" type="number" min="1">
	<button id="btn_buscarDetalle" type="button" value="detalle" >buscar</button>
	<input id="inp_nomCliente" disabled="disabled" >
</section>

<section>
	<div id="mensaje" ></div>
</section>
<footer></footer>

</body>
</html>