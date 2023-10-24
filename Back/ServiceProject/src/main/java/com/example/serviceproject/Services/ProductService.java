package com.example.serviceproject.Services;



import com.example.serviceproject.Entities.Product;
import com.example.serviceproject.Entities.Warehouse;
import com.example.serviceproject.Interface.IProduct;
import com.example.serviceproject.Repositories.ProductRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Service
@Slf4j
public class ProductService implements IProduct {

    @Autowired
    ProductRepo productRepo;

    @Override
    public void AddProduct(Product product) {
    productRepo.save(product);
    }

    @Override
    public List<Product> retrieveAllProducts() {
        return (List<Product>) productRepo.findAll();
    }

    @Override
    public Product retrieveProduct(Integer productId) {
        return productRepo.findById(productId).orElse(null);
    }

    @Override
    public Product updateProduct(Integer id, Map<String, Object> updates) {

        Product existingProduct = productRepo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Product not found"));

        updates.forEach((key, value) -> {
            switch (key) {
                case "name":
                    existingProduct.setName((String) value);
                    break;
                case "description":
                    existingProduct.setDescription((String) value);
                    break;
                case "price":
                    existingProduct.setPrice((double) value);
                    break;
                case "quantity":
                    try {
                        existingProduct.setQuantity(Integer.parseInt(value.toString()));
                    } catch (NumberFormatException e) {
                        // Handle the parsing exception if necessary
                    }
                    break;

                case "urlImg":
                    existingProduct.setUrlImg((String) value);
                    break;
                case "rating":
                    try {
                        existingProduct.setRating(Integer.parseInt(value.toString()));
                    } catch (NumberFormatException e) {
                        // Handle the parsing exception if necessary
                    }
                    break;
                case "warehouse":
                    // Assuming the value is of type Warehouse, update the associated warehouse
                    existingProduct.setWarehouse((Warehouse) value);
                    break;

                default:
                    // Ignore unknown fields
                    break;
            }
        });

        return productRepo.save(existingProduct);
    }

    @Override
    public void removeProduct(Integer idProduct) {
    productRepo.deleteById(idProduct);
    }
}
