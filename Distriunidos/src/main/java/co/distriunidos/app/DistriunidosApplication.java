package co.distriunidos.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import co.distriunidos.app.domain.Clientes;
import co.distriunidos.app.repository.CarritoDeComprasRepository;
import co.distriunidos.app.repository.ClientesRepository;
import co.distriunidos.app.repository.MetodoDePagoRepository;
import co.distriunidos.app.repository.ProductosAComprarRepository;
import co.distriunidos.app.repository.ProductosRepository;

@SpringBootApplication
public class DistriunidosApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(DistriunidosApplication.class, args);
	}

	

}
