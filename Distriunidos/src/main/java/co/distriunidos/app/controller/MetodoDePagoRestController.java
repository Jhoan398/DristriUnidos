package co.distriunidos.app.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.distriunidos.app.domain.MetodoDePago;
import co.distriunidos.app.dto.MetodoDePagoDTO;
import co.distriunidos.app.services.MetodoDePagoService;
/**
 * @author Jhoan Saldarriaga
 *
 */
/*Creamos el controlador que es el que va a generar las peticiones de sus respectivos procesos*/
@RestController
@RequestMapping("/api/metodoPago")
public class MetodoDePagoRestController {

	@Autowired
	MetodoDePagoService metodoDePagoService;
	
	@GetMapping("/consultarMetodoDePago")
	public ResponseEntity<?> consultarMetodoDePagoPorId(@RequestParam ("idPago") Integer idPago){
		try {
			MetodoDePago metodoPago = metodoDePagoService.consultarMetodoDePago(idPago);
			return ResponseEntity.ok().body(metodoPago);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());

		}
	}
	
	
	@PostMapping("/guardarMetodoDePago")
	public ResponseEntity<?> guardarMetodoDePago(@RequestBody MetodoDePagoDTO metodoDTO){
		try {
			MetodoDePago metodoPago = new MetodoDePago();
			metodoPago.setIdPago(metodoDTO.getIdPago());
			metodoPago.setNombre(metodoDTO.getNombre());
			metodoPago.setEstado(metodoDTO.getEstado());
			metodoDePagoService.agregarMetodoDePago(metodoPago);
			return ResponseEntity.ok().body(metodoPago);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());		}
	}
	
	
}
