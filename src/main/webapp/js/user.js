const URL_PUERTO = "http://18.212.90.18:8080/tecestudioweb-0.0.1-SNAPSHOT"

$(document).ready(function () {

	$("#btn_test").click(function () {
		let test = document.getElementById("inp_test").value;
		$.post("http://18.212.90.18:8080/tecestudioweb-0.0.1-SNAPSHOT", { text: test }, function (data, status) {
			$("#mensaje").html("test ok " + data.respuesta);
		});


	});

	$("#listarU").click(function () {

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

	$("#buscarU").click(function () {
		let doc = $("#inp_documento").val();
		if (doc == "") {
			alert("campo Cedula esta vacio")
		} else {
			$.get(URL_PUERTO + "/buscar", { doc_usuario: doc }, function (data, status) {
				const lista = data.respuesta;

				if (lista == null) {
					$("#mensaje").html("<b style='color:red;'>no se encontro al usuario !!!</br>")
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

						$("#inp_nombre").val(lista[i].nom_usuario);
						$("#inp_email").val(lista[i].email_usuario);
						$("#inp_usuario").val(lista[i].usuario);
						$("#inp_password").val(lista[i].password);
						$("#inp_documento").val(lista[i].doc_usuario);

					}
					salida = salida + "</table>";
					$("#mensaje").html(salida);

				};

			});
		};

	});

	$("#agregarU").click(function () {

		let nombre = $("#inp_nombre").val();
		let correo = $("#inp_email").val();
		let elusuario = $("#inp_usuario").val();
		let laclave = $("#inp_password").val();
		let doc = $("#inp_documento").val();

		if (nombre == "" || correo == "" || elusuario == "" || laclave == "" || doc == "") {
			alert("por favor llenar todos los campos");
		} else {
			$.post(URL_PUERTO + "/guardar", {
				nom_usuario: nombre,
				email_usuario: correo, usuario: elusuario, password: laclave, doc_usuario: doc
			}, function (data, status) {

				var respuesta = data.guardado;

				if (respuesta) {
					$("#mensaje").html("el usuario fue guardado");
				} else {
					$("#mensaje").html("el usuario no se logro guardar");
				};

			});
		};
	});


	$("#actualizarU").click(function () {

		let nombre = $("#inp_nombre").val();
		let correo = $("#inp_email").val();
		let elusuario = $("#inp_usuario").val();
		let laclave = $("#inp_password").val();
		let doc = $("#inp_documento").val();

		if (nombre == "" || correo == "" || elusuario == "" || laclave == "" || doc == "") {
			alert("Datos faltantes");
		} else {
			$.post(URL_PUERTO + "/actualizar", {
				doc_usuario: doc, nom_usuario: nombre,
				email_usuario: correo, usuario: elusuario, password: laclave
			}, function (data, status) {

				var respuesta = data.actualizado;
				if (respuesta) {
					$("#mensaje").html("el usuario fue actualizado");
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
		} else if (elid == "1013689281") {
			alert(" no se puede elminar al administrador ")
		 }
				else {
					$.post(URL_PUERTO + "/eliminar", { doc_usuario: elid }, function (data, status) {

						var respuesta = data.eliminado
						if (respuesta == true) {
							$("#mensaje").html("El usuario fue eliminado");
						} else {
							$("#mensaje").html("<b style= 'color:red;'>No se pudo eliminar, No existe !!!</b>");

						}
					});
				};

	});
});
