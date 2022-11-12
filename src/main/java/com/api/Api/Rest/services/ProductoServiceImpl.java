package com.api.Api.Rest.services;
import com.api.Api.Rest.entities.Producto;
import com.api.Api.Rest.repositories.BaseRepository;
import com.api.Api.Rest.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class ProductoServiceImpl extends BaseServiceImpl<Producto, Long> implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;
    public ProductoServiceImpl(BaseRepository<Producto,Long> baseRepository){
        super(baseRepository);
    }

    @Override
    @Transactional
    public List<Producto> ProductosPorCategoria(int categoria) throws Exception {
        try {
            List<Producto> productos = productoRepository.ProductosPorCategoria(categoria);
            return productos;
        } catch(Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    @Override
    @Transactional
    public Page<Producto> ProductosPorCategoriaPage(int categoria, Pageable pageable) throws Exception {
        try {
            Page<Producto> productos = productoRepository.ProductosPorCategoriaPage(categoria, pageable);
            return productos;
        } catch(Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Page<Producto> ProductosPorNombre(String nombre, Pageable pageable) throws Exception {
        try {
            Page<Producto> productos = productoRepository.ProductosPorNombre(nombre, pageable);
            return productos;
        } catch(Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
