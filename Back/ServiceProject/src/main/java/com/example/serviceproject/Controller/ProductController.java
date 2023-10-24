package com.example.serviceproject.Controller;


import com.example.serviceproject.Entities.Product;
import com.example.serviceproject.Interface.IProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("stockService")
public class ProductController {

    @Autowired
    IProduct iProduct;

    @PostMapping(value = "saveProduct")
    public Product saveProduct(@RequestBody Product product){
        System.out.println("Product save works properly !");
        iProduct.AddProduct(product);
        return product;
    }

    //find all Vehicles
    @GetMapping(value = "getAllProducts")
    public List<Product> findAllProducts(){
        return iProduct.retrieveAllProducts();
    }


    @PatchMapping(value = "updateProduct/{id}")
    public Product updateProduct(@PathVariable Integer id, @RequestBody Map<String, Object> updates) {
        return iProduct.updateProduct(id, updates);
    }

    //delete Vehicle
    @DeleteMapping(value = "deleteProduct/{id}")
    public void deleteProduct(@PathVariable("id") Integer id)
    {
        iProduct.removeProduct(id);
    }

    @GetMapping("GetProduct/{id}")
    public Product getVehicle(@PathVariable Integer id){
        return iProduct.retrieveProduct(id);
    }
}
