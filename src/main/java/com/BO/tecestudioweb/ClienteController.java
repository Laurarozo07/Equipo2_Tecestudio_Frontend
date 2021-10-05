package com.BO.tecestudioweb;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DAO.tecestudioweb.ClienteDAO;
import com.DTO.tecestudioweb.ClienteVO;


@RestController
public class ClienteController {

	ClienteDAO clienteService = new ClienteDAO();
	
	@RequestMapping("/clienteTodos")
	public Map<String, List<ClienteVO>> traerClientes() {
		
		
		List<ClienteVO> listaEncontrados = clienteService.traerTodos();
		
		if(listaEncontrados.isEmpty()) {
			return null;
		}else {
			
			return Collections.singletonMap("respuesta", listaEncontrados);
			
		}
	}
	
    @RequestMapping("/clienteBuscar")
    public Map<String, List<ClienteVO>> buscarCliente(String doc_usuario){
    	
    	
    	List<ClienteVO> listaEncontrados = clienteService.buscar(doc_usuario);
    	
    	if(listaEncontrados.isEmpty()) {
    		return null;
    	}else {
    		
    		return Collections.singletonMap("respuesta", listaEncontrados);
    	}
    }
    
    @RequestMapping("/clienteGuardar")
    public Map<String, Boolean> guardarCliente(String nom_cliente, String ape_cliente, 
			String direc_cliente, String email_cliente, String tel_cliente, 
			String doc_cliente ){
    	boolean guardado = false;
    	
    	guardado = clienteService.guardar( nom_cliente, ape_cliente,direc_cliente ,
    			email_cliente, tel_cliente, doc_cliente);
    if (guardado) {
    	return Collections.singletonMap("guardado", true);
    }else {
    	return Collections.singletonMap("guardado", false);
    }
    }
    
	@RequestMapping("/clienteEliminar")
	public Map<String, Boolean> eliminarCliente(String doc_cliente ){
		boolean eliminado = false;
		
		eliminado = clienteService.eliminar(doc_cliente);
	if (eliminado) {
		return Collections.singletonMap("eliminado", true);
	}else {
		return Collections.singletonMap("eliminado", false);
	}
	}
	
	@RequestMapping("/clienteActualizar")
	public Map<String, Boolean> actualizarCliente(String nom_cliente, String ape_cliente, String direc_cliente, String email_cliente, String tel_cliente, String doc_cliente){
		boolean actualizado = false;
		long documento = 0;
		
		try {
			documento = Long.parseLong(doc_cliente);	
		} catch (Exception e) {
			System.out.println("no se logro pasar a long "+e);
		}
		
		actualizado = clienteService.actualizar(documento, nom_cliente, 
				ape_cliente, direc_cliente, email_cliente,tel_cliente);
		
	if (actualizado) {
		return Collections.singletonMap("actualizado", true);
	}else {
		return Collections.singletonMap("actualizado", false);
	}
		
	}
	
}
