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

            let lista = data.respuesta;

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









});