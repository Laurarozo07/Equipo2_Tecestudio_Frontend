/**
 * Se encarga de enviar la informacion de la venta al backEnd de la aplicacion 
 */

const URL_PUERTO = "http://localhost:8080"

$(document).ready(function () {

    //------------------------- consecutivo -------------------------
    traerConsecutivo().then((conse) => {
        $("#inp_consec").val(" # " + (conse + 1));
    });

    //---------------------------- traer id usuario ------------------
    $.get(URL_PUERTO + "/userId", function (data, status) {

        setTimeout(() => {
            let id_user = data.idUsuario;
            idUser = data.idUsuario;
            Venta.id_user = idUser;
            $("#id_user").html("<p>Usuario " + id_user + "</p>");

        }, 700)

    });

    //---------------------------- consultar cliente ----------------------
    $("#btn_consuCli").click(function () {

        let docCliente = $("#inp_documento").val();

        if (docCliente == "" || docCliente == " ") {
            alert(" campo cedula esta vacio");
        } else {

            $.get(URL_PUERTO + "/clienteBuscar", { doc_usuario: docCliente }, function (data, status) {

                setTimeout(() => {

                    let idCliente = data.respuesta[0].id_cliente;
                    Venta.id_cliente = idCliente;
                    console.log(Venta.id_cliente + " || " + Venta.id_user);
                    $("#inp_nomCliente").val(data.respuesta[0].ape_cliente + " " + data.respuesta[0].nom_cliente);
                }, 500)



            });

        };
    })

    // ---------------- consultar producto 1 --------------------------
    $("#codigo1").click(function () {

        let codigo = $("#inp_codigo1").val();

        if (codigo == "" || codigo == " ") {
            alert("El codigo del producto esta vacio");
        } else {
            calcularVenta();
        }

    });
    //---------------- consultar producto 2 ------------------------------
    $("#codigo2").click(function () {

        let codigo = $("#inp_codigo2").val();

        if (codigo == "" || codigo == " ") {
            alert("El codigo del producto esta vacio");
        } else {
            calcularVenta();
        }

    });
    //--------------- consultar producto 3 ----------------------------
    $("#codigo3").click(function () {

        let codigo = $("#inp_codigo3").val();

        if (codigo == "" || codigo == " ") {
            alert("El codigo del producto esta vacio");
        } else {
            calcularVenta();
        }

    });
    // ------------------------------- boton confirmar ------------------------------------
    $("#btn_confirmar").click(function () {

        Venta.total_venta = $("#inp_totalVenta").val();
        Venta.iva_venta = $("#inp_totalIva").val();
        Venta.valor_venta = $("#inp_valorVenta").val();

        setTimeout(() => {
            console.log(Venta.id_cliente + " " + Venta.id_user + " " + Venta.iva_venta + " " + Venta.total_venta + " " + Venta.valor_venta)
            $.get(URL_PUERTO + "/guardarVenta", {
                id_cliente: Venta.id_cliente, id_usuario: Venta.id_user,
                iva_venta: Venta.iva_venta, total_venta: Venta.total_venta, valor_venta: Venta.valor_venta
            }, function (data, status) {
                let ventaGuardada = data.guardado
                if (ventaGuardada) {
                    setTimeout(() => {

                    }, 2000)
                } else {
                    alert("La venta No fue guardada");
                };

            });
        }, 2000);

        const detalle1 = new DetalleVenta();

        detalle1.cantidad_producto = $("#inp_cant1").val();
        detalle1.codigo_producto = $("#inp_codigo1").val();
        traerConsecutivo().then((conse) => {
            detalle1.codigo_venta = conse;
        });
        detalle1.valor_iva = ($("#valorT1").val() * 0.19) * detalle1.cantidad_producto;
        detalle1.valor_total = $("#valorT1").val() * detalle1.cantidad_producto;
        detalle1.valor_venta = detalle1.valor_iva + detalle1.valor_total;

        setTimeout(() => {
            console.log(detalle1);
        }, 2000);



    });
    // ------------------ functions ---------------------------------
    function traerConsecutivo() {
        return new Promise((resolve, reject) => {
            $.get(URL_PUERTO + "/venta/consecutivo", function (data, status) {
                let consecut = data.consecutivo;
                resolve(consecut);
            });
        })

    }
    //----------------- calcular venta --------------------------------
    function calcularVenta() {
        let totalVenta = 0;
        let valorIva = 0;
        let valorVenta = 0;

        for (let i = 1; i < 4; i++) {
            let cantidad = $("#inp_cant" + i).val();
            let valor = $("#valorT" + i).val();
            totalVenta += cantidad * valor;
        }
        valorIva = totalVenta * 0.19;
        valorVenta = valorIva + totalVenta;

        $("#inp_totalVenta").val(totalVenta);
        $("#inp_totalIva").val(valorIva);
        $("#inp_valorVenta").val(valorVenta);
    };

    //-------------- class -----------------------------
    class Venta {

        static id_cliente = -1
        static id_user = -1
        static iva_venta = -1
        static total_venta = -1
        static valor_venta = -1
    };
    class DetalleVenta {

        cantidad_producto = -1;
        codigo_producto = -1;
        codigo_venta = -1;
        valor_total = -1;
        valor_venta = -1;
        valor_iva = -1;

    }


});