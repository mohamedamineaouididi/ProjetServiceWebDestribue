package com.example.serviceproject.Interface;



import com.example.serviceproject.Entities.Warehouse;

import java.util.List;
import java.util.Map;

public interface IWarehouse {

    public void AddWarehouse(Warehouse warehouse);
    public List<Warehouse> retrieveAllWarehouses();
    Warehouse retrieveWarehouse(Integer warehouseId);
    Warehouse updateWarehouse(Integer id, Map<String, Object> updates);
    public  void removeWarehouse(Integer idWarehouse);
}
