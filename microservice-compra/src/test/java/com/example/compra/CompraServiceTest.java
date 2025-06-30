package com.example.compra;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase
class CompraServiceTest {

    @Autowired
    private CompraService service;

    @Autowired
    private CompraRepository repository;

    @BeforeEach
    void setUp() {
        repository.deleteAll();

        Compra c1 = new Compra();
        c1.setFecha(LocalDate.now());
        c1.setTotal(100.0);
        service.guardar(c1);

        Compra c2 = new Compra();
        c2.setFecha(LocalDate.now());
        c2.setTotal(50.0);
        service.guardar(c2);
    }

    @Test
    void testListar() {
        List<Compra> compras = service.listar();
        assertEquals(2, compras.size());
    }

    @Test
    void testGuardar() {
        Compra compra = new Compra();
        compra.setFecha(LocalDate.now());
        compra.setTotal(70.0);
        Compra saved = service.guardar(compra);
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
