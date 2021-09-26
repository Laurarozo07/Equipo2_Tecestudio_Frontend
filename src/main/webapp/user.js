$(document).ready(function(){
	
$("#btn_test").click(function(){
	let test = document.getElementById("inp_test").value;
	$.post("http://localhost:8080/test",{text: test},function(data, status){
		$("#mensaje").html("test ok "+data.respuesta);
	});
	
	
});	
		
$("#listarU").click(function(){
	
	$.get("http://localhost:8080/todos",function(data, status){
		const lista = data.respuesta;
		
		if (lista.isempty){
			alert("no hay usuarios");	
		
		}else{
		
			let salida = "<table>";
			salida = salida + "<tr><th>NOMBRE</th><th>EMAIL</th><th>USUARIO</th><th>CLAVE</th><th>DOCUM</th></tr>";
			for (let i=0; i<lista.length;i++){
				salida = salida + "<tr>";
				salida = salida + "<td>" + lista[i].nom_usuario+ "</td>";
				salida = salida + "<td>" + lista[i].email_usuario+ "</td>";
				salida = salida + "<td>" + lista[i].usuario+ "</td>";
				salida = salida + "<td>" + lista[i].password + "</td>";
				salida = salida + "<td>" + lista[i].doc_usuario+ "</td>";
				salida = salida + "</tr>";
			}
			salida = salida +"</table>";
			$("#mensaje").html(salida);

		}
	});
});

$("#buscarU").click(function(){
	let doc = document.getElementById("inp_documento").value;

	$.post("http://localhost:8080/buscar",{doc_usuario: doc }, function(data, status){
		const lista = data.respuesta;

		if(lista == null){
			$("#mensaje").html("<b style='color:red;'>no se encontro al usuario !!!</br>")
		}else{
			let salida = "<table>";
			salida = salida + "<tr><th>NOMBRE</th><th>EMAIL</th><th>USUARIO</th><th>CLAVE</th><th>DOCUM</th></tr>";
			for (let i=0; i<lista.length;i++){
				salida = salida + "<tr>";
				salida = salida + "<td>" + lista[i].nom_usuario+ "</td>";
				salida = salida + "<td>" + lista[i].email_usuario+ "</td>";
				salida = salida + "<td>" + lista[i].usuario+ "</td>";
				salida = salida + "<td>" + lista[i].password + "</td>";
				salida = salida + "<td>" + lista[i].doc_usuario+ "</td>";
				salida = salida + "</tr>";
			}
			salida = salida +"</table>";
			$("#mensaje").html(salida);

		}
		

		 
	});
});

$("#agregarU").click(function(){
	let elid = $("#id").val();
	let nombre = $("#nom").val();
	let correo = $("#email").val();
	let elusuario = $("#usuario").val();
	let laclave = $("#password").val ();
	let doc = $("#docu").val();
	
	$.post("http://localhost:3036/guardar",{id_usuario:elid,nom_usuario: nombre,
	email_usuario: correo, usuario:elusuario, password: laclave, doc_usuario:doc},function(data, status){
		if (data==true){
			$("#mensaje").html("el usuario fue creado.");
			
		}else{
			$("#mensaje").html("<b style='color:red;'>No se pudo crear, ya existe !!!</br>")
		}
	});
});


$("#actualizarU").click(function(){
	let elid = $("#id").val();
	let nombre = $("#nom").val();
	let correo = $("#email").val();
	let elusuario = $("#usuario").val();
	let laclave = $("#password").val ();
	let doc = $("#docu").val();
	$.post("http://localhost:3036/actualizar",{id_usuario:elid,nom_usuario: nombre,
	email_usuario: correo, usuario:elusuario, password: laclave, doc_usuario:doc},function(data, status){
		if (data == true){
			$("#mensaje").html("el usuario fue actualizado");
		}else{
			$("#mensaje").html("<b style='color:red;'>No se puedo actualizar, NO existe !!!!</b>");
			
		}
	});
});


$("#eliminarU").click(function(){
	let elid = $("#id").val();
	$.post("http://localhost:3036/borrar",{id_usuario: elid},function(data,status){
		if (data == true){
			$("#mensaje").html("El usuario fue eliminado");
		}else{
			$("#mensaje").html("<b style= 'color:red;'>No se pudo eliminar, No existe !!!</b>");
			
		}
	});
});
});
