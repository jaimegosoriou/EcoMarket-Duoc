package com.example.compra;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CompraService {
    private final CompraRepository repository;

    public CompraService(CompraRepository repository) {
        this.repository = repository;
    }

    public List<Compra> listar() {
        return repository.findAll();
    }

    public Compra guardar(Compra compra) {
        return repository.save(compra);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
