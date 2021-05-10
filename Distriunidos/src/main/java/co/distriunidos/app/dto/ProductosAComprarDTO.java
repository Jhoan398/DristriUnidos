package co.distriunidos.app.dto;

/*Creamos la clase ProductosAComprarDTO para recibir los datos que nos llegan por una petición url*/
public class ProductosAComprarDTO {

	/*Declaración de variables*/
	private Integer idCompra;
	private Integer cantidad;
	private Double total;
	private Integer idCarro;
	private Integer idProd;
	
	/*Getters and setters*/
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
	public Integer getIdCarro() {
		return idCarro;
	}
	public void setIdCarro(Integer idCarro) {
		this.idCarro = idCarro;
	}
	public Integer getIdProd() {
		return idProd;
	}
	public void setIdProd(Integer idProd) {
		this.idProd = idProd;
	}


	
}
