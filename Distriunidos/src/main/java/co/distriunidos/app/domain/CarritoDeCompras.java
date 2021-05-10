package co.distriunidos.app.domain;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*Creamos la clase carrito de compras y le hacemos referencia con la tabla que esta en la 
 * base de datos*/
@Entity
@Table(name= "CARRITO_DE_COMPRAS")
public class CarritoDeCompras implements Serializable{

	

/**
	 * 
	 */
	private static final long serialVersionUID = 732763177808334217L;
/*Declaración de variables con su respectivo mapeo a la base de datos*/	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCarro;
	
	private Double total;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "correo")
	Clientes correo;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pago")
	MetodoDePago idPago;
		
/*Getters and setters y constructor vacio*/	
	public void setIdPago(MetodoDePago idPago) {
		this.idPago = idPago;
	}
	public CarritoDeCompras() {
		super();
	}
	public Integer getIdCarro() {
		return idCarro;
	}
	public MetodoDePago getIdPago() {
		return idPago;
	}
	public void setIdCarro(Integer idCarro) {
		this.idCarro = idCarro;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Clientes getCorreo() {
		return correo;
	}
	public void setCorreo(Clientes correo) {
		this.correo = correo;
	}

	
	
}
