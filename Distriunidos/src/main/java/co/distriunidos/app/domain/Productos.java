package co.distriunidos.app.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/*Creamos la clase Productos y le hacemos referencia con la tabla que esta en la 
 * base de datos*/
@Entity
@Table(name = "PRODUCTOS")
public class Productos {
	
	/*Declaración de variables con su respectivo mapeo a la base de datos*/	
	@Id
	private Integer idProd;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "precio")
	private double precio;
	@Column(name = "detalle")
	private String detalle;
	@Column(name = "estado")
	private String estado;

	/*Getters and setters y constructor vacio*/	
	public Productos() {
		super();
	}

	public Integer getIdProd() {
		return idProd;
	}

	public void setIdProd(Integer idProd) {
		this.idProd = idProd;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
