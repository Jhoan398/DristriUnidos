package co.distriunidos.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.distriunidos.app.domain.CarritoDeCompras;
import co.distriunidos.app.domain.Clientes;
import co.distriunidos.app.domain.MetodoDePago;
import co.distriunidos.app.dto.CarritoDeComprasDTO;
import co.distriunidos.app.repository.MetodoDePagoRepository;
import co.distriunidos.app.services.CarritoDeComprasService;
import co.distriunidos.app.services.ClientesService;
/**
 * @author Jhoan Saldarriaga
 *
 */

/*Creamos el controlador que es el que va a generar las peticiones de sus respectivos procesos*/
@RestController
@RequestMapping("/api/carroDeCompras")
public class CarritoDeComprasRestController {
	
	@Autowired
	MetodoDePagoRepository metodoDePagoService;
	@Autowired
	ClientesService clienteService;
	@Autowired
	CarritoDeComprasService carritoService;
	
	@PostMapping("/agregarCarroDeCompras")
	public ResponseEntity<?> agregarAlCarroDeCompras(@RequestBody CarritoDeComprasDTO carritoDTO){
		try {
			
			Clientes cliente = clienteService.consultarClientePorCorreo(carritoDTO.getCorreo());
			MetodoDePago metodoPago = metodoDePagoService.findByIdPago(carritoDTO.getIdPago());
			
			CarritoDeCompras carro = new CarritoDeCompras();
			carro.setIdCarro(carritoDTO.getIdCarro());
			carro.setCorreo(cliente);
			carro.setIdPago(metodoPago);
			carro.setTotal(carritoDTO.getTotal());
			carritoService.agregarCarrito(carro);
			return ResponseEntity.ok().body(carro);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}

	}
	
	@GetMapping("/consultarCarro/{idCarro}")
	public ResponseEntity<?> consultarCarroPorId(@PathVariable ("idCarro")Integer idCarro){
		try {
			CarritoDeComprasDTO carro = carritoService.consultarCarritoDeComprasDTO(idCarro);
			return ResponseEntity.ok().body(carro);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		
	}
	
	@GetMapping("/consultarCarrosDeCompras")
	public ResponseEntity<?> consultarCarrosDeCompra(){
		try {
			
			return ResponseEntity.ok().body(carritoService.consultarCarrosDeCompras());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		
	}
	
}
