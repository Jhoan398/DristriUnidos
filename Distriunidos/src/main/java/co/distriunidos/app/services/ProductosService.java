package co.distriunidos.app.services;

import java.util.List;

import org.springframework.stereotype.Service;

import co.distriunidos.app.domain.Productos;

/*Creamos el servicio donde vamos a declarar la firma de los metodos*/
@Service
public interface ProductosService {

	public void agregarProducto(Productos producto) throws Exception;
	public void actualizarProducto(Productos producto) throws Exception;
	public void eliminarProducto(Productos producto) throws Exception;
	public List<Productos> consultarProductos() throws Exception;
	public Productos buscarProductoPorId(Integer id) throws Exception;
	
}
