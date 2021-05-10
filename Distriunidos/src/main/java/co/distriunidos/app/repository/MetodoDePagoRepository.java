package co.distriunidos.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import co.distriunidos.app.domain.MetodoDePago;
/**
 * @author Jhoan Saldarriaga
 *
 */
/*Creamos una inteface donde va heredar los metodos del JPA para las consultas en la base de datos*/
public interface MetodoDePagoRepository extends JpaRepository<MetodoDePago, Integer>{

	public MetodoDePago findByIdPago(@Param("pIdPago")Integer IdPago);
}
