package co.distriunidos.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.distriunidos.app.domain.Productos;
import co.distriunidos.app.repository.ProductosRepository;

/*Acá se implementan los metodos que estan en la interfaz del servicio*/
@Service
public class ProductosServiceImpl implements ProductosService {
	@Autowired
	ProductosRepository productoR;

	/*Agregamos el producto recibiendo como parametro el objeto*/
	@Override
	public void agregarProducto(Productos producto) throws Exception {
		productoR.save(producto);
	}

	@Override
	public void actualizarProducto(Productos producto) throws Exception {
		productoR.save(producto);

	}

	@Override
	public void eliminarProducto(Productos producto) throws Exception {
		productoR.delete(producto);

	}

	@Override
	public List<Productos> consultarProductos() throws Exception {
		List<Productos> lstProductos = productoR.findAll();
		return lstProductos;
	}

	@Override
	public Productos buscarProductoPorId(Integer id) throws Exception {
		if(id == null) {
			throw new Exception("No se encontro ningún producto");
		}
		return productoR.findByIdProd(id);

	}

}
