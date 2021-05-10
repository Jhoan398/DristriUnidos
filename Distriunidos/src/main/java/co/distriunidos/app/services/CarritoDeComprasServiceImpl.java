package co.distriunidos.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.distriunidos.app.domain.CarritoDeCompras;
import co.distriunidos.app.dto.CarritoDeComprasDTO;
import co.distriunidos.app.dto.ProductosAComprarDTO;
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

	@Override
	public List<CarritoDeCompras> consultarCarrosDeCompras() throws Exception {
		List<CarritoDeCompras> lstCarritoDeCompras = carritoR.findAll();
		return lstCarritoDeCompras;
	}

	/*Consultamos el carrito de comprar por el id*/
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

	/* Se construte un DTO y se calcula el total del carrito */
	public CarritoDeComprasDTO buildDtoCarrito(CarritoDeCompras carritoDeCompras) throws Exception {

		CarritoDeComprasDTO carritoDeComprasDTO = new CarritoDeComprasDTO();
		carritoDeComprasDTO.setCorreo(carritoDeCompras.getCorreo().getCorreo());
		carritoDeComprasDTO.setIdCarro(carritoDeCompras.getIdCarro());
		carritoDeComprasDTO.setIdPago(carritoDeCompras.getIdPago().getIdPago());
		carritoDeComprasDTO.setTotal(carritoDeCompras.getTotal());


		return carritoDeComprasDTO;
	}

}
