package com.firebornserviciocompras.com.firebornserviciocompras;

import com.firebornserviciocompras.com.firebornserviciocompras.repositorios.VentaRepository;
import com.firebornserviciocompras.com.firebornserviciocompras.servicios.ServicioProducto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EnableEurekaClient
public class FirebornserviciocomprasApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(FirebornserviciocomprasApplication.class, args);

		ServicioProducto productoServices = (ServicioProducto) applicationContext.getBean("servicioProducto");
		productoServices.crearProductos();

	}

}
