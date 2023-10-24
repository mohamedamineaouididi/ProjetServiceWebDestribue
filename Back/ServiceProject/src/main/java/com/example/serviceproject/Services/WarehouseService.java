package com.example.serviceproject.Services;


import com.example.serviceproject.Entities.Warehouse;
import com.example.serviceproject.Interface.IWarehouse;
import com.example.serviceproject.Repositories.WarehouseRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Service
@Slf4j
public class WarehouseService implements IWarehouse {

    @Autowired
    WarehouseRepo warehouseRepo;

    @Override
    public void AddWarehouse(Warehouse warehouse) {
    warehouseRepo.save(warehouse);
    }

    @Override
    public List<Warehouse> retrieveAllWarehouses() {
        return (List<Warehouse>)warehouseRepo.findAll();
    }

    @Override
    public Warehouse retrieveWarehouse(Integer warehouseId) {
        return warehouseRepo.findById(warehouseId).orElse(null);
    }

    @Override
    public Warehouse updateWarehouse(Integer id, Map<String, Object> updates) {

        Warehouse existingWarehouse = warehouseRepo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Warehouse not found"));

        updates.forEach((key, value) -> {
            switch (key) {
                case "name":
                    existingWarehouse.setName((String) value);
                    break;
                case "location":
                    existingWarehouse.setLocation((String) value);
                    break;
                case "manager":
                    existingWarehouse.setManager((String) value);
                    break;

                default:
                    // Ignore unknown fields
                    break;
            }
        });

        return warehouseRepo.save(existingWarehouse);
    }

    @Override
    public void removeWarehouse(Integer idWarehouse)
    {
        warehouseRepo.deleteById(idWarehouse);
    }
}
