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