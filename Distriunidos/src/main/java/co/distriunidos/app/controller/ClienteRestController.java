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

import co.distriunidos.app.domain.Clientes;
import co.distriunidos.app.dto.ClientesDTO;
import co.distriunidos.app.services.ClientesService;
/**
 * @author Jhoan Saldarriaga
 *
 */
/*Creamos el controlador que es el que va a generar las peticiones de sus respectivos procesos*/
@RestController
@RequestMapping("/api/cliente")
public class ClienteRestController {
 
	@Autowired
	ClientesService clientesService;

	/*Escribimos la peticion url para guardar al cliente*/
	@PostMapping("/guardarClientes")
	public ResponseEntity<?> guardarCliente(@RequestBody ClientesDTO clientesDTO){
		try {
			/*Creamos un objeto cliente y le insertamos lo que nos llega de petición*/
			Clientes cliente = new Clientes();
			cliente.setCorreo(clientesDTO.getCorreo());
			cliente.setContraseña(clientesDTO.getContraseña());
			cliente.setDireccion(clientesDTO.getDireccion());
			cliente.setNombre(clientesDTO.getNombre());
			cliente.setTelefono(clientesDTO.getTelefono());
			cliente.setEstado(clientesDTO.getEstado());
			clientesService.agregarCliente(cliente,clientesDTO);
			return ResponseEntity.ok().body(cliente);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		
	}

	/*Escribimos la peticion url para actualizar al cliente*/
	@PostMapping("/actualizarClientes")
	public ResponseEntity<?> actualizarCliente(@RequestBody ClientesDTO clientesDTO){
		try {
			/*Consultamos el correo del cliente y le insertamos los nuevos datos que nos llega de la peticion*/
			Clientes cliente = clientesService.consultarClientePorCorreo(clientesDTO.getCorreo());
			cliente.setContraseña(clientesDTO.getContraseña());
			cliente.setDireccion(clientesDTO.getDireccion());
			cliente.setNombre(clientesDTO.getNombre());
			cliente.setTelefono(clientesDTO.getTelefono());
			cliente.setEstado(clientesDTO.getEstado());
			clientesService.agregarCliente(cliente,clientesDTO);
			return ResponseEntity.ok().body(cliente);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		
	}
	
	
	/*Escribimos la peticion url para consultar los clientes*/
	@GetMapping("/consultarClientes")
	public ResponseEntity<?> consultarClientes(){
		try {
			/*Retornamos la lista que nos trae el servicio*/
			return ResponseEntity.ok().body(clientesService.consultarClientes());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());

		}
	}
	
	/*Eliminamos el cliente por parametro recibiendo su respectiva llave primaria*/
	@DeleteMapping("/eliminarCliente")
	public ResponseEntity<?> eliminarClientes(@RequestParam("correo") String correo){
		try {
			/*creamos el objeto cliente y lo igualamos con la consulta, esta nos trae el cliente especifico por su correo*/
			Clientes cliente = clientesService.consultarClientePorCorreo(correo);
			clientesService.eliminarCLiente(cliente);
			return ResponseEntity.ok().body("Se elimino satisfactoriamente");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	
	/*Consultamos el cliente por su respectiva llave primaria*/
	@GetMapping("/consultarCliente")
	public ResponseEntity<?> consultarClientePorCorreo(@RequestParam("correo") String correo){
		try {
			Clientes cliente = clientesService.consultarClientePorCorreo(correo);
			
			return ResponseEntity.ok().body(cliente);
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());		}
	}
	
}
