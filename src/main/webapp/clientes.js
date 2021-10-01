const URL_PUERTO = "http://localhost:8080"

$(document).ready(function () {

	$("#btn_test").click(function () {
		let test = document.getElementById("inp_test").value;
		$.post("http://localhost:8080/test", { text: test }, function (data, status) {
			$("#mensaje").html("test ok " + data.respuesta);
		});


	});

	$("#listarC").click(function () {

		$.get(URL_PUERTO + "/clientetodos", function (data, status) {
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

	$("#buscarC").click(function () {
		let doc = $("#inp_documento").val();
		if (doc == "") {
			alert("campo Cedula esta vacio")
		}else{
			$.get(URL_PUERTO + "/clienteBuscar", { doc_usuario: doc }, function (data, status) {
				const lista = data.respuesta;

				if (lista == null) {
					$("#mensaje").html("<b style='color:red;'>no se encontro el cliente !!!</br>")
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

						$("#inp_nombre").val(lista[i].nom_cliente);
						$("#inp_apellido").val(lista[i].ape_cliente);
						$("#inp_direccion").val(lista[i].direc_cliente);
						$("#inp_email").val(lista[i].email_cliente);
						$("#inp_telefono").val(lista[i].tel_client);
						$("#inp_documento").val(lista[i].doc_cliente);

					}
					salida = salida + "</table>";
					$("#mensaje").html(salida);

				};

			});
		};

	});

	$("#agregarC").click(function () {

		let nombre = $("#inp_nombre").val();
		let apellido = $("#inp_apellido").val();
		let direccion = $("#inp_direccion").val();
		let email = $("#inp_email").val();
		let telefono = $("#inp_telefono").val();
		let documento = $("#inp_documento").val();

		if (nombre == "" || apellido == "" || direccion == "" || email == "" || telefono == ""|| documento == "") {
			alert("por favor llenar todos los campos");
		} else {
			$.post(URL_PUERTO + "/clienteGuardar", {
				nom_cliente: nombre,ape_cliente: apellido, direc_cliente: direccion,
				 email_cliente: email, tel_cliente: telefono, doc_cliente: documento
			}, function (data, status) {

				var respuesta = data.guardado;

				if (respuesta) {
					$("#mensaje").html("el cliente fue guardado");
				} else {
					$("#mensaje").html("el cliente no se logro guardar");
				};

			});
		};
	});


	$("#actualizarC").click(function () {

		let nombre = $("#inp_nombre").val();
		let apellido = $("#inp_apellido").val();
		let direccion = $("#inp_direccion").val();
		let email = $("#inp_email").val();
		let telefono = $("#inp_telefono").val();
		let documento = $("#inp_documento").val();

		if (nombre == "" || apellido == "" || direccion == "" || email == "" || telefono == ""|| documento == "") {
			alert("Datos faltantes");
		} else {
			$.post(URL_PUERTO + "/clienteActualizar", {
				nom_cliente: nombre,ape_cliente: apellido, direc_cliente: direccion,
				 email_cliente: email, tel_cliente: telefono, doc_cliente: documento
			}, function (data, status) {

				var respuesta = data.actualizado;
				if (respuesta) {
					$("#mensaje").html("el cliente fue actualizado");
				} else {
					$("#mensaje").html("<b style='color:red;'>No se puedo actualizar, NO existe !!!!</b>");

				}
			});
		};


	});

	$("#eliminarU").click(function () {
		let elid = $("#inp_documento").val();
		if (elid == "") {
			alert(" campo Cedula esta vacio ")
		} else {
			$.post(URL_PUERTO + "/clienteEliminar", { doc_cliente: elid }, function (data, status) {

				var respuesta = data.eliminado
				if (respuesta == true) {
					$("#mensaje").html("El cliente fue eliminado");
				} else {
					$("#mensaje").html("<b style= 'color:red;'>No se pudo eliminar, No existe !!!</b>");

				}
			});
		};

	});
});
