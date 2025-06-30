package com.example.inventario;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase
class ProductoServiceTest {

    @Autowired
    private ProductoService service;

    @Autowired
    private ProductoRepository repository;

    @BeforeEach
    void setUp() {
        repository.deleteAll();

        Producto p1 = new Producto();
        p1.setNombre("Producto1");
        p1.setPrecio(10.0);
        p1.setCantidad(5);
        service.guardar(p1);

        Producto p2 = new Producto();
        p2.setNombre("Producto2");
        p2.setPrecio(15.0);
        p2.setCantidad(3);
        service.guardar(p2);
    }

    @Test
    void testListar() {
        List<Producto> productos = service.listar();
        assertEquals(2, productos.size());
    }

    @Test
    void testGuardar() {
        Producto nuevo = new Producto();
        nuevo.setNombre("Producto3");
        nuevo.setPrecio(20.0);
        nuevo.setCantidad(2);
        Producto saved = service.guardar(nuevo);
        assertNotNull(saved.getId());
        assertEquals(3, repository.count());
    }

    @Test
    void testEliminar() {
        Long id = service.listar().get(0).getId();
        service.eliminar(id);
        assertEquals(1, repository.count());
    }
}
