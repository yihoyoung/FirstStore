package org.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.store.domain.Product;
import org.store.repository.ProductRepository;

import java.util.List;

/**
 * Created by hoyounglee on 2016. 6. 5..
 */
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProductList(){
        return (List<Product>) productRepository.findAll();
    }

}
