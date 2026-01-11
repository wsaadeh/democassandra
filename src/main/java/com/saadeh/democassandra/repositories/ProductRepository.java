package com.saadeh.democassandra.repositories;

import com.saadeh.democassandra.model.entities.Product;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends CassandraRepository<Product, UUID> {
    @AllowFiltering
    List<Product> findByDepartment(String department);
}
