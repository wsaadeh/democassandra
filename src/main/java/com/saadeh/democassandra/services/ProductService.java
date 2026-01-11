package com.saadeh.democassandra.services;

import com.saadeh.democassandra.model.dto.ProductDTO;
import com.saadeh.democassandra.model.entities.Product;
import com.saadeh.democassandra.repositories.ProductRepository;
import com.saadeh.democassandra.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public ProductDTO findById(UUID id) {
        Product entity = getById(id);
        return new ProductDTO(entity);
    }

    private Product getById(UUID id) {
        Optional<Product> result = repository.findById(id);
        Product entity = result.orElseThrow(() -> new ResourceNotFoundException("Id not found."));
        return entity;
    }

    public List<ProductDTO> findByDeparment(String department) {
        List<Product> list;
        if ("".equals((department))) {
            list = repository.findAll();
        } else {
            list = repository.findByDepartment(department);
        }

        return list.stream().map(ProductDTO::new).toList();
    }

    public List<ProductDTO> findByDescription(String text) {
        List<Product> list;
        if ("".equals(text)) {
            list = repository.findAll();
        } else {
            list = repository.findByDescription("%" + text + "%");
        }
        return list.stream().map(ProductDTO::new).toList();
    }


}
