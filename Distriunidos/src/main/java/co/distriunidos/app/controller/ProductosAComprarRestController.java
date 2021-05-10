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
import co.distriunidos.app.domain.Productos;
import co.distriunidos.app.domain.ProductosAComprar;
import co.distriunidos.app.dto.ProductosAComprarDTO;
import co.distriunidos.app.services.CarritoDeComprasService;
import co.distriunidos.app.services.ClientesService;
import co.distriunidos.app.services.ProductosAComprarService;
import co.distriunidos.app.services.ProductosService;
/**
 * @author Jhoan Saldarriaga
 *
 */
/*Creamos el controlador que es el que va a generar las peticiones de sus respectivos procesos*/
@RestController
@RequestMapping("/api/productosAComprar")
public class ProductosAComprarRestController {

	@Autowired
	ClientesService clienteService;
	@Autowired
	CarritoDeComprasService carritoService;

	@Autowired
	ProductosService productosService;
	@Autowired
	ProductosAComprarService productosAComprarService;

	@PostMapping("/agregarCarroDeCompras")
	public ResponseEntity<?> agregarCarroDeCompras(@RequestBody ProductosAComprarDTO productosAComprarDTO) {
		try {
			CarritoDeCompras carritoDeCompras = carritoService.consultarCarritoDeCompras(productosAComprarDTO.getIdCarro());
			Productos productos = productosService.buscarProductoPorId(productosAComprarDTO.getIdProd());

			ProductosAComprar productosAComprar = new ProductosAComprar();
			productosAComprar.setIdCompra(productosAComprarDTO.getIdCompra());
			productosAComprar.setCantidad(productosAComprarDTO.getCantidad());
			productosAComprar.setIdProd(productos);
			productosAComprar.setIdCarro(carritoDeCompras);
			productosAComprar.setTotal(productosAComprarDTO.getCantidad() * productos.getPrecio());

			return ResponseEntity.ok().body(productosAComprarService.agregarCarrito(productosAComprar));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}

	}
	
	@GetMapping("/consultarCarroDeCompras/{idCarro}")
	public ResponseEntity<?> consultarCarroPorId(@PathVariable ("idCarro")Integer idCarro){
		try {
			return ResponseEntity.ok().body(productosAComprarService.buscarCarrito(idCarro));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		
	}

}
