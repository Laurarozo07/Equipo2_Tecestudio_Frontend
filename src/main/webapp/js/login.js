$(document).ready(function () {
    $("#btn_Enviaru").click(function () {//El evento
        let elUsuario =
            document.getElementById("usuario").value;//trae el valor del imput con el id usuario
        let laClave =
            document.getElementById("password").value;//trae el valor del imput co el id password
        
        if (elUsuario == ""  && laClave == "" ){
            alert("ambos campos estan vacios");
        }else if(laClave == "" ){
            alert("la contraseña esta vacia");
        }else if(elUsuario == "" ){
            alert(" el usuario esta vacio");
        }else{
            $.post("http://localhost:5000/loginusuario2", {
                usuario: elUsuario, password: laClave
            },
                function (data, status) {
                    // data1 = $.parseJSON( data );
                    if (data.existe == true) {
                        alert("Bienvenido " + elUsuario);
                        window.location.href =
                            "menu.jsp";
                    }
                    else {
                        alert("Usuario o clave incorrectos ");
                    }
                });
        };
            
       
    });
    function mostrarUno(item, index) {
        let valores = Object.values(item);

        $("#usuario").val(valores[0]);
        $("#password").val(valores[1]);
    }
});