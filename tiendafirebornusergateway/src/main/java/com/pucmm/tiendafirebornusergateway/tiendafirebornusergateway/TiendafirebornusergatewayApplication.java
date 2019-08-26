package com.pucmm.tiendafirebornusergateway.tiendafirebornusergateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class TiendafirebornusergatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(TiendafirebornusergatewayApplication.class, args);
	}

}
