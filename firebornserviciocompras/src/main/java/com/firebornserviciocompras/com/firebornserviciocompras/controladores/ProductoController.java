package com.firebornserviciocompras.com.firebornserviciocompras.controladores;

import com.firebornserviciocompras.com.firebornserviciocompras.controladores.DAO.ProductoDAO;
import com.firebornserviciocompras.com.firebornserviciocompras.controladores.DAO.VentaDAO;
import com.firebornserviciocompras.com.firebornserviciocompras.entidad.Producto;
import com.firebornserviciocompras.com.firebornserviciocompras.entidad.Venta;
import com.firebornserviciocompras.com.firebornserviciocompras.repositorios.ProductoRepository;
import com.firebornserviciocompras.com.firebornserviciocompras.repositorios.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class ProductoController {
    @Autowired
    ProductoRepository productoRepository;

    @Autowired
    VentaRepository ventaRepository;

    @PostMapping("/venta")
    public VentaDAO agregandoVenta(@RequestBody VentaDAO ventaDao) {
        Producto producto = productoRepository.findById(ventaDao.producto).get();
        Venta venta = new Venta();

        venta.setFecha_venta(new Date());
        venta.setProducto(producto);
        venta.setMonto(ventaDao.monto);
        venta.setUsuario(ventaDao.usuario);

        Venta v = ventaRepository.save(venta);
        VentaDAO vDao = new VentaDAO();

        vDao.monto = v.getMonto();
        vDao.producto = producto.getNombreProducto();
        vDao.usuario = v.getUsuario();

        return vDao;
    }

    @GetMapping("/venta")
    public ArrayList<ProductoDAO> productos() {
        List<Producto> productos = productoRepository.findAll();
        ArrayList<ProductoDAO> productoDAOS = new ArrayList<>();
        for(Producto p: productos) {
            ProductoDAO pDao = new ProductoDAO();
            pDao.costo = p.getCosto();
            pDao.nombreProducto = p.getNombreProducto();
            productoDAOS.add(pDao);
        }
        return productoDAOS;
    }
}
