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
		int idCliente = 0;
		int idUsuario = 0;
		double ivaVenta = 0;
		double totalVenta = 0;
		double valorVenta = 0;
		//----------- casting de datos -------------------
		try {
			idCliente = Integer.parseInt(id_cliente);
			idUsuario = Integer.parseInt(id_usuario);
			ivaVenta = Double.parseDouble(iva_venta);
			totalVenta = Double.parseDouble(total_venta);
			valorVenta = Double.parseDouble(valor_venta);
			
		} catch (Exception e) {
			System.out.println("no se logro hacer el casting de los datos ");
		}
		
		//----------------------------------------------- 
		ventaTemp.setId_cliente(idCliente);
		
		ventaTemp.setId_usuario(idUsuario);
		ventaTemp.setIva_venta(ivaVenta);
		ventaTemp.setTotal_venta(totalVenta);
		ventaTemp.setValor_venta(valorVenta);
		
		facturaGuardada = ventasService.guardarVenta(ventaTemp);

		return Collections.singletonMap("guardado", facturaGuardada);
	}
	
	
	@RequestMapping("/guardarDetalle")
	public Map<String, Boolean> guardarDetalle(){
		
		boolean detalleGuardado = false;
		detalleTemp = new DetalleVentaVO();
		detalleTemp.setCantidad_producto(1);
		detalleTemp.setCodigo_producto(1);
		detalleTemp.setCodigo_venta(3);
		detalleTemp.setValor_iva(943076);
		detalleTemp.setValor_total(4963556);
		detalleTemp.setValor_venta(5906632);
		
		detalleGuardado = detalleService.guardarDetalle(detalleTemp);
		
		return Collections.singletonMap("guardado", detalleGuardado);
	}
	
	@RequestMapping("/venta/consecutivo")
	public Map<String, Long > traerConsecutivo(){
		
		long consecutivo;
		consecutivo = ventasService.traerConsecutivo();
		
		return Collections.singletonMap("consecutivo", consecutivo );
	}
	
	
}
