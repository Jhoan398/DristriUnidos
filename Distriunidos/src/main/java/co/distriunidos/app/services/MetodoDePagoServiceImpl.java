package co.distriunidos.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.distriunidos.app.domain.MetodoDePago;
import co.distriunidos.app.repository.MetodoDePagoRepository;



/*Acá se implementan los metodos que estan en la interfaz del servicio*/
@Service
public class MetodoDePagoServiceImpl implements MetodoDePagoService{
	@Autowired 
	MetodoDePagoRepository metodoDePagoR;
	
	/*Agregamos el metodo de pago recibiendo como parametro el objeto*/
	@Override
	public void agregarMetodoDePago(MetodoDePago metodoPago) throws Exception {
		metodoDePagoR.save(metodoPago);
	}
	/*Actualizamos el metodo de pago recibiendo como parametro el objeto*/
	@Override
	public void actualizarMetodoDePago(MetodoDePago metodoPago) throws Exception {
		metodoDePagoR.save(metodoPago);
	}
	/*Consultamos el metodo de pago por su respectiva llave primaria y lo retornamos*/
	@Override
	public MetodoDePago consultarMetodoDePago(Integer idPago) throws Exception {
		if(idPago == null) {
			throw new Exception("Se debe ingresar un numero de identificación valido");
		}
		return metodoDePagoR.findByIdPago(idPago);
	}


	
}
