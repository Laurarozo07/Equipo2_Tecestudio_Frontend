<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="css/main.css" rel="stylesheet" type="text/css">
<script
src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script type="text/javascript" src="js/importcsv.js"></script>
</head>
<body>
<header>
	<%@ include file="fragments/navbar.jsp"%>
</header>
<section>
  <form name="formulario" method="get" action="/csv_data.csv" enctype="multipart/form-data">
     <div>
         <input id="archivoCSV" type="file" name="adjunto"> 
         <br/>
        <input type="submit" value="Cargar">
     </div>
    </form>
</section>
<footer></footer>
	
	
</body>
</html>