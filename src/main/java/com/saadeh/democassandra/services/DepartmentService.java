package com.saadeh.democassandra.services;

import com.saadeh.democassandra.model.dto.DepartmentDTO;
import com.saadeh.democassandra.model.entities.Department;
import com.saadeh.democassandra.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository repository;

    public List<DepartmentDTO> findAll(){
        List<Department> list = repository.findAll();
        return list.stream().map(DepartmentDTO::new).toList();
    }
}
