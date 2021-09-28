<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script
src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script type="text/javascript" src="proveedores.js"></script>
</head>
<body>
<header>
</header>
<section>
<form action="menu.html" method="post">
        <label for="nit_prov">Nit</label>
        <input type="text"  name="nit_prov" placeholder="Ingrese su Nit"> 
        <br/>
        <label for="nombre">Nombre</label>
        <input type="text"  name="nombre_prov" placeholder="Ingrese su nombre completo">
        <br/>
        <label for="direccion">Direccion</label>
        <input type="text" name="direccion_prov" placeholder="Ingrese su direccion">
        <br/>
        <label for="telefono">Telefono</label>
        <input type="tel" name="tel_prov" placeholder="Ingrese su telefono">
        <br/>
        <label for="ciudad">Ciudad</label>
        <input type="text" name="ciudad_prov" placeholder="Ingrese su ciudad">
        <br/>
        <input type="button" value="Consultar">
        <input type="button" value="Crear">
        <input type="button" value="Actualizar">
        <input type="button" value="Borrar">
        <input id="btn_listar" type="button" value="todos">
    </form>
</section>
<section>
	<div id="mensaje"></div>
</section>

</body>
</html>