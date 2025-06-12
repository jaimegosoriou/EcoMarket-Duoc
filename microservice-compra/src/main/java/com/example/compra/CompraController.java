package com.example.compra;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/compras")
public class CompraController {
    private final CompraService service;

    public CompraController(CompraService service) {
        this.service = service;
    }

    @GetMapping
    public List<Compra> listar() {
        return service.listar();
    }

    @PostMapping
    public Compra guardar(@RequestBody Compra compra) {
        return service.guardar(compra);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
