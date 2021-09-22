package com.BO.tecestudioweb;

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
	public Map<Integer, ProveedorVO> traerProveedores() {
		int contador = 0;
		List<ProveedorVO> listaEncontrados;
		Map<Integer, ProveedorVO> listaProveedores = new HashMap<Integer, ProveedorVO>();
		listaEncontrados = proveedorService.traerTodos();

		if (listaEncontrados.isEmpty()) {

			listaProveedores = null;
		} else {

			for (ProveedorVO proveedor : listaEncontrados) {
				listaProveedores.put(contador, proveedor);
				contador++;
			}
		}

		return listaProveedores;
	}
	
	@GetMapping("/proveedorGuardar")
	public Map<String, Boolean> buscarProveedor(){
		
		boolean guardado = false;
		ProveedorVO proveedor = new ProveedorVO();
		proveedor.setNit_Proveedor(10000000);
		proveedor.setNom_proveedor("TestSave");
		proveedor.setEmail_proveedor("TestProveedor@mail.com");
		proveedor.setCiudad_proveedor("BOGOTA");
		proveedor.setDirec_proveedor("cll 7 No 21b 80");
		proveedor.setTel_proveedor("7777777");
		
		guardado = proveedorService.guardar(proveedor);
		
		if(guardado){
			return Collections.singletonMap("guardado", true);
			
		}else {
			return Collections.singletonMap("guardado", false);		}
		
	
		
	}

	
	
}
