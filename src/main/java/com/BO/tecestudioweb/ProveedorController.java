package com.BO.tecestudioweb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DAO.tecestudioweb.ProveedorDAO;
import com.DTO.tecestudioweb.ProveedorVO;


@RestController
public class ProveedorController {

	private ProveedorDAO proveedorService = new ProveedorDAO();

	@RequestMapping("/proveedorTodos")
	public Map<String, List<ProveedorVO>> traerProveedores() {
		int contador = 0;
		List<ProveedorVO> listaEncontrados;
		listaEncontrados = proveedorService.traerTodos();

		if (listaEncontrados.isEmpty()) {

			return null;
		} else {

			return Collections.singletonMap("respuesta", listaEncontrados);
		}

	
	}
	
	@GetMapping("/proveedorGuardar")
	public Map<String, Boolean> guardarProveedor(String nit_Proveedor, 
			String nom_proveedor, String email_proveedor, String ciudad_proveedor,
			String direc_proveedor, String tel_proveedor ){
		
		long nit = -1;
		
		try {
			nit = Long.parseLong(nit_Proveedor);
			
		} catch (Exception e) {
			System.out.println("no se pudo realizar el cast del numero nit");
		}
		
		boolean guardado = false;
		ProveedorVO proveedor = new ProveedorVO();
		proveedor.setNit_Proveedor(nit);
		proveedor.setNom_proveedor(nom_proveedor);
		proveedor.setEmail_proveedor(email_proveedor);
		proveedor.setCiudad_proveedor(ciudad_proveedor);
		proveedor.setDirec_proveedor(direc_proveedor);
		proveedor.setTel_proveedor(tel_proveedor);
		
		guardado = proveedorService.guardar(proveedor);
		
		if(guardado){
			return Collections.singletonMap("guardado", true);
			
		}else {
			return Collections.singletonMap("guardado", false);		}
		
	}
	

	@RequestMapping("/proveedorBuscar")
	public Map<String, List<ProveedorVO>> buscarProveedor(String nit_Proveedor ) {
		List<ProveedorVO> encontrados = new ArrayList<ProveedorVO>();
		long nit = -1; 
		try {
			// se realiza el cast del dato nit_proveedor en String a long
			nit = Long.parseLong(nit_Proveedor);
			encontrados = proveedorService.buscar(nit);
			
			
		} catch (Exception e) {
			System.out.println("no se pudo realizar el cast del numero nit a long "+e);
		}
		
		
		
		return Collections.singletonMap("respuesta", encontrados);
	}
	
	@GetMapping("/proveedorEliminar")
	public Map<String, Boolean> eliminarProveedor(String nit_Proveedor){
		
		long nit = -1;
		
		try {
			nit = Long.parseLong(nit_Proveedor);
		} catch (Exception e) {
			System.out.println("no se pudo realizar el cast");
		}
		
		boolean eliminado = proveedorService.eliminar(nit);
		
		if(eliminado) {
			return Collections.singletonMap("eliminado", true);
		}else {
			return Collections.singletonMap("eliminado", false);
					
		}
		
	}
	@GetMapping("/proveedorActualizar")
	public Map<String, Boolean> actualizarProveedor(){
		boolean actualizado = false;
		ProveedorVO proveedorGuardar = new ProveedorVO();
		proveedorGuardar.setNit_Proveedor(101);
		proveedorGuardar.setNom_proveedor("testUpdate sas");
		proveedorGuardar.setEmail_proveedor("update@mail.com");
		proveedorGuardar.setDirec_proveedor("Cl. 10 ##20-35");
		proveedorGuardar.setCiudad_proveedor("Bogota");
		proveedorGuardar.setTel_proveedor("2222222");
		actualizado = proveedorService.actualizar(proveedorGuardar);
		
		if(actualizado) {
			return Collections.singletonMap("actualizado", true);
		}else {
			return Collections.singletonMap("actualizado", false);
		}
		
	}
	
}
