package com.saadeh.democassandra.repositories;

import com.saadeh.democassandra.model.entities.Department;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.UUID;

public interface DepartmentRepository extends CassandraRepository<Department, UUID> {
}
