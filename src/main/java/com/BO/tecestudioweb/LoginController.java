package com.BO.tecestudioweb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.boot.json.JsonParser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.DAO.*;
import com.DAO.tecestudioweb.*;
import com.DTO.tecestudioweb.*;
import com.fasterxml.jackson.databind.JsonNode;

@RestController
public class LoginController {
	
	@RequestMapping("/loginusuario2")
	public Map<String, Boolean> validarlogin2(String usuario, String password)//recibe esta cadena y convierte en un objeto de tipo cliente
	{
	 ArrayList<LoginVO> miusuario = new ArrayList<LoginVO>();//Crea el objeto arryList
	 
	//pasa la peteción al servicio
	LoginDAO Dao=new LoginDAO(); //cargamos el objeto y se pasa al DAO y valida el usuario
	 miusuario= Dao.consultarUsuario(usuario, password);
	 if(miusuario.isEmpty())
	 {
	 return Collections.singletonMap("existe", false);
	 }
	 else
	 {
	 return Collections.singletonMap("existe", true);
	 
	 }


	}

}
