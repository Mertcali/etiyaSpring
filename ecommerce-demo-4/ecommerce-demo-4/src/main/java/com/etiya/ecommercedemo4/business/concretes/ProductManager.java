package com.etiya.ecommercedemo4.business.concretes;

import com.etiya.ecommercedemo4.business.abstracts.IProductService;
import com.etiya.ecommercedemo4.business.dtos.request.product.AddProductRequest;
import com.etiya.ecommercedemo4.business.dtos.response.product.AddProductResponse;
import com.etiya.ecommercedemo4.entities.concretes.Product;
import com.etiya.ecommercedemo4.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManager implements IProductService {

    private IProductRepository productRepository;

    @Autowired
    public ProductManager(IProductRepository IProductRepository) {
        this.productRepository = IProductRepository;
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getById(int id) {
        return productRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Product> getAllByStock(int stock) {
        return this.productRepository.findAllProductsByStockGreaterThanOrderByStockDesc(stock);
    }

    @Override
    public Product getByName(String name) {
        return this.productRepository.findByName(name);
    }

    @Override
    public List<Product> getAllProductsUnitPriceBetween(double start, double end) {
        return this.productRepository.findAllProductsUnitPriceBetween(start,end);
    }

    @Override
    public AddProductResponse add(AddProductRequest addProductRequest) {

        Product product = new Product();
        product.setName(addProductRequest.getName());
        product.setStock(addProductRequest.getStock());
        product.setUnitPrice(addProductRequest.getUnitPrice());
        product.setProductionDate(addProductRequest.getProductionDate());

        Product savedProduct = this.productRepository.save(product);

        AddProductResponse response = new AddProductResponse(savedProduct.getId(),
                savedProduct.getName(),savedProduct.getUnitPrice(),
                savedProduct.getProductionDate(),savedProduct.getStock());


        return response;
    }
}
