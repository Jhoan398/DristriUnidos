package co.distriunidos.app.services;

import co.distriunidos.app.domain.MetodoDePago;

/*Creamos el servicio donde vamos a declarar la firma de los metodos*/
public interface MetodoDePagoService {
	
	public void agregarMetodoDePago(MetodoDePago metodoPago) throws Exception;
	public void actualizarMetodoDePago(MetodoDePago metodoPago) throws Exception;
	public MetodoDePago consultarMetodoDePago(Integer idPago) throws Exception;

}
