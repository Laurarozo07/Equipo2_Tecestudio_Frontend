<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script
src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script type="text/javascript" src="js/ventas.js"></script>
<title>Ventas</title>
</head>
<body>

<header>
	<%@ include file="fragments/navbar.jsp"%>
</header>
<section>
<form >
    <div>
        <label for="inp_documento">Cedula</label>
        <input id="inp_documento" type="text" name="cedula_cliente" placeholder="Ingrese su cedula" >
        <div id="consecutivo" ></div>
        <input id="btn_consuCli"type="button" value="Consultar">
        <label for="cliente">Cliente</label>
        <input id="inp_nomCliente" type="text" name="nombre_cliente" placeholder="Ingrese su nombre">
        <label for="factura">Factura</label>
        <input id="inp_consec" type="text" name="num_factura">
    </div>
        <br/>
        <div>
        <label for="codigo">Codigo</label>
        <br/>
        <input type="text" name="cod_producto" placeholder="Ingrese codigo">
        <input  id="codigo1" type="button" value="Consultar">
        <br/>
        <input type="text" name="cod_producto" placeholder="Ingrese codigo">
        <input id="codigo2" type="button" value="Consultar">
        <br/>
        <input type="text" name="cod_producto" placeholder="Ingrese codigo">
        <input id="codigo3" type="button" value="Consultar">
    </div>
        <br/>
     <div>
        <label for="nombre producto">Nombre producto</label>
        <br/>
        <input id="nomProd1" type="text" name="nomb_producto" >
        <br/>
        <input id="nomProd2" type="text" name="nomb_producto" > 
        <br/>
        <input id="nomProd3" type="text" name="nomb_producto">
    </div>
        <br/>
        <div>
        <label for="cant">Cant</label>
        <br/>
        <input id="inp_cant1" type="text" name="cant_producto" >
        <br/>
        <input id="inp_cant2" type="text" name="cant_producto" >
        <br/>
        <input id="inp_cant3" type="text" name="cant_producto" >
    </div>
        <br/>
        <div>
        <label for="vlr total">Vlr total</label>
        <br/>
        <input id="valorT1" type="text" name="vlr_total">
        <br/>
        <input id="valorT2" type="text" name="vlr_total">
        <br/>
        <input id="valorT3" type="text" name="vlr_total">
    </div>
        <br/>
        <div>
        <label >Total venta</label>
        <input id="inp_totalVenta" type="text" name="valor total">
        <label for="total iva">valor total</label>
        <input id="inp_totalIva" type="text" name="total_iva">
        <label for="total con iva">valor venta</label>
        <input id="inp_valorVenta" type="text" name="valor venta">
    </div>
        <br/>
         <input id="btn_confirmar" type="submit" value="Confirmar">
        
    </form>
</section>
<footer></footer>
	
	
</body>
</html>