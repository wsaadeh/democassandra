package com.saadeh.democassandra.services;

import com.saadeh.democassandra.model.dto.DepartmentDTO;
import com.saadeh.democassandra.model.entities.Department;
import com.saadeh.democassandra.repositories.DepartmentRepository;
import com.saadeh.democassandra.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository repository;

    public List<DepartmentDTO> findAll(){
        List<Department> list = repository.findAll();
        return list.stream().map(DepartmentDTO::new).toList();
    }

    public DepartmentDTO findById(UUID id){
        Department entity = getById(id);
        return new DepartmentDTO(entity);
    }

    public DepartmentDTO insert(DepartmentDTO dto){
        Department entity = new Department();
        entity.setId(UUID.randomUUID());
        copyDtoToEntity(dto,entity);
        entity = repository.save(entity);
        return new DepartmentDTO(entity);
    }

    public DepartmentDTO update(UUID id,DepartmentDTO dto){
        Department entity = getById(id);
        copyDtoToEntity(dto,entity);
        entity = repository.save(entity);
        return new DepartmentDTO(entity);
    }

    private Department getById(UUID id){
        Optional<Department> result = repository.findById(id);
        Department entity = result.orElseThrow(()-> new ResourceNotFoundException("Id not found."));
        return entity;
    }

    private void copyDtoToEntity(DepartmentDTO dto, Department entity) {
        entity.setName(dto.getName());
    }


}
