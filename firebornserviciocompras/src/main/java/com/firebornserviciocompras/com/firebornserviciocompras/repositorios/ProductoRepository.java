package com.firebornserviciocompras.com.firebornserviciocompras.repositorios;

import com.firebornserviciocompras.com.firebornserviciocompras.entidad.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, String> {
}
