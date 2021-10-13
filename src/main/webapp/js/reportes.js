const URL_PUERTO = "http://localhost:8080"

$(document).ready(function () {
	$("#moduloVentas").hide();
    
	// ------------------------ listar usuarios -------------------------------------------
	$("#btn_listarU").click(function () {
		$.get(URL_PUERTO + "/todos", function (data, status) {
			const lista = data.respuesta;

			if (lista == null) {
				alert("no hay usuarios");

			} else {

				let salida = "<table>";
				salida = salida + "<tr><th>NOMBRE</th><th>EMAIL</th><th>USUARIO</th><th>DOCUMENTO</th></tr>";
				for (let i = 0; i < lista.length; i++) {
					salida = salida + "<tr>";
					salida = salida + "<td>" + lista[i].nom_usuario + "</td>";
					salida = salida + "<td>" + lista[i].email_usuario + "</td>";
					salida = salida + "<td>" + lista[i].usuario + "</td>";
					salida = salida + "<td>" + lista[i].doc_usuario + "</td>";
					salida = salida + "</tr>";
				}
				salida = salida + "</table>";
				$("#mensaje").html(salida);

			}
		});
	});
	//---------------------- lsitar clientes ---------------------------------
    $("#btn_listac").click(function () {

		$.get(URL_PUERTO + "/clienteTodos", function (data, status) {
			const lista = data.respuesta;

			if (lista == null) {
				alert("no hay clientes");

			} else {

				let salida = "<table>";
				salida = salida + "<tr><th>NOMBRE</th><th>APELLIDO</th><th>DIRECCION</th><th>EMAIL</th><th>TELEFONO</th><th>DOCUMENTO</th></tr>";
				for (let i = 0; i < lista.length; i++) {
					salida = salida + "<tr>";
					salida = salida + "<td>" + lista[i].nom_cliente + "</td>";
					salida = salida + "<td>" + lista[i].ape_cliente + "</td>";
					salida = salida + "<td>" + lista[i].direc_cliente + "</td>";
					salida = salida + "<td>" + lista[i].email_cliente + "</td>";
					salida = salida + "<td>" + lista[i].tel_cliente + "</td>";
					salida = salida + "<td>" + lista[i].doc_cliente + "</td>";
					salida = salida + "</tr>";
				}
				salida = salida + "</table>";
				$("#mensaje").html(salida);

			}
		});
	});
	$("#btn_ventasc").click(function(){

	$("#mensaje").html("");
	$("#form_botones").hide();
	$("#moduloVentas").slideDown(750);

	});

	$("#btn_buscarDetalle").click(function(){

		buscarDetalle();

	});

	function buscarDetalle(){
		let documento = $("#inp_cedulaC").val();
		if(documento == "" || documento ==" "  || documento <1 ){
			alert(" campo documento esta vacio o es un numero no valido ")
		}else{
			$.get(URL_PUERTO + "/buscarReporte",{DOC_CLIENTE: documento}, function (data, status) {
				const lista = data.reportes;
	
	
	
				if (lista == null || lista.length == 0) {
					alert("no hay ventas del cliente con doc: "+documento);
					$("#mensaje").html("")
	
				} else {
	
					let salida = "<table>";
					salida = salida + "<tr><th>codigo venta</th><th>cod producto</th><th>cantidad</th><th>nom Producto</th><th>nom proveedor</th><th>valor_total</th><th>valor_venta</th><th>valor_iva</th></tr>";
					for (let i = 0; i < lista.length; i++) {
						salida = salida + "<tr>";
						salida = salida + "<td>" + lista[i].codigo_venta + "</td>";
						salida = salida + "<td>" + lista[i].codigo_producto + "</td>";
						salida = salida + "<td>" + lista[i].cantidad_producto + "</td>";
						salida = salida + "<td>" + lista[i].nombre_Producto + "</td>";
						salida = salida + "<td>" + lista[i].nom_proveedor + "</td>";
						salida = salida + "<td>" + lista[i].valor_total + "</td>";
						salida = salida + "<td>" + lista[i].valor_venta + "</td>";
						salida = salida + "<td>" + lista[i].valor_iva + "</td>";
						salida = salida + "</tr>";
					}
					salida = salida + "</table>";
					$("#inp_nomCliente").val(lista[0].ape_cilente +" "+lista[0].nom_cliente);
					$("#mensaje").html(salida);
	
				}
			});
		};
		

	}

});
