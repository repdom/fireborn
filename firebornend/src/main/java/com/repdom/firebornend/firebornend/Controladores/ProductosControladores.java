package com.repdom.firebornend.firebornend.Controladores;

import com.repdom.firebornend.firebornend.Controladores.DAO.ProductoDAO;
import com.repdom.firebornend.firebornend.Controladores.DAO.VentaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/productos/")
public class ProductosControladores {
    @Autowired
    RestTemplate restTemplate;

    @PostMapping()
    @CrossOrigin(origins = "http://localhost:4200")
    public VentaDAO agregarVenta(@RequestBody VentaDAO ventaDAO) {
        VentaDAO v = restTemplate.postForObject("http://TIENDAFIREBORN-COMPRASYSERVICIOS/api/venta", ventaDAO, VentaDAO.class);
        return v;
    }

    @GetMapping
    @CrossOrigin(origins = "http://localhost:4200")
    public ProductoDAO[] getProductos() {
        return restTemplate.getForObject("http://TIENDAFIREBORN-COMPRASYSERVICIOS/api/venta", ProductoDAO[].class);
    }
}
