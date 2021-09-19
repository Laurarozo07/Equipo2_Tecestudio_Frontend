package com.BO.tecestudioweb;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DAO.tecestudioweb.UsuarioDAO;
import com.DTO.tecestudioweb.UsuarioVO;

import java.util.Map;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@RestController
public class UsuarioController {
	
	UsuarioDAO usuarioService = new UsuarioDAO();

	@RequestMapping("/todos")
	public Map<Integer, UsuarioVO> traerUsuarios(){
		
		int contador = 0;
		
		List<UsuarioVO> listaEncontrados = usuarioService.traerTodos();
		
		Map<Integer , UsuarioVO> listaUsuarios = new HashMap<Integer , UsuarioVO>();
		
		if(listaEncontrados.isEmpty()){
			return null;
		}else {
			
			for (UsuarioVO usuario : listaEncontrados) {
				
				listaUsuarios.put(contador, usuario);
				contador ++;
			}
			return listaUsuarios;
			
		}
		
		}
	
	@RequestMapping("/buscar")
	public Map<Integer, UsuarioVO> buscarUsuario(){
		
		int contador = 0;
		
		List<UsuarioVO> listaEncontrados = usuarioService.buscar("1010110102");
		
		Map<Integer , UsuarioVO> listaUsuarios = new HashMap<Integer , UsuarioVO>();
		
		if(listaEncontrados.isEmpty()){
			return null;
		}else {
			
			for (UsuarioVO usuario : listaEncontrados) {
				
				listaUsuarios.put(contador, usuario);
				contador ++;
			}
			return listaUsuarios;
			
		}
		
		}
	
	@RequestMapping("/guardar")
	public Map<String, Boolean> guardarUsuario(){
		boolean guardado = false;
		
		guardado = usuarioService.guardar("102", "bibi", "bibi@mail.com", "bibi@mail.com", "bibi1234");
	if(guardado) {
		return Collections.singletonMap("guardado", true);
	}else {
		return Collections.singletonMap("guardado", false);
	}
	
	}
	
}
