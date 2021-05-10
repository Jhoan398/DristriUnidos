package co.distriunidos.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.distriunidos.app.domain.ProductosAComprar;
/**
 * @author Jhoan Saldarriaga
 *
 */
/*Creamos una inteface donde va heredar los metodos del JPA para las consultas en la base de datos*/
public interface ProductosAComprarRepository extends JpaRepository<ProductosAComprar, Integer> {
	
	List<ProductosAComprar> findAllByIdCarro_idCarro(Integer idCarrito);

}
