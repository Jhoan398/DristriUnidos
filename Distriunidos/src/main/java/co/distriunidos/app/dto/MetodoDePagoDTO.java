package co.distriunidos.app.dto;

/*Creamos la clase MetodoDePagoDTO para recibir los datos que nos llegan por una petición url*/
public class MetodoDePagoDTO {
	
	/*Declaración de variables*/
	private Integer idPago;
	private String nombre;
	private String estado;
	
	/*Getters and setters*/
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
