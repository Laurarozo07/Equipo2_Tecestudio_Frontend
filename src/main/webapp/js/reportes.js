const URL_PUERTO = "http://localhost:8080"

$(document).ready(function () {
    
	
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

});
