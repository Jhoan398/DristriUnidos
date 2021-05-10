package co.distriunidos.app.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/*Creamos la clase ProductosAComprar y le hacemos referencia con la tabla que esta en la 
 * base de datos*/
@Entity
@Table(name = "PRODUCTOS_A_COMPRAR")
public class ProductosAComprar implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4743754723083757366L;

	/*Declaración de variables con su respectivo mapeo a la base de datos*/	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCompra;

	@Column(name = "cantidad")
	private Integer cantidad;

	@Column(name = "total")
	private Double total;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_carro")
	CarritoDeCompras idCarro;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_prod")
	Productos idProd;

	
	/*Getters and setters y constructor vacio*/
	public ProductosAComprar() {
		super();
	}

	public Integer getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(Integer idCompra) {
		this.idCompra = idCompra;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public CarritoDeCompras getIdCarro() {
		return idCarro;
	}

	public void setIdCarro(CarritoDeCompras idCarro) {
		this.idCarro = idCarro;
	}

	public Productos getIdProd() {
		return idProd;
	}

	public void setIdProd(Productos idProd) {
		this.idProd = idProd;
	}
	
	

}
