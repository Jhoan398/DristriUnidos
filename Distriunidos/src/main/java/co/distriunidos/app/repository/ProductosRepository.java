package co.distriunidos.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import co.distriunidos.app.domain.Productos;

/**
 * @author Jhoan Saldarriaga
 *
 */

/*Creamos una inteface donde va heredar los metodos del JPA para las consultas en la base de datos*/
public interface ProductosRepository extends JpaRepository<Productos, Integer> {

	public Productos findByIdProd(@Param("pIdProd") Integer idProd);
}
