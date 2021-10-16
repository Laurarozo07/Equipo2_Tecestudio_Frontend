package com.BO.tecestudioweb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DAO.tecestudioweb.ProductoDAO;
import com.DTO.tecestudioweb.ProductoVO;

@RestController
@CrossOrigin(origins ={"http://localhost:8080","http://18.212.90.18"})
public class ProductoController {
 
	ProductoDAO productoService = new ProductoDAO();
	
	@RequestMapping("/productoTodos")
	public Map<String, List<ProductoVO>> traerTodos(){
		List<ProductoVO> listaProductos = new ArrayList<ProductoVO>();
		listaProductos = productoService.traerTodos();
		if (listaProductos.isEmpty()) {
			return Collections.singletonMap("respuesta", null);
		}else {
			return Collections.singletonMap("respuesta", listaProductos);
			
		}
	}
	
	@RequestMapping("/productoGuardar")
	public Map<String, Boolean> productoGuardar(String nombre_producto,
			String precio_compra, String iva_compra, String precio_venta,
			String nit_proveedor){
		boolean guardado = false;
		double pCompra = -1;
		double ivaCompra = -1;
		double pVenta = -1;
		long nit = -1;
		//------------------ casteo ----------------------------------
		try {
			pCompra = Double.parseDouble(precio_compra);
			ivaCompra = Double.parseDouble(iva_compra);
			pVenta =  Double.parseDouble(precio_venta);
			nit = Long.parseLong(nit_proveedor);
		} catch (Exception e) {
			System.out.println("no se pudo realizar el cast de uno de los datos "+e.getMessage());
			return null;
		}
		//-----------------envio de datos al DAO ------------------------
		System.out.println(nombre_producto+precio_compra+iva_compra+precio_venta+nit_proveedor);
		ProductoVO producto = new ProductoVO();
		producto.setNombre_producto(nombre_producto);
		producto.setIva_compra(ivaCompra);
		producto.setPrecio_compra(pCompra);
		producto.setPrecio_venta(pVenta);
		producto.setNit_proveedor(nit);
		
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
