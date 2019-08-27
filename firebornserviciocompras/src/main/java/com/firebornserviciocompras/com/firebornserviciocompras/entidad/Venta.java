package com.firebornserviciocompras.com.firebornserviciocompras.entidad;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Venta {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long codigo;
    private float monto;
    private String usuario;
    private Date fecha_venta;

    @ManyToOne(fetch = FetchType.LAZY)
    private Producto producto;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Date getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(Date fecha_venta) {
        this.fecha_venta = fecha_venta;
    }
}
