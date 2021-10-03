/**
 * se encarga de llamar al backend para mostrar los detos de porveedores 
 */

const URL_PUERTO = 'http://localhost:8080'
$(document).ready(function () {
    //-------------------------------------- metodo buscar todos ------------------------------------------------------------
    /**
     * medodo mostrar todes los proveedores
     */
    $("#btn_listar").click(function () {

        $.get(URL_PUERTO + '/proveedorTodos', function (data, status) {

            let lista = data.respuesta

            if (lista.isempty) {
                alert("no hay proveedores");
            } else {
                let salida = "<table>"
                salida += "<tr><th>NIT</th><th>NOMBRE</th><th>EMAIL</th><th>CIUDAD</th><th>DIRECCION</th><th>TELEFONO</th></tr>";
                for (let i = 0; i < lista.length; i++) {

                    salida += "<tr>"
                    salida += "<td>" + lista[i].nit_Proveedor + "</td>";
                    salida += "<td>" + lista[i].nom_proveedor + "</td>";
                    salida += "<td>" + lista[i].email_proveedor + "</td>";
                    salida += "<td>" + lista[i].ciudad_proveedor + "</td>";
                    salida += "<td>" + lista[i].direc_proveedor + "</td>";
                    salida += "<td>" + lista[i].tel_proveedor + "</td>";
                    salida += "</tr>";

                };
                salida += "</table>";
                $("#mensaje").html(salida);
            };
        });
    });

    //---------------------------- metodo buscar --------------------------------------

    $("#btn_buscar").click(function () {

        let nit = $("#inp_nit").val();

        if (nit != "") {
            $.get(URL_PUERTO + "/proveedorBuscar", { nit_Proveedor: nit }, function (data, status) {
                let listaEncontrados = data.respuesta

                if (listaEncontrados == null) {
                    $("#mensaje").html("<p>no se encontro proveedor con nit " + nit);
                } else {

                    let salida = "<table>";
                    salida += "<tr><th>NIT</th><th>NOMBRE</th><th>EMAIL</th><th>CIUDAD</th><th>DIRECCION</th><th>TELEFONO</th></tr>";

                    for (let i = 0; i < listaEncontrados.length; i++) {
                        //prepara las columnas de la tabla html con la informacion encotrada
                        salida += "<tr>";
                        salida += "<td>" + listaEncontrados[i].nit_Proveedor + "</td>"
                        salida += "<td>" + listaEncontrados[i].nom_proveedor + "</td>"
                        salida += "<td>" + listaEncontrados[i].email_proveedor + "</td>"
                        salida += "<td>" + listaEncontrados[i].ciudad_proveedor + "</td>"
                        salida += "<td>" + listaEncontrados[i].direc_proveedor + "</td>"
                        salida += "<td>" + listaEncontrados[i].tel_proveedor + "</td>"
                        salida += "</tr>";
                        // imprime en los imputs los valores encontrados
                        $("#inp_nit").val(listaEncontrados[i].nit_Proveedor);
                        $("#inp_nom").val(listaEncontrados[i].nom_proveedor);
                        $("#inp_email").val(listaEncontrados[i].email_proveedor);
                        $("#inp_dir").val(listaEncontrados[i].direc_proveedor);
                        $("#inp_tel").val(listaEncontrados[i].tel_proveedor);
                        $("#inp_ciud").val(listaEncontrados[i].ciudad_proveedor);
                    };
                    salida += "</table>";

                    $("#mensaje").html(salida);

                }

            });

        } else {
            alert("el campo Nit esta vacio ");
        };


    });
    //----------------------------------- eliminar -----------------------------------------------------

    $("#btn_eliminar").click(function () {

        let nit = $("#inp_nit").val();

        if (nit == "" || nit == " ") {
            alert("el campo Nit esta vacio ")
        } else {
            $.get(URL_PUERTO + "/proveedorEliminar", { nit_Proveedor: nit }, function (data, status) {
                let eliminado = data.eliminado;
                if (eliminado) {
                    $("#mensaje").html("<p>el preveedor ha sido eliminado</p>");
                } else {
                    $("#mensaje").html("<p>no se ha podido eliminar el proveedor</p>");
                };
            });
        };

    });
    //------------------------------------- guardar ---------------------------------------------------------

    $("#btn_guardar").click(function () {

        let nit = $("#inp_nit").val();
        let nombre = $("#inp_nom").val();
        let email = $("#inp_email").val();
        let direcc = $("#inp_dir").val();
        let tel = $("#inp_tel").val();
        let ciudad = $("#inp_ciud").val();


        if (nit == "" || nombre == "" || email == "" || direcc == "" || tel == "" || ciudad == "") {
            alert("por favor llenar todos los campos");
        } else {
            $.get(URL_PUERTO + "/proveedorGuardar", {
                nit_Proveedor: nit, nom_proveedor: nombre,
                email_proveedor: email, ciudad_proveedor: ciudad, direc_proveedor: direcc, tel_proveedor: tel
            },
                function (data, status) {
                    let guardado = data.guardado;

                    if (guardado) {
                        $("#mensaje").html("<p>el Proveedor se ha guardado</p>");
                    } else {
                        $("#mensaje").html("<p>el preveedor no se ha podido guardar</p>");
                    };
                });
        }


    });

    //-----------------------------actualizar--------------------------------------------------------------

    $("#btn_actualizar").click(function () {

        let nit = $("#inp_nit").val();
        let nombre = $("#inp_nom").val();
        let email = $("#inp_email").val();
        let direcc = $("#inp_dir").val();
        let ciudad = $("#inp_ciud").val();
        let tel = $("#inp_tel").val();

        if (nit == "" || nombre == "" || email == "" || direcc == "" || ciudad == "" || tel == "") {
            alert("por favor llenar todos los campos");
        } else {

            $.get(URL_PUERTO + "/proveedorActualizar", {
                nit_Proveedor: nit, nom_proveedor: nombre,
                email_proveedor: email, ciudad_proveedor: ciudad, direc_proveedor: direcc, tel_proveedor: tel
            }, function (data, status) {
                let actualizado = data.actualizado;

                if (actualizado) {
                    $("#mensaje").html("se ha acualizado el usuario");
                } else {
                    $("mensaje").html("no se ha podido actualizar");
                };
            });
        };
    });

});