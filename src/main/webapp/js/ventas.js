/**
 * Se encarga de enviar la informacion de la venta al backEnd de la aplicacion 
 */

const URL_PUERTO = "http://18.212.90.18:8080/tecestudioweb-0.0.1-SNAPSHOT"

$(document).ready(function () {
    $("#btn_confirmar").hide();

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

                if(data.respuesta === undefined || data.respuesta === null){
                    alert("El usuario con documento :"+docCliente+" no se encuentra registrado ");
                }else{
                    let idCliente = data.respuesta[0].id_cliente;
                    Venta.id_cliente = idCliente;
                    $("#inp_nomCliente").val(data.respuesta[0].ape_cliente + " " + data.respuesta[0].nom_cliente);
                };
                
            });

        };
    })

    // ---------------- consultar producto 1 --------------------------
    $("#codigo1").click(function () {

        let codigo = $("#inp_codigo1").val();

        if (codigo == "" || codigo == " ") {
            alert("El codigo del producto esta vacio");
        } else {
            traerProduto(codigo).then((listaProducto) => {

                if(listaProducto == null){
                    alert("no existe producto con codigo #"+codigo);
                }else{
                    $("#nomProd1").val(listaProducto.nombre_producto);
                $("#valorT1").val(listaProducto.precio_venta);
                console.log(listaProducto);

                };
                
                
            });
        }

    });
    //---------------- consultar producto 2 ------------------------------
    $("#codigo2").click(function () {
        let codigo = $("#inp_codigo2").val();

        if (codigo == "" || codigo == " ") {
            alert("El codigo del producto esta vacio");
        } else {
            traerProduto(codigo).then((listaProducto) => {

                if(listaProducto == null){
                    alert("no existe producto con codigo #"+codigo);
                }else{
                    $("#nomProd2").val(listaProducto.nombre_producto);
                $("#valorT2").val(listaProducto.precio_venta);
                console.log(listaProducto);

                };
                
            });
        }

    });
    //--------------- consultar producto 3 ----------------------------
    $("#codigo3").click(function () {

        let codigo = $("#inp_codigo3").val();

        if (codigo == "" || codigo == " ") {
            alert("El codigo del producto esta vacio");
        } else {
            traerProduto(codigo).then((listaProducto) => {

                if(listaProducto == null){
                    alert("no existe producto con codigo #"+codigo);
                }else{
                    $("#nomProd3").val(listaProducto.nombre_producto);
                $("#valorT3").val(listaProducto.precio_venta);
                console.log(listaProducto);
                };
                 
            });
        }

    });
    //------------------------------ boton calcular ------------------------------
    $("#btn_calcular").click(() => {
        let datosCompletos = false;
        for (var i = 0; i < 3; i++) {
            if ($("#inp_codigo" + (i + 1)).val() != "" && $("#nomProd"+( i + 1 )).val() != ""  && $("#inp_cant" + (i + 1)).val() > 0 && $("#inp_nomCliente").val() != "") {
                datosCompletos = true;
            };
        };

        if (datosCompletos) {
            calcularVenta();
        } else {
            alert("datos imcompletos")
        };

    });
    // ------------------------------- boton confirmar ------------------------------------
    $("#btn_confirmar").click(function () {
        $("#btn_confirmar").hide();
        let CantidadProductos = 0;
        for (let i = 1; i <= 3; i++) {
            if ($("#inp_codigo" + i).val() != "") {
                CantidadProductos++;

            }
        };

        guardarVenta().then((ventaGuardada) => {
            if (ventaGuardada) {
                for (let index = 1; index <= CantidadProductos; index++) {
                    guardarDetalle(index).then((guardado) => {
                        if (guardado) {
                            if(index == 1){
                                alert("Venta realizada");
                            }
                        } else {
                            if(index == 1){
                                alert("no se ha podido realizar la venta");
                            }
                            
                        };

                    });
                }
            };
        });

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
    function guardarVenta() {
        return new Promise((resolve, reject) => {
            Venta.total_venta = $("#inp_totalVenta").val();
            Venta.iva_venta = $("#inp_totalIva").val();
            Venta.valor_venta = $("#inp_valorVenta").val();

            console.log(Venta.id_cliente + " " + Venta.id_user + " " + Venta.iva_venta + " " + Venta.total_venta + " " + Venta.valor_venta)
            $.get(URL_PUERTO + "/guardarVenta", {
                id_cliente: Venta.id_cliente, id_usuario: Venta.id_user,
                iva_venta: Venta.iva_venta, total_venta: Venta.total_venta, valor_venta: Venta.valor_venta
            }, function (data, status) {
                let ventaGuardada = data.guardado
                if (!ventaGuardada) {
                    alert("La venta No fue guardada");
                };
                resolve(ventaGuardada);
            });

        });
    }
    function guardarDetalle(iterator) {

        return new Promise((resolve, reject) => {
            const detalle = new DetalleVenta();

            detalle.cantidad_producto = $("#inp_cant" + iterator).val();
            detalle.codigo_producto = $("#inp_codigo" + iterator).val();
            if (detalle.codigo_producto == "") {
                reject(false);
            } else {

                traerConsecutivo().then((conse) => {
                    detalle.codigo_venta = conse;
                    detalle.valor_iva = ($("#valorT" + iterator).val() * 0.19) * detalle.cantidad_producto;
                    detalle.valor_total = $("#valorT" + iterator).val() * detalle.cantidad_producto;
                    detalle.valor_venta = detalle.valor_iva + detalle.valor_total;
                    $.get(URL_PUERTO + "/guardarDetalle", {
                        cantidad_producto: detalle.cantidad_producto,
                        codigo_producto: detalle.codigo_producto, codigo_venta: detalle.codigo_venta, valor_total: detalle.valor_total,
                        valor_venta: detalle.valor_venta, valor_iva: detalle.valor_iva
                    }, function (data, status) {
                        let guardado = data.guardado;
                        resolve(guardado);
                    });
                });

            };

        });

    }
    //----------------- calcular venta --------------------------------
    function traerProduto(codigo) {
        return new Promise((resolve, reject) => {
            $.get(URL_PUERTO + "/productoBuscar", { CODIGO_PRODUCTO: codigo }, function (data, status) {
                let listaDatos = data.respuesta;
                if(listaDatos == null) {
                    resolve(null);
                }else{
                    resolve(listaDatos[0]);
                };
               
            });
        });
    };

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
        for (var i = 0; i < 3; i++) {
            if ($("#inp_codigo" + (i + 1)).val() != "" && $("#inp_cant" + (i + 1)).val() != "") {
                $("#btn_confirmar").show(400);
            }
        };
    };

    //-------------- class -----------------------------
    class Venta {

        static id_cliente = -1;
        static id_user = -1;
        static iva_venta = -1;
        static total_venta = -1;
        static valor_venta = -1;
    };
    class DetalleVenta {

        cantidad_producto = -1;
        codigo_producto = -1;
        codigo_venta = -1;
        valor_total = -1;
        valor_venta = -1;
        valor_iva = -1;

    };

});