<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reportes</title>
</head>
<body>
<header>
	<%@ include file="fragments/navbar.jsp"%>
</header>
<section>
     <button class="btn_listau" role="link" onclick="window.location='#'">Listado De Usuarios</button>
    <br>
    <button class="btn_listac" role="link" onclick="window.location='#'">Listado De Clientes</button>
    <br>
    <button class="btn_ventasc" role="link" onclick="window.location='#'">Ventas Por Cliente</button>
</section>
<footer></footer>

</body>
</html>