package co.distriunidos.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.distriunidos.app.domain.CarritoDeCompras;
import co.distriunidos.app.domain.Clientes;
import co.distriunidos.app.dto.ClientesDTO;
import co.distriunidos.app.repository.ClientesRepository;

/*Acá se implementan los metodos que estan en la interfaz del servicio*/
@Service
public class ClientesServiceImpl implements ClientesService{

	/*Declaramos los repositorios*/
	@Autowired
	ClientesRepository clientesRepository;
	@Autowired 
	CarritoDeComprasService carritoDeComprasService;
	@Autowired
	MetodoDePagoService metodoDePagoService; 
	
	
	/*Consultamos la lista de clientes y la retornamos*/
	@Override
	public List<Clientes> consultarClientes() throws Exception {
		List<Clientes> listClientes = clientesRepository.findAll();

		return listClientes;
	}


	/*agregamos el cliente recibiendo como parametro cliente y ClienteDTO para crear el carrito por defecto*/
	@Override
	public void agregarCliente(Clientes clientes, ClientesDTO clientesDTO) throws Exception {
		Clientes cliente = clientesRepository.save(clientes);
		carritoDeComprasService.agregarCarrito(buildCarrito(cliente, clientesDTO));
		
	}

	/*actualizamos el cliente recibiendo como parametro el objeto*/
	@Override
	public void actualizarCliente(Clientes clientes) throws Exception {
		clientesRepository.save(clientes);
		
	}

	/*Eliminamos el cliente recibiendo como parametro el objeto*/
	@Override
	public void eliminarCLiente(Clientes clientes) throws Exception {
		clientesRepository.delete(clientes);
	}


	/*consultamos el cliente por su respectiva llave primaria*/
	@Override
	public Clientes consultarClientePorCorreo(String correo) throws Exception {
		if(correo == null || correo.trim().equals("")) {
			throw new Exception("No se encontro ningún cliente");
		}
		return clientesRepository.findByCorreo(correo);
	}
	
	
	/*Construir el carro de compras recibiendo como parametros cliente y el ClienteDTO ya que el tiene el metodo de pago*/
	public CarritoDeCompras buildCarrito(Clientes clientes, ClientesDTO clientesDTO) throws Exception {
		CarritoDeCompras carrito = new CarritoDeCompras();
		if(clientesDTO.getMetodoPagoId() == null) {
			carrito.setIdPago(metodoDePagoService.consultarMetodoDePago(1));
		}
		carrito.setIdPago(metodoDePagoService.consultarMetodoDePago(clientesDTO.getMetodoPagoId()));
		carrito.setCorreo(clientes);
		carrito.setTotal(0D);
		return carrito;
	}
}
