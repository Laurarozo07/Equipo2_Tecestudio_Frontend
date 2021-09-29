<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<header>
	<%@ include file="fragments/navbar.jsp"%>
</header>
<section>
  <form name="formulario" method="post" action="/send.php" enctype="multipart/form-data">
     <div>
         <input type="file" name="adjunto"> 
         <br/>
        <input type="submit" value="Cargar">
     </div>
    </form>
</section>
<footer></footer>
	
	
</body>
</html>