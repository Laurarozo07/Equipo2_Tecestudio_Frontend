/**
 * 
 */
const URL_PUERTO = "http://localhost:8080"

$(document).ready(function () {
    $.get(URL_PUERTO + "/venta/consecutivo", function (data, status) {
        let consecu = data.consecutivo;
        $("#inp_consec").val(" # " + (consecu+1));

    });

    $.get(URL_PUERTO + "/userId", function (data, status) {
        let id_user = data.idUsuario;
        $("#id_user").html("<p>Usuario "+id_user+"</p>");
    });
    $("#btn_consuCli").click(function () {

        let docCliente = $("#inp_documento").val();

        if (docCliente == "" || docCliente == " ") {
            alert(" campo cedula esta vacio");
        } else {

            $.get(URL_PUERTO + "/clienteBuscar", { doc_usuario: docCliente }, function (data, status) {
                const lista = data.respuesta;
                console.log(lista);
                $("#inp_nomCliente").val(lista[0].ape_cliente + " " + lista[0].nom_cliente);

            });

        };
    })

});