package co.distriunidos.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.distriunidos.app.domain.CarritoDeCompras;
import co.distriunidos.app.domain.ProductosAComprar;
import co.distriunidos.app.dto.ProductosAComprarDTO;
import co.distriunidos.app.repository.CarritoDeComprasRepository;
import co.distriunidos.app.repository.ProductosAComprarRepository;

/*Acá se implementan los metodos que estan en la interfaz del servicio*/
@Service
public class ProductosAComprarServiceImpl implements ProductosAComprarService {

	@Autowired
	ProductosAComprarRepository productosAComprarRepository;
	@Autowired
	ClientesService clienteService;
	@Autowired
	CarritoDeComprasService carritoService;

	@Autowired
	ProductosService productosService;

	/* Se añade el productos a comprar y se actualiza el total del carrito */
	@Override
	public ProductosAComprarDTO agregarCarrito(ProductosAComprar productosAComprar) throws Exception {
		if (productosAComprar.getIdProd() == null) {
			throw new Exception("No existe el producto");
		}
		if (productosAComprar.getIdCarro() == null) {
			throw new Exception("No existe el carrito");
		}
		/*
		 * Consulto el carrito de compras, valido si no esta vacia y le sumo las
		 * cantidades
		 */
		
		/*Consulto la lista de productos del carrito, para saber que productos ya ha añadido*/
		List<ProductosAComprarDTO> lstProductosAComprar = buscarCarrito(productosAComprar.getIdCarro().getIdCarro());
		
		
		/*Consulto el carrito*/
		CarritoDeCompras carro = carritoService.consultarCarritoDeCompras(productosAComprar.getIdCarro().getIdCarro());
		
		
		Double totalAux;
		carro.setTotal(0D);

		if (!lstProductosAComprar.isEmpty()) {
			for (ProductosAComprarDTO productosAComprarDTO : lstProductosAComprar) {
				if (productosAComprarDTO.getIdProd() == productosAComprar.getIdProd().getIdProd()) {
					Integer aux;
					Double auxTotal;
					aux = productosAComprar.getCantidad() + productosAComprarDTO.getCantidad();
					productosAComprar.setCantidad(aux);
					auxTotal = productosAComprar.getTotal() + productosAComprarDTO.getTotal();
					productosAComprar.setTotal(auxTotal);
					productosAComprar.setIdCompra(productosAComprarDTO.getIdCompra());
				}

			}

		}
		/* Guarda o actualiza el producto en el carrito*/
		ProductosAComprarDTO productosAComprarDTO = buildProdAComprarDTO(productosAComprarRepository.save(productosAComprar));
		/*Vuelve a consultar la lista de productos por carrito*/
		List<ProductosAComprarDTO> lstProductosAComprar2 = buscarCarrito(productosAComprar.getIdCarro().getIdCarro());
		for (ProductosAComprarDTO aux : lstProductosAComprar2) {
			totalAux = carro.getTotal() + aux.getTotal();
			carro.setTotal(totalAux);
		}
		/*actualiza el carrito*/
		carritoService.agregarCarrito(carro);
		return productosAComprarDTO;
	}

	/* Busca la lista de productos por carrito */
	@Override
	public List<ProductosAComprarDTO> buscarCarrito(Integer idCarro) throws Exception {
		return buildProdAComprarDTOList(productosAComprarRepository.findAllByIdCarro_idCarro(idCarro));
	}

	/*
	 * Recibe una lista de ProductosAComprar y retorna una lista de
	 * ProductosAComprarDTO
	 */
	public List<ProductosAComprarDTO> buildProdAComprarDTOList(List<ProductosAComprar> productosAComprarList) {
		List<ProductosAComprarDTO> productosAComprarDTOs = new ArrayList<>();

		for (ProductosAComprar productosAComprar : productosAComprarList) {
			productosAComprarDTOs.add(buildProdAComprarDTO(productosAComprar));
		}
		return productosAComprarDTOs;
	}

	/*
	 * Recibe el objeto productos a comprar y lo convierte a DTO, para no mostrar
	 * todo el objeto
	 */
	public ProductosAComprarDTO buildProdAComprarDTO(ProductosAComprar productosAComprar) {
		ProductosAComprarDTO productosAComprarDTO = new ProductosAComprarDTO();
		productosAComprarDTO.setCantidad(productosAComprar.getCantidad());
		productosAComprarDTO.setIdCarro(productosAComprar.getIdCarro().getIdCarro());
		productosAComprarDTO.setIdCompra(productosAComprar.getIdCompra());
		productosAComprarDTO.setIdProd(productosAComprar.getIdProd().getIdProd());
		productosAComprarDTO.setTotal(productosAComprar.getTotal());

		return productosAComprarDTO;

	}

}
