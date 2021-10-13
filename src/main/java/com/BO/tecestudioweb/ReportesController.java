package com.BO.tecestudioweb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DAO.tecestudioweb.ReportesDAO;
import com.DTO.tecestudioweb.ReportesVO;

@RestController
public class ReportesController {
	
	
	ReportesDAO reportesService = new ReportesDAO();
	
	@RequestMapping("/buscarReporte")
	public Map<String, List<ReportesVO>> traerReportes(String DOC_CLIENTE){
		long documento = -1;
		List<ReportesVO> listaReportes = new ArrayList<ReportesVO>();
		
		try {
			documento = Long.parseLong(DOC_CLIENTE);
		} catch (Exception e) {
			System.out.println("reportes: no se logro hacer el casting a long "+e);
		}
		if(documento > 0) {
			
			listaReportes = reportesService.buscarVentas(documento);
		}else {
			listaReportes = null;
		}
		
		return Collections.singletonMap("reportes", listaReportes);
	}
}
