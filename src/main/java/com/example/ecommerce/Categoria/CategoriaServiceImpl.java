package com.example.ecommerce.Categoria;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ecommerce.Base.BaseServiceImpl;

@Service
@Transactional
public class CategoriaServiceImpl
        extends BaseServiceImpl<Categoria, Long, CategoriaRepository>
        implements CategoriaService {

    @Autowired
    CategoriaServiceImpl(CategoriaRepository repository) {
        super(repository);
    }

    public Categoria create(String nombre) {
        Categoria nCategoria = Categoria
                .builder()
                .nombre(nombre)
                .build();
        return this.repository.save(nCategoria);
    }

    public List<Categoria> createMultiple(List<String> nombres) {
        List<Categoria> categorias = new ArrayList<>();
        nombres.forEach((n) -> {
            Categoria c = this.create(n);
            categorias.add(c);
        });
        return categorias;
    }

}
