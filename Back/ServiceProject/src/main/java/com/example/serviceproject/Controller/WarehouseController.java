package com.example.serviceproject.Controller;

import com.example.serviceproject.Entities.Warehouse;
import com.example.serviceproject.Interface.IWarehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class WarehouseController {

    @Autowired
    IWarehouse iWarehouse;

    @PostMapping(value = "saveWarehouse")
    public Warehouse saveWarehouse(@RequestBody Warehouse warehouse){
        System.out.println("Warehouse save works properly !");
        iWarehouse.AddWarehouse(warehouse);
        return warehouse;
    }

    //find all Vehicles
    @GetMapping(value = "getAllWarehouses")
    public List<Warehouse> findAllWarehouses(){
        return iWarehouse.retrieveAllWarehouses();
    }


    @PatchMapping(value = "updateWarehouse/{id}")
    public Warehouse updateWarehouse(@PathVariable Integer id, @RequestBody Map<String, Object> updates) {
        return iWarehouse.updateWarehouse(id, updates);
    }

    //delete Vehicle
    @DeleteMapping(value = "deleteWarehouse/{id}")
    public void deleteWarehouse(@PathVariable("id") Integer id)
    {
        iWarehouse.removeWarehouse(id);
    }

    @GetMapping("GetWarehouse/{id}")
    public Warehouse getWarehouse(@PathVariable Integer id){
        return iWarehouse.retrieveWarehouse(id);
    }
}
