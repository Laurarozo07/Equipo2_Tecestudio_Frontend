package com.BO.tecestudioweb;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DAO.tecestudioweb.DetalleVentaDAO;
import com.DAO.tecestudioweb.VentasDAO;
import com.DTO.tecestudioweb.DetalleVentaVO;
import com.DTO.tecestudioweb.VentasVO;

@RestController
public class VentasController {

	private VentasDAO ventasService = new VentasDAO();
	private DetalleVentaDAO detalleService = new DetalleVentaDAO();
	private DetalleVentaVO detalleTemp ;
	private VentasVO ventaTemp ;
	
	@RequestMapping("/guardarVenta")
	public Map<String , Boolean> guardarFactura(String id_cliente, String id_usuario,
			String iva_venta, String total_venta, String valor_venta){
		
		boolean facturaGuardada = false;
		ventaTemp = new VentasVO();
		 
		ventaTemp.setId_cliente(11);
		ventaTemp.setId_usuario(3);
		ventaTemp.setIva_venta(943076);
		ventaTemp.setTotal_venta(4963556);
		ventaTemp.setValor_venta(5906632);
		
		facturaGuardada = ventasService.guardarVenta(ventaTemp);

		return Collections.singletonMap("guardado", facturaGuardada);
	}
	
	@RequestMapping("/guardarDetalle")
	public Map<String, Boolean> guardarDetalle(){
		
		boolean detalleGuardado = false;
		detalleTemp = new DetalleVentaVO();
		detalleTemp.setCantidad_producto(1);
		detalleTemp.setCodigo_producto(1);
		detalleTemp.setCodigo_venta(11);
		detalleTemp.setValor_iva(4963556);
		detalleTemp.setValor_total(5906632);
		detalleTemp.setValor_venta(943076);
		
		//1, 1, 10, 4963556, 5906632, 943076
		detalleGuardado = detalleService.guardarDetalle(detalleTemp);
		
		return Collections.singletonMap("guardado", detalleGuardado);
	}
	
	
}
