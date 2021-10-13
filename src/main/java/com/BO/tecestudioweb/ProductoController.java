package com.BO.tecestudioweb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DAO.tecestudioweb.ProductoDAO;
import com.DTO.tecestudioweb.ProductoVO;

@RestController
public class ProductoController {
 
	ProductoDAO productoService = new ProductoDAO();
	
	@RequestMapping("/productoGuardar")
	public Map<String, Boolean> productoGuardar(){
		
		boolean guardado = false;
		
		ProductoVO producto = new ProductoVO();
		producto.setNombre_producto("Portátil HP 14-cf2059la");
		producto.setIva_compra(588810);
		producto.setPrecio_compra(2500000);
		producto.setPrecio_venta(3099000);
		producto.setNit_proveedor(9004984410l);
		
		guardado = productoService.productoGuardar(producto);
		
		return Collections.singletonMap("guardado", guardado);
	}

	@RequestMapping("/productoBuscar")
	public Map<String, List<ProductoVO>> productoBuscar(String CODIGO_PRODUCTO) {
		List<ProductoVO> listaProductos = new ArrayList<ProductoVO>();
		long codigoP = -1;
		try {
			codigoP = Long.parseLong(CODIGO_PRODUCTO);
			
			
		} catch (Exception e) {
			System.out.println("no se pudo realizar el cast del numero nit a long "+e);
		}
		listaProductos = productoService.buscar(codigoP);
		
		if (listaProductos.isEmpty()) {
			return Collections.singletonMap("respuesta", null);
		}else {
			return Collections.singletonMap("respuesta", listaProductos);
		}
		
	}
	
	@GetMapping("/productoEliminar")
	public Map<String, Boolean> eliminarProducto(String nit_proveedor) {
		long nit = -1;
		
		try { 
			nit= Long.parseLong(nit_proveedor);
		} catch (Exception e) {
			System.out.println("no se pudo realizar el cast");
		} 
		
		boolean eliminado = productoService.eliminar(nit);
		
		if(eliminado) {
			return Collections.singletonMap("eliminado", true);
		} else {
			return Collections.singletonMap("eliminado", false);
		}
	}
	
	@GetMapping("/productoActualizar")
	public Map<String, Boolean> actualizarProducto(String nit_proveedor, 
			String nombre_producto, String iva_compra, String precio_compra, String precio_venta){
		boolean actualizado = false;
		long nit = -1;
		try {
			nit= Long.parseLong(nit_proveedor);//verificar si es nit_proveedor o precio_compra//
		} catch (Exception e) {
			System.out.println("no se ha podido convertir el nit a long"+e);	
		}
		
		ProductoVO productoGuardar = new ProductoVO();
		
		productoGuardar.setNombre_producto(nombre_producto);
		productoGuardar.setIva_compra(nit);
		productoGuardar.setPrecio_compra(nit);
		productoGuardar.setPrecio_venta(nit);
		productoGuardar.setNit_proveedor(nit);
		System.out.println(productoGuardar.toString());
		actualizado= productoService.actualizar(productoGuardar);
		
		if (actualizado) {
			return Collections.singletonMap("actualizado", true);
		}else {
			return Collections.singletonMap("actualizado", false);
		}
	}
}
