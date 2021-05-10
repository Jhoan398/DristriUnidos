package co.distriunidos.app.services;

import java.util.List;

import co.distriunidos.app.domain.Clientes;
import co.distriunidos.app.dto.ClientesDTO;

/*Creamos el servicio donde vamos a declarar la firma de los metodos*/
public interface ClientesService {

	
	public List<Clientes> consultarClientes()throws Exception;
	public void agregarCliente(Clientes clientes,ClientesDTO clientesDTO)throws Exception;
	public void actualizarCliente(Clientes clientes)throws Exception;
	public void eliminarCLiente (Clientes clientes)throws Exception;
	public Clientes consultarClientePorCorreo(String correo)throws Exception;
	
}
