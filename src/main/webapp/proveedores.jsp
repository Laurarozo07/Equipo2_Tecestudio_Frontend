<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Proveedores</title>
<script
src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script type="text/javascript" src="proveedores.js"></script>
</head>
<body>
<header>
	<%@ include file="fragments/navbar.jsp"%>
</header>
<section>
<form action="menu.html" method="post">
        <label for="inp_nit">Nit</label>
        <input id="inp_nit" type="text"  name="nit_prov" placeholder="Ingrese su Nit"> 
        <br/>
        <label for="nombre">Nombre</label>
        <input id="inp_nom" type="text"  name="nombre_prov" placeholder="Ingrese su nombre completo">
        <br/>
        <label for="inp_email">email</label>
        <input id="inp_email" type="email" name="email_prov" placeholder="Ingrese su correo">
        <br/>
        <label for="direccion">Direccion</label>
        <input id="inp_dir" type="text" name="direccion_prov" placeholder="Ingrese su direccion">
        <br/>
        <label for="telefono">Telefono</label>
        <input id="inp_tel" type="tel" name="tel_prov" placeholder="Ingrese su telefono">
        <br/>
        <label for="ciudad">Ciudad</label>
        <input id="inp_ciud" type="text" name="ciudad_prov" placeholder="Ingrese su ciudad">
        <br/>
        <input id="btn_buscar" type="button" value="Consultar">
        <input id="btn_guardar" type="button" value="Crear">
        <input id="btn_actualizar" type="button" value="Actualizar">
        <input id="btn_eliminar" type="button" value="Borrar">
        <input id="btn_listar" type="button" value="Todos">
        <button type="reset">Limpiar</button>
    </form>
</section>
<section>
	<div id="mensaje"></div>
</section>

</body>
</html>