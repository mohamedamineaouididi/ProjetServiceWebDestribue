package com.example.serviceproject.Repositories;

import com.example.serviceproject.Entities.Warehouse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseRepo extends CrudRepository<Warehouse,Integer> {
}
