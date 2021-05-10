package co.distriunidos.app.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.distriunidos.app.domain.Productos;
import co.distriunidos.app.dto.ProductosDTO;
import co.distriunidos.app.services.ProductosService;
/**
 * @author Jhoan Saldarriaga
 *
 */
/*Creamos el controlador que es el que va a generar las peticiones de sus respectivos procesos*/
@RestController
@RequestMapping("/api/productos")
public class ProductosRestController {
	
	@Autowired
	ProductosService productosService;
	
	
	@PostMapping("/guardarProducto")
	public ResponseEntity<?> guardarProducto(@RequestBody ProductosDTO productoDTO){
		try {
			Productos producto = new Productos();
			producto.setIdProd(productoDTO.getIdProd());
			producto.setNombre(productoDTO.getNombre());
			producto.setPrecio(productoDTO.getPrecio());
			producto.setEstado(productoDTO.getEstado());
			producto.setDetalle(productoDTO.getDetalle());
			productosService.agregarProducto(producto);
			return ResponseEntity.ok().body(producto);
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	} 
	
	
	@PostMapping("/actualizarProducto")
	public ResponseEntity<?> actualizarProducto(@RequestBody ProductosDTO productoDTO){
		try {
			Productos producto = productosService.buscarProductoPorId(productoDTO.getIdProd());
			producto.setNombre(productoDTO.getNombre());
			producto.setPrecio(productoDTO.getPrecio());
			producto.setEstado(productoDTO.getEstado());
			producto.setDetalle(productoDTO.getDetalle());
			productosService.actualizarProducto(producto);
			return ResponseEntity.ok().body(producto);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@GetMapping("/consultarProductos")
	public ResponseEntity<?> consultarProductos(){
		try {
			
			return ResponseEntity.ok().body(productosService.consultarProductos());
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());

		}
	}
	
	@GetMapping("/consultarProductoPorId")
	public ResponseEntity<?> consultarProductoPorId(@RequestParam ("idProd") Integer idProd){
		try {
			Productos producto = productosService.buscarProductoPorId(idProd);
			return ResponseEntity.ok().body(producto);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());

		}
	}
	
	@DeleteMapping("/eliminarProducto")
	public ResponseEntity<?> eliminarProducto(@RequestParam ("idProd") Integer idProd){
		try {
			Productos producto = productosService.buscarProductoPorId(idProd);
			productosService.eliminarProducto(producto);
			return ResponseEntity.ok().body("Se elimino satifactoriamente");
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	
}
