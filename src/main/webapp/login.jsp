<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>logIn</title>

<link rel="icon" type="image/png" href="image/favicon-196x196.png" sizes="196x196" />
<link rel="icon" type="image/png" href="image/favicon-96x96.png" sizes="96x96" />
<link rel="icon" type="image/png" href="image/favicon-16x16.png" sizes="16x16" />
<link rel="icon" type="image/png" href="image/favicon-128.png" sizes="128x128" />
<script
src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script type="text/javascript" src="js/login.js"></script><!-- Incorporo al proyecto javascript -->
<link href="css/login.css" rel="stylesheet" type="text/css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" >
<link href="https://fonts.googleapis.com/css2?family=Oswald:wght@700&display=swap" rel="stylesheet">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Lato:ital,wght@1,700&display=swap" rel="stylesheet">

</head>
<body>
<h1>TecEstudio</h1>
<form>
<table>
<tr>
<td><label>Usuario:</label></td>
<td><input Id="usuario" type="text" value=""></td>
</tr>
<tr>
<td><label>Clave:</label></td>
<td><input Id="password" type="password" value=""></td>
</tr>
<tr><td><input type="button" value="Enviar"
id="btn_Enviaru"></td></tr>
<!-- <tr><td><button id="btnEnviar" class="w3-
button">Enviar</button></td></tr>-->
</table>
</form>
</body>
</html>