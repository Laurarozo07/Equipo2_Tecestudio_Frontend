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
	public Map<String, Boolean> guardarProveedor(){
		
		boolean guardado = false;
		ProveedorVO proveedor = new ProveedorVO();
		proveedor.setNit_Proveedor(101);
		proveedor.setNom_proveedor("TestSave2");
		proveedor.setEmail_proveedor("TestProveedor@mail.com");
		proveedor.setCiudad_proveedor("BOGOTA");
		proveedor.setDirec_proveedor("cll 7 No 21b 80");
		proveedor.setTel_proveedor("4444444");
		
		guardado = proveedorService.guardar(proveedor);
		
		if(guardado){
			return Collections.singletonMap("guardado", true);
			
		}else {
			return Collections.singletonMap("guardado", false);		}
		
	}
	

	@RequestMapping("/proveedorBuscar")
	public Map<String, List<ProveedorVO>> buscarProveedor() {
		List<ProveedorVO> encontrados = new ArrayList<ProveedorVO>();
		
		int contador = 0;
		
		encontrados = proveedorService.buscar(9008315524l);
		
		return Collections.singletonMap("respuesta", encontrados);
	}
	
	@GetMapping("/proveedorEliminar")
	public Map<String, Boolean> eliminarProveedor(){
		
		boolean eliminado = proveedorService.eliminar(101);
		
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
