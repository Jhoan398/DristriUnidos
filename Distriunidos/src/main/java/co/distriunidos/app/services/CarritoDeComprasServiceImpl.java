package co.distriunidos.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.distriunidos.app.domain.CarritoDeCompras;
import co.distriunidos.app.dto.CarritoDeComprasDTO;
import co.distriunidos.app.repository.CarritoDeComprasRepository;

/*Acá se implementan los metodos que estan en la interfaz del servicio*/
@Service
public class CarritoDeComprasServiceImpl implements CarritoDeComprasService {

	@Autowired
	CarritoDeComprasRepository carritoR;

	@Autowired
	ProductosAComprarService productosAComprarService;

	@Override
	public void agregarCarrito(CarritoDeCompras carrito) throws Exception {
		carritoR.save(carrito);
	}

	/*
	 * Traemos de la base de datos todos los carritos de compras y los convertimos
	 * en DTO para poder mostrarlos
	 */
	@Override
	public List<CarritoDeComprasDTO> consultarCarrosDeCompras() throws Exception {
		return buildconsultarCarrosDeCompras(carritoR.findAll());
	}

	/* Consultamos el carrito de comprar por el id */
	@Override
	public CarritoDeComprasDTO consultarCarritoDeComprasDTO(Integer id) throws Exception {
		CarritoDeCompras carro = carritoR.findByIdCarro(id);
		return buildDtoCarrito(carro);
	}

	@Override
	public CarritoDeCompras consultarCarritoDeCompras(Integer id) throws Exception {
		CarritoDeCompras carro = carritoR.findByIdCarro(id);
		return (carro);
	}

	/* Se construte un DTO con el objeto carritoDeCompras */
	public CarritoDeComprasDTO buildDtoCarrito(CarritoDeCompras carritoDeCompras) throws Exception {

		CarritoDeComprasDTO carritoDeComprasDTO = new CarritoDeComprasDTO();
		carritoDeComprasDTO.setCorreo(carritoDeCompras.getCorreo().getCorreo());
		carritoDeComprasDTO.setIdCarro(carritoDeCompras.getIdCarro());
		carritoDeComprasDTO.setIdPago(carritoDeCompras.getIdPago().getIdPago());
		carritoDeComprasDTO.setTotal(carritoDeCompras.getTotal());

		return carritoDeComprasDTO;
	}

	/*
	 * Recibimos una lista de carritos de compras y la convertimos en DTO para no
	 * mostrar todos los demas objetos
	 */
	@Override
	public List<CarritoDeComprasDTO> buildconsultarCarrosDeCompras(List<CarritoDeCompras> listaCarritoDeCompras)
			throws Exception {
		List<CarritoDeComprasDTO> lstCarritoDeComprasDTO = new ArrayList<>();
		for (CarritoDeCompras carritoDeCompras : listaCarritoDeCompras) {
			lstCarritoDeComprasDTO.add(buildDtoCarrito(carritoDeCompras));
		}
		return lstCarritoDeComprasDTO;
	}

}
