package co.distriunidos.app.dto;


/*Creamos la clase CarritoDeComprasDTO para recibir los datos que nos llegan por una petición url*/
public class CarritoDeComprasDTO {

	
	/*Declaración de variables*/
	private Integer idCarro;
	private Double total;
	String correo;
	Integer idPago;
	
	
	/*Getters and setters*/
	public Integer getIdCarro() {
		return idCarro;
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
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public Integer getIdPago() {
		return idPago;
	}
	public void setIdPago(Integer idPago) {
		this.idPago = idPago;
	}

	
	
}
