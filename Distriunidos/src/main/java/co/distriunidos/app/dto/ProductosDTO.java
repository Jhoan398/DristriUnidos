package co.distriunidos.app.dto;

/*Creamos la clase ProductosDTO para recibir los datos que nos llegan por una petición url*/
public class ProductosDTO {

	/*Declaración de variables*/
	private Integer idProd;
	private String nombre;
	private double precio;
	private String detalle;
	private String estado;

	/*Getters and setters*/
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
