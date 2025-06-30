package com.example.inventario;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ProductoServiceTests {

    @Autowired
    private ProductoService service;
    @Autowired
    private ProductoRepository repository;

    @Test
    void registrarYObtenerProducto() {
        Producto p = new Producto();
        p.setNombre("Prueba");
        p.setPrecio(10.0);
        p.setCantidad(2);
        Producto guardado = service.guardar(p);
        assertThat(guardado.getId()).isNotNull();

        Producto obtenido = repository.findById(guardado.getId()).orElse(null);
        assertThat(obtenido).isNotNull();
        assertThat(obtenido.getNombre()).isEqualTo("Prueba");

        List<Producto> productos = service.listar();
        assertThat(productos).extracting(Producto::getId).contains(guardado.getId());
    }
}
