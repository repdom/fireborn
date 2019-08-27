package com.firebornserviciocompras.com.firebornserviciocompras.servicios;

import com.firebornserviciocompras.com.firebornserviciocompras.entidad.Producto;
import com.firebornserviciocompras.com.firebornserviciocompras.entidad.Venta;
import com.firebornserviciocompras.com.firebornserviciocompras.repositorios.ProductoRepository;
import com.firebornserviciocompras.com.firebornserviciocompras.repositorios.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Service
public class ServicioProducto {
    @Autowired
    ProductoRepository productoRepository;

    @Autowired
    VentaRepository ventaRepository;

    public void crearProductos() {
        Producto producto1 = new Producto();
        Producto producto2 = new Producto();
        Producto producto3 = new Producto();
        Producto producto4 = new Producto();

        producto1.setCosto(1000);
        producto1.setNombreProducto("Pre-Boda");

        producto2.setCosto(5000);
        producto2.setNombreProducto("Boda");

        producto3.setCosto(3000);
        producto3.setNombreProducto("Cumpleaños");

        producto4.setCosto(4000);
        producto4.setNombreProducto("Vídeo de evento");

        productoRepository.save(producto1);
        productoRepository.save(producto2);
        productoRepository.save(producto3);
        productoRepository.save(producto4);
    }

    public Venta crearVenta(Producto producto, String codigoUsuario) {
        Venta venta = new Venta();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        Date date = new Date();

        venta.setUsuario(codigoUsuario);
        venta.setMonto(producto.getCosto());
        venta.setProducto(producto);
        venta.setFecha_venta(date);

        ventaRepository.save(venta);

        return venta;
    }
}
