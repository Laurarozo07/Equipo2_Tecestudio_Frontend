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
    public Map<String, List<ClienteVO>> buscarCliente(){
    	
    	
    	List<ClienteVO> listaEncontrados = clienteService.buscar("106");
    	
    	if(listaEncontrados.isEmpty()) {
    		return null;
    	}else {
    		
    		return Collections.singletonMap("respuesta", listaEncontrados);
    	}
    }
    
    @RequestMapping("/clienteGuardar")
    public Map<String, Boolean> guardarCliente(){
    	boolean guardado = false;
    	
    	guardado = clienteService.guardar( "sara", "peréz", "cra 12", "saraPeréz@gmail.com", "3144236759", "1345295768");
    if (guardado) {
    	return Collections.singletonMap("guardado", true);
    }else {
    	return Collections.singletonMap("guardado", false);
    }
    }
    
	@RequestMapping("/clienteEliminar")
	public Map<String, Boolean> eliminarCliente(){
		boolean eliminado = false;
		
		eliminado = clienteService.eliminar("106");
	if (eliminado) {
		return Collections.singletonMap("eliminado", true);
	}else {
		return Collections.singletonMap("eliminado", false);
	}
	}
	
	@RequestMapping("/clienteActualizar")
	public Map<String, Boolean> actualizarCliente(){
		boolean actualizado = false;
		
		actualizado = clienteService.actualizar("106", "tanjiro", 
				"kamado", "Yoyogikamizonochō, Shibuya City, Tokyo 151-8557,"
				, "kamado@mail.com",
				"3-3379-5511");
		
	if (actualizado) {
		return Collections.singletonMap("actualizado", true);
	}else {
		return Collections.singletonMap("actualizado", false);
	}
		
	}
}
