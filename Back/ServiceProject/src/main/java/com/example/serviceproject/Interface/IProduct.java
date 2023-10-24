package com.example.serviceproject.Interface;



import com.example.serviceproject.Entities.Product;

import java.util.List;
import java.util.Map;

public interface IProduct {

    public void AddProduct(Product product);
    public List<Product> retrieveAllProducts();
    Product retrieveProduct(Integer productId);
    Product updateProduct(Integer id, Map<String, Object> updates);
    public  void removeProduct(Integer idProduct);
}
