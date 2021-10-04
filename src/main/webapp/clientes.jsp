<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>clientes</title>
<link href="css/main.css" rel="stylesheet" type="text/css">
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
<section>
<form action="menu.html" method="post">
        <label for="cedula">Cedula</label>
        <input id="inp_documento" type="text" name="cedula_cliente" placeholder="Ingrese su cedula"> 
        <br/>
        <label for="nombre_cliente">Nombre</label>
        <input id="inp_nombre" type="text" name="nombre_cliente" placeholder="Ingrese su nombre completo">
        <br/>
        <label for="apellido_cliente">apellido</label>
        <input id="inp_apellido" type="text" name="apellido_cliente" placeholder="Ingrese su apellido completo">
        <br/>
        <label for="direccion">Direccion</label>
        <input id="inp_direccion" type="text" name="direccion_cliente" placeholder="Ingrese su direccion">
        <br/>
        <label for="telefono">Telefono</label>
        <input id="inp_telefono" type="tel" name="tel_cliente" placeholder="Ingrese su telefono">
        <br/>
        <label for="correo">Correo</label>
        <input id="inp_email" type="text" name="email_cliente" placeholder="Ingrese su correo electronico">
        <br/>
        <input id="buscarC" type="button" value="Consultar">
        <input id="agregarC" type="button" value="Crear">
        <input id="actualizarC" type="button" value="Actualizar">
        <input id="eliminarU" type="button" value="Borrar">
        <input id="listarC" type="button" value="Todos" >
        <button type="reset" >Limpiar</button>
    </form>
    <div id="mensaje"></div>
 </section>
 <footer></footer>   
    

</body>
</html>