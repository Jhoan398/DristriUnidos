package co.distriunidos.app.services;

import java.util.List;

import org.springframework.stereotype.Service;

import co.distriunidos.app.domain.CarritoDeCompras;
import co.distriunidos.app.dto.CarritoDeComprasDTO;


/*Creamos el servicio donde vamos a declarar la firma de los metodos*/
@Service
public interface CarritoDeComprasService {

	
	public void agregarCarrito(CarritoDeCompras carrito) throws Exception;
	public List<CarritoDeCompras> consultarCarrosDeCompras() throws Exception;
	public CarritoDeCompras consultarCarritoDeCompras(Integer id)throws Exception;
	CarritoDeComprasDTO consultarCarritoDeComprasDTO(Integer id) throws Exception;
	
}
