<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<title>Ventas</title>

<link rel="icon" type="image/png" href="image/favicon-196x196.png" sizes="196x196" />
<link rel="icon" type="image/png" href="image/favicon-96x96.png" sizes="96x96" />
<link rel="icon" type="image/png" href="image/favicon-16x16.png" sizes="16x16" />
<link rel="icon" type="image/png" href="image/favicon-128.png" sizes="128x128" />

<link href="css/main.css" rel="stylesheet" type="text/css">
<script
src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script type="text/javascript" src="js/importcsv.js"></script>
</head>
<body>
<header>
	<%@ include file="fragments/navbar.jsp"%>
</header>
<section>
  <form >
     <div>
         <input id="archivoInput" type="file" onchange="return validarExt()"> 
         <br/>
       <!--  <input type="submit" value="Cargar"> -->
       <div id="visorArchivo">
       
     </div>
    </form>
</section>
<section>
  
       </div>

       <div id="tableResult">
</section >
 
<section id="modulo_confirmar" >
   <input id="confirmar" type="button" value="Confirmar">
</section>
<footer></footer>
	
	
</body>

<script type="text/javascript">
  $("#modulo_confirmar").hide();
  const listProduct = [];
	function validarExt(){
		var archivoInput = document.getElementById('archivoInput');
    var archivoRuta = archivoInput.value;
    var extPermitidas =  /(.csv)$/i;
    const reader = new FileReader();
    const input = archivoInput.files[0]
    

    if(!extPermitidas.exec(archivoRuta)){
      alert("formato no valido ");
      archivoInput.value = '';
      return false;
    }
		else {
      if(archivoInput.files && archivoInput.files[0]){
        var visor = new FileReader();
        visor.onload=function(e){
          document.getElementById('visorArchivo').innerHTML = '<embed src="' +e.target.result+'" width="500" height="500" >'
        };
        console.log(archivoInput.files);
        
            reader.onload = function (e) {
              const text = (e.target.result);
              successFunction(text).then((listaEncont) => {
                console.log(listaEncont)
                listProduct.push(listaEncont);
                $("#modulo_confirmar").show();
                
              });
              
            };
            reader.readAsText(input);
        
      }
    }
	};
  //----------------------------------------------------------------
  
  function successFunction(data) {
    var textProduct = [];
    return new Promise((resolve, reject) => {
      var allRows = data.split(/\r?\n|\r/);
   var table = '<table>';
   for (var singleRow = 0; singleRow < allRows.length; singleRow++) {
     if (singleRow === 0) {
       table += '<thead>';
       table += '<tr>';
     } else {
       table += '<tr>';
     }
     var rowCells = allRows[singleRow].split(',');
     for (var rowCell = 0; rowCell < rowCells.length; rowCell++) {
       if (singleRow === 0) {
         table += '<th>';
         table += rowCells[rowCell];
         table += '</th>';
       } else {
         table += '<td>';
         table += rowCells[rowCell];
         textProduct.push(rowCells[rowCell]);
         table += '</td>';
       };
     }
     if (singleRow === 0) {
       table += '</tr>';
       table += '</thead>';
       table += '<tbody>';
     } else {
       table += '</tr>';
     };
   } 
   table += '</tbody>';
   table += '</table>';
  $("#tableResult").html(table);

  resolve(textProduct);
   
    });


  //  var allRows = data.split(/\r?\n|\r/);
  //  var table = '<table>';
  //  for (var singleRow = 0; singleRow < allRows.length; singleRow++) {
  //    if (singleRow === 0) {
  //      table += '<thead>';
  //      table += '<tr>';
  //    } else {
  //      table += '<tr>';
  //    }
  //    var rowCells = allRows[singleRow].split(',');
  //    for (var rowCell = 0; rowCell < rowCells.length; rowCell++) {
  //      if (singleRow === 0) {
  //        table += '<th>';
  //        table += rowCells[rowCell];
  //        table += '</th>';
  //      } else {
  //        table += '<td>';
  //        table += rowCells[rowCell];
  //        textProduct.push(rowCells[rowCell]);
  //        table += '</td>';
  //      };
  //    }
  //    if (singleRow === 0) {
  //      table += '</tr>';
  //      table += '</thead>';
  //      table += '<tbody>';
  //    } else {
  //      table += '</tr>';
  //    };
  //  } 
  //  table += '</tbody>';
  //  table += '</table>';
  // //  $('body').append(table);
  // $("#tableResult").html(table);
  // console.log(textProduct);
 };

 $("#confirmar").click(function(){
    console.log(listProduct);
 });
</script>
</html>