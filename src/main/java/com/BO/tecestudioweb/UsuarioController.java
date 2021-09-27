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
/**
 * este Clase se encarga de realizar el CRUD para la tabla usuario
 * 
 * @since 2020
 * @version 1.0.0
 * 
 *
 */
@RestController
public class UsuarioController {
	
	private UsuarioDAO usuarioService = new UsuarioDAO();
	
	@RequestMapping("/test")
	public Map<String, String> testMetodo(String text) {
		
		return Collections.singletonMap("respuesta", "controller "+text);
	}
	
	//--------------todos--------------------------------------------
	
	@RequestMapping("/todos")
	public Map<String, List<UsuarioVO>> traerUsuarios(){
		
		int contador = 0;
		
		List<UsuarioVO> listaEncontrados = usuarioService.traerTodos();
		
		if(listaEncontrados.isEmpty()){
			return null;
		}else {
			
			return Collections.singletonMap("respuesta", listaEncontrados);
			
		}
		
		}
	
	/**
	 * 
	 * @return {@code HashMap<Integer, UsuarioVO>} con todos los usuarios en la 
	 * base de datos
	 */
//	@RequestMapping("/todos")
//	public Map<Integer, UsuarioVO> traerUsuarios(){
//		
//		int contador = 0;
//		
//		List<UsuarioVO> listaEncontrados = usuarioService.traerTodos();
//		
//		Map<Integer , UsuarioVO> listaUsuarios = new HashMap<Integer , UsuarioVO>();
//		
//		if(listaEncontrados.isEmpty()){
//			return null;
//		}else {
//			
//			for (UsuarioVO usuario : listaEncontrados) {
//				
//				listaUsuarios.put(contador, usuario);
//				contador ++;
//			}
//			return listaUsuarios;
//			
//		}
//		
//		}
	
	/**
	 * @param numero de documento a consultar
	 * @return {@code Map<Integer, UsuarioVO>) con el o los usuarios que encuentre 
	 * con el numero de documento se le pasa como parametro
	 */
	@RequestMapping("/buscar")
	public Map<String, List<UsuarioVO>> buscarUsuario(String doc_usuario){
		
		int contador = 0;
		
		List<UsuarioVO> listaEncontrados = usuarioService.buscar(doc_usuario);
		
		if(listaEncontrados.isEmpty()){
			return null;
		}else {
			
			return Collections.singletonMap("respuesta", listaEncontrados);
			}
			
		}
		
		
	
	/**
	 * se encarga de guardar al usuario que recibe como parametro
	 * @return {@code Map<String, Boolean>} clave: "guardado" valor: {@code true} 
	 * si logro guardar al usuario y {@code false} si no pudo guardarlo
	 */
	@RequestMapping("/guardar")
	public Map<String, Boolean> guardarUsuario(String nom_usuario, 
			String email_usuario, String usuario, String password, String doc_usuario  ){
		boolean guardado = false;
		
		guardado = usuarioService.guardar(nom_usuario, email_usuario,
				usuario, password, doc_usuario);
	if(guardado) {
		return Collections.singletonMap("guardado", true);
	}else {
		return Collections.singletonMap("guardado", false);
	}
	
	}
	
	/**
	 * se encarga de eliminar al usario
	 * @param {@code String} con el numero de documento
	 * @return {@code Map<String, Boolean>} clave: "eliminado" valor: {@code true} 
	 * si logro eliminar al usuario y {@code false} si no pudo eliminarlo
	 */
	@RequestMapping("/eliminar")
	public Map<String, Boolean> eliminarUsuario(String doc_usuario){
		boolean eliminado = false;
		
		eliminado = usuarioService.eliminar(doc_usuario);
		
	if(eliminado) {
		return Collections.singletonMap("eliminado", true);
	}else {
		return Collections.singletonMap("eliminado", false);
	}
	
	}
	
	/**
	 * se encarga de actualizar actualizar los datos de nombre, correo, usuario y 
	 * contraseña de un usuario en especifico
	 * @param {@code String} con el documento al que se va a actualizar, 
	 * {@code String} con el nombre nuevo, {@code String} con el correo nuevo, 
	 * {@code String} con el usuario nuevo , {@code String} con el correo nuevo
	 * @return {@code Map<String, Boolean>} clave: "eliminado" valor: {@code true} 
	 * si logro eliminar al usuario y {@code false} si no pudo eliminarlo
	 */
	@RequestMapping("/actualizar")
	public Map<String, Boolean> actualizarUsuario(String doc_usuario, String nom_usuario,String email_usuario, String usuario, String password){
		boolean actualizado = false;
		
		actualizado = usuarioService.actualizar(doc_usuario, nom_usuario, 
				email_usuario, usuario, password);
		
	if(actualizado) {
		return Collections.singletonMap("actualizado", true);
	}else {
		return Collections.singletonMap("actualizado", false);
	}
	
	}
	

	
}
