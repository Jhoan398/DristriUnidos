package co.distriunidos.app.services;

import java.util.List;

import co.distriunidos.app.domain.ProductosAComprar;
import co.distriunidos.app.dto.ProductosAComprarDTO;

/*Creamos el servicio donde vamos a declarar la firma de los metodos*/
public interface ProductosAComprarService {

	public ProductosAComprarDTO agregarCarrito(ProductosAComprar productosAComprar) throws Exception;

	List<ProductosAComprarDTO> buscarCarrito(Integer idCarro) throws Exception;

}
