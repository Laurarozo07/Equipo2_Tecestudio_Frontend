<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>clientes</title>
</head>
<body>
<header>
	<%@ include file="fragments/navbar.jsp"%>
</header>
<section>
<form action="menu.html" method="post">
        <label for="cedula">Cedula</label>
        <input type="text" name="cedula_cliente" placeholder="Ingrese su cedula"> 
        <br/>
        <label for="nombre">Nombre</label>
        <input type="text" name="nombre_cliente" placeholder="Ingrese su nombre completo">
        <br/>
        <label for="direccion">Direccion</label>
        <input type="text" name="direccion_cliente" placeholder="Ingrese su direccion">
        <br/>
        <label for="telefono">Telefono</label>
        <input type="tel" name="tel_cliente" placeholder="Ingrese su telefono">
        <br/>
        <label for="correo">Correo</label>
        <input type="text" name="email_cliente" placeholder="Ingrese su correo electronico">
        <br/>
        <input type="button" value="Consultar">
        <input type="button" value="Crear">
        <input type="button" value="Actualizar">
        <input type="button" value="Borrar">
    </form>
 </section>
 <footer></footer>   
    

</body>
</html>