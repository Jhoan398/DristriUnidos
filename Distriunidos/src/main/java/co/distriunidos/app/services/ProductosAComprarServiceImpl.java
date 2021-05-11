package co.distriunidos.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.distriunidos.app.domain.CarritoDeCompras;
import co.distriunidos.app.domain.ProductosAComprar;
import co.distriunidos.app.dto.ProductosAComprarDTO;
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
		/*Validaciones*/
		if (productosAComprar.getIdProd() == null) {
			throw new Exception("No existe el producto");
		}
		if (productosAComprar.getIdCarro() == null) {
			throw new Exception("No existe el carrito");
		}
		
		
		/*Consulto la lista de productos que se agregan*/
		List<ProductosAComprarDTO> lstProductosAComprar = buscarCarrito(productosAComprar.getIdCarro().getIdCarro());
		
		
		/*Consulto el objeto carrito en la base de datos*/
		CarritoDeCompras carro = carritoService.consultarCarritoDeCompras(productosAComprar.getIdCarro().getIdCarro());
		
		Double totalAux;
		/*Se coloca en 0 para volver a recalcular el total*/
		carro.setTotal(0D);

		/*Valido si la lista no se encuentra vacia*/
		if (!lstProductosAComprar.isEmpty()) {
			/*Recorro la lista de productos y lo almaceno en el productos a comprar DTO*/
			for (ProductosAComprarDTO productosAComprarDTO : lstProductosAComprar) {
				/*Valido si el id del producto es igual al que esta en la base de datos*/
				if (productosAComprarDTO.getIdProd() == productosAComprar.getIdProd().getIdProd()) {
					Integer aux;
					Double auxTotal;
					aux = productosAComprar.getCantidad() + productosAComprarDTO.getCantidad();
					productosAComprar.setCantidad(aux);
					auxTotal = productosAComprar.getTotal() + productosAComprarDTO.getTotal();
					productosAComprar.setTotal(auxTotal);
					/*Vuelo a poner el codigo de compra para que me lo actualice*/
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

	/* Busca la lista de productos por carrito y lo convierto en un DTO */
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
