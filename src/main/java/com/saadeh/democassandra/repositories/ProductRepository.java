package com.saadeh.democassandra.repositories;

import com.saadeh.democassandra.model.entities.Product;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.UUID;

public interface ProductRepository extends CassandraRepository<Product, UUID> {
}
