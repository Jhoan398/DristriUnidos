package co.distriunidos.app.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*Creamos la clase MetodoDePago y le hacemos referencia con la tabla que esta en la 
 * base de datos*/
@Entity
@Table(name="METODO_PAGO")
public class MetodoDePago {
	
	/*Declaración de variables con su respectivo mapeo a la base de datos*/	
	
	@Id
	private Integer idPago;
	
	@Column(name= "nombre")
	private String nombre;
	
	@Column(name = "estado")
	private String estado;

	/*Getters and setters y constructor vacio*/	
	
	public MetodoDePago() {
		super();
	}

	public Integer getIdPago() {
		return idPago;
	}

	public void setIdPago(Integer idPago) {
		this.idPago = idPago;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
}
