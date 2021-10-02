<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ventas</title>
</head>
<body>

<header>
	<%@ include file="fragments/navbar.jsp"%>
</header>
<section>
<form action="" method="post">
    <div>
        <label for="cedula">Cedula</label>
        <input type="text" name="cedula_cliente" placeholder="Ingrese su cedula">
        <input type="button" value="Consultar">
        <label for="cliente">Cliente</label>
        <input type="text" name="nombre_cliente" placeholder="Ingrese su nombre">
        <label for="factura">Factura</label>
        <input type="text" name="num_factura">
    </div>
        <br/>
        <div>
        <label for="codigo">Codigo</label>
        <br/>
        <input type="text" name="cod_producto" placeholder="Ingrese codigo">
        <input type="button" value="Consultar">
        <br/>
        <input type="text" name="cod_producto" placeholder="Ingrese codigo">
        <input type="button" value="Consultar">
        <br/>
        <input type="text" name="cod_producto" placeholder="Ingrese codigo">
        <input type="button" value="Consultar">
    </div>
        <br/>
     <div>
        <label for="nombre producto">Nombre producto</label>
        <br/>
        <input type="text" name="nomb_producto" >
        <br/>
        <input type="text" name="nomb_producto" > 
        <br/>
        <input type="text" name="nomb_producto">
    </div>
        <br/>
        <div>
        <label for="cant">Cant</label>
        <br/>
        <input type="text" name="cant_producto" >
        <br/>
        <input type="text" name="cant_producto" >
        <br/>
        <input type="text" name="cant_producto" >
    </div>
        <br/>
        <div>
        <label for="vlr total">Vlr total</label>
        <br/>
        <input type="text" name="vlr_total">
        <br/>
        <input type="text" name="vlr_total">
        <br/>
        <input type="text" name="vlr_total">
    </div>
        <br/>
        <div>
        <label for="total venta">Total venta</label>
        <input type="text" name="total">
        <label for="total iva">Total iva</label>
        <input type="text" name="total_iva">
        <label for="total con iva">Total con iva</label>
        <input type="text" name="total_factura">
    </div>
        <br/>
         <input type="submit" value="Confirmar">
        
    </form>
</section>
<footer></footer>
	
	
</body>
</html>