/**
 * 
 */



const URL_PUERTO = "http://localhost:8080"

$(document).ready(function () {

    //------------------------- consecutivo -------------------------
    $.get(URL_PUERTO + "/venta/consecutivo", function (data, status) {
        let consecu = data.consecutivo;
        $("#inp_consec").val(" # " + (consecu+1));

    });
    //---------------------------- traer id usuario ------------------
    $.get(URL_PUERTO + "/userId", function (data, status) {
        let id_user = data.idUsuario;
        $("#id_user").html("<p>Usuario "+id_user+"</p>");
    });

    //---------------------------- consultar cliente ----------------------
    $("#btn_consuCli").click(function () {

        let docCliente = $("#inp_documento").val();

        if (docCliente == "" || docCliente == " ") {
            alert(" campo cedula esta vacio");
        } else {

            $.get(URL_PUERTO + "/clienteBuscar", { doc_usuario: docCliente }, function (data, status) {
                const lista = data.respuesta;
                
                $("#inp_nomCliente").val(lista[0].ape_cliente + " " + lista[0].nom_cliente);

            });

        };
    })

    // ---------------- consultar producto 1 --------------------------
    $("#codigo1").click(function () {

        let codigo = $("#inp_codigo1").val();

        if( codigo == "" || codigo == " "){
            alert("El codigo del producto esta vacio");
        }else{
            calcularVenta();
        }
       
    });
    //---------------- consultar producto 2 ------------------------------
    $("#codigo2").click(function () {

        let codigo = $("#inp_codigo2").val();

        if( codigo == "" || codigo == " "){
            alert("El codigo del producto esta vacio");
        }else{
            calcularVenta();
        }
       
    });
    //--------------- consultar producto 3 ----------------------------
    $("#codigo3").click(function () {

        let codigo = $("#inp_codigo3").val();

        if( codigo == "" || codigo == " "){
            alert("El codigo del producto esta vacio");
        }else{
            calcularVenta();
        }
       
    });

    $("#btn_confirmar").click(function () {

        

        let documento = $("#inp_documento").val();
        let idUser = 0;
        

            $.get(URL_PUERTO + "/clienteBuscar",{doc_usuario: documento},function (data, status){
              let idCliente = data.respuesta[ 0].id_cliente;
              venta.id_cliente = idCliente; 
    
            });

            $.get(URL_PUERTO + "/userId", function (data, status){
                 idUser = data.idUsuario;
                 venta.id_user =  idUser;
                 console.log(venta.id_cliente+" "+venta.id_user);

            });

            



    });

    //----------------- calcular venta --------------------------------
    function calcularVenta(){
        let totalVenta = 0; 
        let valorIva = 0;
        let valorVenta = 0;
        
        for (let i = 1; i < 4; i++){
            let cantidad = $("#inp_cant"+i).val();
            let valor = $("#valorT"+i).val();
            totalVenta += cantidad * valor ;
        }
        valorIva = totalVenta*0.19;
        valorVenta = valorIva + totalVenta;

        $("#inp_totalVenta").val(totalVenta);
        $("#inp_totalIva").val(valorIva);
        $("#inp_valorVenta").val(valorVenta);
    };

    
    //-------------- class -----------------------------
    class venta{

        static id_cliente = -1;
        static id_user = -1 ;
    
    };
    

});