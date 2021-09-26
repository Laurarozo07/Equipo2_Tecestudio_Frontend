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
<script src="user.js"></script>
</head>
<body>
<form>
        <label for="inp_documento">Cedula</label>
        <input id="inp_documento" type="text" placeholder="Ingrese su cedula">
        <br/>
        <label for="nombre">Nombre</label>
        <input type="text" placeholder="Ingrese su nombre completo">
        <br/>
        <label for="correo">Correo</label>
        <input type="text" placeholder="Ingrese su correo">
        <br/>
        <label for="usuario">Usuario</label>
        <input type="text" placeholder="Ingrese el ususario">
        <br/>
        <label for="contraseña">Contraseña</label>
        <input type="text" placeholder="Ingrese la contraseña">
        <br/>
        <label>cualquier cosa</label>
        <input type="text" id="inp_test" ><!-- test2 -->
        
        <input id="buscarU" type="button" value="Consultar">
        <input type="button" value="Crear">
        <input type="button" value="Actualizar">
        <input type="button" value="Borrar">
        <input id="listarU" type="button" value="todos">
        <input id="btn_test" type="button" value="test"  > <!-- test2 -->
        
        
    </form>
    <div id="mensaje">
    </div>

</body>
</html>