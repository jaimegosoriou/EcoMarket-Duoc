package com.example.compra;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CompraServiceTests {

    @Autowired
    private CompraService service;
    @Autowired
    private CompraRepository repository;

    @Test
    void registrarYObtenerCompra() {
        Compra c = new Compra();
        c.setFecha(LocalDate.now());
        c.setTotal(50.0);
        Compra guardada = service.guardar(c);
        assertThat(guardada.getId()).isNotNull();

        Compra obtenida = repository.findById(guardada.getId()).orElse(null);
        assertThat(obtenida).isNotNull();
        assertThat(obtenida.getTotal()).isEqualTo(50.0);

        List<Compra> compras = service.listar();
        assertThat(compras).extracting(Compra::getId).contains(guardada.getId());
    }
}
